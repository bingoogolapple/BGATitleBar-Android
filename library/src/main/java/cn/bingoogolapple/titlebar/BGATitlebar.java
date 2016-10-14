package cn.bingoogolapple.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/4 下午4:51
 * 描述:
 */
public class BGATitlebar extends RelativeLayout implements View.OnClickListener {
    private AppCompatCheckedTextView mTitleCtv;
    private AppCompatCheckedTextView mLeftCtv;
    private AppCompatCheckedTextView mRightCtv;
    private BGATitlebarDelegate mDelegate;

    public BGATitlebar(Context context) {
        this(context, null);
    }

    public BGATitlebar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BGATitlebar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_bgatitlebar, this);
        initView();
        setListener();
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BGATitlebar);
        final int N = typedArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            initAttr(typedArray.getIndex(i), typedArray);
        }
        typedArray.recycle();
    }

    protected void initView() {
        mLeftCtv = getViewById(R.id.ctv_bgatitlebar_left);
        mRightCtv = getViewById(R.id.ctv_bgatitlebar_right);
        mTitleCtv = getViewById(R.id.ctv_bgatitlebar_title);
    }

    protected void setListener() {
        mLeftCtv.setOnClickListener(this);
        mTitleCtv.setOnClickListener(this);
        mRightCtv.setOnClickListener(this);
    }

    protected void initAttr(int attr, TypedArray typedArray) {
        if (attr == R.styleable.BGATitlebar_bgatitlebar_leftText) {
            setLeftText(typedArray.getText(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_titleText) {
            setTitleText(typedArray.getText(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_rightText) {
            setRightText(typedArray.getText(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_leftDrawable) {
            setLeftDrawable(typedArray.getDrawable(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_titleDrawable) {
            setTitleDrawable(typedArray.getDrawable(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_rightDrawable) {
            setRightDrawable(typedArray.getDrawable(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_leftAndRightTextSize) {
            int textSize = typedArray.getDimensionPixelSize(attr, sp2px(getContext(), 12));
            mLeftCtv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            mRightCtv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_titleTextSize) {
            mTitleCtv.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray.getDimensionPixelSize(attr, sp2px(getContext(), 16)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_leftAndRightTextColor) {
            mLeftCtv.setTextColor(typedArray.getColorStateList(attr));
            mRightCtv.setTextColor(typedArray.getColorStateList(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_titleTextColor) {
            mTitleCtv.setTextColor(typedArray.getColorStateList(attr));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_titleDrawablePadding) {
            mTitleCtv.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 3)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_leftDrawablePadding) {
            mLeftCtv.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 3)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_rightDrawablePadding) {
            mRightCtv.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 3)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_leftAndRightPadding) {
            int leftAndRightPadding = typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 10));
            mLeftCtv.setPadding(leftAndRightPadding, 0, leftAndRightPadding, 0);
            mRightCtv.setPadding(leftAndRightPadding, 0, leftAndRightPadding, 0);
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_leftMaxWidth) {
            setLeftCtvMaxWidth(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 85)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_rightMaxWidth) {
            setRightCtvMaxWidth(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 85)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_titleMaxWidth) {
            setTitleCtvMaxWidth(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 144)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_isTitleTextBold) {
            mTitleCtv.getPaint().setTypeface(getTypeface(typedArray.getBoolean(attr, true)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_isLeftTextBold) {
            mLeftCtv.getPaint().setTypeface(getTypeface(typedArray.getBoolean(attr, false)));
        } else if (attr == R.styleable.BGATitlebar_bgatitlebar_isRightTextBold) {
            mRightCtv.getPaint().setTypeface(getTypeface(typedArray.getBoolean(attr, false)));
        }
    }

    private Typeface getTypeface(boolean isBold) {
        return isBold ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT;
    }

    public void setLeftCtvMaxWidth(int maxWidth) {
        mLeftCtv.setMaxWidth(maxWidth);
    }

    public void setRightCtvMaxWidth(int maxWidth) {
        mRightCtv.setMaxWidth(maxWidth);
    }

    public void setTitleCtvMaxWidth(int maxWidth) {
        mTitleCtv.setMaxWidth(maxWidth);
    }

    public void hiddenLeftCtv() {
        mLeftCtv.setVisibility(GONE);
    }

    public void showLeftCtv() {
        mLeftCtv.setVisibility(VISIBLE);
    }

    public void setLeftText(@StringRes int resid) {
        setLeftText(getResources().getString(resid));
    }

    public void setLeftText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            mLeftCtv.setText("");
            if (mLeftCtv.getCompoundDrawables()[0] == null) {
                hiddenLeftCtv();
            }
        } else {
            mLeftCtv.setText(text);
            showLeftCtv();
        }
    }

    public void setLeftDrawable(Drawable drawable) {
        if (drawable == null) {
            mLeftCtv.setCompoundDrawables(null, null, null, null);
            if (TextUtils.isEmpty(mLeftCtv.getText())) {
                hiddenLeftCtv();
            }
        } else {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            mLeftCtv.setCompoundDrawables(drawable, null, null, null);
            showLeftCtv();
        }
    }

    public void hiddenTitleCtv() {
        mTitleCtv.setVisibility(GONE);
    }

    public void showTitleCtv() {
        mTitleCtv.setVisibility(VISIBLE);
    }

    public void setTitleText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            mTitleCtv.setText("");
            if (mTitleCtv.getCompoundDrawables()[2] == null) {
                hiddenTitleCtv();
            }
        } else {
            mTitleCtv.setText(text);
            showTitleCtv();
        }
    }

    public void setTitleText(@StringRes int resid) {
        setTitleText(getResources().getString(resid));
    }

    public void setTitleDrawable(Drawable drawable) {
        if (drawable == null) {
            mTitleCtv.setCompoundDrawables(null, null, null, null);
            if (TextUtils.isEmpty(mTitleCtv.getText())) {
                hiddenTitleCtv();
            }
        } else {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            mTitleCtv.setCompoundDrawables(null, null, drawable, null);
            showTitleCtv();
        }
    }

    public void hiddenRightCtv() {
        mRightCtv.setVisibility(GONE);
    }

    public void showRightCtv() {
        mRightCtv.setVisibility(VISIBLE);
    }

    public void setRightText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            mRightCtv.setText("");
            if (mRightCtv.getCompoundDrawables()[2] == null) {
                hiddenRightCtv();
            }
        } else {
            mRightCtv.setText(text);
            showRightCtv();
        }
    }

    public void setRightText(@StringRes int resid) {
        setRightText(getResources().getString(resid));
    }

    public void setRightDrawable(Drawable drawable) {
        if (drawable == null) {
            mRightCtv.setCompoundDrawables(null, null, null, null);
            if (TextUtils.isEmpty(mRightCtv.getText())) {
                hiddenRightCtv();
            }
        } else {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            mRightCtv.setCompoundDrawables(null, null, drawable, null);
            showRightCtv();
        }
    }

    public void setLeftCtvChecked(boolean checked) {
        mLeftCtv.setChecked(checked);
    }

    public void setTitleCtvChecked(boolean checked) {
        mTitleCtv.setChecked(checked);
    }

    public void setRightCtvChecked(boolean checked) {
        mRightCtv.setChecked(checked);
    }

    public AppCompatCheckedTextView getLeftCtv() {
        return mLeftCtv;
    }

    public AppCompatCheckedTextView getRightCtv() {
        return mRightCtv;
    }

    public AppCompatCheckedTextView getTitleCtv() {
        return mTitleCtv;
    }

    @Override
    public void onClick(View v) {
        if (mDelegate != null) {
            int id = v.getId();
            if (id == R.id.ctv_bgatitlebar_left) {
                mDelegate.onClickLeftCtv();
            } else if (id == R.id.ctv_bgatitlebar_title) {
                mDelegate.onClickTitleCtv();
            } else if (id == R.id.ctv_bgatitlebar_right) {
                mDelegate.onClickRightCtv();
            }
        }
    }

    public void setDelegate(BGATitlebarDelegate delegate) {
        mDelegate = delegate;
    }

    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    protected <VT extends View> VT getViewById(@IdRes int id) {
        return (VT) findViewById(id);
    }

    public static int dp2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, context.getResources().getDisplayMetrics());
    }

    /**
     * 根据实际业务重写相应地方法
     */
    public static class BGATitlebarDelegate {
        public void onClickLeftCtv() {
        }

        public void onClickTitleCtv() {
        }

        public void onClickRightCtv() {
        }
    }
}