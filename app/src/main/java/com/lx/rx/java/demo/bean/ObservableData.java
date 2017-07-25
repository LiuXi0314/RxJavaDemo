package com.lx.rx.java.demo.bean;

import com.lx.rx.java.demo.Utils.LogUtils;
import com.lx.rx.java.demo.listener.Observable;
import com.lx.rx.java.demo.listener.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式demo
 * Created on 17-7-25 下午5:56
 */

public class ObservableData implements Observable {

    private List<Observer> mObserverList;
    private List<String> mStringList;

    public ObservableData() {
        mObserverList = new ArrayList<>();
        mStringList = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        LogUtils.d("关注");
        mObserverList.add(observer);
    }

    @Override
    public void unSubscribe(Observer observer) {
        LogUtils.d("取关");
        mObserverList.remove(observer);
    }

    @Override
    public void notifyToAll() {
        for (Observer observer : mObserverList) {
            observer.dataIsChanged(mStringList);
        }
    }

    public void addData(String str) {
        mStringList.add(str);
        notifyToAll();
    }

}
