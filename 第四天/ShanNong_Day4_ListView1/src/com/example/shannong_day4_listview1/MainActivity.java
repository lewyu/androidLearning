package com.example.shannong_day4_listview1;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    
    //M:数据源
    private ArrayList<String> mDataList;
    
    //V:视图
    private ListView mListView;
    
    //P:适配器
    private ArrayAdapter<String> mAdapter;
    
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
        mDataList = new ArrayList<String>();
        mDataList.add("分公司的境况放个假开始淡化");
        mDataList.add("的卡是基督教哈数据库噶速度加快");
        mDataList.add("噶进口国对公司给");
        mDataList.add("找个不错杰克逊公交卡双方各段水电工");
        mDataList.add("大罗还好点卡视角可能就矮冬瓜覅");
        mDataList.add("和雕塑爷爷给恒大授课更好杜卡嘎附件");
        mDataList.add("等各环节爱上过的痕迹按时感到骄傲四个即可都尬数据");
        mDataList.add("的宫颈癌十多个很骄傲上个阶段干净啊是个");
        mDataList.add("的has电话卡是对卡是");
        mDataList.add("阿hi和答辩卡狗");
        mDataList.add("但失败代码，哈就开始特工段位高");
        mDataList.add("阿姨欧阳少恭很大数据库大纲啥");
    }
    
    
    /**
     * 初始化视图
     */
    private void initView() {
        mListView = (ListView) findViewById(R.id.list_view);
        //给视图设置适配器
        mListView.setAdapter(mAdapter);
    }
    
    /**
     * 初始化适配器
     */
    private void initAdapter() {
        //第一个参数：上下文
        //第二个参数：单个Item的布局
        mAdapter = new ArrayAdapter<>(this, R.layout.item_layout, mDataList);
    }

}
