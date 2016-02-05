package com.tax.service;

import java.util.List;

import com.tax.model.DO.AddedValueTax;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public interface AddedValueService {
	
	/**
	 * add by lzc     date: 2016年1月26日
	 * @param type 0->最近三个月 n->n年
	 * @param taxCode
	 * @return
	 */
	public List<AddedValueTax> getAddedValueTaxs(int type, String taxCode, int pageNo, int pageSize );
	
	
	
	

}
