package com.lx.rx.java.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lx.rx.java.demo.activity.Utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        testObserver();

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


    }
}
