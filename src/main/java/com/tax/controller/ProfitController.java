package com.tax.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tax.common.Global;
import com.tax.model.BO.ProfitContent;
import com.tax.model.BO.SheetContent;
import com.tax.model.DO.Profitstatement;
import com.tax.service.ProfitService;
import com.tax.util.ExportToExcel;

/**
 * author lzc <coushuxiaolang@163.com>
 */
@Controller
@RequestMapping("profit")
public class ProfitController {

	@Resource
	private ProfitService profitService;

	// 年
	private int yearShow = Calendar.getInstance().get(Calendar.YEAR);

	/**
	 * 利润表列表数据取得 
	 * modified by maozj at 2016/01/29
	 * @param request
	 * @param year
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String getProfitList(HttpServletRequest request,
			@RequestParam(defaultValue = "0") int year, Model model) {

		String taxCode = (String) request.getSession().getAttribute(
				Global.TAX_CODE);

		List<Profitstatement> nowYearData = new ArrayList<Profitstatement>();
		List<Profitstatement> lastYearData = new ArrayList<Profitstatement>();
		List<Profitstatement> previousYearData = new ArrayList<Profitstatement>();

		List<Profitstatement> list = profitService.getProfitList(year, taxCode);
		
		if (year == 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getReportDate().toString().substring(0, 4).equals(String.valueOf(yearShow))) {
					nowYearData.add(list.get(i));
				} else {
					lastYearData.add(list.get(i));
				}
			}
			model.addAttribute("type", 1);
			model.addAttribute("nowYearData", nowYearData);
			model.addAttribute("lastYearData", lastYearData);
		} else if (year == yearShow-1) {
			lastYearData = list;
			model.addAttribute("type", 2);
			model.addAttribute("lastYearData", lastYearData);
		} else if (year == yearShow-2) {
			previousYearData = list;
			model.addAttribute("type", 3);
			model.addAttribute("previousYearData", previousYearData);
		}

		model.addAttribute("nowYear", yearShow);

		return "profit/profitList";
	}

	/**
	 * 详情
	 * modified by maozj at 2016/01/29
	 * @param taxCode
	 * @param reportDate
	 * @param model
	 * @return
	 */
	@RequestMapping("info")
	public String getProfitInfo(HttpServletRequest request,int date, Model model) {
		
		String taxCode = (String) request.getSession().getAttribute(
				Global.TAX_CODE);
		
		Profitstatement profitstatement = profitService.getProfitByTime(date, taxCode);

		ProfitContent profitContent = new ProfitContent(profitstatement.getReportContent());
		model.addAttribute("content", profitContent);
		
		return "profit/profitInfo";
	}
	
	/**
	 * 详情下载
	 * add by maozj at 2016/01/29
	 * @param request
	 * @param response
	 * @param date
	 */
	@RequestMapping("detail/download")
	public void detailDownload(HttpServletRequest request,HttpServletResponse response, int date) {
		// 税号
		String taxCode = (String) request.getSession().getAttribute(
				Global.TAX_CODE);
		Profitstatement profitstatement = profitService.getProfitByTime(date,
				taxCode);

		ProfitContent content = new ProfitContent(
				profitstatement.getReportContent());
		
		//第一行表头
		String[] header = new String[] { Global.DOWNLOAD_PROFIT_ITEM,
				Global.DOWNLOAD_PROFIT_INDEX,
				Global.DOWNLOAD_PROFIT_MONTH_TOTAL,
				Global.DOWNLOAD_PROFIT_YEAR_TOTAL };
		
		// 数据生成
		List<String[]> dataList = new ArrayList<String[]>();
		dataList.clear();
		for (int i = 0; i < content.getList().size(); i++) {

			String[] tempS = new String[] { content.getList().get(i).getItem(),
					content.getList().get(i).getIndex(),
					content.getList().get(i).getMonth_amount(),
					content.getList().get(i).getYear_amount() };

			dataList.add(tempS);
		}

		try {
			// 下载调用
			ExportToExcel excel = new ExportToExcel();
			excel.export(response, Global.DOWNLOAD_PROFIT_TABLE_NAME
					+ ".xls", Global.DOWNLOAD_PROFIT_TABLE_NAME, header,
					dataList);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 列表页下载
	 * @param request
	 * @param response
	 * @param type
	 */
	@RequestMapping("all/download")
	public void allDownload(HttpServletRequest request,HttpServletResponse response, int type) {
		//税号
		String taxCode = (String) request.getSession().getAttribute(
				Global.TAX_CODE);

		List<Profitstatement> list = null;

		switch (type) {
		case 1:
			list = profitService.getProfitList(0, taxCode);
			break;
		case 2:
			list = profitService.getProfitList(yearShow-1, taxCode);
			break;
		case 3:
			list = profitService.getProfitList(yearShow-2, taxCode);
			break;
		default:
			break;
		}
		
		if (list != null) {
			//第一行表头
			String[] header = new String[] { Global.DOWNLOAD_PROFIT_ITEM,
					Global.DOWNLOAD_PROFIT_INDEX,
					Global.DOWNLOAD_PROFIT_MONTH_TOTAL,
					Global.DOWNLOAD_PROFIT_YEAR_TOTAL };
			
			//数据整理-内容
			List<SheetContent> sheets = new ArrayList<>();
			//数据整理-sheet
			String[] sheetNames = new String[list.size()];
			
			for (int i = 0; i < list.size(); i++) {
				Profitstatement profitstatement = profitService.getProfitByTime(list.get(i).getReportDate(), taxCode);
				ProfitContent content = new ProfitContent(profitstatement.getReportContent());
				
				//sheet名
				sheetNames[i] = content.getRepost_date();
				
				//one sheet's data
				SheetContent sc = new SheetContent(content.getList().size());
				List<String[]> contentlist = new ArrayList<>();
				for (int j = 0; j < content.getList().size(); j++) {
					String[] tempS = new String[] { 
							content.getList().get(j).getItem(),
							content.getList().get(j).getIndex(),
							content.getList().get(j).getMonth_amount(),
							content.getList().get(j).getYear_amount() };
					
					contentlist.add(tempS);
					
				}
				sc.setContents(contentlist);
				sheets.add(sc);
			}
			
			try {
				//下载
				ExportToExcel exportToExcel = new ExportToExcel();
				exportToExcel.allExport(response, Global.DOWNLOAD_PROFIT_TABLE_NAME+"_all.xls", header, sheetNames, sheets);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
