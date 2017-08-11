package com.lx.rx.java.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lx.rx.java.demo.R;
import com.lx.rx.java.demo.Utils.LogUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function4;

/**
 * Created on 17-8-11 下午3:25
 */

public class OperatorActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);
        findViewById(R.id.concat).setOnClickListener(v -> concat());
        findViewById(R.id.startWith).setOnClickListener(v -> startWith());
        findViewById(R.id.merge).setOnClickListener(v -> merge());
        findViewById(R.id.zip).setOnClickListener(v -> zip());
        findViewById(R.id.combineLatest).setOnClickListener(v -> combineLatest());
    }

    /**
     * 合并操作
     */

    void concat() {
        Observable observable1 = Observable.just(1, 2, 3, 4, 5, 6);
        Observable observable2 = Observable.just(6, 5, 4, 3, 2, 1);

        Observable.concat(observable1, observable2).subscribe(i -> LogUtils.d(String.valueOf(i)));

    }

    void startWith() {
        Observable.just(1, 2, 3, 4).startWith(0).subscribe(s -> LogUtils.d(String.valueOf(s)));

    }

    void merge() {
        Observable observable1 = Observable.just(1, 2, 3, 4, 5, 6);
        Observable observable2 = Observable.just(6, 5, 4, 3, 2, 1);

        Observable.merge(observable1, observable2).subscribe(i -> LogUtils.d(String.valueOf(i)));
    }

    void zip() {
        Observable observable1 = Observable.just(1, true, 3, false, 5, "就不噶朴素");
        Observable observable2 = Observable.just(6, 5, 4, 3, 2, 1);

        Observable.zip(observable1, observable2, new BiFunction() {
            @Override
            public Object apply(@NonNull Object o, @NonNull Object o2) throws Exception {
                return o + "-----" + o2;
            }
        }).subscribe(s -> LogUtils.d(String.valueOf(s)));
    }

    void combineLatest() {
        Observable observable1 = Observable.just(1, 2, 3, 4, 5, 6);
        Observable observable2 = Observable.just(6, 5, 4, 3, 2, 1);

        Observable.combineLatest(observable1, observable2, observable1, observable1, new Function4() {
            @Override
            public Object apply(@NonNull Object o, @NonNull Object o2, @NonNull Object o3, @NonNull Object o4) throws Exception {
                return "" + o + o2 + o3 + o4;
            }
        }).subscribe(s -> LogUtils.d(String.valueOf(s)));
    }

    /**
     * 过滤操作
     */


    void filter() {
        Observable.just(1, 2, 3, 4, 5, 6, 7).filter(i -> i > 6).subscribe(s -> LogUtils.d(String.valueOf(s)));
    }

    void ofType() {
        Observable.just(1, 2, "3", false).ofType(Integer.class).subscribe(s -> LogUtils.d("" + s));
    }

    //通过发送数据的数量和时间来过滤数据
    void take() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9).take(8).take(10, TimeUnit.MILLISECONDS).subscribe(s -> LogUtils.d(String.valueOf("take" + s)));
    }

    void takeLast() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9).takeLast(8).takeLast(10, TimeUnit.MILLISECONDS).subscribe(s -> LogUtils.d(String.valueOf("take" + s)));
    }

    void first() {
        Observable.just(1, 2, 3).first(1).filter(i -> i > 1).subscribe(s -> LogUtils.d(String.valueOf(s)));
    }

    void last() {
        Observable.just(1, 2, 3).last(1).filter(i -> i > 1).subscribe(s -> LogUtils.d(String.valueOf(s)));
    }

    void skip() {
        Observable.just(1, 2, 3).skip(1).subscribe(s -> LogUtils.d(String.valueOf(s)));
    }


}
