package com.tax.model.DO;

public class Profitstatement {
    private Integer id;

    private String taxCode;

    private Integer reportDate;

    private String reportContent;

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

    public Integer getReportDate() {
        return reportDate;
    }

    public void setReportDate(Integer reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
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
        Profitstatement other = (Profitstatement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaxCode() == null ? other.getTaxCode() == null : this.getTaxCode().equals(other.getTaxCode()))
            && (this.getReportDate() == null ? other.getReportDate() == null : this.getReportDate().equals(other.getReportDate()))
            && (this.getReportContent() == null ? other.getReportContent() == null : this.getReportContent().equals(other.getReportContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaxCode() == null) ? 0 : getTaxCode().hashCode());
        result = prime * result + ((getReportDate() == null) ? 0 : getReportDate().hashCode());
        result = prime * result + ((getReportContent() == null) ? 0 : getReportContent().hashCode());
        return result;
    }
}