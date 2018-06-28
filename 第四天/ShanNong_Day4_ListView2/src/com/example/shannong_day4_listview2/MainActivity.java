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

    // M:����Դ
    private ArrayList<String> mTextList;
    private ArrayList<Integer> mImgList;
    //������Դ
    private ArrayList<HashMap<String, Object>> mDataList;

    // V:��ͼ
    private ListView mListView;

    // P������Դ
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
        //ѭ��װ��
        for (int i = 0; i < mTextList.size(); i++) {
            HashMap<String, Object> map  = new HashMap<String, Object>();
            map.put("img", mImgList.get(i));
            map.put("text", mTextList.get(i));
            //�Ѽ�ֵ��װ��List��
            mDataList.add(map);
        }
    }

    /**
     * ��ʼ����ͼ
     */
    private void initView() {
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter);
    }

    /**
     * ��ʼ��������
     */
    private void initAdapter() {
        String[] from = new String[] {"img","text"};
        int[] to = new int[] {R.id.item_image,R.id.item_text};
        // ��һ��������������
        // �ڶ���������������Դ
        // ����������������Item�Ĳ����ļ�
        // ���ĸ�������Map�����еļ�����
        // �����������Item�����еĿؼ���id����
        mAdapter = new SimpleAdapter(this, mDataList, R.layout.item_layout, from, to);
    }

}
