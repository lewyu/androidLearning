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
     * ʹ��HttpClient������GET����
     */
    private void httpClientGet() {

        new Thread() {
            @Override
            public void run() {

                // ������������
                BasicHttpParams params = new BasicHttpParams();
                // ʹ�þ�̬����
                // ��������ʱ��
                // ��һ��������BasicHttpParams����
                // �ڶ�������������ʱ��
                HttpConnectionParams.setConnectionTimeout(params, 10000);
                HttpConnectionParams.setSoTimeout(params, 10000);

                // ���HttpClient����
                HttpClient client = new DefaultHttpClient(params);

                // ʵ����Get�������
                HttpGet get = new HttpGet(
                        "http://v.juhe.cn/toutiao/index?type=tiyu&key=5465c4c5d60f72c3d756a9f1a9b8437d");

                try {
                    // ִ��get����,��÷��ص����ݷ�װ
                    HttpResponse response = client.execute(get);

                    // �ж�״̬��
                    if (response.getStatusLine().getStatusCode() == 200) {
                        // ��ȡ�ֽ�������
                        InputStream is = response.getEntity().getContent();
                        // ת��Ϊ�ַ���������
                        InputStreamReader isr = new InputStreamReader(is);
                        // �����ַ�������
                        BufferedReader br = new BufferedReader(isr);

                        // JSON����ƴ���õ��ַ�����
                        StringBuffer sb = new StringBuffer();
                        // ��ˮư��
                        String buffer = new String();

                        // ѭ����ȡ����
                        while ((buffer = br.readLine()) != null) {
                            // ׷��ƴ�ӵ��ַ���
                            sb.append(buffer);
                        }
                        // ת�����ַ�������ӡ������Ƿ�����
                        Log.d(TAG, sb.toString());

                        // �ر�������
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
