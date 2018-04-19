package com.example.evey.ibox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.evey.ibox.adapters.AddressRecycleAdapter;
import com.example.evey.ibox.bean.Address;
import com.example.evey.ibox.fragments.DeliveryFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.baidu.mapapi.BMapManager.getContext;

public class AddressListActivity extends AppCompatActivity {

    private ListView addressList;
    private AddressRecycleAdapter mAdapter;

    @BindView(R.id.address_list)
    RecyclerView recyclerView;
    @BindView(R.id.return_btn_address)
    ImageView return_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        List<Address> addresses = AddressData.GetAddressData();
        mAdapter = new AddressRecycleAdapter(getContext(), addresses);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setmOnItemClickListener(new AddressRecycleAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, Address address) {
//                Toast.makeText(AddressListActivity.this,"点击了Item",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddressListActivity.this, DeliveryFragment.class);
                intent.putExtra("Address_data",address);
                setResult(11,intent);
                finish();
            }
        });

        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
