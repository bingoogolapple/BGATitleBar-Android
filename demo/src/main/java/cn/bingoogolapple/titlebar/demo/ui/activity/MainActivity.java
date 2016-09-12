package cn.bingoogolapple.titlebar.demo.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.PopupWindow;

import java.util.List;

import cn.bingoogolapple.titlebar.BGATitlebar;
import cn.bingoogolapple.titlebar.demo.R;
import cn.bingoogolapple.titlebar.demo.ui.model.HomeCategory;
import cn.bingoogolapple.titlebar.demo.ui.popupwindow.HomeCategoryPopupWindow;
import cn.bingoogolapple.titlebar.demo.util.ToastUtils;

public class MainActivity extends AppCompatActivity {
    private BGATitlebar mTitlebar;
    private HomeCategoryPopupWindow mCategoryPw;
    private List<HomeCategory> mHomeCategorys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testClick();

        testHidden();

        testTitleText1();

        testTitleText2();
    }

    /**
     * 测试各个标题文本的点击事件
     */
    private void testClick() {
        mTitlebar = (BGATitlebar) findViewById(R.id.titlebar);
        mTitlebar.setDelegate(new BGATitlebar.BGATitlebarDelegate() {
            @Override
            public void onClickLeftCtv() {
                ToastUtils.show("点击了加关注");
            }

            @Override
            public void onClickTitleCtv() {
                showCategoryPw();
            }

            @Override
            public void onClickRightCtv() {
                ToastUtils.show("点击了雷达");
            }
        });
    }

    private void showCategoryPw() {
        if (mCategoryPw == null) {
            mCategoryPw = new HomeCategoryPopupWindow(this, mTitlebar.getTitleCtv());
            mCategoryPw.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    mTitlebar.setTitleCtvChecked(false);
                }
            });
            mCategoryPw.setDelegate(new HomeCategoryPopupWindow.HomeCategoryPopupWindowDelegate() {
                @Override
                public void onSelectCategory(HomeCategory category) {
                    ToastUtils.show("选择了分类：" + category.title);
                }
            });
        }

        if (mHomeCategorys == null) {
            mHomeCategorys = HomeCategory.getTestDatas();
        }
        mCategoryPw.setCategorys(mHomeCategorys);
        mCategoryPw.show();
        mTitlebar.setTitleCtvChecked(true);
    }

    /**
     * 测试隐藏各个标题文本
     */
    private void testHidden() {
        final BGATitlebar titlebar2 = (BGATitlebar) findViewById(R.id.titlebar2);
        titlebar2.setDelegate(new BGATitlebar.BGATitlebarDelegate() {
            @Override
            public void onClickLeftCtv() {
                ToastUtils.show("点击了返回");
                titlebar2.hiddenLeftCtv();
            }

            @Override
            public void onClickTitleCtv() {
                ToastUtils.show("点击了标题");
                titlebar2.hiddenTitleCtv();
            }

            @Override
            public void onClickRightCtv() {
                ToastUtils.show("点击了右边按钮");
                titlebar2.hiddenRightCtv();
            }
        });
    }

    /**
     * 测试标题文本
     */
    private void testTitleText1() {
        BGATitlebar titlebar3 = (BGATitlebar) findViewById(R.id.titlebar3);
        // 先清除掉默认的粗体，否则下面设置Typeface.NORMAL不会生效
        titlebar3.getTitleCtv().getPaint().setTypeface(Typeface.DEFAULT);
        // 取消默认的单行
        titlebar3.getTitleCtv().setSingleLine(false);
        // 设置行间距
        titlebar3.getTitleCtv().setLineSpacing(3, 1);

        String sendWeiBo = "发微博";
        String username = "bingoogolapple";
        SpannableString titleSs = new SpannableString(sendWeiBo + "\n" + username);
        titleSs.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)), 0, sendWeiBo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSs.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelOffset(R.dimen.textSize_18), false), 0, sendWeiBo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSs.setSpan(new StyleSpan(Typeface.BOLD), 0, sendWeiBo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        titleSs.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.gray)), sendWeiBo.length(), titleSs.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSs.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelOffset(R.dimen.textSize_14), false), sendWeiBo.length(), titleSs.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSs.setSpan(new StyleSpan(Typeface.NORMAL), sendWeiBo.length(), titleSs.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titlebar3.setTitleText(titleSs);
    }

    /**
     * 测试标题文本
     */
    private void testTitleText2() {
        BGATitlebar titlebar4 = (BGATitlebar) findViewById(R.id.titlebar4);
        // 先清除掉默认的粗体，否则下面设置Typeface.NORMAL不会生效
        titlebar4.getTitleCtv().getPaint().setTypeface(Typeface.DEFAULT);

        String title = "资料设置";
        String progress = " (完成进度10%)";
        SpannableString titleSs = new SpannableString(title + progress);
        titleSs.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSs.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelOffset(R.dimen.textSize_18), false), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSs.setSpan(new StyleSpan(Typeface.BOLD), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        titleSs.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.gray)), title.length(), titleSs.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSs.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelOffset(R.dimen.textSize_14), false), title.length(), titleSs.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleSs.setSpan(new StyleSpan(Typeface.NORMAL), title.length(), titleSs.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titlebar4.setTitleText(titleSs);
    }

}