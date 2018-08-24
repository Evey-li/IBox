package com.example.evey.ibox.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.evey.ibox.AddressListActivity;
import com.example.evey.ibox.MainActivity;
import com.example.evey.ibox.R;
import com.example.evey.ibox.bean.Address;
import com.example.evey.ibox.bean.ServicePointBean;
import com.example.evey.ibox.receiver.Event;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Evey on 2018/3/11.
 */

public class DeliveryFragment extends Fragment {
    private View mRootView;

    @BindView(R.id.receive_address_send)
    LinearLayout receive_address;
    @BindView(R.id.send_address_send)
    LinearLayout send_address;
    @BindView(R.id.service_point_send)
    LinearLayout service_point;
    @BindView(R.id.item_type)
    LinearLayout item_type;
    @BindView(R.id.delivery_weight)
    LinearLayout delivery_weight;
    @BindView(R.id.send_type)
    LinearLayout send_type;
    @BindView(R.id.payment)
    LinearLayout payment;

    @BindView(R.id.receive_address_detail)
    TextView receive_addr_detail;
    @BindView(R.id.receiver)
    TextView receiver;
    @BindView(R.id.send_address_detail)
    TextView send_addr_detail;
    @BindView(R.id.sender)
    TextView sender;
    @BindView(R.id.service_point_address)
    TextView servicePointAddress;
    @BindView(R.id.payment_detail)
    TextView paymentDetail;
    @BindView(R.id.send_type_detail)
    TextView sendTypeDetail;
    @BindView(R.id.item_detail)
    TextView itemDetail;
    @BindView(R.id.weight)
    TextView weight;

    private Button sendDeliverySelf;
    private Button courierTakeDelivery;
    private Button senderPay;
    private Button receiverPay;
    private Button confirmWeight;
    private EditText weightDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_send, container, false);
        ButterKnife.bind(this, mRootView);
        receive_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),AddressListActivity.class);
//                startActivity(intent);
                startActivityForResult(new Intent(getActivity(), AddressListActivity.class), 1);
            }
        });


        send_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), AddressListActivity.class), 2);
            }
        });

        service_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).clickMenu(R.id.item_service_point,2);
            }
        });

        //寄件种类选择
        item_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
                View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_dialog_item, null);
                dialog.setContentView(dialogView);
                dialog.show();

                dialogView.findViewById(R.id.close_item_dialog).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                //选择文件类型
                final Button file = dialogView.findViewById(R.id.file);
                file.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemDetail.setText(file.getText().toString());
                        dialog.dismiss();
                    }
                });
                //选择数码产品类型
                final Button digital = dialogView.findViewById(R.id.digital);
                digital.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemDetail.setText(digital.getText().toString());
                        dialog.dismiss();
                    }
                });
                //选择日用品类型
                final Button dailyNecessities = dialogView.findViewById(R.id.daily_necessities);
                dailyNecessities.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemDetail.setText(dailyNecessities.getText().toString());
                        dialog.dismiss();
                    }
                });
                //选择服饰类型
                final Button close = dialogView.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemDetail.setText(close.getText().toString());
                        dialog.dismiss();
                    }
                });
                //选择食品类型
                final Button food = dialogView.findViewById(R.id.food);
                food.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemDetail.setText(food.getText().toString());
                        dialog.dismiss();
                    }
                });
                //选择其它
                final Button other = dialogView.findViewById(R.id.other);
                other.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemDetail.setText(other.getText().toString());
                        dialog.dismiss();
                    }
                });

            }
        });

        //寄件重量填写
        delivery_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
                View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_dialog_weight, null);

                dialog.setContentView(dialogView);
                dialog.show();

                dialogView.findViewById(R.id.close_weight_dialog).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                confirmWeight = (Button)dialogView.findViewById(R.id.confirm_weight);
                weightDialog = (EditText) dialogView.findViewById(R.id.weight_dialog);
                confirmWeight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        weight.setText(weightDialog.getText().toString());
                        dialog.dismiss();
                    }
                });

            }
        });

        //寄件方式选择
        send_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
                View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_dialog_send, null);

                dialog.setContentView(dialogView);
                dialog.show();

                dialogView.findViewById(R.id.close_send_dialog).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                //选择服务点自寄
                sendDeliverySelf = (Button)dialogView.findViewById(R.id.send_delivery_self);
                sendDeliverySelf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendTypeDetail.setText(sendDeliverySelf.getText().toString());
                        dialog.dismiss();
                    }
                });
                //选择快递员上门取件
                courierTakeDelivery = dialogView.findViewById(R.id.courier_take_delivery);
                courierTakeDelivery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendTypeDetail.setText(courierTakeDelivery.getText().toString());
                        dialog.dismiss();
                    }
                });
            }
        });
        //付款方式选择
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
                View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_dialog_payment, null);

                dialog.setContentView(dialogView);
                dialog.show();

                dialogView.findViewById(R.id.close_payment_dialog).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                //选择寄件人付款
                senderPay = (Button)dialogView.findViewById(R.id.sender_pay);
                senderPay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        paymentDetail.setText(senderPay.getText().toString());
                        dialog.dismiss();
                    }
                });
                //选择收件人付款
                receiverPay = dialogView.findViewById(R.id.receiver_pay);
                receiverPay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        paymentDetail.setText(receiverPay.getText().toString());
                        dialog.dismiss();
                    }
                });
            }
        });
        return mRootView;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 11) {
            Address address = data.getParcelableExtra("Address_data");
            receive_addr_detail.setText(address.toString());
            receiver.setText(address.getName() + " " + address.getTel());
        }
        if (requestCode == 2 && resultCode == 11) {
            Address address = data.getParcelableExtra("Address_data");
            send_addr_detail.setText(address.toString());
            sender.setText(address.getName() + " " + address.getTel());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Event.CODE_MAP_SERVICE_SELECT);
        getActivity().registerReceiver(new MapServiceSelectReceiver(), filter);
    }

    class MapServiceSelectReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Event.CODE_MAP_SERVICE_SELECT)) {
                ServicePointBean servicePointBean = (ServicePointBean) intent.getSerializableExtra("data");
                servicePointAddress.setText(servicePointBean.getServicePointName());
                ((MainActivity)getActivity()).clickMenu(R.id.item_my_delivery,1);
            }
        }
    }
}
