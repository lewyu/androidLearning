package com.example.shannong_day7_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * @author Jason
 *
 *         �Զ������ݿ�������
 *
 */
public class MyHelper extends SQLiteOpenHelper {
    
    public static final String DB_TABLE_CACHE = "cache";
    public static final String DB_TABLE_COLLECTION = "collection";

    private Context mContext;

    /**
     * @param context
     *            ������
     * @param name
     *            ���ݿ����ƣ�������չ��.db��
     * @param version
     *            ���ݿ�İ汾 1 --> 2 --> 3 ......
     */
    public MyHelper(Context context, String name, int version) {
        super(context, name, null, version);
        mContext = context;
    }

    /*
     * ���ݿⴴ���Ļص�����
     * 
     * @param db �´��������ݿ����
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // ִ��SQL���
        db.execSQL(
                "create table cache(_id integer primary key autoincrement,uniquekey text,title text,date text,category text,author_name text,url text,thumbnail_pic_s text)");
        db.execSQL(
                "create table collection(_id integer primary key autoincrement,uniquekey text,title text,date text,category text,author_name text,url text,thumbnail_pic_s text)");
        Toast.makeText(mContext, "���ݿⴴ���ɹ�", Toast.LENGTH_SHORT).show();
    }

    /*
     * 
     * ���ݿ�汾���µĻص� ֻ���°汾���Ը����ϰ汾���ϰ汾�޷������°汾
     * 
     * @param db �°汾�����ݿ����
     * 
     * @param oldVersion �ϰ汾�İ汾��
     * 
     * @param newVersion �°汾�İ汾��
     * 
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(mContext, "onUpgrade: " + oldVersion + "-->" + newVersion ,Toast.LENGTH_SHORT).show();
    }

}
