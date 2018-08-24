package com.example.evey.ibox.SQLlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Evey on 2018/5/9.
 */

public class AddressRepo {
    private DBHelper dbHelper;

    public AddressRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Address address) {
        //打开连接，写入数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Address.KEY_UserID, address.User_ID);
        values.put(Address.KEY_Tel, address.tel);
        values.put(Address.KEY_Name, address.name);
        values.put(Address.KEY_Province, address.province);
        values.put(Address.KEY_City, address.city);
        values.put(Address.KEY_District, address.district);
        values.put(Address.KEY_Addr_Detail, address.addr_detail);


        long Address_Id = db.insert(Address.TABLE, null, values);
        db.close();
        return (int) Address_Id;
    }

    public void delete(int address_Id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Address.TABLE, Address.KEY_ID + "=?", new String[]{String.valueOf(address_Id)});
        db.close();
    }

    public void update(Address address) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Address.KEY_UserID, address.User_ID);
        values.put(Address.KEY_Tel, address.tel);
        values.put(Address.KEY_Name, address.name);
        values.put(Address.KEY_Province, address.province);
        values.put(Address.KEY_City, address.city);
        values.put(Address.KEY_District, address.district);
        values.put(Address.KEY_Addr_Detail, address.addr_detail);

        db.update(Address.TABLE, values, Address.KEY_ID + "=?", new String[]{String.valueOf(address.Address_ID)});
        db.close();
    }

    public ArrayList<HashMap<String, String>> getAddressList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                Address.KEY_ID + "," +
                Address.KEY_UserID + "," +
                Address.KEY_Tel + "," +
                Address.KEY_Name + "," +
                Address.KEY_Province + "," +
                Address.KEY_City + "," +
                Address.KEY_District + "," +
                Address.KEY_Addr_Detail + " FROM " + Address.TABLE;
        ArrayList<HashMap<String, String>> addressList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> address = new HashMap<String, String>();
                address.put("id", cursor.getString(cursor.getColumnIndex(Address.KEY_ID)));
                address.put("userId", cursor.getString(cursor.getColumnIndex(Address.KEY_UserID)));
                address.put("name", cursor.getString(cursor.getColumnIndex(Address.KEY_Name)));
                address.put("tel", cursor.getString(cursor.getColumnIndex(Address.KEY_Tel)));
                address.put("province", cursor.getString(cursor.getColumnIndex(Address.KEY_Province)));
                address.put("city", cursor.getString(cursor.getColumnIndex(Address.KEY_City)));
                address.put("district", cursor.getString(cursor.getColumnIndex(Address.KEY_District)));
                address.put("addrDetail", cursor.getString(cursor.getColumnIndex(Address.KEY_Addr_Detail)));
                addressList.add(address);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return addressList;
    }

    public Address getAddressById(int Id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                Address.KEY_ID + "," +
                Address.KEY_UserID + "," +
                Address.KEY_Name + "," +
                Address.KEY_Tel + "," +
                Address.KEY_Province + "," +
                Address.KEY_City + "," +
                Address.KEY_District + "," +
                Address.KEY_Addr_Detail + " FROM " + Address.TABLE + " WHERE " + Address.KEY_ID + "=?";
        int iCount = 0;
        Address address = new Address();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});
        if (cursor.moveToFirst()) {
            do {
                address.User_ID = cursor.getInt(cursor.getColumnIndex(Address.KEY_ID));
                address.name = cursor.getString(cursor.getColumnIndex(Address.KEY_Name));
                address.tel = cursor.getString(cursor.getColumnIndex(Address.KEY_Tel));
                address.province = cursor.getString(cursor.getColumnIndex(Address.KEY_Province));
                address.city = cursor.getString(cursor.getColumnIndex(Address.KEY_City));
                address.district = cursor.getString(cursor.getColumnIndex(Address.KEY_District));
                address.addr_detail = cursor.getString(cursor.getColumnIndex(Address.KEY_Addr_Detail));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return address;
    }
    public Address[] findAddressByKey(String key){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Vector<Address> v = new Vector<Address>();
        Cursor cursor = null;
        try {
            cursor=db.rawQuery("select * from " + Address.TABLE+ " where "
                    + Address.KEY_Name + " like '%" + key +"%' " +
                    " or "+Address.KEY_Tel + " like '%" + key +"%' " +
                    " or "+Address.KEY_Province + " like '%" + key +"%' " +
                    " or "+Address.KEY_City + " like '%" + key +"%' " +
                    " or "+Address.KEY_District + " like '%" + key +"%' " +
                    " or "+Address.KEY_Addr_Detail + " like '%" + key +"%' ",null);
            while (cursor.moveToNext()){
                Address temp = new Address();
                temp.Address_ID = cursor.getInt(cursor.getColumnIndex(Address.KEY_ID));
                temp.User_ID = cursor.getInt(cursor.getColumnIndex(Address.KEY_UserID));
                temp.name = cursor.getString(cursor.getColumnIndex(Address.KEY_Name));
                temp.tel = cursor.getString(cursor.getColumnIndex(Address.KEY_Tel));
                temp.province = cursor.getString(cursor.getColumnIndex(Address.KEY_Province));
                temp.city = cursor.getString(cursor.getColumnIndex(Address.KEY_City));
                temp.district = cursor.getString(cursor.getColumnIndex(Address.KEY_District));
                temp.addr_detail = cursor.getString(cursor.getColumnIndex(Address.KEY_Addr_Detail));

                v.add(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(cursor != null){
                cursor.close();
            }
            db.close();
        }
        if(v.size() > 0){
            return v.toArray(new Address[]{});
        }
        else {
            Address[] addresses = new Address[1];
            Address address = new Address();
            address.name = "无结果";
            addresses[0] = address;
            return addresses;
        }
    }
}
