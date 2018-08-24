package com.example.evey.ibox.SQLlite;

/**
 * Created by Evey on 2018/5/9.
 */

public class ServicePoint {
    public static final String TABLE="ServicePoint";
    public static final String KEY_ID="id";
    public static final String KEY_Service_Point_Name="servicePointName";
    public static final String KEY_Service_Point_Addr="servicePointAddr";
    public static final String KEY_Latitude="latitude";
        public static final String KEY_Longtitude="longitude";
    public static final String KEY_Introduce="introduce";

    public  int servicePointId;
    public String servicePointName;//快递点名字
    public String servicePointAddr;//快递点地址
    public double latitude;//快递点地址纬度
    public double longitude;//快递点地址经度
    public String introduce;//快递点介绍
}
