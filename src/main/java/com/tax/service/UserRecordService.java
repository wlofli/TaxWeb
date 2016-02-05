package com.tax.service;

import com.tax.model.DO.UserRecordInfo;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public interface UserRecordService {
	
	/**添加用户登录
	 * add by lzc     date: 2016年1月30日
	 * @param user
	 * @return
	 */
	public int addUser(UserRecordInfo user);

}
