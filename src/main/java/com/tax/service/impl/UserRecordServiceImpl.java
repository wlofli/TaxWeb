package com.tax.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tax.dao.UserRecordInfoMapper;
import com.tax.model.DO.UserRecordInfo;
import com.tax.service.UserRecordService;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@Service
public class UserRecordServiceImpl implements UserRecordService{

	@Resource
	private UserRecordInfoMapper userRecordInfoMapper;
	
	@Override
	public int addUser(UserRecordInfo user) {
		// TODO Auto-generated method stub
		return userRecordInfoMapper.insertSelective(user);
	}

}
