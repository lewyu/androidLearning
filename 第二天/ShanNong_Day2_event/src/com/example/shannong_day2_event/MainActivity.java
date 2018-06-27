package com.example.shannong_day2_event;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity {
    
    public static final String TAG = "MainActivity";

    private TextView mTextBottom, mTextMiddle, mTextTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        mTextBottom = (TextView) findViewById(R.id.text_bottom);
        mTextBottom.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "mTextBottom touched");
                return false;
            }
        });

        mTextMiddle = (TextView) findViewById(R.id.text_middle);
        mTextMiddle.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "mTextMiddle touched");
                return true;
            }
        });

        mTextTop = (TextView) findViewById(R.id.text_top);
        mTextTop.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "mTextTop touched");
                return false;
            }
        });
    }

}
