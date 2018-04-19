package com.example.evey.ibox.bean;

import java.util.List;

/**
 * Author:hwj
 * Time: 2016-12-21
 * Blog:www.llms.online
 */

public class CityBean {
    private String name;//城市的名字
    private String pictureUrl;//城市的照片地址
    private String introduce;//城市介绍
    private List<ServicePointBean> houseList;

    public CityBean(String name, String pictureUrl, String introduce, List<ServicePointBean> houseList) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.introduce = introduce;
        this.houseList = houseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public List<ServicePointBean> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<ServicePointBean> houseList) {
        this.houseList = houseList;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

}
