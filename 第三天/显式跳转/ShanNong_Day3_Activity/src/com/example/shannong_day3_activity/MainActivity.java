package com.example.shannong_day3_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 取出Intent对象
        Intent intent = getIntent();
        // 取出响应的键对应的数据
        String data = intent.getStringExtra("data");
        //如果有数据取出则进行展示
        if (data != null) {
            Toast.makeText(this, "取出的数据是:" + data, Toast.LENGTH_LONG).show();
        }

    }

}
