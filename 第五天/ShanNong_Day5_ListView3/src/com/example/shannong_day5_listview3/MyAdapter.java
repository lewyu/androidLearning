package com.example.shannong_day5_listview3;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Jason
 * 
 *         自定义Adapter
 *
 */
public class MyAdapter extends BaseAdapter {
    
    //定义三个全局变量对象
    private Context mContext;
    private List<Integer> mImageList;
    private List<String> mTextList;
    
    

    // 有参构造器，用于初始化传参
    public MyAdapter(Context context, List<Integer> imageList, List<String> textList) {
        mContext = context;
        mImageList = imageList;
        mTextList = textList;
    }

    @Override
    public int getCount() {
        // 返回数据有多少
        return mTextList.size();
    }

    @Override
    public Object getItem(int position) {
        // 此方法可以用于返回Item的数据
        return mTextList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    
    //getView负责每个Item的数据设置
    //第一个参数:当前绘制的Item的序号
    //TODO 第二个参数？？？
    //第三个参数：Item所在的容器控件
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //布局建造器对象
        LayoutInflater inflater = LayoutInflater.from(mContext);
        //第一个参数：单个Item的布局id
        //第二个参数： null
        View linearLayout = inflater.inflate(R.layout.item_layout, null);
        //单独找出Item内部的控件
        ImageView image = (ImageView) linearLayout.findViewById(R.id.item_image);
        TextView text = (TextView) linearLayout.findViewById(R.id.item_text);
        //给控件设置相应的数据
        image.setImageResource(mImageList.get(position));
        text.setText(mTextList.get(position));
        
        return linearLayout;
    }

}
