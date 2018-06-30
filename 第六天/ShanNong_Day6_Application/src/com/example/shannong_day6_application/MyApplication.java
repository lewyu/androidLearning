package com.example.shannong_day6_application;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Jason", "Application Created!");
    }

    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<String> mUrlList = new ArrayList<>();

    // 插入一条新闻的相关数据
    public void addItem(String title, String url) {
        mTitleList.add(title);
        mUrlList.add(url);
    }

    /**
     * 获取每个新闻的相关信息
     * @param index 在集合中第几条新闻
     * @return 新闻所有数据的集合
     */
    public HashMap<String, String> getItem(int index) {

        String title = mTitleList.get(index);
        String url = mUrlList.get(index);

        HashMap<String, String> map = new HashMap<>();
        map.put(KeyOfMap.KEY_TITLE, title);
        map.put(KeyOfMap.KEY_URL, url);

        return map;
    }
    
    /**
     * @param index 要移除的新闻序号
     */
    public void removeItem(int index) {
        mTitleList.remove(index);
        mUrlList.remove(index);
    }
    
    /**
     * 清空所有数据
     */
    public void clearData() {
        mTitleList.clear();
        mUrlList.clear();
    }

}
