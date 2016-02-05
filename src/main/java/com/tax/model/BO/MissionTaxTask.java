package com.tax.model.BO;
/**
 * author lzc
 * <coushuxiaolang@163.com>
 * 定时任务中间模型
 * 
 * 
 * 
 * 
 */
public class MissionTaxTask {
	private String taxCode;//
	private String taxPwd;
	private String vpdnUser;
	private String vpdnPwd;
	private String userId;//user_record_info主键
	private String startDate;//mission_task字段
	private String endDate;//mission_task字段
	private String missionId;//mission_task主键
	private String taskId;//spidertaxtask主键
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getTaxPwd() {
		return taxPwd;
	}
	public void setTaxPwd(String taxPwd) {
		this.taxPwd = taxPwd;
	}
	public String getVpdnUser() {
		return vpdnUser;
	}
	public void setVpdnUser(String vpdnUser) {
		this.vpdnUser = vpdnUser;
	}
	public String getVpdnPwd() {
		return vpdnPwd;
	}
	public void setVpdnPwd(String vpdnPwd) {
		this.vpdnPwd = vpdnPwd;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getMissionId() {
		return missionId;
	}
	public void setMissionId(String missionId) {
		this.missionId = missionId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	 
	

}
