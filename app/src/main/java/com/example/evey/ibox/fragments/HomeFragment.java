package com.example.evey.ibox.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evey.ibox.DeliveryData;
import com.example.evey.ibox.R;
import com.example.evey.ibox.adapters.DeliveryRecyclerAdapter;
import com.example.evey.ibox.bean.Delivery;
import com.shizhefei.view.indicator.BannerComponent;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Evey on 2018/3/11.
 */

public class HomeFragment extends Fragment {

    private View mRootView;
    private DeliveryRecyclerAdapter mAdapter;
    private BannerComponent bannerComponent;

    @BindView(R.id.search_btn)
    TextView searchBtn;
    @BindView(R.id.delivery_list)
    RecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,mRootView);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"点击了按钮",Toast.LENGTH_SHORT).show();
            }
        });

        /*ViewPager实现轮播图*/
        ViewPager viewPager = (ViewPager) mRootView.findViewById(R.id.banner_viewPager);
        Indicator indicator = (Indicator) mRootView.findViewById(R.id.banner_indicator);
        indicator.setScrollBar(new ColorBar(getContext(), Color.WHITE, 0, ScrollBar.Gravity.CENTENT_BACKGROUND));
        viewPager.setOffscreenPageLimit(2);
        bannerComponent = new BannerComponent(indicator, viewPager, false);
        bannerComponent.setAdapter(adapter);
        bannerComponent.setAutoPlayTime(2500);


        /*最新快递信息列表*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        List<Delivery> deliveries = DeliveryData.GetDeliveryList();
        mAdapter = new DeliveryRecyclerAdapter(getContext(), deliveries);
        recyclerView.setAdapter(mAdapter);

        return mRootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        bannerComponent.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        bannerComponent.stopAutoPlay();
    }

    private int[] images = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4};

    private IndicatorViewPager.IndicatorViewPagerAdapter adapter = new IndicatorViewPager.IndicatorViewPagerAdapter() {

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = new View(container.getContext());
            }
            return convertView;
        }

        @Override
        public View getViewForPage(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = new ImageView(getContext());
                convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
            ImageView imageView = (ImageView) convertView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(images[position]);
            return convertView;
        }

        @Override
        public int getCount() {
            return images.length;
        }
    };
}
