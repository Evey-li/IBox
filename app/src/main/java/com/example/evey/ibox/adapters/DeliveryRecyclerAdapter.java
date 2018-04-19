package com.example.evey.ibox.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.evey.ibox.R;
import com.example.evey.ibox.bean.Delivery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Evey on 2018/3/11.
 */

public class DeliveryRecyclerAdapter extends RecyclerView.Adapter<DeliveryRecyclerAdapter.ViewHolder> {

    private List<Delivery> deliveryList;
    private Context mContext;

    public DeliveryRecyclerAdapter(Context context, List<Delivery> deliveryList) {

        this.deliveryList = deliveryList;
        this.mContext = context;
    }

    /**
     * 创建ViewHolder
     * @param parent 父容器
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_delivery, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Delivery delivery = deliveryList.get(position);
        holder.imageView.setImageBitmap(delivery.getImage());
        holder.number.setText(String.format("运单号：%s", delivery.getNumber()));
        holder.place.setText(delivery.getPlace());
        Date time = new Date(delivery.getTime());
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sf = new SimpleDateFormat("MM-dd HH:mm");
        holder.time.setText(String.format("签收时间：%s", sf.format(time)));
    }

    @Override
    public int getItemCount() {
        return deliveryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.delivery_image)
        ImageView imageView;
        @BindView(R.id.delivery_time)
        TextView time;
        @BindView(R.id.delivery_number)
        TextView number;
        @BindView(R.id.delivery_place)
        TextView place;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
