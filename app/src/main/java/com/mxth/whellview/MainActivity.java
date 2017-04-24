package com.mxth.whellview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WheelView wv = (WheelView) findViewById(R.id.wv);
        WheelView wv2 = (WheelView) findViewById(R.id.wv2);
        WheelView wv3 = (WheelView) findViewById(R.id.wv3);
        ArrayList<String> data=new ArrayList<>();
        data.add("北京");
        data.add("北京");
        data.add("北京");
        data.add("北京");
        wv.setData(data);
        wv.setDefault(0);
        wv2.setData(data);
        wv2.setDefault(0);
        wv3.setData(data);
        wv3.setDefault(0);
        wv.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, final String text) {
                //回调(子线程)
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void selecting(int id, String text) {
            //回调(子线程)
            }
        });
    }
}
