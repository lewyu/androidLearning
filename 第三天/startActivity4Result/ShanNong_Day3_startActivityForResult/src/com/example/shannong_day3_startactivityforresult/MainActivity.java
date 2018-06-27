package com.example.shannong_day3_startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    // 定义此Activity的请求码
    public static final int TEST_REQUEST = 1;

    private Button mBtn1, mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // 使用的方法变了
                // 第一个参数：intent对象
                // 第二个参数：请求码
                startActivityForResult(intent, TEST_REQUEST);
            }
        });

        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

            }
        });
    }

    // 此页面发起请求的页面完成返回时此页面的回调
    // 参数一：请求码
    // 参数二：结果码
    // 参数三：如果上个页面有数据，可以在第三个参数中取出
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "requestCode-->" + requestCode + ",resultCode-->" + resultCode, Toast.LENGTH_LONG).show();
    }

}
