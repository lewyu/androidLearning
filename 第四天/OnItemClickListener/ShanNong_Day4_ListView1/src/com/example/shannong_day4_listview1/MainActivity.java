package com.example.shannong_day4_listview1;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    // M:数据源
    private ArrayList<String> mDataList;

    // V:视图
    private ListView mListView;

    // P:适配器
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
        // 给视图设置适配器
        mListView.setAdapter(mAdapter);
        // 对每一个Item做监听
        mListView.setOnItemClickListener(new OnItemClickListener() {

            //第一个参数：被点击的Item所在的容器控件，本例中是ListView对象，即mListView
            //第二个参数：被点击的Item对象，本例中是TextView对象，且每个Item都不是同一个对象
            //第三个参数/第四个参数：被点击的Item的序号
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "parent-->" + parent);
                Log.d(TAG, "view-->" + view);
                Log.d(TAG, "position-->" + position);
                Log.d(TAG, "id-->" + id);
                Log.d(TAG, "------------------------------");
                
                //在这里举例如何删除数据后，重新更新UI，增加数据同理
                //根据点击的Item返回的序号，可以精准的找到对应的数据源，来进行删除、修改、插入等操作
                mDataList.remove(position);
                //使用适配器来通知UI根据当前的数据刷新
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        // 第一个参数：上下文
        // 第二个参数：单个Item的布局
        mAdapter = new ArrayAdapter<>(this, R.layout.item_layout, mDataList);
    }

}
