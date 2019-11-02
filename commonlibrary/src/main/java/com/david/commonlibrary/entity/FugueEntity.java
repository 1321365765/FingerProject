package com.david.commonlibrary.entity;
//配置采集数量
public class FugueEntity {
    //采集张数 每个人需要采集的数量
    private int enrol;
    //比较张数 每个人需要采集的数量
    private int verify;

    public int getEnrol() {
        return enrol;
    }

    public void setEnrol(int enrol) {
        this.enrol = enrol;
    }

    public int getVerify() {
        return verify;
    }

    public void setVerify(int verify) {
        this.verify = verify;
    }
}
