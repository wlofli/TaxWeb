package com.tax.dao;

import org.apache.ibatis.annotations.Param;

import com.tax.model.DO.TaxOrgInfo;
import com.tax.model.DO.TaxOrgInfoLog;

public interface TaxOrgInfoLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaxOrgInfoLog record);

    int insertSelective(TaxOrgInfoLog record);

    TaxOrgInfoLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaxOrgInfoLog record);

    int updateByPrimaryKey(TaxOrgInfoLog record);

	int insertTaxOrgInfo(@Param("taxCode")String taxCode);
}