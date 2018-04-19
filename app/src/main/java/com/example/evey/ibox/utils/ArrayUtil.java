package com.example.evey.ibox.utils;

import java.util.ArrayList;

/**
 * Author:hwj
 * Time: 2016-12-19
 * Blog:www.llms.online
 */

public class ArrayUtil<T> {
    public ArrayList<T> GetArray(T ...t){
        ArrayList<T> list = new ArrayList<T>();
        for(int i=0;i<t.length;i++){
            list.add(t[i]);
        }
        return list;
    }
}
