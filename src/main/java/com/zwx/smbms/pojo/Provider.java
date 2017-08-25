package com.zwx.smbms.pojo;

import java.util.Date;

/**
 *供应商定义类
 */
public class Provider {
    private int id;//供应商ID
    private String proCode;//供应商编码
    private String proName;//供应商姓名
    private String proDesc;//供应商描述
    private String proContact;//供应商联系人
    private String proPhone;//供应商电话
    private String proAddress;//供应商地址
    private String proFax;//供应商传真
    private int createdBy;//该供应商创建者
    private Date creationDate;//该供应商创建日期
    private int modifyBy;//该供应商更新者
    private Date modifyDate;//该供应商更新日期


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getProCode() {
        return proCode;
    }


    public void setProCode(String proCode) {
        this.proCode = proCode;
    }


    public String getProName() {
        return proName;
    }


    public void setProName(String proName) {
        this.proName = proName;
    }


    public String getProDesc() {
        return proDesc;
    }


    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }


    public String getProContact() {
        return proContact;
    }


    public void setProContact(String proContact) {
        this.proContact = proContact;
    }


    public String getProPhone() {
        return proPhone;
    }


    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }


    public String getProAddress() {
        return proAddress;
    }


    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }


    public String getProFax() {
        return proFax;
    }


    public void setProFax(String proFax) {
        this.proFax = proFax;
    }


    public int getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }


    public Date getCreationDate() {
        return creationDate;
    }


    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public int getModifyBy() {
        return modifyBy;
    }


    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }


    public Date getModifyDate() {
        return modifyDate;
    }


    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }


    @Override
    public String toString() {
        return "Provider [id=" + id + ", proCode=" + proCode + ", proName="
                + proName + ", proDesc=" + proDesc + ", proContact="
                + proContact + ", proPhone=" + proPhone + ", proAddress="
                + proAddress + ", proFax=" + proFax + ", createdBy="
                + createdBy + ", creationDate=" + creationDate + ", modifyBy="
                + modifyBy + ", modifyDate=" + modifyDate + "]";
    }



}

