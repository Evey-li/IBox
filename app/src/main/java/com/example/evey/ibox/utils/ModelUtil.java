package com.example.evey.ibox.utils;

import com.example.evey.ibox.bean.CityBean;
import com.example.evey.ibox.bean.ServicePointBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:hwj
 * Time: 2016-12-19
 * Blog:www.llms.online
 */

public class ModelUtil {

    public static List<CityBean> GetCityData() {
        List<CityBean> cityList = new ArrayList<CityBean>();
        List<ServicePointBean> houseList = new ArrayList<ServicePointBean>();

        houseList.add(new ServicePointBean("万达广场韵达物流点", "万达广场6号写字楼一楼" , 31.245475, 121.326519,
                "寄件服务|代收快递"));

        houseList.add(new ServicePointBean("华庄顺丰快递超市", "华庄中心村100号", 31.239609, 121.323608,
                "寄件服务|代收快递" ));

        houseList.add(new ServicePointBean("沙河名苑中通快递点", "白石路30号",  31.240597, 121.330615,
                " 寄件服务|代收快递"));

        houseList.add(new ServicePointBean("馥郁园申通快递点", "成和路20号北门",31.236675, 121.325728,
                "寄件服务|代收快递"));

        houseList.add(new ServicePointBean("大联圆通物流点", "环城西路480号",31.243344, 121.337838,
                "寄件服务|代收快递"));


        for (int i = 0; i < 5; i++) {
            cityList.add(new CityBean("北京", "http://bbs.yduoo.com/attachment/Fid_146/146_46_31c06d26eef7973.jpg",
                    "香风绕白塔,一池粼波画连廊", houseList));

        }
        return cityList;
    }


//    public static Pair<List<String>, List<String>> GetBannerData() {
//        List<String> bannerImageUrl = new ArrayList<String>();
//        bannerImageUrl.add("https://z0.muscache.com/im/pictures/75412362/a399ac26_original.jpg?aki_policy=xx_large");
//        bannerImageUrl.add("https://z2.muscache.com/im/pictures/75412557/bd73c3b8_original.jpg?aki_policy=x_large");
//        bannerImageUrl.add("https://z1.muscache.com/im/pictures/75412779/5f1a9886_original.jpg?aki_policy=x_large");
//        bannerImageUrl.add("https://z1.muscache.com/im/pictures/105692109/ccc51ffa_original.jpg?aki_policy=x_large");
//        List<String> bannerIntroduce = new ArrayList<String>();
//        bannerIntroduce.add("静水流深，沧笙踏歌；三生阴晴圆缺，一朝悲欢离合。");
//        bannerIntroduce.add("人世间有百媚千红，唯独你是我情之所钟。");
//        bannerIntroduce.add("生能尽欢，死亦无憾。");
//        bannerIntroduce.add("蓄起亘古的情丝，揉碎殷红的相思。");
//        return new Pair<>(bannerImageUrl, bannerIntroduce);
//    }


//    public static List<String> GetHotCityList() {
//        List<String> hotCityList = new ArrayList<>();
//
//        hotCityList.add("北京");
//        hotCityList.add("三亚");
//        hotCityList.add("广州");
//        hotCityList.add("上海");
//        hotCityList.add("成都");
//        hotCityList.add("南京");
//        hotCityList.add("杭州");
//        hotCityList.add("厦门");
//        hotCityList.add("深圳");
//        hotCityList.add("重庆");
//        hotCityList.add("大连");
//
//        return hotCityList;
//    }


//    public static List<android.support.v4.util.Pair<String, String>> GetInformationSetting() {
//        List<android.support.v4.util.Pair<String, String>> list = new ArrayList<>();
//        android.support.v4.util.Pair<String, String> pair = new android.support.v4.util.Pair<>("积分", "0");
//        list.add(pair);
//        pair = new android.support.v4.util.Pair<>("体验券", "0");
//        list.add(pair);
//        pair = new android.support.v4.util.Pair<>("代金券", "0");
//        list.add(pair);
//        pair = new android.support.v4.util.Pair<>("余额", "0");
//        list.add(pair);
//        pair = new android.support.v4.util.Pair<>("芝麻信用绑定", "");
//        list.add(pair);
//
//        pair = new android.support.v4.util.Pair<>("邀请好友", "");
//        list.add(pair);
//        pair = new android.support.v4.util.Pair<>("积分兑换", "");
//        list.add(pair);
//        pair = new android.support.v4.util.Pair<>("在线客服", "");
//        list.add(pair);
//        pair = new android.support.v4.util.Pair<>("反馈与投诉", "");
//        list.add(pair);
//        pair = new android.support.v4.util.Pair<>("客服电话", "312-312-312");
//        list.add(pair);
//        pair = new android.support.v4.util.Pair<>("我要成为房东", "");
//        list.add(pair);
//        pair = new android.support.v4.util.Pair<>("帮助", "");
//        list.add(pair);
//
//        return list;
//    }

}
