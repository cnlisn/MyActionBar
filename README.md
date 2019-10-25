# MyActionBar

## 效果图

![](https://github.com/cnlisn/MyActionBar/blob/master/Picture/WX20191025-095050%402x.png)

## 属性介绍

    ActionBarSG
    
    <!--是否开启自动沉浸状态栏，默认为true-->
    <attr name="ab_autoImmersion" format="boolean" />
    <!--背景层布局，优先级高于背景层为图片-->
    <attr name="ab_backgroundLayerLayout" format="reference" />
    <!--背景层为图片-->
    <attr name="ab_backgroundLayerImageRes" format="reference" />
    <!--是否显示状态栏，默认为true-->
    <attr name="ab_statusBarVisible" format="boolean" />
    <!--状态栏颜色，默认透明-->
    <attr name="ab_statusBarColor" format="color|reference" />
    <!--状态栏图标颜色模式，默认light-->
    <attr name="ab_statusBarMode" format="enum">
        <enum name="light" value="0" />
        <enum name="dark" value="1" />
    </attr>
    <!--点击关闭Activity控件ID-->
    <attr name="ab_clickToFinish" format="reference" />
    <!--主体层布局-->
    <attr name="ab_titleBarLayout" format="reference" />
    <!--主体层高度，默认为48dp-->
    <attr name="ab_titleBarHeight" format="dimension|reference" />
    <!--底部分割线高度，默认为0dp-->
    <attr name="ab_bottomLineHeight" format="dimension|reference" />
    <!--底部分割线颜色，默认透明-->
    <attr name="ab_bottomLineColor" format="color|reference" />
    <!--底部分割线资源引用，默认透明-->
    <attr name="ab_bottomLineResId" format="reference" />
    <!--底部分割线位于ActionBar外部，可实现投影效果-->
    <attr name="ab_bottomLineOutside" format="boolean|reference" />
    <!--前景层布局-->
    <attr name="ab_foregroundLayerLayout" format="reference" />
    
## 使用：

    import android.content.Intent;
    import android.os.Bundle;
    import android.os.Handler;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.SwitchCompat;
    import android.view.View;
    import android.widget.CompoundButton;
    import android.widget.Toast;
    import com.lisn.actionbarsg.ActionBarSG;
    import com.lisn.common.ActionBarCommon;
    import com.lisn.common.ActionBarSearch;
    import com.lisn.common.ActionBarSuper;
    import com.lisn.common.ActionView;
    import com.lisn.common.OnActionBarChildClickListener;
    import com.lisn.statusbarcompat.StatusBarCompat;
    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBarCommon simple_action_bar_1 = findViewById(R.id.simple_action_bar_1);
        ActionBarCommon simple_action_bar_2 = findViewById(R.id.simple_action_bar_2);
        ActionBarCommon simple_action_bar_3 = findViewById(R.id.simple_action_bar_3);
        ActionBarSearch search_action_bar_1 = findViewById(R.id.search_action_bar_1);
        ActionBarSearch search_action_bar_2 = findViewById(R.id.search_action_bar_2);
        ActionBarSG action_bar_sg_1 = findViewById(R.id.action_bar_sg_1);
        ActionBarSG action_bar_sg_2 = findViewById(R.id.action_bar_sg_2);
        ActionBarSuper action_bar_super_2 = findViewById(R.id.action_bar_super_2);
        ActionBarSuper action_bar_super_3 = findViewById(R.id.action_bar_super_3);
        ActionBarSuper action_bar_super_4 = findViewById(R.id.action_bar_super_4);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simple_action_bar_1.getForegroundLayer().setVisibility(View.VISIBLE);
                simple_action_bar_2.getForegroundLayer().setVisibility(View.VISIBLE);
                simple_action_bar_3.getForegroundLayer().setVisibility(View.VISIBLE);
                search_action_bar_1.getForegroundLayer().setVisibility(View.VISIBLE);
                search_action_bar_2.getForegroundLayer().setVisibility(View.VISIBLE);
                action_bar_sg_1.getForegroundLayer().setVisibility(View.VISIBLE);
                action_bar_sg_2.getForegroundLayer().setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        simple_action_bar_1.getForegroundLayer().setVisibility(View.GONE);
                        simple_action_bar_2.getForegroundLayer().setVisibility(View.GONE);
                        simple_action_bar_3.getForegroundLayer().setVisibility(View.GONE);
                        search_action_bar_1.getForegroundLayer().setVisibility(View.GONE);
                        search_action_bar_2.getForegroundLayer().setVisibility(View.GONE);
                        action_bar_sg_1.getForegroundLayer().setVisibility(View.GONE);
                        action_bar_sg_2.getForegroundLayer().setVisibility(View.GONE);
                    }
                }, 3000);
            }
        });

        findViewById(R.id.tv_test_in_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestInFragmentActivity.class);
                startActivity(intent);
            }
        });

        SwitchCompat sc_status_bar_dark_icon = findViewById(R.id.sc_status_bar_dark_icon);
        sc_status_bar_dark_icon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                StatusBarCompat.setIconMode(MainActivity.this, isChecked);
            }
        });

        ActionView[] leftActionViews = action_bar_super_4.getLeftActionViews();

        leftActionViews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "LeftIconClick 2", Toast.LENGTH_SHORT).show();
            }
        });

        ActionView[] rightActionViews = action_bar_super_4.getRightActionViews();
        for (int i = 0; i < rightActionViews.length; i++) {
            int finalI = i;
            rightActionViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "RightIconClick " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });
        }

        simple_action_bar_1.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "LeftIconClick", Toast.LENGTH_SHORT).show();
            }
        });

        simple_action_bar_1.setOnRightIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "RightIconClick", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


