package com.lx.rx.java.demo.bean;

import com.lx.rx.java.demo.Utils.LogUtils;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created on 17-7-27 下午4:52
 */

public class Reader implements Observer {

    private String name;
    private String email;

    public Reader(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        LogUtils.d(getName()+"订阅");
    }

    @Override
    public void onNext(@NonNull Object o) {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
