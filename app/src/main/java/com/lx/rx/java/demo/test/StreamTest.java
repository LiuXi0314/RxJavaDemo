package com.lx.rx.java.demo.test;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.stream.Stream;

/**
 * Created on 17-7-27 下午6:22
 */

public class StreamTest {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.filter(f -> f > 3);
    }
}
