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
                // �洢����
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
     * ʹ��SharedPreferences���洢����
     * 
     * @param key
     *            ��
     * @param value
     *            ֵ
     */
    private void save(String key, String value) {
        // ���SharedPreferences����
        // ��һ��������SharedPreferences������
        // �ڶ���������������ģʽ������ֻʹ��˽��ģʽMODE_PRIVATE
        SharedPreferences prefs = getSharedPreferences("my_prefs", MODE_PRIVATE);
        // ���Ҫд�����ݣ���Ҫһ���ڲ���Editor����
        SharedPreferences.Editor edit = prefs.edit();
        // �洢��ֵ��
        edit.putString(key, value);
        // �����ύ
        boolean result = edit.commit();
        if (result)
            Toast.makeText(this, "���ݴ洢�ɹ�", Toast.LENGTH_SHORT).show();
    }

    private void load(String key, String defValue) {
        // ���SharedPreferences����
        // ��һ��������SharedPreferences������,��ȡ�õ����־�Ҫ�Ǵ洢�õ�����
        // �ڶ���������������ģʽ������ֻʹ��˽��ģʽMODE_PRIVATE
        SharedPreferences prefs = getSharedPreferences("my_prefs", MODE_PRIVATE);
        // ֱ�Ӷ�ȡ����
        // ��һ����������
        // �ڶ�����������ȡʧ�ܵ�Ĭ��ֵ
        String value = prefs.getString(key, defValue);
        Toast.makeText(this, key + "-->" + value, Toast.LENGTH_SHORT).show();

    }

}
