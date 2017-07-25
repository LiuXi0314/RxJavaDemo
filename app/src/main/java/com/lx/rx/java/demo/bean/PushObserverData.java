package com.lx.rx.java.demo.bean;

import java.util.ArrayList;

/**
 * Created on 17-7-25 下午5:49
 */

public class PushObserverData {

    private ArrayList<String> mArrayList = new ArrayList<>();


    public void addData(String str) {
        mArrayList.add(str);

    }


}
