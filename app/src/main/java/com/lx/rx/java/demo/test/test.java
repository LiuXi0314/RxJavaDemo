package com.lx.rx.java.demo.test;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created on 17-7-27 下午5:34
 */

public class test {
    public static <T> T getT(T a) {
        return a;
    }

    public <T> T getA(T v) {
        return v;
    }

    private Context mContext;
    private TextView mTextView = new TextView(mContext);

    private void lambdaTest(){
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("Lambda");
            }
        });

        mTextView.setOnClickListener((View v)-> {

        });
    }
}
