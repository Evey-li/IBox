package com.example.evey.ibox.SQLlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/11/27.
 */
public class DBHelper extends SQLiteOpenHelper {
    //数据库版本号
    private static final int DATABASE_VERSION=2;

    //数据库名称
    private static final String DATABASE_NAME="IBox.db";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据表
        String CREATE_TABLE_USER="CREATE TABLE "+ User.TABLE+"("
                +User.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +User.KEY_Name+" TEXT, "
                +User.KEY_Tel+" TEXT, "
                +User.KEY_PassWord+" TEXT)";
        db.execSQL(CREATE_TABLE_USER);

        String CREATE_TABLE_ORDER = "CREATE TABLE "+ Order.TABLE+"("
                +Order.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +Order.KEY_Send_Addr_ID+" TEXT, "
                +Order.KEY_Receive_Addr_ID+" TEXT, "
                +Order.KEY_Service_Point_ID+" TEXT, "
                +Order.KEY_Delivery_Type+" TEXT, "
                +Order.KEY_Send_Type+" TEXT, "
                +Order.KEY_Payment+" TEXT, "
                +Order.KEY_Express_Fee+" TEXT)";
        db.execSQL(CREATE_TABLE_ORDER);

        String CREATE_TABLE_Address = "CREATE TABLE "+ Address.TABLE+"("
                +Address.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +Address.KEY_UserID+" TEXT, "
                +Address.KEY_Name+" TEXT, "
                +Address.KEY_Tel+" TEXT, "
                +Address.KEY_Province+" TEXT, "
                +Address.KEY_City+" TEXT, "
                +Address.KEY_District+" TEXT, "
                +Address.KEY_Addr_Detail+" TEXT)";
        db.execSQL(CREATE_TABLE_Address);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果旧表存在，删除，所以数据将会消失
        db.execSQL("DROP TABLE IF EXISTS "+ User.TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ Address.TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ Order.TABLE);

        //再次创建表
        onCreate(db);
    }
}

