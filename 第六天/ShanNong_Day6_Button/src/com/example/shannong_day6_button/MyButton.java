package com.example.shannong_day6_button;

/**
 * @author Jason
 *
 * �Զ���Button�࣬�����ڻص����Ƶ�ѧϰ��û��ʵ����������
 *
 */
public class MyButton {
    
    private MyOnClickListener mListener;
    
    public void setOnClickListener(MyOnClickListener listener) {
        mListener = listener;
    }
    
    //���û�����ؼ����ײ����ô˷���
    public void userEvent() {
        mListener.onClick();
    }
    

}
