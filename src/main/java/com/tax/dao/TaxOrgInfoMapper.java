package com.tax.dao;

import org.apache.ibatis.annotations.Param;

import com.tax.model.DO.TaxOrgInfo;

public interface TaxOrgInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaxOrgInfo record);

    int insertSelective(TaxOrgInfo record);

    TaxOrgInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaxOrgInfo record);

    int updateByPrimaryKey(TaxOrgInfo record);
    
    /**根据税号获取信息
     * add by lzc     date: 2016年1月26日
     * @param taxId
     * @return
     */
    TaxOrgInfo getTaxOrgByTaxId(@Param("id")String taxId);
    
    
    int countTaxOrgByTaxId(@Param("id")String taxId);

    /**获取纳税人名称
     * add by lzc     date: 2016年1月28日
     * @param taxCode
     * @return
     */
	String getNameByTaxCode(String taxCode);
}