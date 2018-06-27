package com.test.shannong;

import com.example.shannong_day3_activity.MainActivity;
import com.example.shannong_day3_activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyActivity extends Activity {

    private Button mBtn1, mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 显示跳转
                // 第一个参数：上下文
                Intent intent = new Intent(MyActivity.this, MainActivity.class);
                // 传递数据
                intent.putExtra("data", "这是一段来自于MyActivity的数据");

                // 跳转
                startActivity(intent);
            }
        });

        mBtn2 = (Button) findViewById(R.id.btn2);
    }

}
