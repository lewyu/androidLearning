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

    // M:����Դ
    private ArrayList<String> mDataList;

    // V:��ͼ
    private ListView mListView;

    // P:������
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
        // ����ͼ����������
        mListView.setAdapter(mAdapter);
        // ��ÿһ��Item������
        mListView.setOnItemClickListener(new OnItemClickListener() {

            //��һ���������������Item���ڵ������ؼ�����������ListView���󣬼�mListView
            //�ڶ����������������Item���󣬱�������TextView������ÿ��Item������ͬһ������
            //����������/���ĸ��������������Item�����
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "parent-->" + parent);
                Log.d(TAG, "view-->" + view);
                Log.d(TAG, "position-->" + position);
                Log.d(TAG, "id-->" + id);
                Log.d(TAG, "------------------------------");
                
                //������������ɾ�����ݺ����¸���UI����������ͬ��
                //���ݵ����Item���ص���ţ����Ծ�׼���ҵ���Ӧ������Դ��������ɾ�����޸ġ�����Ȳ���
                mDataList.remove(position);
                //ʹ����������֪ͨUI���ݵ�ǰ������ˢ��
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    /**
     * ��ʼ��������
     */
    private void initAdapter() {
        // ��һ��������������
        // �ڶ�������������Item�Ĳ���
        mAdapter = new ArrayAdapter<>(this, R.layout.item_layout, mDataList);
    }

}
