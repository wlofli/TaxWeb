package com.tax.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tax.dao.MissionTaskMapper;
import com.tax.dao.SpiderTaxTaskMapper;
import com.tax.model.BO.MissionTaxTask;
import com.tax.model.DO.SpiderTaxTask;
import com.tax.service.MissionTaskService;
import com.tax.util.DateUtil;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@Service
public class MisstionTaskImpl  implements MissionTaskService{
	
	private Logger log = Logger.getLogger(getClass());
	
	
	@Resource
	private SpiderTaxTaskMapper spiderTaxTaskMapper;
	
	@Resource
	private MissionTaskMapper missionTaskMapper;

	@Override
	public void beginMission() {
		// TODO Auto-generated method stub
		log.info("beginMission()");
		List<MissionTaxTask> list = spiderTaxTaskMapper.getMisstionList();
		for (MissionTaxTask missionTaxTask : list) {
			updateMission(missionTaxTask);
		}
		log.info("mission succeed");
		
	}
	
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.NESTED,isolation=Isolation.REPEATABLE_READ)
	public void updateMission(MissionTaxTask missionTaxTask){
		try {
			SpiderTaxTask task= new SpiderTaxTask();
			task.setId(Integer.parseInt(missionTaxTask.getTaskId()));
			task.setStartdate(missionTaxTask.getStartDate());
			task.setEnddate(missionTaxTask.getEndDate());
			task.setStatus(0);
			spiderTaxTaskMapper.updateByPrimaryKeySelective(task);
			missionTaskMapper.updateFlagsById(missionTaxTask);
		} catch (Exception e) {
			// TODO: handle exception
			log.warn("update fail where id = " + missionTaxTask.getTaskId(), e);
		}
		
	}
	

	@Override
	public void failMission() {
		// TODO Auto-generated method stub
		log.info("fialMission(");
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class,isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED)
	public void resetTask() {
		// TODO Auto-generated method stub
		try {
			spiderTaxTaskMapper.resetTask(DateUtil.getLastMonthStartDate(),DateUtil.getLastMonthEndDate());
		} catch (Exception e) {
			// TODO: handle exception
			log.error("÷ÿ÷√»ŒŒÒ ß∞‹", e);
		}
		
	}

}
