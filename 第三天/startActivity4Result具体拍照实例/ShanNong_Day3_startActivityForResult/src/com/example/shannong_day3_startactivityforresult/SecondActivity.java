package com.example.shannong_day3_startactivityforresult;

import android.app.Activity;
import android.os.Bundle;

public class SecondActivity  extends Activity{
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        //��ҳ������ϸ�ҳ���ĳ������
        //���֮����Ҫһ�����
        setResult(4678);
    }

}
