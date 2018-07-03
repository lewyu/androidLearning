package com.example.shannong_day8_webview;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends Activity {

    // �ȴ���ʾ�ؼ�
    private ProgressDialog mDialog;

    // ��ҳ���ؿؼ�
    private WebView mWebView;
    
    //��ǰ���ڼ��ص���ҳ����
    private String mURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        // ����ת����Intent��ȡ����Ӧ������
        String url = getIntent().getStringExtra("url");

        mWebView = (WebView) findViewById(R.id.web_view);
        // ������JS��֧��
        mWebView.getSettings().setJavaScriptEnabled(true);
        // ���Ӷ��û��ļ�����ʾ�ͷ����ⲿ�������ת
        mWebView.setWebViewClient(new WebViewClient() {

            // ��ʼ����һ����ҳ�Ļص�
            // ��һ��������mWebView
            // �ڶ�����������ǰ���ص���ҳ�ĵ�ַ
            // 
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mURL = url;
                // �������չʾ�У���չʾ����
                if (!mDialog.isShowing())
                    mDialog.show();
            }

            // ����������ҳ�Ļص�
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // �����չʾ�У��͹ر�
                if (mDialog.isShowing())
                    mDialog.dismiss();
            }

        });
        
        //���ӳ����ļ�����
        mWebView.setOnLongClickListener(new OnLongClickListener() {
            
            @Override
            public boolean onLongClick(View v) {
                //TODO ����ǰ��ҳ�����ӳ־û��������ԣ�����ѡ��ʹ��SQLite����SharedPreferences
                Toast.makeText(WebViewActivity.this, "�ղسɹ����뵽�ղؼ��в鿴���ղص����ݣ�", Toast.LENGTH_SHORT).show();
                Log.d("Jason", mURL);
                return false;
            }
        });

        initDialog();

        // ������ҳ
        mWebView.loadUrl(url);

    }

    private void initDialog() {
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("����������...");
    }

    // �����¼��Ļص�
    // ��һ������������������
    // �ڶ����������������¼�
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // �ж��Ƿ��Ƿ��ؼ�
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            // ��ҳ�Ƿ���Է���
            // �����ϸ���ҳ
            mWebView.goBack();
            // ���ط��ذ����¼���������
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
