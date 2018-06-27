package com.example.shannong_day2_listener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

//MainActivity是程序默认的主页面
public class MainActivity extends Activity {

    // 声明控件
    private Button mBtn;

    // 现在阶段暂且认为onCreate方法是程序的入口
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置此页面的布局文件
        setContentView(R.layout.activity_main);

        // 给Button赋值(多态，强制造型)
        mBtn = (Button) findViewById(R.id.btn1);
        // 设置监听器对象
        mBtn.setOnClickListener(new OnClickListener() {

            // 用户点击的回调方法
            @Override
            public void onClick(View v) {
                // 显示Toast控件
                //第一个参数：Context上下文：可以传入Activity类的对象
                //第二个参数：要显示的内容，通常传入String类型
                //第三个参数：Toast控件要显示的长度，可选值：短显示Toast.LENGTH_SHORT，长显示Toast.LENGTH_SHORT
                Toast.makeText(MainActivity.this, "按钮被点击了！！！", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
