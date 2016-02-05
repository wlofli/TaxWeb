package com.tax.service;
/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public interface CommonService {
	
	/**发送短信验证码
	 * add by lzc     date: 2016年1月28日
	 * @param phone
	 * @param code
	 * @return
	 */
	boolean sendCode(String phone, String code);

}
