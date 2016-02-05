package com.tax.service;

import java.util.List;

import com.tax.model.DO.Profitstatement;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public interface ProfitService {
	
	/**
	 * add by lzc     date: 2016年1月26日
	 * @param year 0->近三个月
	 * @param TaxCode 纳税号
	 * @return
	 */
	public List<Profitstatement> getProfitList(int year, String TaxCode); 
	
	
	
	public Profitstatement getProfitByTime(int date, String TaxCode);

}
