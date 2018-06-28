package com.example.shannong_day4_listview1;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    
    //M:����Դ
    private ArrayList<String> mDataList;
    
    //V:��ͼ
    private ListView mListView;
    
    //P:������
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
     * ��ʼ������Դ
     */
    private void initData() {
        mDataList = new ArrayList<String>();
        mDataList.add("�ֹ�˾�ľ����Ÿ��ٿ�ʼ����");
        mDataList.add("�Ŀ��ǻ����̹����ݿ���ٶȼӿ�");
        mDataList.add("�����ڹ��Թ�˾��");
        mDataList.add("�Ҹ�����ܿ�ѷ������˫������ˮ�繤");
        mDataList.add("���޻��õ㿨�ӽǿ��ܾͰ�����҅");
        mDataList.add("�͵���үү������ڿθ��öſ��¸���");
        mDataList.add("�ȸ����ڰ��Ϲ��ĺۼ���ʱ�е������ĸ����ɶ�������");
        mDataList.add("�Ĺ�����ʮ����ܽ����ϸ��׶θɾ����Ǹ�");
        mDataList.add("��has�绰���ǶԿ���");
        mDataList.add("��hi�ʹ�翨��");
        mDataList.add("��ʧ�ܴ��룬���Ϳ�ʼ�ع���λ��");
        mDataList.add("����ŷ���ٹ��ܴ����ݿ���ɶ");
    }
    
    
    /**
     * ��ʼ����ͼ
     */
    private void initView() {
        mListView = (ListView) findViewById(R.id.list_view);
        //����ͼ����������
        mListView.setAdapter(mAdapter);
    }
    
    /**
     * ��ʼ��������
     */
    private void initAdapter() {
        //��һ��������������
        //�ڶ�������������Item�Ĳ���
        mAdapter = new ArrayAdapter<>(this, R.layout.item_layout, mDataList);
    }

}
