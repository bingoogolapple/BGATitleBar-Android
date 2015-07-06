:running:BGATitlebar-Android v1.0.0:running:
============

>关于我<br/>
>微博：<a href="http://weibo.com/bingoogol" target="_blank">bingoogolapple</a>&nbsp;&nbsp;&nbsp;&nbsp;主页：<a  href="http://www.bingoogolapple.cn" target="_blank">bingoogolapple.cn</a>&nbsp;&nbsp;&nbsp;&nbsp;邮箱：<a href="mailto:bingoogolapple@gmail.com" target="_blank">bingoogolapple@gmail.com</a>

工作以来公司UI设计师出的Android效果图都是iOS风格的Titlebar，新项目还是用原来那一套，不想重复造轮子，所以趁着这次练习 [仿新浪微博Android客户端](https://github.com/bingoogolapple/BGAWeiBo-Android)，抽取一个通用的iOS风格的Titlebar

** 但是作为Android开发者，平时学习练手时还是得紧跟Google的步伐，说不定哪天公司的UI射击狮们就出一套MD风格的效果图 **

demo中演示了各种情况的标题和新浪微博首页选择微博分类案例

### 效果图
![Demo](https://raw.githubusercontent.com/bingoogolapple/BGATitlebar-Android/master/screenshots/demo.gif)

### 基本使用

#### 1.添加Gradle依赖

```groovy
dependencies {
    compile 'com.android.support:appcompat-v7:22.2.0'
    compile 'cn.bingoogolapple:bga-titlebar:1.0.0@aar'
}
```

#### 2.在布局文件中添加BGATitlebar

```xml
<cn.bingoogolapple.titlebar.BGATitlebar
        android:id="@+id/titlebar"
        style="@style/TitleBar"
        app:bgatitlebar_leftDrawable="@drawable/selector_nav_friendsearch"
        app:bgatitlebar_rightDrawable="@drawable/selector_nav_pop"
        app:bgatitlebar_titleDrawable="@drawable/selector_nav_arrow_orange"
        app:bgatitlebar_titleDrawablePadding="3dp"
        app:bgatitlebar_titleText="bingoogolapple" />
```

#### 3.在Activity或者Fragment中配置BGATitlebar

```java
mTitlebar = (BGATitlebar) findViewById(R.id.titlebar);
mTitlebar.setDelegate(new BGATitlebar.BGATitlebarDelegate() {
    @Override
    public void onClickLeftCtv() {
        // 可选，根据实际业务重写该方法
    }

    @Override
    public void onClickTitleCtv() {
        // 可选，根据实际业务重写该方法
    }

    @Override
    public void onClickRightCtv() {
        // 可选，根据实际业务重写该方法
    }
});
```

### 自定义属性说明

>建议在项目中把下面这五项定义在styles.xml里

* bgatitlebar_leftAndRightTextColor 左右按钮文字颜色
* bgatitlebar_titleTextColor 中间标题文字颜色
* bgatitlebar_leftAndRightTextSize 左右按钮文字大小
* bgatitlebar_titleTextSize 中间标题文字大小
* bgatitlebar_leftAndRightPadding 左右按钮在水平方向上的padding

>下面这几项根据每个页面的业务写在layout中（可以把带有返回按钮的titlebar也单独抽取一个style）

* bgatitlebar_leftText 左边按钮的文字
* bgatitlebar_rightText 右边按钮的文字
* bgatitlebar_titleText 中间标题文字
* bgatitlebar_leftDrawable 左边按钮图标
* bgatitlebar_rightDrawable 右边按钮图标
* bgatitlebar_titleDrawable 中间标题图标
* bgatitlebar_titleDrawablePadding 中间按钮文本和图标之间的间距（当既有titleText，又有titleDrawable时，设置该属性，例如新浪微博首页选择微博分类 ）
* bgatitlebar_leftDrawablePadding 左边按钮文本和图标之间的间距（当既有leftText，又有leftDrawable时，设置该属性）
* bgatitlebar_rightDrawablePadding 右边按钮和图标之间的间距（当既有rightText，又有rightDrawable时，设置该属性）

>下面三项通常情况下不用，使用默认值就好。某个界面标题特别长并且左右文字短或者左右文字特别长并且标题特别短时单独配置

* bgatitlebar_leftMaxWidth 左边按钮的最大宽度
* bgatitlebar_rightMaxWidth 右边按钮的最大宽度
* bgatitlebar_titleMaxWidth 中间标题的最大宽度

### 代码是最好的老师，更多详细用法请查看[demo](https://github.com/bingoogolapple/BGATitlebar-Android/tree/master/demo):feet:

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
