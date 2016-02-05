package com.tax.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tax.dao.AddedValueTaxMapper;
import com.tax.model.DO.AddedValueTax;
import com.tax.service.AddedValueService;
import com.tax.util.DateUtil;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@Service
public class AddedValueServiceImpl implements AddedValueService{

	@Resource 
	private AddedValueTaxMapper addedValueTaxMapper;
	
	
	@Override
	public List<AddedValueTax> getAddedValueTaxs(int type, String taxCode, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		if(type == 0){
			
			return addedValueTaxMapper.getAddedValueLastThreeMonth(DateUtil.getLatst3MonthStartDate(), 
					DateUtil.getLastMonthEndDate(), taxCode, pageNo, pageSize);
		}
		return addedValueTaxMapper.getAddedValueByYear(type, taxCode, pageNo, pageSize);
	}

}
