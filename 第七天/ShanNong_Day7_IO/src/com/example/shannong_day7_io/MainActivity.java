package com.example.shannong_day7_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ����·��
        String cacheDir = getCacheDir().toString();
        Log.d(TAG, cacheDir);

        // ��ʱ����һ��Ҫ�����߳��н���
        new Thread() {

            public void run() {

                try {
                    // ʹ���ļ�����������ȡ
                    FileInputStream fis = new FileInputStream(getCacheDir() + File.separator + "source.jpg");
                    // ʹ���ļ���������������
                    FileOutputStream fos = new FileOutputStream(getCacheDir() + File.separator + "copy.jpg");

                    // ��ˮư��
                    byte[] buffer = new byte[1024];

                    // �洢ÿ�ζ�ȡ��������
                    int len = -1;

                    // ѭ����ȡ
                    while ((len = fis.read(buffer)) != -1) {
                        Log.d("Jason", "copying...");
                        // �������
                        // ��һ������������
                        // �ڶ������������Ķ���ʼ�����һ��Ϊ0
                        // ������������Ҫ�������������
                        fos.write(buffer, 0, len);
                    }

                    // ��Ҫ�ر�
                    fis.close();
                    fos.flush();
                    fos.close();

                    Log.d(TAG, "copy finished");

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    // �������ӳ����쳣�Ĵ���ʽ
                    Log.d(TAG, e.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG, e.toString());
                }

            }

        }.start();

    }

}
