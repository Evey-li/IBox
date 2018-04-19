package com.example.evey.ibox.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Evey on 2018/3/31.
 */

public class Address implements Parcelable {

    private String name;
    private String tel;
    private String province;
    private String city;
    private String district;
    private String detail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Address(){

    }

    public Address (String name,String tel,String province,String city,String district,String detail)
    {
        this.name = name;
        this.tel = tel;
        this.province = province;
        this.city = city;
        this.district = district;
        this.detail =  detail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.tel);
        dest.writeString(this.province);
        dest.writeString(this.city);
        dest.writeString(this.district);
        dest.writeString(this.detail);
    }

    protected Address(Parcel in) {
        this.name = in.readString();
        this.tel = in.readString();
        this.province = in.readString();
        this.city = in.readString();
        this.district = in.readString();
        this.detail = in.readString();
    }

    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel source) {
            return new Address(source);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    @Override
    public String toString() {
        return province + " " + city + " " + district + " " + detail;
    }
}
