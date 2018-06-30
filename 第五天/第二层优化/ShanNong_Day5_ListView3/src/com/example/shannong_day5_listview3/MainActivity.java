package com.example.shannong_day5_listview3;

import java.util.ArrayList;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
    //M:����Դ
    private ArrayList<String> mTextList;
    private ArrayList<Integer> mImageList;
    
    //V:��ͼ
    private ListView mListView;
    
    //P:�Զ���������
    private MyAdapter mAdapter;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initData();
        initAdapter();
        initView();
    }
    
    /**
     * ��ʼ������Դ
     */
    private void initData() {
        mTextList = new ArrayList<String>();
        mTextList.add("�µ�");
        mTextList.add("ѩ����");
        mTextList.add("����˹��");
        mTextList.add("����");
        mTextList.add("Ӣ�����");
        mTextList.add("��ɯ����");
        mTextList.add("����");
        mTextList.add("˹��³");
        mTextList.add("����");
        mTextList.add("�ֶ���");

        mImageList = new ArrayList<Integer>();
        mImageList.add(R.drawable.audi);
        mImageList.add(R.drawable.chevrolet);
        mImageList.add(R.drawable.chrysler);
        mImageList.add(R.drawable.ford);
        mImageList.add(R.drawable.infinity);
        mImageList.add(R.drawable.maserati);
        mImageList.add(R.drawable.mitsubishi);
        mImageList.add(R.drawable.subaru);
        mImageList.add(R.drawable.volkswagen);
        mImageList.add(R.drawable.volvo);
    }
    
    private void initView() {
        mListView = (ListView) findViewById(R.id.list_view);
        //����������
        mListView.setAdapter(mAdapter);
    }
    
    /**
     * ��ʼ��������
     */
    private void initAdapter() {
        //��һ������:������
        //�ڶ���������ͼƬ����Դ
        //��������������������Դ
        mAdapter = new MyAdapter(this, mImageList, mTextList);
    }
    
    
    

}
