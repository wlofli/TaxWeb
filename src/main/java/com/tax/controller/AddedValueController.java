package com.tax.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tax.common.Global;
import com.tax.model.DO.AddedValueTax;
import com.tax.service.AddedValueService;
import com.tax.util.ExportToExcel;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 * modified by mzj at 2016/1/28
 */
@Controller
@RequestMapping("VAT")
public class AddedValueController {
	
	@Resource
	private AddedValueService addedValueService;
	
	//年度
	private int yearShow = Calendar.getInstance().get(Calendar.YEAR);
	
	@RequestMapping(value = { "", "/list" })
	public String getAddedValue(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "0") int year, Model model,
			HttpSession session) {
		
		//税号取得
		String taxCode = (String) session.getAttribute(Global.TAX_CODE);
		
		//数据取得
		List<AddedValueTax> list = addedValueService.getAddedValueTaxs(year,
				taxCode, pageNo, Global.PAGE_SIZE);
		
		List<AddedValueTax> nowYearData = new ArrayList<>();
		List<AddedValueTax> lastYearData = new ArrayList<>();
		List<AddedValueTax> previousYearData = new ArrayList<>();
		
		if (year == 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getStartdate().toString().substring(0, 4).equals(String.valueOf(yearShow))) {
					nowYearData.add(list.get(i));
				} else {
					lastYearData.add(list.get(i));
				}
			}
			model.addAttribute("type", 1);
		}else if (year == yearShow-1) {
			lastYearData = list;
			model.addAttribute("type", 2);
		}else if (year == yearShow -2) {
			previousYearData = list;
			model.addAttribute("type", 3);
		}
		
		model.addAttribute("nowYearData", nowYearData);
		model.addAttribute("lastYearData", lastYearData);
		model.addAttribute("previousYearData", previousYearData);
		
		model.addAttribute("nowYear", yearShow);
		
		return "added/addedList";
	}
	
	
	/**
	 * 增值税表导出
	 * add by maozj at 2016/01/28
	 * @param response
	 * @param type-->1:近三月;2: 去年;3:前年
	 */
	@RequestMapping(value="/download")
	public void taxDownload(HttpServletRequest request,HttpServletResponse response,int type) {
		
		//税号取得
		String taxCode = (String) request.getSession().getAttribute(Global.TAX_CODE);
		//纳税人姓名
		String taxName = (String) request.getSession().getAttribute(Global.COMPANY_NAME);
		
		List<AddedValueTax> dataVAT = null;
		switch (type) {
		case 1:
			dataVAT = addedValueService.getAddedValueTaxs(0,taxCode, 0, Global.PAGE_SIZE);
			break;
		case 2:
			dataVAT = addedValueService.getAddedValueTaxs(yearShow-1,taxCode, 0, Global.PAGE_SIZE);
			break;
		case 3:
			dataVAT = addedValueService.getAddedValueTaxs(yearShow-2,taxCode, 0, Global.PAGE_SIZE);
			break;
		default:
			break;
		}
		
		//第一行表头
		String[] header = new String[] {
				Global.DOWNLOAD_VAT_CODE,
				Global.DOWNLOAD_VAT_NAME,
				Global.DOWNLOAD_VAT_START,
				Global.DOWNLOAD_VAT_END,
				Global.DOWNLOAD_VAT_AMOUNT };
		
		//数据生成
		List<String[]> dataList = new ArrayList<String[]>();
		for (int i = 0; i < dataVAT.size(); i++) {
			
			String startT = dataVAT.get(i).getStartdate().toString();
			String endT = dataVAT.get(i).getEnddate().toString();
			
			String[] tempS = new String[]{
					taxCode,
					taxName,
					startT, 
					endT,
					dataVAT.get(i).getAmountTax().toString()
			};
			
			dataList.add(tempS);
		}
		
		try {
			//下载调用
			ExportToExcel excel = new ExportToExcel();
			excel.export(response, Global.DOWNLOAD_VAT_TABLE_NAME+".xls", Global.DOWNLOAD_VAT_TABLE_NAME, header, dataList);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	

}
