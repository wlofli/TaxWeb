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
import com.tax.model.BO.BalanceSheetContent;
import com.tax.model.BO.SheetContent;
import com.tax.model.DO.Balancesheet;
import com.tax.service.BalanceSheetService;
import com.tax.util.ExportToExcel;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@Controller
@RequestMapping("balance")
public class BalanceSheetController {
	
	@Resource
	private BalanceSheetService balanceSheetService;
	
	//年
	private int yearShow = Calendar.getInstance().get(Calendar.YEAR);
	
	/**
	 * 资产负债表列表数据取得
	 * modified by maozj at 2016/01/29
	 * @param taxCode 税号
	 * @param year 年份
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String getBalanceSheetList(HttpServletRequest request, @RequestParam(defaultValue = "0")int year, Model model) {
		
		String taxCode = (String) request.getSession().getAttribute(
				Global.TAX_CODE);
		
		List<Balancesheet> nowYearData = new ArrayList<Balancesheet>();
		List<Balancesheet> lastYearData = new ArrayList<Balancesheet>();
		List<Balancesheet> previousYearData = new ArrayList<Balancesheet>();
		
		List<Balancesheet> list = balanceSheetService.getBalancesheetList(year, taxCode);
		
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
		
		return "balance/balanceList";
		
	}
	
	/**
	 * 详情
	 * modified by maozj at 2016/01/29
	 * @param request
	 * @param reportDate 日期
	 * @param model
	 * @return
	 */
	@RequestMapping("info")
	public String getBalanceSheetInfo(HttpServletRequest request,int date, Model model){
		
		String taxCode = (String) request.getSession().getAttribute(
				Global.TAX_CODE);

		Balancesheet balancesheet = balanceSheetService.getBalancesheetByDate(taxCode, date);
		
		BalanceSheetContent content = new BalanceSheetContent(balancesheet.getReportContent());
		
		model.addAttribute("content", content);
		return "balance/balanceInfo";
	}
	
	/**
	 * 详情下载
	 * add by maozj at 2016/01/29
	 * @param request
	 * @param response
	 * @param date 日期
	 */
	@RequestMapping("detail/download")
	public void detailDownload(HttpServletRequest request,HttpServletResponse response, int date) {
		
		//税号
		String taxCode = (String) request.getSession().getAttribute(
				Global.TAX_CODE);
		
		Balancesheet balancesheet = balanceSheetService.getBalancesheetByDate(taxCode, date);
		
		BalanceSheetContent content = new BalanceSheetContent(balancesheet.getReportContent());
		
		//第一行表头
		String[] header = new String[] { Global.DOWNLOAD_BALANCE_SHEET_ASSET,
				Global.DOWNLOAD_BALANCE_SHEET_INDEX,
				Global.DOWNLOAD_BALANCE_SHEET_START,
				Global.DOWNLOAD_BALANCE_SHEET_END,
				Global.DOWNLOAD_BALANCE_SHEET_DEBT,
				Global.DOWNLOAD_BALANCE_SHEET_INDEX,
				Global.DOWNLOAD_BALANCE_SHEET_START,
				Global.DOWNLOAD_BALANCE_SHEET_END };
		
		//数据生成
		List<String[]> dataList = new ArrayList<String[]>();
		dataList.clear();
		for (int i = 0; i < content.getList().size(); i++) {
			
			String[] tempS = new String[]{
					content.getList().get(i).getAsset(),
					content.getList().get(i).getIndex1(),
					content.getList().get(i).getBalance_begin1(),
					content.getList().get(i).getBalance_end1(),
					content.getList().get(i).getLiabilities(),
					content.getList().get(i).getIndex2(),
					content.getList().get(i).getBalance_begin2(),
					content.getList().get(i).getBalance_end2()
			};
			
			dataList.add(tempS);
		}
		
		try {
			//下载调用
			ExportToExcel excel = new ExportToExcel();
			excel.export(response, Global.DOWNLOAD_BALANCE_SHEET_TABLE_NAME+".xls", Global.DOWNLOAD_BALANCE_SHEET_TABLE_NAME, header, dataList);
			
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
		String taxCode = (String) request.getSession().getAttribute(Global.TAX_CODE);
		
		List<Balancesheet> list = null;
		
		switch (type) {
		case 1:
			list = balanceSheetService.getBalancesheetList(0, taxCode);
			break;
		case 2:
			list = balanceSheetService.getBalancesheetList(yearShow-1, taxCode);
			break;
		case 3:
			list = balanceSheetService.getBalancesheetList(yearShow-2, taxCode);
			break;
		default:
			break;
		}
		
		if (list != null) {
			//第一行表头
			String[] header = new String[] { Global.DOWNLOAD_BALANCE_SHEET_ASSET,
					Global.DOWNLOAD_BALANCE_SHEET_INDEX,
					Global.DOWNLOAD_BALANCE_SHEET_START,
					Global.DOWNLOAD_BALANCE_SHEET_END,
					Global.DOWNLOAD_BALANCE_SHEET_DEBT,
					Global.DOWNLOAD_BALANCE_SHEET_INDEX,
					Global.DOWNLOAD_BALANCE_SHEET_START,
					Global.DOWNLOAD_BALANCE_SHEET_END };
			
			//数据整理-内容
			List<SheetContent> sheets = new ArrayList<>();
			//数据整理-sheet
			String[] sheetNames = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				
				Balancesheet balancesheet = balanceSheetService.getBalancesheetByDate(taxCode, list.get(i).getReportDate());
				BalanceSheetContent content = new BalanceSheetContent(balancesheet.getReportContent());
				
				//sheet名
				sheetNames[i] = content.getRepost_date().substring(0,6);
				
				//one sheet's data
				SheetContent sc = new SheetContent(content.getList().size());
				List<String[]> contentlist = new ArrayList<>();
				for (int j = 0; j < content.getList().size(); j++) {
					String[] tempS = new String[]{
							content.getList().get(j).getAsset(),
							content.getList().get(j).getIndex1(),
							content.getList().get(j).getBalance_begin1(),
							content.getList().get(j).getBalance_end1(),
							content.getList().get(j).getLiabilities(),
							content.getList().get(j).getIndex2(),
							content.getList().get(j).getBalance_begin2(),
							content.getList().get(j).getBalance_end2()
					};
					contentlist.add(tempS);
					
				}
				sc.setContents(contentlist);
				sheets.add(sc);
			}
			
			try {
				//下载
				ExportToExcel exportToExcel = new ExportToExcel();
				exportToExcel.allExport(response, Global.DOWNLOAD_BALANCE_SHEET_TABLE_NAME+"_all.xls", header, sheetNames, sheets);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
