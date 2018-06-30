package com.example.shannong_day6_receiver2;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    //声明Receiver对象
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
        //注销广播接收器
        //参数为广播接收器对象
        unregisterReceiver(mReceiver);
    }
    
    
    /**
     * 动态注册广播接收器
     */
    private void regist() {
        mReceiver = new MyReceiver();
        //拿到意图过滤器对象
        IntentFilter filter = new IntentFilter();
        //增加Action(想接受的所有类型都可以在下面去添加)
        filter.addAction("hello123");
        filter.addAction("hellfd");
        filter.addAction("hefsdfsd");
        
        //注册广播接收器
        //第一个参数：广播接收器对象
        //第二个参数：意图过滤器对象
        registerReceiver(mReceiver, filter);
    }

    class MyReceiver extends BroadcastReceiver {

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
                Toast.makeText(context, "动态注册的接收器收到的广播信息内容为：" + data, Toast.LENGTH_LONG).show();
            } else {
                // 可以再去判断其他类型的广播
            }
        }

    }

}
