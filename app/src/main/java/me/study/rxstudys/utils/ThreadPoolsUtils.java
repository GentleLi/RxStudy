package me.study.rxstudys.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2018/9/5.
 */

public class ThreadPoolsUtils {

    private ExecutorService executorService;
    private static ThreadPoolsUtils mInstance;

    private ThreadPoolsUtils() {
        executorService = Executors.newFixedThreadPool(3);
    }


    public static ThreadPoolsUtils getInstance() {

        if (null == mInstance) {
            synchronized (ThreadPoolsUtils.class) {
                if (null == mInstance) {
                    mInstance = new ThreadPoolsUtils();
                }
            }
        }
        return mInstance;
    }


    public synchronized void execute(Runnable runnable) {
        if (null != executorService) {
            executorService.execute(runnable);
        }
    }


}
