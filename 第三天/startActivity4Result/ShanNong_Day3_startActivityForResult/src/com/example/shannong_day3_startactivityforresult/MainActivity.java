package com.example.shannong_day3_startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    // �����Activity��������
    public static final int TEST_REQUEST = 1;

    private Button mBtn1, mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // ʹ�õķ�������
                // ��һ��������intent����
                // �ڶ���������������
                startActivityForResult(intent, TEST_REQUEST);
            }
        });

        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

            }
        });
    }

    // ��ҳ�淢�������ҳ����ɷ���ʱ��ҳ��Ļص�
    // ����һ��������
    // �������������
    // ������������ϸ�ҳ�������ݣ������ڵ�����������ȡ��
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "requestCode-->" + requestCode + ",resultCode-->" + resultCode, Toast.LENGTH_LONG).show();
    }

}
