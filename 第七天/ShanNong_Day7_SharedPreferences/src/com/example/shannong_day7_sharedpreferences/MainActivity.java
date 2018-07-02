package com.example.shannong_day7_sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText mEditKey, mEditValue;
    private Button mBtnSave, mBtnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditKey = (EditText) findViewById(R.id.edit_key);
        mEditValue = (EditText) findViewById(R.id.edit_value);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnSave.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 存储数据
                save(mEditKey.getText().toString(), mEditValue.getText().toString());
            }
        });

        mBtnLoad = (Button) findViewById(R.id.btn_load);
        mBtnLoad.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                load(mEditKey.getText().toString(), mEditValue.getText().toString());
            }
        });
    }

    /**
     * 使用SharedPreferences来存储数据
     * 
     * @param key
     *            键
     * @param value
     *            值
     */
    private void save(String key, String value) {
        // 获得SharedPreferences对象
        // 第一个参数：SharedPreferences的名字
        // 第二个参数：操作的模式，建议只使用私有模式MODE_PRIVATE
        SharedPreferences prefs = getSharedPreferences("my_prefs", MODE_PRIVATE);
        // 如果要写入数据，需要一个内部类Editor对象
        SharedPreferences.Editor edit = prefs.edit();
        // 存储键值对
        edit.putString(key, value);
        // 数据提交
        boolean result = edit.commit();
        if (result)
            Toast.makeText(this, "数据存储成功", Toast.LENGTH_SHORT).show();
    }

    private void load(String key, String defValue) {
        // 获得SharedPreferences对象
        // 第一个参数：SharedPreferences的名字,读取用的名字就要是存储用的名字
        // 第二个参数：操作的模式，建议只使用私有模式MODE_PRIVATE
        SharedPreferences prefs = getSharedPreferences("my_prefs", MODE_PRIVATE);
        // 直接读取数据
        // 第一个参数：键
        // 第二个参数：读取失败的默认值
        String value = prefs.getString(key, defValue);
        Toast.makeText(this, key + "-->" + value, Toast.LENGTH_SHORT).show();

    }

}
