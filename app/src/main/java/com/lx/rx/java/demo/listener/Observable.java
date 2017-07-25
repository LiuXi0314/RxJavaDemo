package com.lx.rx.java.demo.listener;

/**
 * Created on 17-7-25 下午5:50
 */

public interface Observable {

    public void subscribe(Observer observer);

    public void unSubscribe(Observer observer);

    public void notifyToAll();

}
