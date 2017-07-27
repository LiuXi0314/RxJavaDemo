package com.lx.rx.java.demo.bean;

import com.lx.rx.java.demo.Utils.LogUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * use RXJava2
 * <p>
 * Created on 17-7-27 下午4:48
 */

public class Tutorial extends Observable {

    private String authName;
    private String content;
    private List<Reader> mReaderList;

    public Tutorial(String authName, String content) {
        this.authName = authName;
        this.content = content;
    }

    public Tutorial() {

    }

    public void post() {
        sendEmail();
    }

    @Override
    protected void subscribeActual(Observer observer) {
        mReaderList.add((Reader) observer);
    }

    private void sendEmail() {
        for (Reader reader : mReaderList) {
            if (reader == null) continue;
            LogUtils.d(String.format("name: %s    email: %s", reader.getName(), reader.getEmail()));
        }
    }


}
