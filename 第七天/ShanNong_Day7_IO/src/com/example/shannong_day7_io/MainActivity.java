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

        // 缓存路径
        String cacheDir = getCacheDir().toString();
        Log.d(TAG, cacheDir);

        // 耗时操作一定要在子线程中进行
        new Thread() {

            public void run() {

                try {
                    // 使用文件输入流来读取
                    FileInputStream fis = new FileInputStream(getCacheDir() + File.separator + "source.jpg");
                    // 使用文件输出流来输出数据
                    FileOutputStream fos = new FileOutputStream(getCacheDir() + File.separator + "copy.jpg");

                    // “水瓢”
                    byte[] buffer = new byte[1024];

                    // 存储每次读取的数据量
                    int len = -1;

                    // 循环读取
                    while ((len = fis.read(buffer)) != -1) {
                        Log.d("Jason", "copying...");
                        // 输出数据
                        // 第一个参数：数据
                        // 第二个参数：从哪儿开始输出，一般为0
                        // 第三个参数：要输出多少数据量
                        fos.write(buffer, 0, len);
                    }

                    // 流要关闭
                    fis.close();
                    fos.flush();
                    fos.close();

                    Log.d(TAG, "copy finished");

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    // 建议增加出现异常的处理方式
                    Log.d(TAG, e.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG, e.toString());
                }

            }

        }.start();

    }

}
