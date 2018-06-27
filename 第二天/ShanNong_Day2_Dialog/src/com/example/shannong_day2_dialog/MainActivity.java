package com.example.shannong_day2_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtn1, mBtn2, mBtn3;

    // AlertDialog������
    private ProgressDialog mDialog1;

    // Dialog������
    private AlertDialog mDialog2;
    private AlertDialog.Builder mBuilder;

    // �Զ���Dialog
    private MyDialog mDialog3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProgressDialog();
        initAlertDialog();
        initMyDialog();

        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn3 = (Button) findViewById(R.id.btn3);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btn1:
            // չʾProgressDialog
            mDialog1.show();
            break;
        case R.id.btn2:
            // չʾAlertDialog
            mBuilder.show();
            break;
        case R.id.btn3:
            mDialog3.show();
            break;
        }

    }

    /**
     * ��ʼ��ProgressDialog
     */
    private void initProgressDialog() {
        // ʵ����ProgressDialog����
        mDialog1 = new ProgressDialog(this);
        // ���ñ���
        mDialog1.setTitle("ProgressDialog");
        // ������ʾ��Ϣ
        mDialog1.setMessage("����һ��������ʾ�ȴ��Ŀؼ����������û�֪���������ڼ����У������ǿ����ˡ�");
        // ����ͼ��
        mDialog1.setIcon(R.drawable.ic_launcher);
    }

    /**
     * ��ʼ��AlertDialog
     */
    private void initAlertDialog() {
        // ʵ������̬�ڲ��࣬����Ϊ������
        mBuilder = new AlertDialog.Builder(this);
        // ���ñ���
        mBuilder.setTitle("AlertDialog");
        // ������ʾ��Ϣ
        mBuilder.setMessage("����ؼ���ProgressDialog�ĸ��࣬��Dialog�����࣬ͨ�����������ı�׼��Dialog��ʾ.");
        // ����ͼ��
        mBuilder.setIcon(R.drawable.ic_launcher);
        // ����ȡ����Button
        // ��һ����������ť��Ҫ��ʾ������
        mBuilder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "ȡ����", Toast.LENGTH_SHORT).show();
            }
        });

        // ����ȷ���İ�ť
        mBuilder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "ȷ����", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * ��ʼ��MyDialog
     */
    private void initMyDialog() {
        mDialog3 = new MyDialog(this);
    }

}
