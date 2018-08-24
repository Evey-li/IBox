package com.example.evey.ibox.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evey.ibox.LoginActivity;
import com.example.evey.ibox.MembersActivity;
import com.example.evey.ibox.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Evey on 2018/3/11.
 */

public class MyFragment extends Fragment{
    private View mRootView;
    @BindView(R.id.btn_log_reg)
    TextView log_reg;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_my, container, false);

        ButterKnife.bind(this,mRootView);//绑定View

        mRootView.findViewById(R.id.btn_log_reg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);

                startActivityForResult(intent,100);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && requestCode == 101){
            String userName = data.getStringExtra("user_name");
            log_reg.setText(userName);
        }
    }
}
