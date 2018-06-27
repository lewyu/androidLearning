package com.example.shannong_day3_startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // 定义此Activity的请求码
    public static final int TEST_REQUEST = 1;
    public static final int CAPTURE = 2;

    private Button mBtn1, mBtn2;
    
    private ImageView mImage;

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
                // 使用隐式跳转，跨App跳转
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAPTURE);
            }
        });
        
        mImage = (ImageView) findViewById(R.id.image_view);
    }

    // 此页面发起请求的页面完成返回时此页面的回调
    // 参数一：请求码
    // 参数二：结果码
    // 参数三：如果上个页面有数据，可以在第三个参数中取出
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MainActivity", "requestCode-->" + requestCode + ",resultCode-->" + resultCode);

        if (requestCode == CAPTURE) {
            // 从拍照页面返回而来
            if (resultCode == RESULT_OK) {
                // 用户成功拍照,可以用过返回的Intent取出响应的数据
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                Log.d("MainActivity", "Bitmap:" + bitmap);
                //设置图片显示控件的图片内容
                mImage.setImageBitmap(bitmap);
            } else {
                Toast.makeText(this, "拍照失败或没有没有拍照！", Toast.LENGTH_LONG).show();
            }

        }

    }

}
