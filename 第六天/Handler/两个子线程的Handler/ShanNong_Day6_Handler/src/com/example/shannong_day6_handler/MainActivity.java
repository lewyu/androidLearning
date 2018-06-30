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

        // 每次从消息队列中取出信息到主线程后被调用的方法
        // 传进来的参数：message对象
        public void handleMessage(android.os.Message msg) {
            // 判断消息的类型
            switch (msg.what) {
            case 1:
                // 取出数据并设置到UI上进行显示
                mTextView1.setText("" + msg.arg1);
                break;
            case 2:
                // 取出数据并设置到UI上进行显示
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

        // 线程一
        new Thread() {

            public void run() {

                for (int i = 0; i <= 1000; i++) {

                    // 子线程睡眠10ms
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 通知主线程更新当前数据
                    Message message = Message.obtain();
                    // 使用一个int类型的what属性来作为不同的信息识别（寄信人）
                    message.what = 1;
                    // message可以携带内容(信的内容)
                    message.arg1 = i;
                    // 使用Handler（送信的）发送信息
                    mHandler.sendMessage(message);
                }

            }

        }.start();

        // 线程二
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i <= 1000; i++) {

                    // 子线程睡眠10ms
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 通知主线程更新当前数据
                    Message message = Message.obtain();
                    // 使用一个int类型的what属性来作为不同的信息识别（寄信人）
                    message.what = 2;
                    // message可以携带内容(信的内容)
                    message.arg1 = i;
                    // 使用Handler（送信的）发送信息
                    mHandler.sendMessage(message);
                }
            }
        }).start();

    }

}
