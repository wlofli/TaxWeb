package com.tax.model.DO;

import java.util.Date;

public class TaxOrgInfoLog {
    private Integer id;

    private String taxCode;

    private String name;

    private String address;

    private String taxOrg;

    private String regtype;

    private String industry;

    private String tel;

    private String legalPerson;

    private String mOrg;

    private String cOrg;

    private String chargeCode;

    private String mobile;

    private Date addtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxOrg() {
        return taxOrg;
    }

    public void setTaxOrg(String taxOrg) {
        this.taxOrg = taxOrg;
    }

    public String getRegtype() {
        return regtype;
    }

    public void setRegtype(String regtype) {
        this.regtype = regtype;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getmOrg() {
        return mOrg;
    }

    public void setmOrg(String mOrg) {
        this.mOrg = mOrg;
    }

    public String getcOrg() {
        return cOrg;
    }

    public void setcOrg(String cOrg) {
        this.cOrg = cOrg;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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
        TaxOrgInfoLog other = (TaxOrgInfoLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaxCode() == null ? other.getTaxCode() == null : this.getTaxCode().equals(other.getTaxCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getTaxOrg() == null ? other.getTaxOrg() == null : this.getTaxOrg().equals(other.getTaxOrg()))
            && (this.getRegtype() == null ? other.getRegtype() == null : this.getRegtype().equals(other.getRegtype()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getLegalPerson() == null ? other.getLegalPerson() == null : this.getLegalPerson().equals(other.getLegalPerson()))
            && (this.getmOrg() == null ? other.getmOrg() == null : this.getmOrg().equals(other.getmOrg()))
            && (this.getcOrg() == null ? other.getcOrg() == null : this.getcOrg().equals(other.getcOrg()))
            && (this.getChargeCode() == null ? other.getChargeCode() == null : this.getChargeCode().equals(other.getChargeCode()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaxCode() == null) ? 0 : getTaxCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getTaxOrg() == null) ? 0 : getTaxOrg().hashCode());
        result = prime * result + ((getRegtype() == null) ? 0 : getRegtype().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getLegalPerson() == null) ? 0 : getLegalPerson().hashCode());
        result = prime * result + ((getmOrg() == null) ? 0 : getmOrg().hashCode());
        result = prime * result + ((getcOrg() == null) ? 0 : getcOrg().hashCode());
        result = prime * result + ((getChargeCode() == null) ? 0 : getChargeCode().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }
}