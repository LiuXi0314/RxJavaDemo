package com.lx.rx.java.demo.bean;

import java.util.ArrayList;

/**
 * 推模式Demo
 * Created on 17-7-25 下午5:32
 */

public class PushData {
    private ArrayList<String> mArrayList = new ArrayList<>();
    private PushCallBack mCallBack;

    public PushData(PushCallBack callBack) {
        mCallBack = callBack;
    }

    public interface PushCallBack {
        public void onPush(ArrayList<String> dataList);
    }

    public void addData(String str) {
        mArrayList.add(str);
        mCallBack.onPush(mArrayList);
    }


}
