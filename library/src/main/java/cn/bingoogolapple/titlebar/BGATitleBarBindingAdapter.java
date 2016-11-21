package cn.bingoogolapple.titlebar;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:16/11/21 上午12:13
 * 描述:
 */
public class BGATitleBarBindingAdapter {

    @BindingAdapter("bgatitlebar_delegate")
    public static void setDelegate(BGATitleBar titleBar, final BGATitleBar.Delegate delegate) {
        titleBar.setDelegate(delegate);
    }

    @BindingAdapter("bgatitlebar_leftText")
    public static void setLeftText(BGATitleBar titleBar, String text) {
        titleBar.setLeftText(text);
    }

    @BindingAdapter("bgatitlebar_titleText")
    public static void setTitleText(BGATitleBar titleBar, String text) {
        titleBar.setTitleText(text);
    }

    @BindingAdapter("bgatitlebar_rightText")
    public static void setRightText(BGATitleBar titleBar, String text) {
        titleBar.setRightText(text);
    }

    @BindingAdapter("bgatitlebar_rightText")
    public static void setRightSecondaryText(BGATitleBar titleBar, String text) {
        titleBar.setRightSecondaryText(text);
    }

    @BindingAdapter("bgatitlebar_leftDrawable")
    public static void setLeftDrawable(BGATitleBar titleBar, Drawable drawable) {
        titleBar.setLeftDrawable(drawable);
    }

    @BindingAdapter("bgatitlebar_titleDrawable")
    public static void setTitleDrawable(BGATitleBar titleBar, Drawable drawable) {
        titleBar.setTitleDrawable(drawable);
    }

    @BindingAdapter("bgatitlebar_rightDrawable")
    public static void setRightDrawable(BGATitleBar titleBar, Drawable drawable) {
        titleBar.setRightDrawable(drawable);
    }

    @BindingAdapter("bgatitlebar_rightSecondaryDrawable")
    public static void setRightSecondaryDrawable(BGATitleBar titleBar, Drawable drawable) {
        titleBar.setRightSecondaryDrawable(drawable);
    }
}