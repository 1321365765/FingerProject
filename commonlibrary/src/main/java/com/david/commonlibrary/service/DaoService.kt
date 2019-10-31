package com.david.commonlibrary.service

import com.alibaba.android.arouter.facade.template.IProvider
import com.david.commonlibrary.dao.AppDatabase

interface DaoService : IProvider{
    fun getAppDatabase(): AppDatabase
}