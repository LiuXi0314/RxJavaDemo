package com.lx.rx.java.demo.activity;

import android.os.Bundle;

import com.lx.rx.java.demo.R;
import com.lx.rx.java.demo.Utils.LogUtils;
import com.lx.rx.java.demo.bean.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

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
        findViewById(R.id.startWith).setOnClickListener(v -> startWith());
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

    void startWith() {
        Observable.just("test", 1, false, Math.random())
                .startWith(Observable.just(1, 2, 3, 4))
                .subscribe(log -> LogUtils.d(String.valueOf(log)));
    }

    void from() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
//        Observable.fromIterable(integerList).subscribe(s -> LogUtils.d(String.valueOf(s)));
//        Observable.fromArray(integerList).forEach(s -> LogUtils.d(String.valueOf(s)));

        Observable ob = Observable.fromCallable(new Callable<Student>() {
            @Override
            public Student call() throws Exception {
                return new Student("error", "boy");
            }
        });

//        Observable.fromFuture();
//        Observable.fromPublisher()
//          后续再仔细研究
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

    //可代替for循环
    void range() {
        Observable.range(0, 3).subscribe(e -> LogUtils.d(String.valueOf(e)));

        Observable.range(0, 3).doOnNext(i -> LogUtils.d(String.valueOf(i)))
                .flatMap(j -> Observable.range(0, 5))
                .doOnNext(j -> LogUtils.d(String.valueOf(j)))
                .subscribe();

    }

    void interval() {
//        Observable.interval(1, TimeUnit.SECONDS).subscribe(s -> LogUtils.logCurrentTime());
        Observable.interval(5, 1, TimeUnit.SECONDS).subscribe(s -> LogUtils.logCurrentTime());
    }

    //延时操作
    void timer() {
        Observable.timer(1, TimeUnit.SECONDS).subscribe(function -> LogUtils.logCurrentTime());


    }

    void empty() {
        Observable.empty().subscribe(f -> LogUtils.logCurrentTime());
    }

    void defer() {

//        List<Integer> list = new ArrayList<>();
//        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
//        Observable observable = Observable.defer(() -> Observable.fromArray(list));
//        observable.forEach(v -> LogUtils.d(String.valueOf(v)));
//        list.add(6);
//        observable.forEach(v -> LogUtils.d(String.valueOf(v)));

//        Observable observable1 = Observable.fromArray(list);
//        observable1.forEach(v -> LogUtils.d(String.valueOf(v)));
//        list.add(6);
//        observable1.forEach(v -> LogUtils.d(String.valueOf(v)));

        Student student = new Student("王若琳", " 女");
        Observable ob = Observable.just(student);
        ob.subscribe(s -> LogUtils.d(student.toString()));
        student.setSex("男");
        ob.subscribe(s -> LogUtils.d(student.toString()));
        //以上测试暂未发现defer()在RXJava2 中有什么作用


    }

}
