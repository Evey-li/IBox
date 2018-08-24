package com.example.evey.ibox.SQLlite;

/**
 * Created by Evey on 2018/5/9.
 */

public class Order {
    public static final String TABLE="Orders";
    public static final String KEY_ID="id";
    public static final String KEY_Send_Addr_ID="sendAddrId";
    public static final String KEY_Receive_Addr_ID="receiveAddrId";
    public static final String KEY_Service_Point_ID="servicePointId";
    public static final String KEY_Delivery_Type="deliveryType";
    public static final String KEY_Send_Type="sendType";
    public static final String KEY_Payment="payment";
    public static final String KEY_Express_Fee="expressFee";

    public int order_id;
    public int send_addr_id;
    public int receive_addr_id;
    public int service_point_id;
    public String delivery_type;
    public String send_type;
    public String payment;
    public Number express_fee;

}
