package com.tax.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tax.model.DO.TaxOrgInfo;
import com.tax.service.TaxOrgService;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@Controller
@RequestMapping("org")
public class TaxOrgController {
	
	
	@Resource
	private TaxOrgService taxOrgService;
	
	@RequestMapping("getinfo")
	public String getTaxInfo(String taxCode, Model model){
		TaxOrgInfo org = taxOrgService.getOrgInfoByTaxId(taxCode);
		model.addAttribute("org", org);
		return "info/companyInfo";
	}
	
	

}
