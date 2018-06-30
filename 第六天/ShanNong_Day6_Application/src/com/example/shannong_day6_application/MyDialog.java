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
 *         自定义Dialog类
 *
 */
public class MyDialog extends Dialog {

    private Button mBtn;

    // 存储传入的上下文
    private Context mContext;

    // 增加构造方法
    public MyDialog(Context context) {
        super(context);
        // 设置布局文件
        setContentView(R.layout.my_dialog);

        // 存储上下文
        mContext = context;

        // 设置标题
        setTitle("取出Application中的数据");

        mBtn = (Button) findViewById(R.id.mydialog_btn);
        // 在自定义Dialog中使用普通的OnClickListener要注意加View前缀
        mBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 为了去除Application
                Activity activity = (Activity) mContext;
                // 取得全局的Application对象
                MyApplication app = (MyApplication) activity.getApplication();
                // 做一些数据的操作
                HashMap<String, String> map = app.getItem(0);
                String title = map.get(KeyOfMap.KEY_TITLE);
                String url = map.get(KeyOfMap.KEY_URL);
                Toast.makeText(mContext, title + "\n" + url, Toast.LENGTH_LONG).show();

                // 关闭Dialog
                dismiss();
            }
        });

    }

}
