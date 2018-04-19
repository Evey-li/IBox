package com.example.evey.ibox.adapters;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by hwj12 on 2016/12/17.
 */

public class ItemMapBottomAdapter extends PagerAdapter {
    private List<View> iList;
    private int count = 1; //轮播图的数量

    public ItemMapBottomAdapter(List<View> iList) {
        this.iList = iList;
        count = iList.size();
    }

    @Override
    public int getCount() {
        if(count == 1) {
            return 1;
        }else{
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % count;
        View view = iList.get(newPosition);
        container.removeView(view);
        container.addView(view);
        Log.e(TAG, "instantiateItem: " + container.getChildCount());
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
