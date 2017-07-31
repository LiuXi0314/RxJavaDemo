package com.lx.rx.java.demo.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.lx.rx.java.demo.R;
import com.lx.rx.java.demo.Utils.LogUtils;
import com.lx.rx.java.demo.bean.Student;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * 用RXJava2操作Android 数组
 */
public class Rx2ArrayActivity extends BaseActivity {

    Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
    List<String> mStringList = new ArrayList<>();
    List<Student> mStudentList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initList();
        initStudent();
        setContentView(R.layout.activity_rx2_android_array);
        findViewById(R.id.fromArray).setOnClickListener(v -> testFromArray());
        findViewById(R.id.map).setOnClickListener(v -> testMap());
        findViewById(R.id.filter).setOnClickListener(v -> testFilter());
        findViewById(R.id.fromIterable).setOnClickListener(v -> testFromIterable());
        findViewById(R.id.range).setOnClickListener(v -> testRange());
        findViewById(R.id.map_if).setOnClickListener(v -> changeSex());
    }

    private void initList() {
        mStringList.add("1");
        mStringList.add("2");
        mStringList.add("3");
        mStringList.add("4");
        mStringList.add("5");
        mStringList.add("6");
    }

    private void initStudent() {
        mStudentList.add(new Student("王大", "女"));
        mStudentList.add(new Student("李二", "男"));
        mStudentList.add(new Student("张三", "女"));
        mStudentList.add(new Student("冯四", "男"));
        mStudentList.add(new Student("赵五", "女"));
    }

    private void testFromArray() {
        Observable.fromArray(array).forEach(a -> LogUtils.d(String.valueOf("from array:" + a)));
    }

    // filter 可以用于替换if操作,执行过滤
    private void testFilter() {
        Observable.fromArray(array)
                .filter(a -> a > 3)
                .forEach(a -> LogUtils.d(String.valueOf("test filter:" + a)));
    }

    //map:将现有数据进行转换处理
    private void testMap() {
        Observable.fromArray(array).map(a -> a * a).forEach(a -> LogUtils.d(String.valueOf("test map:" + a)));
    }

    private void testFromIterable() {

        Observable.fromIterable(mStringList).subscribe(s -> LogUtils.d(s + s));

    }

    //可以用于替换for循环语句
    private void testRange() {
        Observable.range(0, 3).forEach(a -> LogUtils.d(String.valueOf("range : " + a)));
        //for 循环嵌套
        Observable.range(0, 5)
                .doAfterNext(i -> LogUtils.d(i + "---------------------"))
                .flatMap(j -> Observable.range(0, 5))
                .doOnNext(j -> LogUtils.d(j + ""))
                .subscribe();
    }

    //map中使用if判断
    private void changeSex() {
        Observable.fromIterable(mStudentList)
                .subscribe(student -> LogUtils.d(student.getName() + ":" + student.getSex()));
        LogUtils.d("-----------------------------------------");
        Observable.fromIterable(mStudentList)
                .map(student -> {
                    if (student.getSex().equals("女")) {
                        student.setSex("男");
                    } else {
                        student.setSex("女");
                    }
                    return student;
                }).subscribe(student -> LogUtils.d(student.getName() + ":" + student.getSex()));

    }


}
