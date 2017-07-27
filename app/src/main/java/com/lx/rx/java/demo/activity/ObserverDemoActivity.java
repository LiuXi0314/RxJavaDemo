package com.lx.rx.java.demo.activity;

import android.os.Bundle;
import android.view.View;

import com.lx.rx.java.demo.R;
import com.lx.rx.java.demo.Utils.LogUtils;
import com.lx.rx.java.demo.bean.ObservableData;
import com.lx.rx.java.demo.bean.Reader;
import com.lx.rx.java.demo.bean.Tutorial;
import com.lx.rx.java.demo.listener.Observer;

import java.util.List;

public class ObserverDemoActivity extends BaseActivity implements Observer {

    private ObservableData mObservableData;
    private Tutorial mTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("观察者模式");
        setContentView(R.layout.activity_observer_demo);
        findViewById(R.id.demo1).setOnClickListener(this);
        findViewById(R.id.demo2).setOnClickListener(this);
    }

    private void test1() {
        mObservableData = new ObservableData();
        mObservableData.subscribe(this);
        mObservableData.addData("YI");
        mObservableData.addData("ER");
        mObservableData.addData("SAN");
        mObservableData.addData("SI");
        mObservableData.unSubscribe(this);
    }


    private void testWithRxJava() {
        if (mTutorial == null) mTutorial = new Tutorial("Android探索者","锲而不舍");

        Reader reader1 = new Reader("a","12345@gmail.com");





    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.demo1) {
            test1();
        } else if (id == R.id.demo2) {
            testWithRxJava();
        }
    }


    @Override
    public void dataIsChanged(List<String> data) {
        LogUtils.logCurrentTime();
        for (String str : data) {
            LogUtils.d(str);
        }

    }
}
