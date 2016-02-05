package com.tax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tax.model.DO.Profitstatement;

public interface ProfitstatementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Profitstatement record);

    int insertSelective(Profitstatement record);

    Profitstatement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Profitstatement record);

    int updateByPrimaryKeyWithBLOBs(Profitstatement record);

    int updateByPrimaryKey(Profitstatement record);
    
    /**获取近3月的数据
     * add by lzc     date: 2016年1月28日
     * @param taxCode
     * @param startDate
     * @param endDate
     * @return
     */
    List<Profitstatement> getLast3MonthProfitByTaxCode(@Param("taxCode")String taxCode, @Param("startDate")int startDate,
    		@Param("endDate")int endDate);
    
    /**获取year年的数据
     * add by lzc     date: 2016年1月28日
     * @param taxCode
     * @param year
     * @return
     */
    List<Profitstatement> getProfitByYear(@Param("taxCode")String taxCode, @Param("year")int year);
    
    
    Profitstatement getProfitstatementByTaxCode(@Param("taxCode")String taxCode, @Param("date")int date);

    
    /**获取profit数据
     * add by lzc     date: 2016年2月1日
     * @param taxCode
     * @param reportDate
     * @return
     */
	Profitstatement getProfitByReportDate(@Param("taxCode")String taxCode, @Param("reprotDate")Integer reportDate);
    
    
}