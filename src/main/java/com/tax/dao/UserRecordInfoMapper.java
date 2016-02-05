package com.tax.dao;

import com.tax.model.DO.UserRecordInfo;

public interface UserRecordInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRecordInfo record);

    int insertSelective(UserRecordInfo record);

    UserRecordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRecordInfo record);

    int updateByPrimaryKey(UserRecordInfo record);
}