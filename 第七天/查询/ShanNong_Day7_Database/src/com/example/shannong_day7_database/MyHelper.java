package com.example.shannong_day7_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * @author Jason
 *
 *         自定义数据库助手类
 *
 */
public class MyHelper extends SQLiteOpenHelper {
    
    public static final String DB_TABLE_CACHE = "cache";
    public static final String DB_TABLE_COLLECTION = "collection";

    private Context mContext;

    /**
     * @param context
     *            上下文
     * @param name
     *            数据库名称（包含扩展名.db）
     * @param version
     *            数据库的版本 1 --> 2 --> 3 ......
     */
    public MyHelper(Context context, String name, int version) {
        super(context, name, null, version);
        mContext = context;
    }

    /*
     * 数据库创建的回调方法
     * 
     * @param db 新创建的数据库对象
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 执行SQL语句
        db.execSQL(
                "create table cache(_id integer primary key autoincrement,uniquekey text,title text,date text,category text,author_name text,url text,thumbnail_pic_s text)");
        db.execSQL(
                "create table collection(_id integer primary key autoincrement,uniquekey text,title text,date text,category text,author_name text,url text,thumbnail_pic_s text)");
        Toast.makeText(mContext, "数据库创建成功", Toast.LENGTH_SHORT).show();
    }

    /*
     * 
     * 数据库版本更新的回调 只有新版本可以覆盖老版本，老版本无法覆盖新版本
     * 
     * @param db 新版本的数据库对象
     * 
     * @param oldVersion 老版本的版本号
     * 
     * @param newVersion 新版本的版本号
     * 
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(mContext, "onUpgrade: " + oldVersion + "-->" + newVersion ,Toast.LENGTH_SHORT).show();
    }

}
