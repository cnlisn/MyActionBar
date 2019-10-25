package com.lisn.statusbarcompat;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.Window;


interface OsStatusBarCompat {
    void setDarkIconMode(@NonNull Activity activity, boolean darkIconMode);
    void setDarkIconMode(@NonNull Fragment fragment, boolean darkIconMode);
    void setDarkIconMode(@NonNull Window window, boolean darkIconMode);
}
