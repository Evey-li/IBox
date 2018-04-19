package com.example.evey.ibox;

import com.example.evey.ibox.bean.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evey on 2018/4/2.
 */

public class AddressData {
    public static List<Address> GetAddressData()
    {
        List<Address> addressList = new ArrayList<>();

        Address address1 = new Address("Evey","1770585110","浙江省","杭州市","萧山区","解放南路100号");
        addressList.add(address1);

        Address address2 = new Address("Marry","1234567890","浙江省","宁波市","海曙区","王家弄15号");
        addressList.add(address2);

        Address address3 = new Address("王小明","17802321854","上海","上海市","金山区","张家村520号");
        addressList.add(address3);

        Address address4 = new Address("张大福","12396584700","江苏省","南京市","鼓楼区","湖南路101号");
        addressList.add(address4);

        return addressList;
    }
}
