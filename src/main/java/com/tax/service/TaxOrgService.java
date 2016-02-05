package com.tax.service;

import com.tax.model.DO.TaxOrgInfo;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public interface TaxOrgService {
	/**获取企业基本信息
	 * add by lzc     date: 2016年1月26日
	 * @param taxCode
	 * @return
	 */
	TaxOrgInfo getOrgInfoByTaxId(String taxCode);
	
	

}
