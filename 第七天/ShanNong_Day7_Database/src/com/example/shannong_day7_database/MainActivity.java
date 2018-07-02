package com.example.shannong_day7_database;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button mBtnCreate, mBtnVersion, mBtnInsert, mBtnDelete, mBtnUpdate, mBtnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDB();
        updateVision();
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

}
