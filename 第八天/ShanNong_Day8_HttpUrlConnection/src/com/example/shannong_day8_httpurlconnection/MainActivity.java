package com.example.shannong_day8_httpurlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    public static final String TAG = "HttpURLConnection";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        httpUrlConnectionGet();
    }

    private void httpUrlConnectionGet() {
        new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    // 获得URL对象
                    URL url = new URL("http://v.juhe.cn/toutiao/index?type=tiyu&key=5465c4c5d60f72c3d756a9f1a9b8437d");

                    // 网络Get请求的主类对象
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    // 设置为GET请求
                    connection.setRequestMethod("GET");
                    // 设置连接时长和读取时长
                    connection.setConnectTimeout(10000);
                    connection.setReadTimeout(10000);

                    // 判断状态码
                    if (connection.getResponseCode() == 200) {
                        // 获取字节输入流
                        InputStream is = connection.getInputStream();
                        // 转换为字符流输入流
                        InputStreamReader isr = new InputStreamReader(is);
                        // 缓冲字符输入流
                        BufferedReader br = new BufferedReader(isr);

                        // JSON数据拼接用的字符串类
                        StringBuffer sb = new StringBuffer();
                        // “水瓢”
                        String buffer = new String();

                        // 循环读取数据
                        while ((buffer = br.readLine()) != null) {
                            // 追加拼接的字符串
                            sb.append(buffer);
                        }
                        // 转换成字符串，打印检测结果是否正常
                        Log.d(TAG, sb.toString());

                        // 关闭输入流
                        br.close();

                    } else {
                        Log.d(TAG, "Error code:" + connection.getResponseCode());
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    Log.d(TAG, "" + e);
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG, "" + e);
                }

            }
        }).start();
    }

}
