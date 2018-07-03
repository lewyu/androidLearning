package com.example.shannong_day8_httpurlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    public static final String TAG = "HttpURLConnection";
    public static final String TAG2 = "News";

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

                        // ����JSON����
                        parseJSON(sb.toString());

                    } else {
                        Log.d(TAG, "Error code:" + connection.getResponseCode());
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    Log.d(TAG, "" + e);
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG, "" + e);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d(TAG, "" + e);
                }

            }
        }).start();
    }

    /**
     * ����JSON����
     * 
     * @throws JSONException
     */
    private void parseJSON(String data) throws JSONException {
        // ������JSONObject����
        JSONObject object = new JSONObject(data);
        JSONObject result = object.getJSONObject("result");
        // JSONArray����
        JSONArray array = result.getJSONArray("data");
        // ��������
        for (int i = 0; i < array.length(); i++) {
            // �������Ŷ�Ӧ��JSONObject
            JSONObject item = array.getJSONObject(i);
            // �ó������е�ÿһ������
            String uniquekey = item.getString("uniquekey");
            String title = item.getString("title");
            String date = item.getString("date");
            String category = item.getString("category");
            String author_name = item.getString("author_name");
            String url = item.getString("url");
            String thumbnail_pic_s = item.getString("thumbnail_pic_s");

            Log.d(TAG2, uniquekey);
            Log.d(TAG2, title);
            Log.d(TAG2, date);
            Log.d(TAG2, category);
            Log.d(TAG2, author_name);
            Log.d(TAG2, url);
            Log.d(TAG2, thumbnail_pic_s);
            Log.d(TAG2, "**************************************");
            // ʹ�����ݣ����д���
            // �־û����洢�����ݿ���

        }

    }

}
