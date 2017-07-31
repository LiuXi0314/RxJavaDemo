package com.lx.rx.java.demo.activity;

import android.os.Bundle;

import com.lx.rx.java.demo.R;
import com.lx.rx.java.demo.Utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;


public class ObservableSummaryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable_summary);
        findViewById(R.id.just).setOnClickListener(v -> just());
        findViewById(R.id.from).setOnClickListener(v -> from());
        findViewById(R.id.create).setOnClickListener(v -> create());
        findViewById(R.id.range).setOnClickListener(v -> range());
        findViewById(R.id.interval).setOnClickListener(v -> interval());
        findViewById(R.id.timer).setOnClickListener(v -> timer());
        findViewById(R.id.empty).setOnClickListener(v -> empty());
        findViewById(R.id.defer).setOnClickListener(v -> defer());
    }

    /**
     * 最多支持十个参数,支持多种不同类型的数据
     */
    void just() {
        Observable.just("test", 1, false, Math.random())
                .subscribe(log -> LogUtils.d(String.valueOf(log)));
    }

    void from() {
//        Observable.fromIterable();
//        Observable.fromArray();
//        Observable.fromCallable();
//        Observable.fromFuture();
//        Observable.fromPublisher()
//          后续在仔细研究
    }

    void create() {
        Observable<Integer> intObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onComplete();
                e.onNext(3);
                e.onNext(4);
            }
        });
        intObservable.subscribe(e -> LogUtils.d(e.toString()));
    }

    void range() {
        Observable.range(0, 3).subscribe(e -> LogUtils.d(String.valueOf(e)));

        Observable.range(0, 3).doOnNext(i -> LogUtils.d(String.valueOf(i)))
                .flatMap(j -> Observable.range(0, 5))
                .doOnNext(j -> LogUtils.d(String.valueOf(j)))
                .subscribe();

    }

    void interval() {

    }

    void timer() {

    }

    void empty() {

    }

    void defer() {

    }
}
