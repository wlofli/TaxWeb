package com.tax.model.DO;

import java.util.Date;

public class SpiderTaxTask {
    private Integer id;

    private String taxcode;

    private String taxpwd;

    private String vpdnuser;

    private String vpdnpwd;

    private String startdate;

    private String enddate;

    private Integer status;

    private String msg;

    private Date updatetime;

    private Date addtime;

    private String clientid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode;
    }

    public String getTaxpwd() {
        return taxpwd;
    }

    public void setTaxpwd(String taxpwd) {
        this.taxpwd = taxpwd;
    }

    public String getVpdnuser() {
        return vpdnuser;
    }

    public void setVpdnuser(String vpdnuser) {
        this.vpdnuser = vpdnuser;
    }

    public String getVpdnpwd() {
        return vpdnpwd;
    }

    public void setVpdnpwd(String vpdnpwd) {
        this.vpdnpwd = vpdnpwd;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }
    
    public String toJson(){
    	StringBuilder sb = new StringBuilder();
    	sb.append("{");
        sb.append("\"taxcode\" : \"" + taxcode + "\", ");
        sb.append("\"taxpwd\" : \"" + taxpwd +"\", ");
        sb.append("\"vpdnuser\" : \"" + vpdnuser + "\", ");
        sb.append("\"vpdnpwd\" : \"" + vpdnpwd + "\", ");
        sb.append("\"startdate\" : \"" + startdate + "\", ");
        sb.append("\"enddate\" : \"" + enddate + "\", ");
        sb.append("\"taskid\" : " + id);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SpiderTaxTask other = (SpiderTaxTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaxcode() == null ? other.getTaxcode() == null : this.getTaxcode().equals(other.getTaxcode()))
            && (this.getTaxpwd() == null ? other.getTaxpwd() == null : this.getTaxpwd().equals(other.getTaxpwd()))
            && (this.getVpdnuser() == null ? other.getVpdnuser() == null : this.getVpdnuser().equals(other.getVpdnuser()))
            && (this.getVpdnpwd() == null ? other.getVpdnpwd() == null : this.getVpdnpwd().equals(other.getVpdnpwd()))
            && (this.getStartdate() == null ? other.getStartdate() == null : this.getStartdate().equals(other.getStartdate()))
            && (this.getEnddate() == null ? other.getEnddate() == null : this.getEnddate().equals(other.getEnddate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMsg() == null ? other.getMsg() == null : this.getMsg().equals(other.getMsg()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getClientid() == null ? other.getClientid() == null : this.getClientid().equals(other.getClientid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaxcode() == null) ? 0 : getTaxcode().hashCode());
        result = prime * result + ((getTaxpwd() == null) ? 0 : getTaxpwd().hashCode());
        result = prime * result + ((getVpdnuser() == null) ? 0 : getVpdnuser().hashCode());
        result = prime * result + ((getVpdnpwd() == null) ? 0 : getVpdnpwd().hashCode());
        result = prime * result + ((getStartdate() == null) ? 0 : getStartdate().hashCode());
        result = prime * result + ((getEnddate() == null) ? 0 : getEnddate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMsg() == null) ? 0 : getMsg().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getClientid() == null) ? 0 : getClientid().hashCode());
        return result;
    }
}