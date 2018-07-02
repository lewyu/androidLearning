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
     * �������ݿ�
     */
    private void createDB() {
        mBtnCreate = (Button) findViewById(R.id.btn_create);
        mBtnCreate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // �������ݿ⣺
                // ʵ�������ݿ�������
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 1);
                // ������ݿ����
                helper.getWritableDatabase().close();
            }
        });
    }

    /**
     * �������ݿ�汾
     */
    private void updateVision() {
        mBtnVersion = (Button) findViewById(R.id.btn_update_version);
        mBtnVersion.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // �������ݿ�İ汾
                // �������ݿ⣺
                // ʵ�������ݿ�������
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // ������ݿ����
                helper.getWritableDatabase().close();
            }
        });
    }

}
