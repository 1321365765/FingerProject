package com.david.fingerlibrary.entity;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PalmEntity {
    /**
     * 选择的手指
     * 小指 Little finger
     * 无名指 Ring finger
     * 中指 middle finger
     * 食指 fore finger
     * 大拇指 thumb
     */

    public int littleCount;


    private String name = "左手";

    //store+user
    public void initData(final String filePath) {
        Observable.timer(1, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        File rootFile = new File(filePath);
                        if (rootFile.exists()) {
                            File[] files = rootFile.listFiles();
                            if (files != null) {
                                for (int i = 0; i < files.length; i++) {
                                    switch (files[i].getName()) {
                                        case "little":
                                            littleCount = (int) files[i].length();
                                            break;
                                    }

                                }
                            }


                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
