package com.tax.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tax.dao.TaxOrgInfoMapper;
import com.tax.model.DO.TaxOrgInfo;
import com.tax.service.TaxOrgService;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@Service
public class TaxOrgServiceImpl implements TaxOrgService{

	@Resource
	private TaxOrgInfoMapper taxOrgMapper;
	
	
	@Override
	public TaxOrgInfo getOrgInfoByTaxId(String taxCode) {
		// TODO Auto-generated method stub
		return taxOrgMapper.getTaxOrgByTaxId(taxCode);
	}

}
