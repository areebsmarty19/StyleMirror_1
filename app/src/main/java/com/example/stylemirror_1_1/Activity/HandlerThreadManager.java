package com.example.stylemirror_1_1.Activity;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class HandlerThreadManager {
    private HandlerThread handlerThread;
    private Handler handler;

    public HandlerThreadManager(String name) {
        handlerThread = new HandlerThread(name);
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
    }

    public void post(Runnable runnable) {
        handler.post(runnable);
    }

    public void quit() {
        handlerThread.quit();
    }

    public Looper getLooper() {
        return handlerThread.getLooper();
    }
}