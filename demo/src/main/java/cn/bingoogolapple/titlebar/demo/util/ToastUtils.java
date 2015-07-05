package cn.bingoogolapple.titlebar.demo.util;

import android.support.annotation.StringRes;
import android.widget.Toast;

import cn.bingoogolapple.titlebar.demo.App;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 10:17
 * 描述:
 */
public class ToastUtils {

    private ToastUtils() {
    }

    public static void show(CharSequence text) {
        if (text.length() < 10) {
            Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(App.getInstance(), text, Toast.LENGTH_LONG).show();
        }
    }

    public static void show(@StringRes int resId) {
        show(App.getInstance().getString(resId));
    }

}