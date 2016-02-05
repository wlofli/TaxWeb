package com.tax.service;

import javax.servlet.http.HttpServletRequest;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public interface SpiderTaskService {
	
	public String begin(HttpServletRequest request) throws Exception;
	
	
	/**更新task
	 * add by lzc     date: 2016年2月1日
	 * @param request
	 * @param msg
	 */
	public void updateTask(HttpServletRequest request, String msg);

	

}
