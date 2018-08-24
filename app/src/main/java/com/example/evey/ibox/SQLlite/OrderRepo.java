package com.example.evey.ibox.SQLlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Evey on 2018/5/9.
 */

public class OrderRepo {
    private DBHelper dbHelper;

    public OrderRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Order order) {
        //打开连接，写入数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Order.KEY_Send_Addr_ID, order.send_addr_id);
        values.put(Order.KEY_Receive_Addr_ID, order.receive_addr_id);
        values.put(Order.KEY_Service_Point_ID, order.service_point_id);
        values.put(Order.KEY_Delivery_Type, order.delivery_type);
        values.put(Order.KEY_Send_Type, order.send_type);
        values.put(Order.KEY_Payment, order.payment);
        values.put(Order.KEY_Express_Fee, order.express_fee.toString());

        long Order_Id = db.insert(Order.TABLE, null, values);
        db.close();
        return (int) Order_Id;
    }

    public void delete(int order_Id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Order.TABLE, Order.KEY_ID + "=?", new String[]{String.valueOf(order_Id)});
        db.close();
    }

    public void update(Order order) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Order.KEY_Send_Addr_ID, order.send_addr_id);
        values.put(Order.KEY_Receive_Addr_ID, order.receive_addr_id);
        values.put(Order.KEY_Service_Point_ID, order.service_point_id);
        values.put(Order.KEY_Delivery_Type, order.delivery_type);
        values.put(Order.KEY_Send_Type, order.send_type);
        values.put(Order.KEY_Payment, order.payment);
        values.put(Order.KEY_Express_Fee, order.express_fee.toString());

        db.update(Order.TABLE, values, Order.KEY_ID + "=?", new String[]{String.valueOf(order.order_id)});
        db.close();
    }

    public ArrayList<HashMap<String, String>> getOrdersList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                Order.KEY_ID + "," +
                Order.KEY_Send_Addr_ID + "," +
                Order.KEY_Receive_Addr_ID + "," +
                Order.KEY_Service_Point_ID + "," +
                Order.KEY_Delivery_Type + "," +
                Order.KEY_Send_Type + "," +
                Order.KEY_Payment + "," +
                Order.KEY_Express_Fee + " FROM " + Order.TABLE;
        ArrayList<HashMap<String, String>> ordersList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> order = new HashMap<String, String>();
                order.put("id", cursor.getString(cursor.getColumnIndex(Order.KEY_ID)));
                order.put("sendAddrId", cursor.getString(cursor.getColumnIndex(Order.KEY_Send_Addr_ID)));
                order.put("receiveAddrId", cursor.getString(cursor.getColumnIndex(Order.KEY_Receive_Addr_ID)));
                order.put("servicePointId", cursor.getString(cursor.getColumnIndex(Order.KEY_Service_Point_ID)));
                order.put("deliveryType", cursor.getString(cursor.getColumnIndex(Order.KEY_Delivery_Type)));
                order.put("sendType", cursor.getString(cursor.getColumnIndex(Order.KEY_Send_Type)));
                order.put("payment", cursor.getString(cursor.getColumnIndex(Order.KEY_Payment)));
                order.put("expressFee", cursor.getString(cursor.getColumnIndex(Order.KEY_Express_Fee)));
                ordersList.add(order);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ordersList;
    }

    public Order getOrderById(int Id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                Order.KEY_ID + "," +
                Order.KEY_Send_Addr_ID + "," +
                Order.KEY_Receive_Addr_ID + "," +
                Order.KEY_Service_Point_ID + "," +
                Order.KEY_Delivery_Type + "," +
                Order.KEY_Send_Type + "," +
                Order.KEY_Payment + "," +
                Order.KEY_Express_Fee + " FROM " + Order.TABLE + " WHERE " + Order.KEY_ID + "=?";
        int iCount = 0;
        Order order = new Order();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});
        if (cursor.moveToFirst()) {
            do {
                order.order_id = cursor.getInt(cursor.getColumnIndex(Order.KEY_ID));
                order.send_addr_id = cursor.getInt(cursor.getColumnIndex(Order.KEY_Send_Addr_ID));
                order.receive_addr_id = cursor.getInt(cursor.getColumnIndex(Order.KEY_Receive_Addr_ID));
                order.service_point_id = cursor.getInt(cursor.getColumnIndex(Order.KEY_Service_Point_ID));
                order.delivery_type = cursor.getString(cursor.getColumnIndex(Order.KEY_Delivery_Type));
                order.send_type = cursor.getString(cursor.getColumnIndex(Order.KEY_Send_Type));
                order.payment = cursor.getString(cursor.getColumnIndex(Order.KEY_Payment));
                order.express_fee = cursor.getDouble(cursor.getColumnIndex(Order.KEY_Express_Fee));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return order;
    }
}
