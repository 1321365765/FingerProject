package com.david.fingerlibrary.entity;

import com.david.fingerlibrary.R;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HeandEntity {
    /**
     * 选择的手指
     * 小指 Little finger
     * 无名指 Ring finger
     * 中指 middle finger
     * 食指 fore finger
     * 大拇指 thumb
     */
    //enrol
    public int littleCount;
    public int ringCount;
    public int middleCount;
    public int foreCount;
    public int thumbCount;

    //verify
    public int littleCount2;
    public int ringCount2;
    public int middleCount2;
    public int foreCount2;
    public int thumbCount2;

    private String name = "左手";

    private int enrolCount;
    private int verifyCount;

    //store+user
    public void initData(final String filePath, int enrolCount, int verifyCount) {
        this.enrolCount = enrolCount;
        this.verifyCount = verifyCount;
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
                                        case "ringCount":
                                            ringCount = (int) files[i].length();
                                            break;
                                        case "middleCount":
                                            middleCount = (int) files[i].length();
                                            break;
                                        case "foreCount":
                                            foreCount = (int) files[i].length();
                                            break;
                                        case "thumbCount":
                                            thumbCount = (int) files[i].length();
                                            break;
                                        default:
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

    public int getDrawable(int enrol, int verify) {
        if (enrol == 0 && verify == 0) {
            return R.drawable.finger_ripple;
        }

        if (enrol < enrolCount) {

        }
        if (verify < verifyCount) {

        }
        if (enrol == enrolCount && verify == verifyCount) {
            return 0;
        }
        return R.drawable.finger_ripple;
    }


}
