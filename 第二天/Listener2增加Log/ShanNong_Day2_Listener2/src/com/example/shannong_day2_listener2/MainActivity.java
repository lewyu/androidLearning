package com.example.shannong_day2_listener2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

//��ǰ��ʵ��OnClickListener�ӿ�
public class MainActivity extends Activity implements OnClickListener {
    
    //TAG����
    public static final String TAG = "MainActivity";

    private Button mBtn1, mBtn2, mBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.d(TAG, "onCreate");

        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn3 = (Button) findViewById(R.id.btn3);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);

    }

    // ʵ��OnClick����
    // ����View vʵ�����ǵ���Ŀؼ��Ķ���
    @Override
    public void onClick(View v) {
        // Ҫִ�еĴ���
        // �жϵ�������ĸ��ؼ�
        switch (v.getId()) {
        case R.id.btn1:
            Toast.makeText(this, "��������ǵ�һ����ť��", Toast.LENGTH_SHORT).show();
            // ��һ��������TAG����(ͨ��ʹ�õ�ǰ������������,�����һ������)
            // �ڶ���������Ҫ����ĵ�����Ϣ(ʹ��Ӣ��)
            Log.d(TAG, "Button One Clicked!");
            break;
        case R.id.btn2:
            Toast.makeText(this, "��������ǵڶ�����ť��", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Button Two Clicked!");
            break;
        case R.id.btn3:
            Toast.makeText(this, "��������ǵ�������ť��", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Button Three Clicked!");
            break;
        }

    }

}
