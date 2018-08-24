package com.example.evey.ibox.SQLlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;


public class UserRepo {
    private DBHelper dbHelper;

    public UserRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(User user) {
        //打开连接，写入数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.KEY_Name, user.name);
        values.put(User.KEY_Tel, user.tel);
        values.put(User.KEY_PassWord, user.password);
//        values.put(User.KEY_Email, user.email);
//        values.put(User.KEY_Addrress, user.address);

        long user_Id = db.insert(User.TABLE, null, values);
        db.close();
        return (int) user_Id;
    }

    public void delete(int user_Id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(User.TABLE, User.KEY_ID + "=?", new String[]{String.valueOf(user_Id)});
        db.close();
    }

    public void update(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(User.KEY_Name, user.name);
        values.put(User.KEY_PassWord, user.password);
        values.put(User.KEY_Tel, user.tel);
//        values.put(User.KEY_Email, user.email);
//        values.put(User.KEY_Addrress, user.address);

        db.update(User.TABLE, values, User.KEY_ID + "=?", new String[]{String.valueOf(user.User_ID)});
        db.close();
    }

    public ArrayList<HashMap<String, String>> getUserList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                User.KEY_ID + "," +
                User.KEY_Name + "," +
                User.KEY_PassWord + "," +
                User.KEY_Tel + " FROM " + User.TABLE;
        ArrayList<HashMap<String, String>> userList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> user = new HashMap<String, String>();
                user.put("id", cursor.getString(cursor.getColumnIndex(User.KEY_ID)));
                user.put("name", cursor.getString(cursor.getColumnIndex(User.KEY_Name)));
                user.put("tel", cursor.getString(cursor.getColumnIndex(User.KEY_Tel)));
                user.put("password", cursor.getString(cursor.getColumnIndex(User.KEY_PassWord)));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;
    }

    public User getUserByTel(String tel) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                User.KEY_ID + "," +
                User.KEY_Name + "," +
                User.KEY_PassWord + "," +
                User.KEY_Tel + " FROM " + User.TABLE + " WHERE " + User.KEY_ID + "=?";
        int iCount = 0;
        User user = new User();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(tel)});
        if (cursor.moveToFirst()) {
            do {
                user.User_ID = cursor.getInt(cursor.getColumnIndex(User.KEY_ID));
                user.name = cursor.getString(cursor.getColumnIndex(User.KEY_Name));
                user.password = cursor.getString(cursor.getColumnIndex(User.KEY_PassWord));
                user.tel = cursor.getString(cursor.getColumnIndex(User.KEY_Tel));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return user;
    }
    public User[] findUserByKey(String key){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Vector<User> v = new Vector<User>();
        Cursor cursor = null;
        try {
            cursor=db.rawQuery("select * from " + User.TABLE+ " where "
            + User.KEY_Name + " like '%" + key +"%' " +
                    " or "+User.KEY_Tel + " like '%" + key +"%' " +
                    " or "+User.KEY_PassWord + " like '%" + key +"%' ",null);
            while (cursor.moveToNext()){
                User temp = new User();
                temp.User_ID = cursor.getInt(cursor.getColumnIndex(User.KEY_ID));
                temp.name = cursor.getString(cursor.getColumnIndex(User.KEY_Name));
                temp.password = cursor.getString(cursor.getColumnIndex(User.KEY_PassWord));
                temp.tel = cursor.getString(cursor.getColumnIndex(User.KEY_Tel));
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
            return v.toArray(new User[]{});
        }
        else {
            User[] users = new User[1];
            User user = new User();
            user.name = "无结果";
            users[0] = user;
            return users;
        }
    }
}


