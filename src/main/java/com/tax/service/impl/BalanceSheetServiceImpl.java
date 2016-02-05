package com.tax.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tax.dao.BalancesheetMapper;
import com.tax.model.DO.Balancesheet;
import com.tax.service.BalanceSheetService;
import com.tax.util.DateUtil;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@Service
public class BalanceSheetServiceImpl implements BalanceSheetService{

	@Resource
	private BalancesheetMapper balancesheetMapper;
	
	@Override
	public List<Balancesheet> getBalancesheetList(int year, String taxCode) {
		// TODO Auto-generated method stub
		if(year == 0){
			return balancesheetMapper
					.getLast3MonthBalancesheets(taxCode, DateUtil.getLatst3MonthStartDate(), DateUtil.getLastMonthEndDate());
		}
		return balancesheetMapper.getBalancesheetsByYear(taxCode, year);
	}

	/**
	 * modified by maozj at 2016/01/29
	 */
	@Override
	public Balancesheet getBalancesheetByDate(String taxCode, int date) {
		
		return balancesheetMapper.getBalancesheetByTaxCode(taxCode, String.valueOf(date).substring(0, 6));
	}

}
