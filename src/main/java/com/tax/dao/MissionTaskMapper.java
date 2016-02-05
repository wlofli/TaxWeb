package com.tax.dao;

import com.tax.model.BO.MissionTaxTask;
import com.tax.model.DO.MissionTask;

public interface MissionTaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(MissionTask record);

    int insertSelective(MissionTask record);

    MissionTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MissionTask record);

    int updateByPrimaryKey(MissionTask record);

    
    /**更新任务标记
     * add by lzc     date: 2016年1月30日
     * @param missionTaxTask
     */
	void updateFlagsById(MissionTaxTask missionTaxTask);
}