package com.example.shannong_day2_listener2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

//当前类实现OnClickListener接口
public class MainActivity extends Activity implements OnClickListener {
    
    //TAG名称
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

    // 实现OnClick方法
    // 参数View v实际上是点击的控件的对象
    @Override
    public void onClick(View v) {
        // 要执行的代码
        // 判断点击的是哪个控件
        switch (v.getId()) {
        case R.id.btn1:
            Toast.makeText(this, "您点击的是第一个按钮！", Toast.LENGTH_SHORT).show();
            // 第一个参数：TAG名称(通常使用当前的类名来定义,定义成一个常量)
            // 第二个参数：要输出的调试信息(使用英文)
            Log.d(TAG, "Button One Clicked!");
            break;
        case R.id.btn2:
            Toast.makeText(this, "您点击的是第二个按钮！", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Button Two Clicked!");
            break;
        case R.id.btn3:
            Toast.makeText(this, "您点击的是第三个按钮！", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Button Three Clicked!");
            break;
        }

    }

}
