package com.tax.model.DO;

import java.math.BigDecimal;
import java.util.Date;

public class AddedValueTax {
    private Integer id;

    private String taxCode;

    private Integer startdate;

    private Integer enddate;

    private Integer declaredate;

    private Date addtime;

    private BigDecimal amountTax;

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

    public Integer getStartdate() {
        return startdate;
    }

    public void setStartdate(Integer startdate) {
        this.startdate = startdate;
    }

    public Integer getEnddate() {
        return enddate;
    }

    public void setEnddate(Integer enddate) {
        this.enddate = enddate;
    }

    public Integer getDeclaredate() {
        return declaredate;
    }

    public void setDeclaredate(Integer declaredate) {
        this.declaredate = declaredate;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public BigDecimal getAmountTax() {
        return amountTax;
    }

    public void setAmountTax(BigDecimal amountTax) {
        this.amountTax = amountTax;
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
        AddedValueTax other = (AddedValueTax) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaxCode() == null ? other.getTaxCode() == null : this.getTaxCode().equals(other.getTaxCode()))
            && (this.getStartdate() == null ? other.getStartdate() == null : this.getStartdate().equals(other.getStartdate()))
            && (this.getEnddate() == null ? other.getEnddate() == null : this.getEnddate().equals(other.getEnddate()))
            && (this.getDeclaredate() == null ? other.getDeclaredate() == null : this.getDeclaredate().equals(other.getDeclaredate()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getAmountTax() == null ? other.getAmountTax() == null : this.getAmountTax().equals(other.getAmountTax()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaxCode() == null) ? 0 : getTaxCode().hashCode());
        result = prime * result + ((getStartdate() == null) ? 0 : getStartdate().hashCode());
        result = prime * result + ((getEnddate() == null) ? 0 : getEnddate().hashCode());
        result = prime * result + ((getDeclaredate() == null) ? 0 : getDeclaredate().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getAmountTax() == null) ? 0 : getAmountTax().hashCode());
        return result;
    }
}