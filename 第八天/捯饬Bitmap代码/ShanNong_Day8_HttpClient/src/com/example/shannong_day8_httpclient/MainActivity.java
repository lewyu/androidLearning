package com.example.shannong_day8_httpclient;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private static final String TAG = "HttpClient";

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.image_view);
        
        file2Bitmap();
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

    /**
     * �������ȡͼƬ��������,���ҽ�������ת����Bitmap����UI��ʾ
     */
    private void getInputStreamFromNet() {
        new Thread() {

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

                HttpGet get = new HttpGet(
                        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530532248868&di=0fccebc2c4911e0520b9b84db949b0b3&imgtype=0&src=http%3A%2F%2Fwww.sdtajg.com%2FimageRepository%2F401a6292-6cf9-4d0f-850a-29fbb08c5271.jpg");
                try {
                    // ִ��get����,��÷��ص����ݷ�װ
                    HttpResponse response = client.execute(get);

                    // �ж�״̬��
                    if (response.getStatusLine().getStatusCode() == 200) {
                        // ��ȡ�ֽ�������
                        InputStream is = response.getEntity().getContent();
                        // TODO תBitmap ���� �ļ��洢
                        final Bitmap bitmap = BitmapFactory.decodeStream(is);
                        // ��ʾ�ڿؼ������̣߳�
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // ���߳�Ҫִ�еĴ���
                                mImageView.setImageBitmap(bitmap);
                            }
                        });

                        // ׼��һ��������������Bitmap���ļ�
                        FileOutputStream fos = new FileOutputStream(getCacheDir() + File.separator + "demo.jpg");
                        // �׻�����
                        BufferedOutputStream bos = new BufferedOutputStream(fos);

                        // ��Bitmap������ļ�
                        // ��һ��������Ҫѹ���ĸ�ʽ
                        // �ڶ���������ѹ��Ʒ�ʣ�0����С�ļ���100�����Ʒ��
                        //
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);

                        is.close();

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

    /**
     * �ӻ����ж�ȡͼƬΪBitmap��UI��ʾ
     */
    private void file2Bitmap() {

        new Thread() {

            public void run() {

                // ���ļ���ȡ��Bitmap������Ϊ�ļ�·��
                final Bitmap bitmap = BitmapFactory.decodeFile(getCacheDir() + File.separator + "demo.jpg");
                // ֪ͨ���߳���ʾ
                runOnUiThread(new Runnable() {
                    public void run() {
                        mImageView.setImageBitmap(bitmap);
                    }
                });

            }

        }.start();

    }

}
