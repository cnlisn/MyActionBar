package com.lisn.statusbarcompat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
/**
 * @author LiShan
 * @date 2019/10/24
 */
public class StatusBarCompat {

    /**
     * 设置状态栏颜色
     */
    public static void setColor(Window window, @ColorInt int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(color);
        }
    }

    /**
     * 获取状态栏高度
     */
    public static int getHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return context.getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    /**
     * 设置状态栏图标主题
     */
    public static void setIconMode(Fragment fragment, boolean darkIconMode) {
        createOsStatusBarCompat().setDarkIconMode(fragment, darkIconMode);
    }

    /**
     * 设置状态栏图标主题
     */
    public static void setIconMode(Activity activity, boolean darkIconMode) {
        createOsStatusBarCompat().setDarkIconMode(activity, darkIconMode);
    }

    /**
     * 设置状态栏图标主题
     */
    public static void setIconMode(Window window, boolean darkIconMode) {
        createOsStatusBarCompat().setDarkIconMode(window, darkIconMode);
    }

    /**
     * 设置状态栏透明
     */
    public static void transparent(Activity activity) {
        transparent(activity.getWindow());
    }

    /**
     * 设置状态栏透明
     */
    public static void transparent(Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity != null) {
            transparent(activity);
        }
    }

    /**
     * 设置状态栏透明
     */
    public static void transparent(Window window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            transparentStatusBarAbove21(window);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            transparentStatusBarAbove19(window);
        }
    }

    private static OsStatusBarCompat createOsStatusBarCompat(){
        if (OsUtils.isMiui()) {
            return new OsStatusBarCompatMiui();
        } else if (OsUtils.isFlyme()) {
            return new OsStatusBarCompatFlyme();
        } else if (OsUtils.isOppo()) {
            return new OsStatusBarCompatOppo();
        } else {
            return new OsStatusBarCompatDef();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static void transparentStatusBarAbove21(Window window) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static void transparentStatusBarAbove19(Window window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
}
