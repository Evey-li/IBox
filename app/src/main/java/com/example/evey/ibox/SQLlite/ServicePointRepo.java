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

public class ServicePointRepo {
    private DBHelper dbHelper;

    public ServicePointRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(ServicePoint servicePoint) {
        //打开连接，写入数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ServicePoint.KEY_Service_Point_Name, servicePoint.servicePointName);
        values.put(ServicePoint.KEY_Service_Point_Addr, servicePoint.servicePointAddr);
        values.put(ServicePoint.KEY_Latitude, servicePoint.latitude);
        values.put(ServicePoint.KEY_Longtitude, servicePoint.longitude);
        values.put(ServicePoint.KEY_Introduce, servicePoint.introduce);

        long service_point_Id = db.insert(ServicePoint.TABLE, null, values);
        db.close();
        return (int) service_point_Id;
    }

    public void delete(int service_point_id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(ServicePoint.TABLE, ServicePoint.KEY_ID + "=?", new String[]{String.valueOf(service_point_id)});
        db.close();
    }

    public void update(ServicePoint servicePoint) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ServicePoint.KEY_Service_Point_Name, servicePoint.servicePointName);
        values.put(ServicePoint.KEY_Service_Point_Addr, servicePoint.servicePointAddr);
        values.put(ServicePoint.KEY_Latitude, servicePoint.latitude);
        values.put(ServicePoint.KEY_Longtitude, servicePoint.longitude);
        values.put(ServicePoint.KEY_Introduce, servicePoint.introduce);


        db.update(ServicePoint.TABLE, values, ServicePoint.KEY_ID + "=?", new String[]{String.valueOf(servicePoint.servicePointId)});
        db.close();
    }

    public ArrayList<HashMap<String, String>> getServicePointsList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                ServicePoint.KEY_ID + "," +
                ServicePoint.KEY_Service_Point_Name + "," +
                ServicePoint.KEY_Service_Point_Addr + "," +
                ServicePoint.KEY_Latitude + "," +
                ServicePoint.KEY_Longtitude + "," +
                ServicePoint.KEY_Introduce + " FROM " + ServicePoint.TABLE;
        ArrayList<HashMap<String, String>> servicePointList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> servicePoint = new HashMap<String, String>();
                servicePoint.put("id", cursor.getString(cursor.getColumnIndex(ServicePoint.KEY_ID)));
                servicePoint.put("servicePointName", cursor.getString(cursor.getColumnIndex(ServicePoint.KEY_Service_Point_Name)));
                servicePoint.put("servicePointAddr", cursor.getString(cursor.getColumnIndex(ServicePoint.KEY_Service_Point_Addr)));
                servicePoint.put("latitude", cursor.getString(cursor.getColumnIndex(ServicePoint.KEY_Latitude)));
                servicePoint.put("longitude", cursor.getString(cursor.getColumnIndex(ServicePoint.KEY_Longtitude)));
                servicePoint.put("introduce", cursor.getString(cursor.getColumnIndex(ServicePoint.KEY_Introduce)));

                servicePointList.add(servicePoint);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return servicePointList;
    }

    public ServicePoint getServicePointById(int Id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                ServicePoint.KEY_ID + "," +
                ServicePoint.KEY_Service_Point_Name + "," +
                ServicePoint.KEY_Service_Point_Addr + "," +
                ServicePoint.KEY_Latitude + "," +
                ServicePoint.KEY_Longtitude + "," +
                ServicePoint.KEY_Introduce + " FROM " + ServicePoint.TABLE + " WHERE " + ServicePoint.KEY_ID + "=?";
        int iCount = 0;
        ServicePoint servicePoint = new ServicePoint();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});
        if (cursor.moveToFirst()) {
            do {
                servicePoint.servicePointId = cursor.getInt(cursor.getColumnIndex(ServicePoint.KEY_ID));
                servicePoint.servicePointName = cursor.getString(cursor.getColumnIndex(ServicePoint.KEY_Service_Point_Name));
                servicePoint.servicePointAddr = cursor.getString(cursor.getColumnIndex(ServicePoint.KEY_Service_Point_Addr));
                servicePoint.latitude = cursor.getDouble(cursor.getColumnIndex(ServicePoint.KEY_Latitude));
                servicePoint.longitude = cursor.getDouble(cursor.getColumnIndex(ServicePoint.KEY_Longtitude));
                servicePoint.introduce = cursor.getString(cursor.getColumnIndex(ServicePoint.KEY_Introduce));


            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return servicePoint;
    }
}