## 布局：

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@+id/simple_action_bar_1">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <Button
                android:id="@+id/bt"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="显示loading!" />

            <Button
                android:id="@+id/tv_test_in_fragment"
                android:layout_width="match_parent"
                android:layout_height="45dp"
                android:layout_marginTop="10dp"
                android:background="@color/white"
                android:gravity="center"
                android:text="跳转Fragment测试界面" />

            <android.support.v7.widget.SwitchCompat
                android:id="@+id/sc_status_bar_dark_icon"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="#fff"
                android:padding="15dp"
                android:text="切换状态栏图标暗色" />

            <com.lisn.actionbarsg.ActionBarSG
                android:id="@+id/action_bar_sg_1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="@drawable/title_bar_custom_bg"
                app:ab_autoImmersion="false"
                app:ab_bottomLineColor="@color/line"
                app:ab_bottomLineHeight="0dp"
                app:ab_foregroundLayerLayout="@layout/loading_bar"
                app:ab_statusBarColor="@color/transparent"
                app:ab_statusBarMode="dark"
                app:ab_statusBarVisible="false"
                app:ab_titleBarHeight="48dp"
                app:ab_titleBarLayout="@layout/title_bar_custom" />

            <com.lisn.actionbarsg.ActionBarSG
                android:id="@+id/action_bar_sg_2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="#33ffffff"
                app:ab_autoImmersion="false"
                app:ab_backgroundLayerImageRes="@mipmap/action_bar_img"
                app:ab_bottomLineColor="@color/line"
                app:ab_bottomLineHeight="0dp"
                app:ab_clickToFinish="@id/iv_click_to_finish"
                app:ab_foregroundLayerLayout="@layout/loading_bar"
                app:ab_statusBarColor="@color/transparent"
                app:ab_statusBarMode="dark"
                app:ab_statusBarVisible="false"
                app:ab_titleBarHeight="48dp"
                app:ab_titleBarLayout="@layout/title_bar_custom_2" />

            <com.lisn.common.ActionBarCommon
                android:id="@+id/simple_action_bar_2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="#232323"
                app:ab_autoImmersion="false"
                app:ab_bottomLineColor="@color/line"
                app:ab_bottomLineHeight="0dp"
                app:ab_foregroundLayerLayout="@layout/loading_bar"
                app:ab_statusBarColor="@color/transparent"
                app:ab_statusBarMode="dark"
                app:ab_statusBarVisible="false"
                app:ab_titleBarHeight="48dp"
                app:abc_leftText="返回"
                app:abc_leftTextColor="@color/white"
                app:abc_rightText="确定"
                app:abc_rightTextColor="@color/white"
                app:abc_titleText="感觉这个样子还可以"
                app:abc_titleTextColor="@color/white" />

            <com.lisn.common.ActionBarCommon
                android:id="@+id/simple_action_bar_3"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="#ccffffff"
                app:ab_autoImmersion="false"
                app:ab_bottomLineColor="@color/line"
                app:ab_bottomLineHeight="0dp"
                app:ab_foregroundLayerLayout="@layout/loading_bar"
                app:ab_statusBarColor="@color/transparent"
                app:ab_statusBarMode="dark"
                app:ab_statusBarVisible="false"
                app:ab_titleBarHeight="48dp"
                app:abc_leftIconColor="@color/black"
                app:abc_leftIconRes="@mipmap/back"
                app:abc_leftText="返回"
                app:abc_leftTextPaddingLeft="0dp"
                app:abc_leftTextPaddingRight="0dp"
                app:abc_rightIconColor="@color/black"
                app:abc_rightIconRes="@mipmap/search"
                app:abc_rightText="确定"
                app:abc_rightTextPaddingLeft="0dp"
                app:abc_rightTextPaddingRight="0dp"
                app:abc_titleText="这个标题有点长我试试长标题什么样子"
                app:abc_titleTextMaxWidth="180dp" />

            <com.lisn.common.ActionBarSearch
                android:id="@+id/search_action_bar_1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="#ffffff"
                app:ab_autoImmersion="false"
                app:ab_bottomLineColor="@color/line"
                app:ab_bottomLineHeight="1dp"
                app:ab_foregroundLayerLayout="@layout/loading_bar"
                app:ab_statusBarColor="@color/transparent"
                app:ab_statusBarMode="dark"
                app:ab_statusBarVisible="false"
                app:ab_titleBarHeight="48dp"
                app:abs_leftIconColor="@color/black"
                app:abs_leftIconRes="@mipmap/back"
                app:abs_rightIconColor="@color/black"
                app:abs_rightIconRes="@mipmap/search"
                app:abs_titleHintColor="#aaaaaa"
                app:abs_titleHintText="这是一个搜索框..."
                app:abs_titleTextColor="#232323"
                app:abs_titleTextSize="15sp" />

            <com.lisn.common.ActionBarSearch
                android:id="@+id/search_action_bar_2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="#ffffff"
                app:ab_autoImmersion="false"
                app:ab_bottomLineColor="@color/line"
                app:ab_bottomLineHeight="1dp"
                app:ab_foregroundLayerLayout="@layout/loading_bar"
                app:ab_statusBarColor="@color/transparent"
                app:ab_statusBarMode="dark"
                app:ab_statusBarVisible="false"
                app:ab_titleBarHeight="48dp"
                app:abs_leftIconColor="@color/black"
                app:abs_leftIconRes="@mipmap/back"
                app:abs_rightIconColor="@color/black"
                app:abs_rightIconRes="@mipmap/search"
                app:abs_titleBgRes="@drawable/search_bar_title_et_bg"
                app:abs_titleHintColor="#aaaaaa"
                app:abs_titleHintText="这是一个搜索框..."
                app:abs_titleMarginVertical="8dp"
                app:abs_titlePaddingHorizontal="16dp"
                app:abs_titleTextColor="#232323"
                app:abs_titleTextSize="15sp" />

            <com.lisn.common.ActionBarSuper
                android:id="@+id/action_bar_super_1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="@color/colorPrimary"
                app:ab_autoImmersion="false"
                app:ab_bottomLineColor="@color/line"
                app:ab_bottomLineHeight="0dp"
                app:ab_foregroundLayerLayout="@layout/loading_bar"
                app:ab_statusBarColor="@color/transparent"
                app:ab_statusBarMode="dark"
                app:ab_statusBarVisible="false"
                app:ab_titleBarHeight="48dp"
                app:absuper_left1Icon="@mipmap/back"
                app:absuper_left1IconClickToFinish="true"
                app:absuper_left2Text="返回"
                app:absuper_left2TextClickToFinish="true"
                app:absuper_left2TextColor="@color/white"
                app:absuper_left2TextPadding="0dp"
                app:absuper_right1Text="确定"
                app:absuper_right1TextColor="@color/white"
                app:absuper_right1TextMargin="0dp"
                app:absuper_titleText="@string/app_name"
                app:absuper_titleTextColor="@color/white"
                app:absuper_titleTextStyle="bold" />

            <com.lisn.common.ActionBarSuper
                android:id="@+id/action_bar_super_2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="@color/colorPrimary"
                app:ab_autoImmersion="false"
                app:ab_bottomLineColor="@color/line"
                app:ab_bottomLineHeight="0dp"
                app:ab_foregroundLayerLayout="@layout/loading_bar"
                app:ab_statusBarColor="@color/transparent"
                app:ab_statusBarMode="dark"
                app:ab_statusBarVisible="false"
                app:ab_titleBarHeight="58dp"
                app:absuper_right1Icon="@mipmap/search"
                app:absuper_right1IconMarginRight="-5dp"
                app:absuper_right1IconPadding="20dp"
                app:absuper_subtitleMarginLeft="15dp"
                app:absuper_subtitleText="侧边副标题"
                app:absuper_subtitleTextColor="#aaffffff"
                app:absuper_titleGravity="left"
                app:absuper_titleMarginLeft="15dp"
                app:absuper_titleText="侧边大标题"
                app:absuper_titleTextColor="@color/white" />

            <com.lisn.common.ActionBarSuper
                android:id="@+id/action_bar_super_3"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="@color/colorPrimary"
                app:ab_autoImmersion="false"
                app:ab_bottomLineColor="@color/line"
                app:ab_bottomLineHeight="0dp"
                app:ab_foregroundLayerLayout="@layout/loading_bar"
                app:ab_statusBarColor="@color/transparent"
                app:ab_statusBarMode="dark"
                app:ab_statusBarVisible="false"
                app:ab_titleBarHeight="48dp"
                app:absuper_left1Icon="@mipmap/back"
                app:absuper_left1IconClickToFinish="true"
                app:absuper_left2Text="侧边大标题"
                app:absuper_left2TextColor="@color/white"
                app:absuper_left2TextPadding="0dp"
                app:absuper_left2TextSize="17sp"
                app:absuper_right1Icon="@mipmap/download"
                app:absuper_right2Icon="@mipmap/delete"
                app:absuper_right3Icon="@mipmap/more" />

            <com.lisn.common.ActionBarSuper
                android:id="@+id/action_bar_super_4"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="@color/colorPrimary"
                app:ab_autoImmersion="false"
                app:ab_bottomLineColor="@color/line"
                app:ab_bottomLineHeight="0dp"
                app:ab_foregroundLayerLayout="@layout/loading_bar"
                app:ab_statusBarColor="@color/transparent"
                app:ab_statusBarMode="dark"
                app:ab_statusBarVisible="false"
                app:ab_titleBarHeight="48dp"
                app:absuper_left1Icon="@mipmap/back"
                app:absuper_left1IconClickToFinish="true"
                app:absuper_left2Icon="@mipmap/search"
                app:absuper_right1Icon="@mipmap/download"
                app:absuper_right2Icon="@mipmap/delete"
                app:absuper_right3Icon="@mipmap/more" />
            <View
                android:layout_width="match_parent"
                android:layout_height="100dp" />
        </LinearLayout>
    </ScrollView>

    <com.lisn.common.ActionBarCommon
        android:id="@+id/simple_action_bar_1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        app:ab_autoImmersion="false"
        app:ab_bottomLineHeight="10dp"
        app:ab_bottomLineOutside="true"
        app:ab_bottomLineResId="@drawable/bottom_line_bg"
        app:ab_foregroundLayerLayout="@layout/loading_bar"
        app:ab_statusBarColor="@color/colorAccent"
        app:ab_statusBarMode="dark"
        app:ab_statusBarVisible="false"
        app:ab_titleBarHeight="48dp"
        app:abc_leftIconColor="@color/black"
        app:abc_leftIconRes="@mipmap/back"
        app:abc_rightIconColor="@color/black"
        app:abc_rightIconRes="@mipmap/search"
        app:abc_titleText="这个标题有点长我试试长标题什么样子" />

</RelativeLayout>
