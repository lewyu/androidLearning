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
 *         �Զ���Adapter
 *
 */
public class MyAdapter extends BaseAdapter {
    
    //��������ȫ�ֱ�������
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

    
    //getView����ÿ��Item����������
    //��һ������:��ǰ���Ƶ�Item�����
    //TODO �ڶ�������������
    //������������Item���ڵ������ؼ�
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //���ֽ���������
        LayoutInflater inflater = LayoutInflater.from(mContext);
        //��һ������������Item�Ĳ���id
        //�ڶ��������� null
        View linearLayout = inflater.inflate(R.layout.item_layout, null);
        //�����ҳ�Item�ڲ��Ŀؼ�
        ImageView image = (ImageView) linearLayout.findViewById(R.id.item_image);
        TextView text = (TextView) linearLayout.findViewById(R.id.item_text);
        //���ؼ�������Ӧ������
        image.setImageResource(mImageList.get(position));
        text.setText(mTextList.get(position));
        
        return linearLayout;
    }

}
