package com.example.shannong_day4_listview2;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

    // M:数据源
    private ArrayList<String> mTextList;
    private ArrayList<Integer> mImgList;
    //总数据源
    private ArrayList<HashMap<String, Object>> mDataList;

    // V:视图
    private ListView mListView;

    // P：数据源
    private SimpleAdapter mAdapter;

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

        mImgList = new ArrayList<Integer>();
        mImgList.add(R.drawable.audi);
        mImgList.add(R.drawable.chevrolet);
        mImgList.add(R.drawable.chrysler);
        mImgList.add(R.drawable.ford);
        mImgList.add(R.drawable.infinity);
        mImgList.add(R.drawable.maserati);
        mImgList.add(R.drawable.mitsubishi);
        mImgList.add(R.drawable.subaru);
        mImgList.add(R.drawable.volkswagen);
        mImgList.add(R.drawable.volvo);

        mDataList = new ArrayList<HashMap<String, Object>>();
        //循环装载
        for (int i = 0; i < mTextList.size(); i++) {
            HashMap<String, Object> map  = new HashMap<String, Object>();
            map.put("img", mImgList.get(i));
            map.put("text", mTextList.get(i));
            //把键值对装进List中
            mDataList.add(map);
        }
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter);
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        String[] from = new String[] {"img","text"};
        int[] to = new int[] {R.id.item_image,R.id.item_text};
        // 第一个参数：上下文
        // 第二个参数：总数据源
        // 第三个参数：单个Item的布局文件
        // 第四个参数：Map中所有的键数组
        // 第五个参数：Item中所有的控件的id数组
        mAdapter = new SimpleAdapter(this, mDataList, R.layout.item_layout, from, to);
    }

}
