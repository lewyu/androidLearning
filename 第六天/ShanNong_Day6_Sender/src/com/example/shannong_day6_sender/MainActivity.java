package com.example.shannong_day6_sender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
        
        mBtn = (Button) findViewById(R.id.btn1);
        mBtn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // ���͹㲥
                Intent intent = new Intent("hello123");
                intent.putExtra("data", "���ǹ㲥���յ�������");
                //���͹㲥
                sendBroadcast(intent);
            }
        });
    }

}
