package com.example.evey.ibox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.evey.ibox.bean.Delivery;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by Evey on 2018/3/11.
 */

public class DeliveryData {

    private static int[] imgs = new int[]{
            R.drawable.yuantong, R.drawable.tiantian,
            R.drawable.yunda, R.drawable.zhongtong, R.drawable.ems};
    private static String[] places = new String[]{
            "湖南省长沙市宁乡县老粮仓邮政所", "湖南省长沙市宁乡县中国邮政储蓄银行", "广东省佛山市高明区", "上海市徐汇区", "上海市嘉定区",
    };

    public static List<Delivery> GetDeliveryList() {
        Calendar calendar = Calendar.getInstance();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Bitmap image = BitmapFactory.decodeResource(App.getInstance().getResources(), imgs[randInt(0, imgs.length - 1)]);
            calendar.set(randInt(2013, 2017), randInt(1, 12), randInt(1, 28), randInt(1, 24), randInt(0, 59), randInt(0, 59));
            Long time = calendar.getTimeInMillis();
            String place = places[randInt(0, places.length - 1)];
            String number = "7000741" + randInt(10, 99) + "8" + randInt(10, 99);
            deliveries.add(new Delivery(image, time, place, number));
        }

        return deliveries;
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
