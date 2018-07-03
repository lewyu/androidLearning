package com.example.shannong_day8_webview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    // M:����Դ
    private ArrayList<String> mDataList;
    private ArrayList<String> mUrlList;

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
        mDataList.add("�й��˴��������ﾶӭ�������������ͱ�̬ǿ��¼����Ҫ������£�");
        mDataList.add("2018�������ʡ����ҵ�ռ�����֪ʶ�����С���ɹ�����");
        mDataList.add("̨���������ٰ���ʦ��᣺����ǫ̈̄22���и���");
        mDataList.add("�й����������ͬ��!�׽��������籭 3ʤ3�����������࿴!");
        mDataList.add("�»������ס�Ƶ꣬�˷��󣬱��ఢ�̽�ȥ���ŵñ������");
        mDataList.add("�й���ʷ�������˵�Ůս������ʱ���ʵ۳��ң�����һ������");
        mDataList.add("���壺����ٴ�ȫ����Ī�������� ���Ȳ��е�4");
        mDataList.add("����ƽ̨���û�������3.2�� 3�����������˱���");
        mDataList.add("��Ϣ�ư׹�������� WTO ��������ķ���");
        mDataList.add("70�����濡�θ������г� ����֯���������޴������й���");
        mDataList.add("26��С�﷢����ʽ΢��ʧ�� ��Ƿ���ÿ������û�");
        mDataList.add("һ������Ϊ���ܸı�ٶ�֮ս�Ľ�������������½�����");
        
        mUrlList = new ArrayList<>();
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702090023280.html");
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702085938123.html");
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702084927838.html");
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702084824254.html");
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702084644551.html");
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702084454676.html");
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702084453600.html");
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702084316541.html");
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702084234421.html");
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702084149801.html");
        mUrlList.add("http:\\/\\/mini.eastday.com\\/mobile\\/180702084021413.html");
        mUrlList.add("https://www.baidu.com/");
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
                //��ת��ֵ�����¸�ҳ�����Ӧ����ҳ
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url", mUrlList.get(position));
                startActivity(intent);
            }
        });

    }

    /**
     * ��ʼ��������
     */
    private void initAdapter() {
        // ��һ��������������
        // �ڶ�������������Item�Ĳ���
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mDataList);
    }

}
