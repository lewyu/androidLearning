package com.example.shannong_day5_listview3;

import java.util.ArrayList;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
    //M:数据源
    private ArrayList<String> mTextList;
    private ArrayList<Integer> mImageList;
    
    //V:视图
    private ListView mListView;
    
    //P:自定义适配器
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
     * 初始化数据源
     */
    private void initData() {
        mTextList = new ArrayList<String>();
        mTextList.add("奥迪");
        mTextList.add("雪佛兰");
        mTextList.add("克莱斯勒");
        mTextList.add("福特");
        mTextList.add("英菲尼迪");
        mTextList.add("玛莎拉蒂");
        mTextList.add("三菱");
        mTextList.add("斯巴鲁");
        mTextList.add("大众");
        mTextList.add("沃尔沃");

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
        //设置适配器
        mListView.setAdapter(mAdapter);
    }
    
    /**
     * 初始化适配器
     */
    private void initAdapter() {
        //第一个参数:上下文
        //第二个参数：图片数据源
        //第三个参数：文字数据源
        mAdapter = new MyAdapter(this, mImageList, mTextList);
    }
    
    
    

}
