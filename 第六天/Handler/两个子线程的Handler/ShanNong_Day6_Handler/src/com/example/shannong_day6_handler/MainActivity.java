package com.example.shannong_day6_handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView1, mTextView2;

    private Handler mHandler = new Handler() {

        // ÿ�δ���Ϣ������ȡ����Ϣ�����̺߳󱻵��õķ���
        // �������Ĳ�����message����
        public void handleMessage(android.os.Message msg) {
            // �ж���Ϣ������
            switch (msg.what) {
            case 1:
                // ȡ�����ݲ����õ�UI�Ͻ�����ʾ
                mTextView1.setText("" + msg.arg1);
                break;
            case 2:
                // ȡ�����ݲ����õ�UI�Ͻ�����ʾ
                mTextView2.setText("" + msg.arg1);
                break;
            case 3:
                break;
            }

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView1 = (TextView) findViewById(R.id.text1);
        mTextView2 = (TextView) findViewById(R.id.text2);

        // �߳�һ
        new Thread() {

            public void run() {

                for (int i = 0; i <= 1000; i++) {

                    // ���߳�˯��10ms
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // ֪ͨ���̸߳��µ�ǰ����
                    Message message = Message.obtain();
                    // ʹ��һ��int���͵�what��������Ϊ��ͬ����Ϣʶ�𣨼����ˣ�
                    message.what = 1;
                    // message����Я������(�ŵ�����)
                    message.arg1 = i;
                    // ʹ��Handler�����ŵģ�������Ϣ
                    mHandler.sendMessage(message);
                }

            }

        }.start();

        // �̶߳�
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i <= 1000; i++) {

                    // ���߳�˯��10ms
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // ֪ͨ���̸߳��µ�ǰ����
                    Message message = Message.obtain();
                    // ʹ��һ��int���͵�what��������Ϊ��ͬ����Ϣʶ�𣨼����ˣ�
                    message.what = 2;
                    // message����Я������(�ŵ�����)
                    message.arg1 = i;
                    // ʹ��Handler�����ŵģ�������Ϣ
                    mHandler.sendMessage(message);
                }
            }
        }).start();

    }

}
