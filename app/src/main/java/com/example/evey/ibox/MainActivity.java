package com.example.evey.ibox;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.evey.ibox.fragments.DeliveryFragment;
import com.example.evey.ibox.fragments.HomeFragment;
import com.example.evey.ibox.fragments.MyFragment;
import com.example.evey.ibox.fragments.ServicePointFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements
        NavHelper.OnTabChangedListener<Integer>, EasyPermissions.PermissionCallbacks {

    private NavHelper<Integer> mNavHelper;
    private BottomNavigationViewEx navigationView;


    public interface OnBottomMenuChangeListener{
        void onChange(@IdRes int itemId);
    }

    private static final int RC_PERS_CALL_BACK = 0x111;
    private String[] perms = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_NETWORK_STATE};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EasyPermissions.requestPermissions(this, "权限", RC_PERS_CALL_BACK, perms);
        initView();
    }

    private void initView() {
        mNavHelper = new NavHelper<>(this, getSupportFragmentManager(), R.id.container_fl, this);
        mNavHelper.add(R.id.item_home_page, new NavHelper.Tab<Integer>(HomeFragment.class, R.id.item_home_page))
                .add(R.id.item_my_delivery, new NavHelper.Tab<Integer>(DeliveryFragment.class, R.id.item_my_delivery))
                .add(R.id.item_service_point, new NavHelper.Tab<Integer>(ServicePointFragment.class, R.id.item_service_point))
                .add(R.id.item_my, new NavHelper.Tab<Integer>(MyFragment.class, R.id.item_my));
        mNavHelper.performClickMenu(R.id.item_home_page);
        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.enableAnimation(true);
        navigationView.enableShiftingMode(false);
        navigationView.enableItemShiftingMode(false);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mNavHelper.performClickMenu(item.getItemId());
                return true;
            }
        });
    }

    public void clickMenu(@IdRes int itemId,int index){
        mNavHelper.performClickMenu(itemId);
        navigationView.setCurrentItem(index);
    }
    @Override
    public void onTabChanged(NavHelper.Tab<Integer> newTab, NavHelper.Tab<Integer> oldTab) {
    }

    @AfterPermissionGranted(RC_PERS_CALL_BACK)
    private void permissionCallBack() {
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            // ...
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, "权限需求", RC_PERS_CALL_BACK, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }
}

