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
                    // ���URL����
                    URL url = new URL("http://v.juhe.cn/toutiao/index?type=tiyu&key=5465c4c5d60f72c3d756a9f1a9b8437d");

                    // ����Get������������
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    // ����ΪGET����
                    connection.setRequestMethod("GET");
                    // ��������ʱ���Ͷ�ȡʱ��
                    connection.setConnectTimeout(10000);
                    connection.setReadTimeout(10000);

                    // �ж�״̬��
                    if (connection.getResponseCode() == 200) {
                        // ��ȡ�ֽ�������
                        InputStream is = connection.getInputStream();
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
