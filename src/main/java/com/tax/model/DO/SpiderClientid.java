package com.tax.model.DO;

public class SpiderClientid {
    private String clientid;

    private String passwordClient;

    private String remark;

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getPasswordClient() {
        return passwordClient;
    }

    public void setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        SpiderClientid other = (SpiderClientid) that;
        return (this.getClientid() == null ? other.getClientid() == null : this.getClientid().equals(other.getClientid()))
            && (this.getPasswordClient() == null ? other.getPasswordClient() == null : this.getPasswordClient().equals(other.getPasswordClient()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClientid() == null) ? 0 : getClientid().hashCode());
        result = prime * result + ((getPasswordClient() == null) ? 0 : getPasswordClient().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}