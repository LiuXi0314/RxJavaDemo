package com.lx.rx.java.demo.listener;

import java.util.List;

/**
 * Created on 17-7-25 下午5:53
 */

public interface Observer {
    public void dataIsChanged(List<String> data);
}
