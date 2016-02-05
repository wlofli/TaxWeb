package com.tax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tax.model.DO.Balancesheet;

public interface BalancesheetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Balancesheet record);

    int insertSelective(Balancesheet record);

    Balancesheet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Balancesheet record);

    int updateByPrimaryKeyWithBLOBs(Balancesheet record);

    int updateByPrimaryKey(Balancesheet record);
    
    /**获取近三个月的资产负债表信息
     * add by lzc     date: 2016年1月26日
     * @param taxCode
     * @param startDate
     * @param endDate
     * @return
     */
    List<Balancesheet> getLast3MonthBalancesheets(@Param("taxCode")String taxCode, @Param("startDate")int startDate, 
    		@Param("endDate")int endDate);
    
    /**获取**年的资产负债表信息
     * add by lzc     date: 2016年1月26日
     * @param taxCode
     * @param year
     * @return
     */
    List<Balancesheet> getBalancesheetsByYear(@Param("taxCode")String taxCode, @Param("year")int year);
    
    
    Balancesheet getBalancesheetByTaxCode(@Param("taxCode")String taxCode, @Param("reportDate")String ReportDate);
    
    
    /**根据报告日期获取资产负债表
     * add by lzc     date: 2016年2月1日
     * @param taxCode
     * @param ReportDate
     * @return
     */
    Balancesheet getBalanceSheetByReprotDate(@Param("taxCode")String taxCode, @Param("reportDate")Integer ReportDate);
    
    
}