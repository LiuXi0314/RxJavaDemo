package com.lx.rx.java.demo.activity;

import android.os.Bundle;

import com.lx.rx.java.demo.R;
import com.lx.rx.java.demo.Utils.LogUtils;
import com.lx.rx.java.demo.bean.ObservableData;
import com.lx.rx.java.demo.listener.Observer;

import java.util.List;

public class ObserverDemoActivity extends BaseActivity implements Observer {

    private ObservableData mObservableData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_demo);
        load();
    }

    private void load() {
        mObservableData = new ObservableData();
        mObservableData.subscribe(this);
        mObservableData.addData("YI");
        mObservableData.addData("ER");
        mObservableData.addData("SAN");
        mObservableData.addData("SI");
        mObservableData.unSubscribe(this);

    }

    @Override
    public void dataIsChanged(List<String> data) {
        LogUtils.logCurrentTime();
        for (String str : data) {
            LogUtils.d(str);
        }

    }
}
