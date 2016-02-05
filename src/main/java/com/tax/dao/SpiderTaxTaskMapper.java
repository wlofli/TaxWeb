package com.tax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tax.model.BO.MissionTaxTask;
import com.tax.model.DO.SpiderTaxTask;

public interface SpiderTaxTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpiderTaxTask record);

    int insertSelective(SpiderTaxTask record);

    SpiderTaxTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpiderTaxTask record);

    int updateByPrimaryKey(SpiderTaxTask record);
    
    /**是否存在查询企业信息
     * add by lzc     date: 2016年1月25日
     * @param task
     * @return 
     */
    int isExistSpiderTask(SpiderTaxTask task);
    
    
    SpiderTaxTask getTaskByTaxCode(SpiderTaxTask task);
    
    /**根据task获取企业信息
     * add by lzc     date: 2016年1月27日
     * @param task
     * @return
     */
    String getMsg(SpiderTaxTask task);
    
    
    /**根据task获取企业信息
     * add by lzc     date: 2016年1月27日
     * @param task
     * @return
     */
	int getStatus(SpiderTaxTask task);

	
	/**获取待执行任务unimpl
	 * add by lzc     date: 2016年1月29日
	 * @return
	 */
	List<MissionTaxTask> getMisstionList();

	
	/**获取任务
	 * add by lzc     date: 2016年2月1日
	 * @return
	 */
	SpiderTaxTask getReadyTask();
	
	/**
	 * add by lzc     date: 2016年2月1日
	 * @param clientId
	 * @param id
	 * @return
	 */
	int updateTask(@Param("clientId")String clientId, @Param("id")int id);
	
	
	/**重置状态值100->0与开始结束日期
	 * add by lzc     date: 2016年2月2日
	 * @param lastMonthStartDate
	 * @param lastMonthEndDate
	 */
	void resetTask(@Param("startDate")int lastMonthStartDate, @Param("endDate")int lastMonthEndDate);
	
	
	/**根据账户密码获取task
	 * add by lzc     date: 2016年2月3日
	 * @param taxcode
	 * @param taxpwd
	 * @param vpdnuser
	 * @param vpdnpwd
	 * @return
	 */
	SpiderTaxTask getTaskByAccount(@Param("taxCode")String taxCode, @Param("taxPwd")String taxPwd, @Param("vpdnUser")String vpdnUser, 
			@Param("vpdnPwd")String vpdnpwd);
    
    
}