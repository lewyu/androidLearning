package com.example.shannong_day6_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//�̳г�����BroadcastReceiver
public class MyReceiver extends BroadcastReceiver {

    // ʵ�ֻص�����
    // ��һ��������������
    // �ڶ������������ݹ�����Intent����
    @Override
    public void onReceive(Context context, Intent intent) {
        // ������action�Ľ��շ���
        if (intent.getAction().equals("hello123")) {
            // ȡ������
            String data = intent.getStringExtra("data");
            // չʾ����
            Toast.makeText(context, "��̬ע��Ľ������յ��Ĺ㲥��Ϣ����Ϊ��" + data, Toast.LENGTH_LONG).show();
        } else {
            // ������ȥ�ж��������͵Ĺ㲥
        }
    }
}
