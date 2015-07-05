package cn.bingoogolapple.titlebar.demo.ui.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/5 上午11:37
 * 描述:
 */
public class HomeCategory {
    public String header;
    public String title;
    public boolean selected;
    public boolean hasNewStatus;

    public HomeCategory(String header, String title, boolean selected, boolean hasNewStatus) {
        this.header = header;
        this.title = title;
        this.selected = selected;
        this.hasNewStatus = hasNewStatus;
    }

    public static List<HomeCategory> getTestDatas() {
        List<HomeCategory> categorys = new ArrayList<>();
        categorys.add(new HomeCategory(null, "首页", true, false));
        categorys.add(new HomeCategory(null, "好友圈", false, false));
        categorys.add(new HomeCategory(null, "群微博", false, false));
        categorys.add(new HomeCategory(null, "我的微博", false, false));
        categorys.add(new HomeCategory("我的微博", "特别关注", false, true));
        categorys.add(new HomeCategory(null, "IT行业", false, false));
        categorys.add(new HomeCategory(null, "老师", false, true));
        categorys.add(new HomeCategory(null, "同学", false, true));
        categorys.add(new HomeCategory(null, "科技", false, false));
        categorys.add(new HomeCategory("其他", "周边微博", false, true));
        return categorys;
    }
}