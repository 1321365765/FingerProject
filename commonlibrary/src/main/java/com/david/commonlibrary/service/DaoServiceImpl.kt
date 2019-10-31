package com.david.commonlibrary.service

import android.content.Context
import com.david.commonlibrary.dao.AppDatabase
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.migration.Migration
import com.alibaba.android.arouter.facade.annotation.Route
import com.david.commonlibrary.Router

@Route(path = Router.Common.DAO_SERVICE,name = "数据库服务")
class DaoServiceImpl : DaoService {
    private lateinit var appDatabase: AppDatabase

    override fun getAppDatabase(): AppDatabase {
        return appDatabase
    }

    override fun init(context: Context) {
        appDatabase = AppDatabase.getDatabase(context)

    }

}