package com.tax.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tax.dao.ProfitstatementMapper;
import com.tax.model.DO.Profitstatement;
import com.tax.service.ProfitService;
import com.tax.util.DateUtil;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@Service
public class ProfitServiceImpl implements ProfitService{
	
	@Resource
	private ProfitstatementMapper profitstatementMapper;

	@Override
	public List<Profitstatement> getProfitList(int year, String taxCode) {
		if(year == 0)
			return profitstatementMapper
					.getLast3MonthProfitByTaxCode(taxCode, DateUtil.getLatst3MonthStartDate()/100, DateUtil.getLastMonthEndDate()/100);
		return profitstatementMapper.getProfitByYear(taxCode, year);
	}

	@Override
	public Profitstatement getProfitByTime(int date, String taxCode) {
		// TODO Auto-generated method stub
		return profitstatementMapper.getProfitstatementByTaxCode(taxCode, date);
	}

}
