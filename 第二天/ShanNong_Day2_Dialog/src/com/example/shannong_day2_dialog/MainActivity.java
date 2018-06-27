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

    // AlertDialog的子类
    private ProgressDialog mDialog1;

    // Dialog的子类
    private AlertDialog mDialog2;
    private AlertDialog.Builder mBuilder;

    // 自定义Dialog
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
            // 展示ProgressDialog
            mDialog1.show();
            break;
        case R.id.btn2:
            // 展示AlertDialog
            mBuilder.show();
            break;
        case R.id.btn3:
            mDialog3.show();
            break;
        }

    }

    /**
     * 初始化ProgressDialog
     */
    private void initProgressDialog() {
        // 实例化ProgressDialog对象
        mDialog1 = new ProgressDialog(this);
        // 设置标题
        mDialog1.setTitle("ProgressDialog");
        // 设置显示信息
        mDialog1.setMessage("这是一个用于显示等待的控件，可以让用户知道程序正在加载中，而不是卡死了。");
        // 设置图标
        mDialog1.setIcon(R.drawable.ic_launcher);
    }

    /**
     * 初始化AlertDialog
     */
    private void initAlertDialog() {
        // 实例化静态内部类，参数为上下文
        mBuilder = new AlertDialog.Builder(this);
        // 设置标题
        mBuilder.setTitle("AlertDialog");
        // 设置显示信息
        mBuilder.setMessage("这个控件是ProgressDialog的父类，是Dialog的子类，通常用于正常的标准化Dialog显示.");
        // 设置图标
        mBuilder.setIcon(R.drawable.ic_launcher);
        // 设置取消的Button
        // 第一个参数：按钮上要显示的文字
        mBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置确定的按钮
        mBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "确定了", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 初始化MyDialog
     */
    private void initMyDialog() {
        mDialog3 = new MyDialog(this);
    }

}
