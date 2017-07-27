package com.lx.rx.java.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lx.rx.java.demo.R;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.PushModeDemo).setOnClickListener(this);
        findViewById(R.id.ObservableDemo).setOnClickListener(this);
        findViewById(R.id.rxJava2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.PushModeDemo) {
            startActivity(new Intent(this, PushDemoActivity.class));
        } else if (id == R.id.ObservableDemo) {
            startActivity(new Intent(this, ObserverDemoActivity.class));
        } else if (id == R.id.rxJava2) {
            startActivity(new Intent(this, RxJavaActivity.class));
        }
    }


}
