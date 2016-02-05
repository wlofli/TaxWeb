package com.tax.util;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tax.service.MissionTaskService;
import com.tax.service.SpiderTaskService;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@Component
public class TimerUtil {

	private Logger log = Logger.getLogger(getClass());
	
	
	@Resource
	private MissionTaskService missionTaskService;
	
	@Resource
	private SpiderTaskService spiderTaskService;
	
	
	public void resetTask(){
		log.debug("每月查询任务开始 " + new Date());
		missionTaskService.resetTask();
		log.debug("每月查询任务结束 " + new Date());
	}
	
	
	
	
	
}
