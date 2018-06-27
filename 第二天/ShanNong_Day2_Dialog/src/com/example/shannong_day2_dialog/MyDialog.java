package com.example.shannong_day2_dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author Jason
 * 
 * �Զ���Dialog��
 *
 */
public class MyDialog extends Dialog{
    
    private Button mBtn;
    
    //�洢�����������
    private Context mContext;
    
    //���ӹ��췽��
    public MyDialog(Context context) {
        super(context);
        //���ò����ļ�
        setContentView(R.layout.my_dialog);
        
        //�洢������
        mContext = context;
        
        //���ñ���
        setTitle("�Զ���MyDialog");
        
        mBtn  = (Button) findViewById(R.id.mydialog_btn);
        //���Զ���Dialog��ʹ����ͨ��OnClickListenerҪע���Viewǰ׺
        mBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "����˰�ť��", Toast.LENGTH_LONG).show();
                //���е�Dialog
                dismiss();
            }
        });
        
    }
    
    
    
    
    
    
    
    

}
