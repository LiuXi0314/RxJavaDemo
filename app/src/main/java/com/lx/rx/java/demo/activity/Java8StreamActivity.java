package com.lx.rx.java.demo.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.lx.rx.java.demo.R;

import java.util.stream.Stream;

public class Java8StreamActivity extends BaseActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java8_stream);
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
//        Stream.generate(Math::random);
        stream.filter(f -> f > 2);

    }
}
