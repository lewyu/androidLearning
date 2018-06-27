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
                // ��ʾ��ת
                // ��һ��������������
                Intent intent = new Intent(MyActivity.this, MainActivity.class);
                // ��������
                intent.putExtra("data", "����һ��������MyActivity������");

                // ��ת
                startActivity(intent);
            }
        });

        mBtn2 = (Button) findViewById(R.id.btn2);
    }

}
