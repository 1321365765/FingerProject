package com.david.commonlibrary.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FingerEntity {
    @NonNull
    @PrimaryKey
    private String id;
    private String name;
    private byte[] finger;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFinger() {
        return finger;
    }

    public void setFinger(byte[] finger) {
        this.finger = finger;
    }
}
