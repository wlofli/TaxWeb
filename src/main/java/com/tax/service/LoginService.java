package com.tax.service;

import com.tax.model.DO.SpiderTaxTask;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */

public interface LoginService {
	
	/**
	 * add by lzc     date: 2016年1月26日
	 * @param task
	 * @return 状态码
	 * 0->第一次进入
	 * 1->错误
	 * 2->有数据
	 * 3->无数据
	 */
	public int login(SpiderTaxTask task);
	
	/**获取无数据的原因
	 * add by lzc     date: 2016年1月27日
	 * @param task
	 * @return
	 */
	public String getWrongMsg(SpiderTaxTask task); 
	
	/**获取纳税人名称
	 * add by lzc     date: 2016年1月28日
	 * @param taxCode
	 * @return
	 */
	public String getCompany(String taxCode);
	

}
