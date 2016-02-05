package com.tax.service;

import java.util.List;

import com.tax.model.DO.Balancesheet;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public interface BalanceSheetService {
	
	/**
	 * add by lzc     date: 2016年1月26日
	 * @param year 0->最近三个月
	 * @param taxCode
	 * @return
	 */
	public List<Balancesheet> getBalancesheetList(int year, String taxCode);
	
	
	/**
	 * add by lzc     date: 2016年1月26日
	 * @param taxCode
	 * @param date
	 * @return
	 */
	public Balancesheet getBalancesheetByDate(String taxCode, int date);

}
