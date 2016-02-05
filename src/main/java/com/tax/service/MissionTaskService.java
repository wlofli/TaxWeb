package com.tax.service;
/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public interface MissionTaskService {
	
	/**将未执行的查询数据任务插入到待执行任务表,并修改未执行查询标志位为(1)
	 * add by lzc     date: 2016年1月28日
	 *
	 */
	public void beginMission();
	
	
	/**将未执行的查询数据任务设置错误标志位(2)
	 * add by lzc     date: 2016年1月28日
	 *
	 */
	public void failMission();

	/**重置任务列表
	 * add by lzc     date: 2016年2月2日
	 *
	 */
	public void resetTask();

	

}
