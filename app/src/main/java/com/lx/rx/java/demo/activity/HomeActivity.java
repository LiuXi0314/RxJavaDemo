package com.lx.rx.java.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lx.rx.java.demo.R;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.PushModeDemo)
                .setOnClickListener(v -> startActivity(new Intent(this, PushDemoActivity.class)));

        findViewById(R.id.ObservableDemo)
                .setOnClickListener(v -> startActivity(new Intent(this, ObserverDemoActivity.class)));

        findViewById(R.id.rxJava2)
                .setOnClickListener(v -> startActivity(new Intent(this, RxJavaActivity.class)));

        findViewById(R.id.ArrayAboutRxJava2)
                .setOnClickListener(v -> startActivity(new Intent(this, Rx2ArrayActivity.class)));

        findViewById(R.id.observableSummary)
                .setOnClickListener(v -> startActivity(new Intent(this, ObservableSummaryActivity.class)));

    }

}
