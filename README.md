:running:BGATitleBar-Android:running:
============

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/cn.bingoogolapple/bga-titlebar/badge.svg)](https://maven-badges.herokuapp.com/maven-central/cn.bingoogolapple/bga-titlebar)

工作以来公司 UI 设计师出的 Android 效果图都是 iOS 风格的 TitleBar，新项目还是用原来那一套，不想重复造轮子，所以趁着这次练习 [仿新浪微博 Android 客户端](https://github.com/bingoogolapple/BGAWeiBo-Android)，抽取一个通用的 iOS 风格的 TitleBar

>但是作为 Android 开发者，平时学习练手时还是得紧跟 Google 的步伐，说不定哪天公司的 UI 射击狮们就出一套 MD 风格的效果图

支持图片加文本、仅文本、仅图片、微博首页两种文本颜色的大小标题、资料设置进度的两种文本颜色的标题、动态切换文本和图片的显示、监听各按钮的点击事件

## 效果图
![bgatitlebar](https://cloud.githubusercontent.com/assets/8949716/17476247/99c19a10-5d91-11e6-85b1-55764481686e.gif)![titlebar2](https://cloud.githubusercontent.com/assets/8949716/18605827/7bd49bc0-7cd0-11e6-8569-b70c97ee3ff3.gif)
![dkt](https://cloud.githubusercontent.com/assets/8949716/20560633/5e138154-b1b5-11e6-8824-b212438a1cf8.png)

## 基本使用

### 1.添加 Gradle 依赖

```groovy
dependencies {
    compile 'com.android.support:appcompat-v7:latestVersion'
    compile 'cn.bingoogolapple:bga-titlebar:latestVersion@aar'
}
```

### 2.在布局文件中添加 BGATitleBar

```xml
<cn.bingoogolapple.titlebar.BGATitleBar
        android:id="@+id/titlebar"
        style="@style/TitleBar"
        app:bgatitlebar_leftDrawable="@drawable/selector_nav_friendsearch"
        app:bgatitlebar_rightDrawable="@drawable/selector_nav_pop"
        app:bgatitlebar_titleDrawable="@drawable/selector_nav_arrow_orange"
        app:bgatitlebar_titleDrawablePadding="3dp"
        app:bgatitlebar_titleText="bingoogolapple" />
```

### 3.在 Activity 或者 Fragment中 配置 BGATitleBar

```java
mTitleBar = (BGATitleBar) findViewById(R.id.titlebar);
mTitleBar.setDelegate(new BGATitleBar.Delegate() {
    @Override
    public void onClickLeftCtv() {
        // 点击左上角按钮
    }

    @Override
    public void onClickTitleCtv() {
        // 点击标题按钮
    }

    @Override
    public void onClickRightCtv() {
        // 点击右上角按钮
    }

    @Override
    public void onClickRightSecondaryCtv() {
        // 点击右上角倒数第二个按钮
    }
});
```

## 自定义属性说明

>建议在项目中把下面这五项定义在 styles.xml 里

* bgatitlebar_leftAndRightTextColor 左右按钮文字颜色
* bgatitlebar_titleTextColor 中间标题文字颜色
* bgatitlebar_leftAndRightTextSize 左右按钮文字大小
* bgatitlebar_titleTextSize 中间标题文字大小
* bgatitlebar_leftAndRightPadding 左右按钮在水平方向上的padding

>下面这几项根据每个页面的业务写在 layout 中（可以把带有返回按钮的 titlebar 也单独抽取一个 style）

* bgatitlebar_leftText 左边按钮的文字
* bgatitlebar_titleText 中间标题文字
* bgatitlebar_rightText 右边按钮的文字
* bgatitlebar_rightSecondaryText 右边倒数第二个按钮的文字
* bgatitlebar_leftDrawable 左边按钮图标
* bgatitlebar_titleDrawable 中间标题图标
* bgatitlebar_rightDrawable 右边按钮图标
* bgatitlebar_rightSecondaryDrawable 右边倒数第二个按钮图标
* bgatitlebar_titleDrawablePadding 中间按钮文本和图标之间的间距（当既有titleText，又有titleDrawable时，设置该属性，例如新浪微博首页选择微博分类 ）
* bgatitlebar_leftDrawablePadding 左边按钮文本和图标之间的间距（当既有leftText，又有leftDrawable时，设置该属性）
* bgatitlebar_rightDrawablePadding 右边按钮和图标之间的间距（当既有rightText，又有rightDrawable时，设置该属性）

>下面三项通常情况下不用，使用默认值就好。某个界面标题特别长并且左右文字短或者左右文字特别长并且标题特别短时单独配置

* bgatitlebar_leftMaxWidth 左边按钮的最大宽度
* bgatitlebar_rightMaxWidth 右边按钮的最大宽度
* bgatitlebar_titleMaxWidth 中间标题的最大宽度

>下面三项通常情况下不用，使用默认值就好。

* bgatitlebar_isTitleTextBold 标题文字是否为粗体，默认为true
* bgatitlebar_isLeftTextBold 左边文字是否为粗体，默认为false
* bgatitlebar_isRightTextBold 右边文字是否为粗体，默认为false

### 代码是最好的老师，更多详细用法请查看 [demo](https://github.com/bingoogolapple/BGATitleBar-Android/tree/master/demo):feet:

## 作者联系方式

| 个人主页 | 邮箱 |
| ------------- | ------------ |
| <a  href="https://www.bingoogolapple.cn" target="_blank">bingoogolapple.cn</a>  | <a href="mailto:bingoogolapple@gmail.com" target="_blank">bingoogolapple@gmail.com</a> |

| 个人微信号 | 微信群 | 公众号 |
| ------------ | ------------ | ------------ |
| <img width="180" alt="个人微信号" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/BGAQrCode.png"> | <img width="180" alt="微信群" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/WeChatGroup1QrCode.jpg"> | <img width="180" alt="公众号" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/GongZhongHao.png"> |

| 个人 QQ 号 | QQ 群 |
| ------------ | ------------ |
| <img width="180" alt="个人 QQ 号" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/BGAQQQrCode.jpg"> | <img width="180" alt="QQ 群" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/QQGroup1QrCode.jpg"> |

## 打赏支持作者

如果您觉得 BGA 系列开源库或工具软件帮您节省了大量的开发时间，可以扫描下方的二维码打赏支持。您的支持将鼓励我继续创作，打赏后还可以加我微信免费开通一年 [上帝小助手浏览器扩展/插件开发平台](https://github.com/bingoogolapple/bga-god-assistant-config) 的会员服务

| 微信 | QQ | 支付宝 |
| ------------- | ------------- | ------------- |
| <img width="180" alt="微信" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/donate-wechat.jpg"> | <img width="180" alt="QQ" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/donate-qq.jpg"> | <img width="180" alt="支付宝" src="https://github.com/bingoogolapple/bga-god-assistant-config/raw/main/images/donate-alipay.jpg"> |

## 作者项目推荐

* 欢迎您使用我开发的第一个独立开发软件产品 [上帝小助手浏览器扩展/插件开发平台](https://github.com/bingoogolapple/bga-god-assistant-config)

## License

    Copyright 2015 bingoogolapple

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
