package cn.bingoogolapple.titlebar.demo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.PopupWindow;

import java.util.List;

import cn.bingoogolapple.titlebar.BGATitlebar;
import cn.bingoogolapple.titlebar.demo.R;
import cn.bingoogolapple.titlebar.demo.ui.model.HomeCategory;
import cn.bingoogolapple.titlebar.demo.ui.popupwindow.HomeCategoryPopupWindow;
import cn.bingoogolapple.titlebar.demo.util.ToastUtils;

public class MainActivity extends AppCompatActivity {
    private HomeCategoryPopupWindow mCategoryPw;
    private BGATitlebar mTitlebar;
    private List<HomeCategory> mHomeCategorys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

}