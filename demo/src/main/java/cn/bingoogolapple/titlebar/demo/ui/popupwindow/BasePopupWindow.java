package cn.bingoogolapple.titlebar.demo.ui.popupwindow;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.KeyEvent;
import android.view.View;
import android.widget.PopupWindow;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/3 上午1:32
 * 描述:
 */
public abstract class BasePopupWindow extends PopupWindow implements View.OnClickListener {
    protected Activity mActivity;
    protected View mWindowRootView;
    protected View mAnchorView;

    public BasePopupWindow(Activity activity, @LayoutRes int layoutId, View anchorView, int width, int height) {
        super(View.inflate(activity, layoutId, null), width, height, true);
        init(activity, anchorView);

        findView();
        setListener();
        processLogic();
    }

    private void init(Activity activity, View anchorView) {
        getContentView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    dismiss();
                    return true;
                }
                return false;
            }
        });
        // 如果想让在点击别的地方的时候 关闭掉弹出窗体 一定要记得给mPopupWindow设置一个背景资源
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        mAnchorView = anchorView;
        mActivity = activity;
        mWindowRootView = activity.getWindow().peekDecorView();
    }

    protected void findView() {
    }

    protected void setListener() {
    }

    protected void processLogic() {
    }

    @Override
    public void onClick(View v) {
    }

    public abstract void show();

    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    protected <VT extends View> VT getViewById(@IdRes int id) {
        return (VT) getContentView().findViewById(id);
    }
}