package com.example.shannong_day8_httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    private static final String TAG = "HttpClient";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        httpClientGet();
    }

    /**
     * 使用HttpClient来进行GET请求
     */
    private void httpClientGet() {

        new Thread() {
            @Override
            public void run() {

                // 基础参数对象
                BasicHttpParams params = new BasicHttpParams();
                // 使用静态方法
                // 设置连接时长
                // 第一个参数：BasicHttpParams对象
                // 第二个参数：设置时间
                HttpConnectionParams.setConnectionTimeout(params, 10000);
                HttpConnectionParams.setSoTimeout(params, 10000);

                // 获得HttpClient对象
                HttpClient client = new DefaultHttpClient(params);

                // 实例化Get请求对象
                HttpGet get = new HttpGet(
                        "http://v.juhe.cn/toutiao/index?type=tiyu&key=5465c4c5d60f72c3d756a9f1a9b8437d");

                try {
                    // 执行get请求,获得返回的数据封装
                    HttpResponse response = client.execute(get);

                    // 判断状态码
                    if (response.getStatusLine().getStatusCode() == 200) {
                        // 获取字节输入流
                        InputStream is = response.getEntity().getContent();
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
                        Log.d(TAG, "Error code:" + response.getStatusLine().getStatusCode());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG, "" + e);
                }

            }
        }.start();

    }

}
