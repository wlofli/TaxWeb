package com.tax.dao;

import com.tax.model.DO.SpiderClientid;

public interface SpiderClientidMapper {
    int deleteByPrimaryKey(String clientid);

    int insert(SpiderClientid record);

    int insertSelective(SpiderClientid record);

    SpiderClientid selectByPrimaryKey(String clientid);

    int updateByPrimaryKeySelective(SpiderClientid record);

    int updateByPrimaryKey(SpiderClientid record);
}