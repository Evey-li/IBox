package com.example.evey.ibox.bean;

import java.io.Serializable;

/**
 * 房子信息实体类
 */
public class ServicePointBean implements Serializable {

    private String servicePointName;//快递点名字
    private String address;//快递点地址
    private double latitude;//快递点地址纬度
    private double longitude;//快递点地址经度
    private String introduce;//快递点介绍

    public ServicePointBean(String servicePointName, String address, double latitude, double longitude, String introduce) {
        this.servicePointName = servicePointName;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.introduce = introduce;
    }

    public String getAddress() {
        return address;
    }

    public ServicePointBean setAddress(String address) {
        this.address = address;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public ServicePointBean setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public ServicePointBean setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getIntroduce() {
        return introduce;
    }

    public ServicePointBean setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }

    public String getServicePointName() {
        return servicePointName;
    }

    public void setServicePointName(String houseName) {
        this.servicePointName = houseName;
    }
}
