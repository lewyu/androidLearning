package com.example.shannong_day6_button;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        MyButton btn = new MyButton();
        btn.setOnClickListener(new MyOnClickListener() {
            
            @Override
            public void onClick() {
                //�û����֮��Ҫ�����Ĵ���
            }
        });
        
        btn.userEvent();
    }

}
