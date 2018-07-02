package com.example.shannong_day7_database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button mBtnCreate, mBtnVersion, mBtnInsert, mBtnDelete, mBtnUpdate, mBtnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDB();
        updateVision();
        insert();
        delete();
        update();
        easyQuery();
    }

    /**
     * 创建数据库
     */
    private void createDB() {
        mBtnCreate = (Button) findViewById(R.id.btn_create);
        mBtnCreate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 创建数据库：
                // 实例化数据库助手类
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 1);
                // 获得数据库对象
                helper.getWritableDatabase().close();
            }
        });
    }

    /**
     * 更新数据库版本
     */
    private void updateVision() {
        mBtnVersion = (Button) findViewById(R.id.btn_update_version);
        mBtnVersion.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 更新数据库的版本
                // 创建数据库：
                // 实例化数据库助手类
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // 获得数据库对象
                helper.getWritableDatabase().close();
            }
        });
    }

    /**
     * 
     * 向数据库中插入数据
     * 
     * 
     */
    private void insert() {
        mBtnInsert = (Button) findViewById(R.id.btn_insert);
        mBtnInsert.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // 获得可写的数据库对象
                SQLiteDatabase db = helper.getWritableDatabase();
                // 一条数据的封装
                ContentValues cv = new ContentValues();
                // 封装数据
                cv.put("uniquekey", "4f9fdeb307430068151e1356705e34a8");
                cv.put("title", "7月6日，好运溜进门，财富享不尽！3生肖日子一天比一天美！");
                cv.put("date", "2018-07-01 14:22");
                cv.put("category", "头条");
                cv.put("author_name", "阿木细说");
                cv.put("url", "http:\\/\\/mini.eastday.com\\/mobile\\/180701142221871.html");
                cv.put("thumbnail_pic_s",
                        "http:\\/\\/07.imgmini.eastday.com\\/mobile\\/20180701\\/20180701_0370d50c17044dbf515287b70219b520_cover_mwpm_03200403.jpg");
                // 插入数据
                // 第一个参数：表名
                // 第二个参数：空值保护
                // 第三个参数：插入的数据
                long result = db.insert(MyHelper.DB_TABLE_CACHE, null, cv);
                db.close();
                if (result != -1)
                    Toast.makeText(MainActivity.this, "插入数据成功！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 删除数据库 中的数据
     */
    private void delete() {
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mBtnDelete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // 获得可写的数据库对象
                SQLiteDatabase db = helper.getWritableDatabase();
                // 删除数据
                // 第一个参数：表名
                // 第二个参数：where子句 where category = '头条' and author_name = '腾讯网'
                // 第三个参数：where子句中?的数值
                int result = db.delete(MyHelper.DB_TABLE_CACHE, "category = ? and author_name = ?",
                        new String[] { "头条", "腾讯网" });
                Toast.makeText(MainActivity.this, "删除了" + result + "行", Toast.LENGTH_SHORT).show();
                // 关闭数据库
                db.close();
            }
        });
    }

    /**
     * 更新数据库中的数据内容
     */
    private void update() {
        mBtnUpdate = (Button) findViewById(R.id.btn_update);
        mBtnUpdate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // 获得可写的数据库对象
                SQLiteDatabase db = helper.getWritableDatabase();
                // 数据封装对象
                ContentValues cv = new ContentValues();
                // 要更改的数据
                cv.put("author_name", "抖音短视频");

                // 更新数据
                // 第一个参数：表名
                // 第二个参数：数据封装
                // 第三个参数：WHERE子句
                // 第四个参数：WHERE子句中?的数值
                int result = db.update(MyHelper.DB_TABLE_CACHE, cv, "category = ?", new String[] { "头条" });
                Toast.makeText(MainActivity.this, "更新了" + result + "行", Toast.LENGTH_SHORT).show();
                // 关闭数据库
                db.close();
            }
        });

    }

    /**
     * 查询
     */
    private void easyQuery() {
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mBtnQuery.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // 获得可写的数据库对象
                SQLiteDatabase db = helper.getReadableDatabase();
                // 数据查询
                // 第一个参数：表名
                Cursor cursor = db.query(MyHelper.DB_TABLE_CACHE, null, null, null, null, null, null);
                // 循环取出
                while (cursor.moveToNext()) {
                    // 取值
                    String _id = cursor.getString(cursor.getColumnIndex("_id"));
                    String title = cursor.getString(cursor.getColumnIndex("title"));
                    String author_name = cursor.getString(cursor.getColumnIndex("author_name"));

                    Log.d("Jason", _id + " " + title + " " + author_name);
                }

                Toast.makeText(MainActivity.this, "查询成功", Toast.LENGTH_SHORT).show();
                // 关闭游标和数据库
                cursor.close();
                db.close();

            }
        });
    }

    /**
     * 查询
     */
    private void query() {
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mBtnQuery.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // 获得可写的数据库对象
                SQLiteDatabase db = helper.getReadableDatabase();
                // 数据查询
                // 第一个参数：表名
                // 第二个参数：SELECT子句，把结果中希望出现的列名写成String数组的格式
                // 第三个参数：WHERE子句 WHERE author_name = '抖音短视频'
                // 第四个参数：WHERE子句中的参数
                // 第五个参数：GROUP BY 子句
                // 第六个参数：HAVING 子句
                // 第七个参数：排序
                Cursor cursor = db.query(MyHelper.DB_TABLE_CACHE, new String[] { "_id", "title", "author_name" },
                        "author_name = ?", new String[] { "抖音短视频" }, null, null, null);

                // //循环取出
                // while(cursor.moveToNext()) {
                // //取值
                // String _id = cursor.getString(cursor.getColumnIndex("_id"));
                // String title =
                // cursor.getString(cursor.getColumnIndex("title"));
                // String author_name =
                // cursor.getString(cursor.getColumnIndex("author_name"));
                //
                // Log.d("Jason", _id + " " + title + " " + author_name);
                // }
                //
                // Toast.makeText(MainActivity.this, "查询成功",
                // Toast.LENGTH_SHORT).show();
                // //关闭游标和数据库
                // cursor.close();
                // db.close();

            }
        });
    }

}
