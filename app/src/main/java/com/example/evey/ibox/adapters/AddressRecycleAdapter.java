package com.example.evey.ibox.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evey.ibox.R;
import com.example.evey.ibox.bean.Address;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Evey on 2018/3/31.
 */

public class AddressRecycleAdapter extends RecyclerView.Adapter<AddressRecycleAdapter.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<Address> addressList;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public AddressRecycleAdapter(Context mContext, List<Address> addressList) {
        this.addressList = addressList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false));

        View view = View.inflate(mContext,R.layout.list_item,null);
        ViewHolder myViewHolder = new ViewHolder(view);
        //设置RecycleView的item监听
        view.setOnClickListener(this);
        return myViewHolder;
    }
    @Override
    public void onClick(View view) {

        if (mOnItemClickListener != null)
        {
            mOnItemClickListener.onItemClick(view, (Address) view.getTag());
        }
    }
    public void setmOnItemClickListener(OnRecyclerViewItemClickListener listener){
        this.mOnItemClickListener = listener;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Address address = addressList.get(position);
        holder.name.setText(address.getName());
        holder.tel.setText(address.getTel());
        holder.province.setText(address.getProvince());
        holder.city.setText(address.getCity());
        holder.district.setText(address.getDistrict());
        holder.address_detail.setText(address.getDetail());

        //将数据保存在itemView的Tag中，以便点击时获取
        holder.itemView.setTag(addressList.get(position));

    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.tel)
        TextView tel;
        @BindView(R.id.province)
        TextView province;
        @BindView(R.id.city)
        TextView city;
        @BindView(R.id.district)
        TextView district;
        @BindView(R.id.address_detail)
        TextView address_detail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public interface OnRecyclerViewItemClickListener{
        void onItemClick(View view,Address address);
    }
}
