package com.example.evey.ibox.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evey.ibox.LoginActivity;
import com.example.evey.ibox.MembersActivity;
import com.example.evey.ibox.R;

/**
 * Created by Evey on 2018/3/11.
 */

public class MyFragment extends Fragment{
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_my, container, false);

        mRootView.findViewById(R.id.btn_log_reg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        mRootView.findViewById(R.id.membership).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MembersActivity.class);
                startActivity(intent);
            }
        });
        return mRootView;
    }
}
