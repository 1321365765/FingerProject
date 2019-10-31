package com.david.commonlibrary.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.david.commonlibrary.entity.FingerEntity;

import java.util.List;

@Dao
public interface FingerDao {
    @Insert
    void insertFinger(FingerEntity fingerEntity);

    @Query("select * from fingerentity")
    List<FingerEntity> loadAll();
}
