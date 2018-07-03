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

    // M:数据源
    private ArrayList<String> mDataList;
    private ArrayList<String> mUrlList;

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
        mDataList.add("中国人带领亚洲田径迎来革命！上世纪变态强纪录现在要逐个拿下？");
        mDataList.add("2018年度辽宁省银行业普及金融知识万里行”活动成功启动");
        mDataList.add("台反年改团体举办誓师大会：启动全台22县市革命");
        mDataList.add("中国队与意大利同组!首届球迷世界杯 3胜3负让人另眼相看!");
        mDataList.add("新婚夫妇旅游住酒店，退房后，保洁阿姨进去后被吓得崩溃大哭");
        mDataList.add("中国历史上最幸运的女战俘，临时被皇帝宠幸，生下一代明君");
        mDataList.add("高清：贵肯速贷全国赛莫利纳里夺冠 伍兹并列第4");
        mDataList.add("网络平台利用花呗套现3.2亿 3名犯罪嫌疑人被捕");
        mDataList.add("消息称白宫起草无视 WTO 基本规则的法案");
        mDataList.add("70后刘存俊任阜阳副市长 曾组织创建安徽无传销城市工作");
        mDataList.add("26岁小伙发遗书式微信失联 称欠信用卡死后不用还");
        mDataList.add("一封书信为何能改变官渡之战的结果，这则成语故事揭晓答案");
        
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
                //跳转传值，在下个页面打开相应的网页
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url", mUrlList.get(position));
                startActivity(intent);
            }
        });

    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        // 第一个参数：上下文
        // 第二个参数：单个Item的布局
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mDataList);
    }

}
