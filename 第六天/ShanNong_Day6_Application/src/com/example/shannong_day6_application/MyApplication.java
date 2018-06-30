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

    // ����һ�����ŵ��������
    public void addItem(String title, String url) {
        mTitleList.add(title);
        mUrlList.add(url);
    }

    /**
     * ��ȡÿ�����ŵ������Ϣ
     * @param index �ڼ����еڼ�������
     * @return �����������ݵļ���
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
     * @param index Ҫ�Ƴ����������
     */
    public void removeItem(int index) {
        mTitleList.remove(index);
        mUrlList.remove(index);
    }
    
    /**
     * �����������
     */
    public void clearData() {
        mTitleList.clear();
        mUrlList.clear();
    }

}
