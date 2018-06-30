package com.example.shannong_day6_button;

/**
 * @author Jason
 *
 * 自定义Button类，仅用于回调机制的学习，没有实际完整功能
 *
 */
public class MyButton {
    
    private MyOnClickListener mListener;
    
    public void setOnClickListener(MyOnClickListener listener) {
        mListener = listener;
    }
    
    //当用户点击控件，底层会调用此方法
    public void userEvent() {
        mListener.onClick();
    }
    

}
