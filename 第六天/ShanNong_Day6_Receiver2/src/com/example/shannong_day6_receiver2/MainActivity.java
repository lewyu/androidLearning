package com.example.shannong_day6_receiver2;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    //����Receiver����
    private MyReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regist();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ע���㲥������
        //����Ϊ�㲥����������
        unregisterReceiver(mReceiver);
    }
    
    
    /**
     * ��̬ע��㲥������
     */
    private void regist() {
        mReceiver = new MyReceiver();
        //�õ���ͼ����������
        IntentFilter filter = new IntentFilter();
        //����Action(����ܵ��������Ͷ�����������ȥ���)
        filter.addAction("hello123");
        filter.addAction("hellfd");
        filter.addAction("hefsdfsd");
        
        //ע��㲥������
        //��һ���������㲥����������
        //�ڶ�����������ͼ����������
        registerReceiver(mReceiver, filter);
    }

    class MyReceiver extends BroadcastReceiver {

        // ʵ�ֻص�����
        // ��һ��������������
        // �ڶ������������ݹ�����Intent����
        @Override
        public void onReceive(Context context, Intent intent) {
            // ������action�Ľ��շ���
            if (intent.getAction().equals("hello123")) {
                // ȡ������
                String data = intent.getStringExtra("data");
                // չʾ����
                Toast.makeText(context, "��̬ע��Ľ������յ��Ĺ㲥��Ϣ����Ϊ��" + data, Toast.LENGTH_LONG).show();
            } else {
                // ������ȥ�ж��������͵Ĺ㲥
            }
        }

    }

}
