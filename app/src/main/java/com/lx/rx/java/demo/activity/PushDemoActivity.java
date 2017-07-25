package com.lx.rx.java.demo.activity;

import android.os.Bundle;

import com.lx.rx.java.demo.R;
import com.lx.rx.java.demo.Utils.LogUtils;
import com.lx.rx.java.demo.bean.PushData;

import java.util.ArrayList;
import java.util.Date;

public class PushDemoActivity extends BaseActivity implements PushData.PushCallBack {

    private PushData mPushData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_demo);
        loadData();
    }

    private void loadData() {
        mPushData = new PushData(this);
        mPushData.addData("A");
        mPushData.addData("B");
        mPushData.addData("A");
        mPushData.addData("A");
    }

    private void iterateOnData(ArrayList<String> dataList) {
        LogUtils.logCurrentTime();
        for (int i = 0; i < dataList.size(); i++) {
            String str = dataList.get(i);
            LogUtils.d(str);
        }
    }

    @Override
    public void onPush(ArrayList<String> dataList) {
        iterateOnData(dataList);
    }
}
