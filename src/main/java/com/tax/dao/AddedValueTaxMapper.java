package com.tax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tax.model.DO.AddedValueTax;

public interface AddedValueTaxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddedValueTax record);

    int insertSelective(AddedValueTax record);

    AddedValueTax selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddedValueTax record);

    int updateByPrimaryKey(AddedValueTax record);
    
    /**获取最近三个月的增值税记录
     * add by lzc     date: 2016年1月26日
     * @param startDate
     * @param endDate
     * @param taxCode
     * @return
     */
    List<AddedValueTax> getAddedValueLastThreeMonth(@Param("startDate")int startDate, 
    		@Param("endDate")int endDate, @Param("taxCode")String taxCode, @Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
    
    /**获取某年的增值税记录
     * add by lzc     date: 2016年1月26日
     * @param year
     * @param taxCode
     * @return
     */
    List<AddedValueTax> getAddedValueByYear(@Param("year")int year, @Param ("taxCode")String taxCode, @Param("pageNo")int pageNo,
    		@Param("pageSize")int pageSize);

    /**获取增值税记录
     * add by lzc     date: 2016年2月1日
     * @param declareDate
     * @param taxCode
     * @return
     */
	AddedValueTax getAddedValueByTaxCode(@Param("declareDate")Integer declareDate, @Param("taxCode")String taxCode);
    
    
}