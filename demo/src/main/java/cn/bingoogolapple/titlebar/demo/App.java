package cn.bingoogolapple.titlebar.demo;

import android.app.Application;


/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/3 上午12:31
 * 描述:
 */
public class App extends Application {
    private static final String TAG = App.class.getSimpleName();
    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static App getInstance() {
        return sInstance;
    }

}