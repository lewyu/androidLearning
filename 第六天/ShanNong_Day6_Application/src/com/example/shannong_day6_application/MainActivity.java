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
        
        //���Application����,���ص�ǰApp��Application����
        MyApplication app = (MyApplication) getApplication();
        app.addItem("�¹����籭ֹ��32ǿ������������ˮ", "www.baidu.com");
        app.addItem("ɽũĳЩѧ����ĩ��Ȼ�ڽ����Ͽ�", "www.bing.com");
        app.addItem("��������ʮ�¿�", "www.qq.com");
        
        
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                new MyDialog(MainActivity.this).show();
            }
        });
    }
    
    
    

}
