package com.example.shannong_day5_listview3;

import java.util.List;

import android.content.Context;
import android.util.Log;
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

    public static final String TAG = "MyAdapter";

    // 定义三个全局变量对象
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

    // getView负责每个Item的数据设置
    // 第一个参数:当前绘制的Item的序号
    // 第二个参数：之前getView返回的可以重用的单个Item的布局对象
    // 第三个参数：Item所在的容器控件
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "position-->" + position);
        Log.d(TAG, "convertView-->" + convertView);
        Log.d(TAG, "parent-->" + parent);
        Log.d(TAG, "-------------------------------------------");

        View linearLayout = convertView;
        ImageView image;
        TextView text;
        ViewHolder holder;
        // 如果为空表示不可重用
        if (convertView == null) {
            // 布局建造器对象
            LayoutInflater inflater = LayoutInflater.from(mContext);
            // 第一个参数：单个Item的布局id
            // 第二个参数： null
            linearLayout = inflater.inflate(R.layout.item_layout, null);
            // 单独找出Item内部的控件
            image = (ImageView) linearLayout.findViewById(R.id.item_image);
            text = (TextView) linearLayout.findViewById(R.id.item_text);
            //把控件对象装载到holder一个对象中
            holder = new ViewHolder(image, text);
            //“抱大腿”
            linearLayout.setTag(holder);
        }else {
            //布局重用时
            //先从布局对象中取出Holder
            holder = (ViewHolder) linearLayout.getTag();
            //取出之前存进去的对象
            image = holder.mImage;
            text = holder.mText;
        }
        // 给控件设置相应的数据
        image.setImageResource(mImageList.get(position));
        text.setText(mTextList.get(position));

        return linearLayout;
    }
    
    /**
     * @author Jason
     * 
     * 用于多个控件的封装
     *
     */
    class ViewHolder{
        
        public ImageView mImage;
        public TextView mText;
        
        public ViewHolder(ImageView img,TextView text) {
            mImage = img;
            mText = text;
        }
        
    }

}
