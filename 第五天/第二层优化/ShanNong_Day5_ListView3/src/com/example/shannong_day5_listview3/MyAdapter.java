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
 *         �Զ���Adapter
 *
 */
public class MyAdapter extends BaseAdapter {

    public static final String TAG = "MyAdapter";

    // ��������ȫ�ֱ�������
    private Context mContext;
    private List<Integer> mImageList;
    private List<String> mTextList;

    // �вι����������ڳ�ʼ������
    public MyAdapter(Context context, List<Integer> imageList, List<String> textList) {
        mContext = context;
        mImageList = imageList;
        mTextList = textList;
    }

    @Override
    public int getCount() {
        // ���������ж���
        return mTextList.size();
    }

    @Override
    public Object getItem(int position) {
        // �˷����������ڷ���Item������
        return mTextList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // getView����ÿ��Item����������
    // ��һ������:��ǰ���Ƶ�Item�����
    // �ڶ���������֮ǰgetView���صĿ������õĵ���Item�Ĳ��ֶ���
    // ������������Item���ڵ������ؼ�
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
        // ���Ϊ�ձ�ʾ��������
        if (convertView == null) {
            // ���ֽ���������
            LayoutInflater inflater = LayoutInflater.from(mContext);
            // ��һ������������Item�Ĳ���id
            // �ڶ��������� null
            linearLayout = inflater.inflate(R.layout.item_layout, null);
            // �����ҳ�Item�ڲ��Ŀؼ�
            image = (ImageView) linearLayout.findViewById(R.id.item_image);
            text = (TextView) linearLayout.findViewById(R.id.item_text);
            //�ѿؼ�����װ�ص�holderһ��������
            holder = new ViewHolder(image, text);
            //�������ȡ�
            linearLayout.setTag(holder);
        }else {
            //��������ʱ
            //�ȴӲ��ֶ�����ȡ��Holder
            holder = (ViewHolder) linearLayout.getTag();
            //ȡ��֮ǰ���ȥ�Ķ���
            image = holder.mImage;
            text = holder.mText;
        }
        // ���ؼ�������Ӧ������
        image.setImageResource(mImageList.get(position));
        text.setText(mTextList.get(position));

        return linearLayout;
    }
    
    /**
     * @author Jason
     * 
     * ���ڶ���ؼ��ķ�װ
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
