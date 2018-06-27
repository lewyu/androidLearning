package com.example.shannong_day2_dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author Jason
 * 
 * 自定义Dialog类
 *
 */
public class MyDialog extends Dialog{
    
    private Button mBtn;
    
    //存储传入的上下文
    private Context mContext;
    
    //增加构造方法
    public MyDialog(Context context) {
        super(context);
        //设置布局文件
        setContentView(R.layout.my_dialog);
        
        //存储上下文
        mContext = context;
        
        //设置标题
        setTitle("自定义MyDialog");
        
        mBtn  = (Button) findViewById(R.id.mydialog_btn);
        //在自定义Dialog中使用普通的OnClickListener要注意加View前缀
        mBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击了按钮！", Toast.LENGTH_LONG).show();
                //所有的Dialog
                dismiss();
            }
        });
        
    }
    
    
    
    
    
    
    
    

}
