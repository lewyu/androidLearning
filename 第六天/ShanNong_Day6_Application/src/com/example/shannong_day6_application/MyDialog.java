package com.example.shannong_day6_application;

import java.util.HashMap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author Jason
 * 
 *         �Զ���Dialog��
 *
 */
public class MyDialog extends Dialog {

    private Button mBtn;

    // �洢�����������
    private Context mContext;

    // ���ӹ��췽��
    public MyDialog(Context context) {
        super(context);
        // ���ò����ļ�
        setContentView(R.layout.my_dialog);

        // �洢������
        mContext = context;

        // ���ñ���
        setTitle("ȡ��Application�е�����");

        mBtn = (Button) findViewById(R.id.mydialog_btn);
        // ���Զ���Dialog��ʹ����ͨ��OnClickListenerҪע���Viewǰ׺
        mBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Ϊ��ȥ��Application
                Activity activity = (Activity) mContext;
                // ȡ��ȫ�ֵ�Application����
                MyApplication app = (MyApplication) activity.getApplication();
                // ��һЩ���ݵĲ���
                HashMap<String, String> map = app.getItem(0);
                String title = map.get(KeyOfMap.KEY_TITLE);
                String url = map.get(KeyOfMap.KEY_URL);
                Toast.makeText(mContext, title + "\n" + url, Toast.LENGTH_LONG).show();

                // �ر�Dialog
                dismiss();
            }
        });

    }

}
