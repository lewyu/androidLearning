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

    // �����Activity��������
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
                // ʹ�õķ�������
                // ��һ��������intent����
                // �ڶ���������������
                startActivityForResult(intent, TEST_REQUEST);
            }
        });

        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // ʹ����ʽ��ת����App��ת
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAPTURE);
            }
        });
        
        mImage = (ImageView) findViewById(R.id.image_view);
    }

    // ��ҳ�淢�������ҳ����ɷ���ʱ��ҳ��Ļص�
    // ����һ��������
    // �������������
    // ������������ϸ�ҳ�������ݣ������ڵ�����������ȡ��
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MainActivity", "requestCode-->" + requestCode + ",resultCode-->" + resultCode);

        if (requestCode == CAPTURE) {
            // ������ҳ�淵�ض���
            if (resultCode == RESULT_OK) {
                // �û��ɹ�����,�����ù����ص�Intentȡ����Ӧ������
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                Log.d("MainActivity", "Bitmap:" + bitmap);
                //����ͼƬ��ʾ�ؼ���ͼƬ����
                mImage.setImageBitmap(bitmap);
            } else {
                Toast.makeText(this, "����ʧ�ܻ�û��û�����գ�", Toast.LENGTH_LONG).show();
            }

        }

    }

}
