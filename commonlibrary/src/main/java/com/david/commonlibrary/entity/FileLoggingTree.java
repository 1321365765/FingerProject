package com.david.commonlibrary.entity;

import android.util.Log;

import com.david.commonlibrary.BuildConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import timber.log.Timber;

public class FileLoggingTree extends Timber.DebugTree {
    private Logger mLogger;

    public FileLoggingTree() {
        if (BuildConfig.DEBUG) {
            mLogger = LoggerFactory.getLogger(FileLoggingTree.class);
        } else {
            mLogger = LoggerFactory.getLogger("logtest");
        }
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (priority == Log.VERBOSE) {
            return;
        }
        String logMessage = tag + ": " + message;
        switch (priority) {
            case Log.DEBUG:
                mLogger.debug(logMessage);
                break;
            case Log.INFO:
                mLogger.info(logMessage);
                break;
            case Log.WARN:
                mLogger.warn(logMessage);
                break;
            case Log.ERROR:
                mLogger.error(logMessage);
                break;
        }
    }

}