package com.example.shannong_day2_listener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

//MainActivity�ǳ���Ĭ�ϵ���ҳ��
public class MainActivity extends Activity {

    // �����ؼ�
    private Button mBtn;

    // ���ڽ׶�������ΪonCreate�����ǳ�������
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ���ô�ҳ��Ĳ����ļ�
        setContentView(R.layout.activity_main);

        // ��Button��ֵ(��̬��ǿ������)
        mBtn = (Button) findViewById(R.id.btn1);
        // ���ü���������
        mBtn.setOnClickListener(new OnClickListener() {

            // �û�����Ļص�����
            @Override
            public void onClick(View v) {
                // ��ʾToast�ؼ�
                //��һ��������Context�����ģ����Դ���Activity��Ķ���
                //�ڶ���������Ҫ��ʾ�����ݣ�ͨ������String����
                //������������Toast�ؼ�Ҫ��ʾ�ĳ��ȣ���ѡֵ������ʾToast.LENGTH_SHORT������ʾToast.LENGTH_SHORT
                Toast.makeText(MainActivity.this, "��ť������ˣ�����", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
