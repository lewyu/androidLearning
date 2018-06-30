package com.example.shannong_day6_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//继承抽象类BroadcastReceiver
public class MyReceiver extends BroadcastReceiver {

    // 实现回调方法
    // 第一个参数：上下文
    // 第二个参数：传递过来的Intent对象
    @Override
    public void onReceive(Context context, Intent intent) {
        // 给三个action的接收分类
        if (intent.getAction().equals("hello123")) {
            // 取出数据
            String data = intent.getStringExtra("data");
            // 展示数据
            Toast.makeText(context, "静态注册的接收器收到的广播信息内容为：" + data, Toast.LENGTH_LONG).show();
        } else {
            // 可以再去判断其他类型的广播
        }
    }
}
