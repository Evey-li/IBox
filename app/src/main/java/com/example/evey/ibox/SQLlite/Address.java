package com.example.evey.ibox.SQLlite;

/**
 * Created by Evey on 2018/5/9.
 */

public class Address {
    public static final String TABLE="Address";
    public static final String KEY_ID="id";
    public static final String KEY_UserID="userId";
    public static final String KEY_Name="name";
    public static final String KEY_Tel="tel";
    public static final String KEY_Province="province";
    public static final String KEY_City="city";
    public static final String KEY_District="district";
    public static final String KEY_Addr_Detail="addrDetail";

    public int Address_ID;
    public int User_ID;
    public String name;
    public String tel;
    public String province;
    public String city;
    public String district;
    public String addr_detail;

}
