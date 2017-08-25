package com.zwx.smbms.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    private int id;//账单ID
    private String billCode;//账单编码
    private String productName;//商品名称
    private String productDesc;//商品描述
    private String productUnit;//商品单位
    private BigDecimal productCount;//商品数量
    private BigDecimal totalPrice;//商品价格
    private int isPayment;//是否已付款（1.已付款2.未付款）
    private int providerId;//供应商ID
    private Date creationDate;//创建日期
    private int createdBy;//创建人
    private Date modifyDate;//更新日期
    private int modifyBy;//更新者

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBillCode() {
        return billCode;
    }
    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDesc() {
        return productDesc;
    }
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
    public String getProductUnit() {
        return productUnit;
    }
    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }
    public BigDecimal getProductCount() {
        return productCount;
    }
    public void setProductCount(BigDecimal productCount) {
        this.productCount = productCount;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getIsPayment() {
        return isPayment;
    }
    public void setIsPayment(int isPayment) {
        this.isPayment = isPayment;
    }
    public int getProviderId() {
        return providerId;
    }
    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public int getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
    public Date getModifyDate() {
        return modifyDate;
    }
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    public int getModifyBy() {
        return modifyBy;
    }
    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }
    @Override
    public String toString() {
        return "Bill [id=" + id + ", billCode=" + billCode + ", productName="
                + productName + ", productDesc=" + productDesc
                + ", productUnit=" + productUnit + ", productCount="
                + productCount + ", totalPrice=" + totalPrice + ", isPayment="
                + isPayment + ", providerId=" + providerId + ", creationDate="
                + creationDate + ", createdBy=" + createdBy + ", modifyDate="
                + modifyDate + ", modifyBy=" + modifyBy + "]";
    }
}
