package com.david.fingerlibrary;

public class FingerManager {

    interface FingerCallback {
        void onError(String msg);

        void onImg(byte[] bytes);

        void onSuccess();
    }

}
