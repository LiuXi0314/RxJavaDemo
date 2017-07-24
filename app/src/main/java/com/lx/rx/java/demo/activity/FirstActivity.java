package com.lx.rx.java.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lx.rx.java.demo.R;
import com.lx.rx.java.demo.Utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        findViewById(R.id.secondActivity).setOnClickListener(this);
        findViewById(R.id.MainActivity).setOnClickListener(this);


    }

    private void testObserver() {
        final Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                LogUtils.d("e.onNext(1);");
                e.onNext(2);
                LogUtils.d("e.onNext(2);");
                e.onNext(3);
                LogUtils.d("e.onNext(3);");
                e.onComplete();
                LogUtils.d("e.onComplete();");
                e.onNext(4);
                LogUtils.d("e.onNext(4);");
                e.onNext(5);
                LogUtils.d("e.onNext(5);");
                e.onNext(6);
                LogUtils.d("e.onNext(6);");
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            private Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                LogUtils.d("onSubscribe");
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                LogUtils.d("onNext" + integer);
                if (integer == 3) {
                    mDisposable.dispose();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LogUtils.d("onComplete");
            }

            @Override
            public void onComplete() {
                LogUtils.d("onComplete");
            }
        };

        //建立连接
        observable.subscribe(observer);


        Observable observable1 = Observable.just(1, 2, 3, 4, 5).filter(new Predicate<Integer>() {
            @Override
            public boolean test(@NonNull Integer integer) throws Exception {

                return integer % 2 == 0;
            }
        });

        observable1.subscribe(observer);


    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.secondActivity) {
            Intent intent = new Intent();
            intent.setAction("com.lx.rx.java.second");
            startActivity(intent);
        } else if (id == R.id.MainActivity) {
            Intent intent = new Intent();
            intent.setAction("com.lx.rx.java.second");
            intent.addCategory("android.intent.category.INFO");
            startActivity(intent);
        }
    }
}
