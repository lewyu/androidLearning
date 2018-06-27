package com.example.shannong_day3_startactivityforresult;

import android.app.Activity;
import android.os.Bundle;

public class SecondActivity  extends Activity{
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent = new Intent();
        intent.putStringExtra("你好");
        
        //此页面完成上个页面的某种请求
        //完成之后需要一个结果
        setResult(4678,intent);
    }

}
