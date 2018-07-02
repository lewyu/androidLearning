package com.example.shannong_day7_database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button mBtnCreate, mBtnVersion, mBtnInsert, mBtnDelete, mBtnUpdate, mBtnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDB();
        updateVision();
        insert();
        delete();
        update();
        easyQuery();
    }

    /**
     * �������ݿ�
     */
    private void createDB() {
        mBtnCreate = (Button) findViewById(R.id.btn_create);
        mBtnCreate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // �������ݿ⣺
                // ʵ�������ݿ�������
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 1);
                // ������ݿ����
                helper.getWritableDatabase().close();
            }
        });
    }

    /**
     * �������ݿ�汾
     */
    private void updateVision() {
        mBtnVersion = (Button) findViewById(R.id.btn_update_version);
        mBtnVersion.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // �������ݿ�İ汾
                // �������ݿ⣺
                // ʵ�������ݿ�������
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // ������ݿ����
                helper.getWritableDatabase().close();
            }
        });
    }

    /**
     * 
     * �����ݿ��в�������
     * 
     * 
     */
    private void insert() {
        mBtnInsert = (Button) findViewById(R.id.btn_insert);
        mBtnInsert.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // ��ÿ�д�����ݿ����
                SQLiteDatabase db = helper.getWritableDatabase();
                // һ�����ݵķ�װ
                ContentValues cv = new ContentValues();
                // ��װ����
                cv.put("uniquekey", "4f9fdeb307430068151e1356705e34a8");
                cv.put("title", "7��6�գ���������ţ��Ƹ�������3��Ф����һ���һ������");
                cv.put("date", "2018-07-01 14:22");
                cv.put("category", "ͷ��");
                cv.put("author_name", "��ľϸ˵");
                cv.put("url", "http:\\/\\/mini.eastday.com\\/mobile\\/180701142221871.html");
                cv.put("thumbnail_pic_s",
                        "http:\\/\\/07.imgmini.eastday.com\\/mobile\\/20180701\\/20180701_0370d50c17044dbf515287b70219b520_cover_mwpm_03200403.jpg");
                // ��������
                // ��һ������������
                // �ڶ�����������ֵ����
                // ���������������������
                long result = db.insert(MyHelper.DB_TABLE_CACHE, null, cv);
                db.close();
                if (result != -1)
                    Toast.makeText(MainActivity.this, "�������ݳɹ���", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * ɾ�����ݿ� �е�����
     */
    private void delete() {
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mBtnDelete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // ��ÿ�д�����ݿ����
                SQLiteDatabase db = helper.getWritableDatabase();
                // ɾ������
                // ��һ������������
                // �ڶ���������where�Ӿ� where category = 'ͷ��' and author_name = '��Ѷ��'
                // ������������where�Ӿ���?����ֵ
                int result = db.delete(MyHelper.DB_TABLE_CACHE, "category = ? and author_name = ?",
                        new String[] { "ͷ��", "��Ѷ��" });
                Toast.makeText(MainActivity.this, "ɾ����" + result + "��", Toast.LENGTH_SHORT).show();
                // �ر����ݿ�
                db.close();
            }
        });
    }

    /**
     * �������ݿ��е���������
     */
    private void update() {
        mBtnUpdate = (Button) findViewById(R.id.btn_update);
        mBtnUpdate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // ��ÿ�д�����ݿ����
                SQLiteDatabase db = helper.getWritableDatabase();
                // ���ݷ�װ����
                ContentValues cv = new ContentValues();
                // Ҫ���ĵ�����
                cv.put("author_name", "��������Ƶ");

                // ��������
                // ��һ������������
                // �ڶ������������ݷ�װ
                // ������������WHERE�Ӿ�
                // ���ĸ�������WHERE�Ӿ���?����ֵ
                int result = db.update(MyHelper.DB_TABLE_CACHE, cv, "category = ?", new String[] { "ͷ��" });
                Toast.makeText(MainActivity.this, "������" + result + "��", Toast.LENGTH_SHORT).show();
                // �ر����ݿ�
                db.close();
            }
        });

    }

    /**
     * ��ѯ
     */
    private void easyQuery() {
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mBtnQuery.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // ��ÿ�д�����ݿ����
                SQLiteDatabase db = helper.getReadableDatabase();
                // ���ݲ�ѯ
                // ��һ������������
                Cursor cursor = db.query(MyHelper.DB_TABLE_CACHE, null, null, null, null, null, null);
                // ѭ��ȡ��
                while (cursor.moveToNext()) {
                    // ȡֵ
                    String _id = cursor.getString(cursor.getColumnIndex("_id"));
                    String title = cursor.getString(cursor.getColumnIndex("title"));
                    String author_name = cursor.getString(cursor.getColumnIndex("author_name"));

                    Log.d("Jason", _id + " " + title + " " + author_name);
                }

                Toast.makeText(MainActivity.this, "��ѯ�ɹ�", Toast.LENGTH_SHORT).show();
                // �ر��α�����ݿ�
                cursor.close();
                db.close();

            }
        });
    }

    /**
     * ��ѯ
     */
    private void query() {
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mBtnQuery.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MyHelper helper = new MyHelper(MainActivity.this, "news.db", 2);
                // ��ÿ�д�����ݿ����
                SQLiteDatabase db = helper.getReadableDatabase();
                // ���ݲ�ѯ
                // ��һ������������
                // �ڶ���������SELECT�Ӿ䣬�ѽ����ϣ�����ֵ�����д��String����ĸ�ʽ
                // ������������WHERE�Ӿ� WHERE author_name = '��������Ƶ'
                // ���ĸ�������WHERE�Ӿ��еĲ���
                // �����������GROUP BY �Ӿ�
                // ������������HAVING �Ӿ�
                // ���߸�����������
                Cursor cursor = db.query(MyHelper.DB_TABLE_CACHE, new String[] { "_id", "title", "author_name" },
                        "author_name = ?", new String[] { "��������Ƶ" }, null, null, null);

                // //ѭ��ȡ��
                // while(cursor.moveToNext()) {
                // //ȡֵ
                // String _id = cursor.getString(cursor.getColumnIndex("_id"));
                // String title =
                // cursor.getString(cursor.getColumnIndex("title"));
                // String author_name =
                // cursor.getString(cursor.getColumnIndex("author_name"));
                //
                // Log.d("Jason", _id + " " + title + " " + author_name);
                // }
                //
                // Toast.makeText(MainActivity.this, "��ѯ�ɹ�",
                // Toast.LENGTH_SHORT).show();
                // //�ر��α�����ݿ�
                // cursor.close();
                // db.close();

            }
        });
    }

}
