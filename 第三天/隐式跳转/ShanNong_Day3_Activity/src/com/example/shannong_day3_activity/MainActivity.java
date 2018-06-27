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

        // ȡ��Intent����
        Intent intent = getIntent();
        // ȡ����Ӧ�ļ���Ӧ������
        String data = intent.getStringExtra("data");

        //ͨ��Bundle��ȡ������
        Bundle bundle = intent.getBundleExtra("bundle");
        if (bundle != null) {
            data = bundle.getString("data2");
        }

        // ���������ȡ�������չʾ
        if (data != null) {
            Toast.makeText(this, "ȡ����������:" + data, Toast.LENGTH_LONG).show();
        }

    }

}
