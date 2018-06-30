package com.example.shannong_day6_application;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    
    private Button mBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.d("Jason", "MainActivity Created!");
        
        //获得Application对象,返回当前App的Application对象
        MyApplication app = (MyApplication) getApplication();
        app.addItem("德国世界杯止步32强，被韩国拖下水", "www.baidu.com");
        app.addItem("山农某些学生周末依然在教室上课", "www.bing.com");
        app.addItem("今天五点二十下课", "www.qq.com");
        
        
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                new MyDialog(MainActivity.this).show();
            }
        });
    }
    
    
    

}
