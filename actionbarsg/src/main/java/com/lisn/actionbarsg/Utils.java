package com.lisn.actionbarsg;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.Nullable;

/**
 * @author LiShan
 * @date 2019/10/24
 */
class Utils {

    /**
     * 从当前上下文获取Activity
     */
    @Nullable
    static Activity getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }

    static void finishActivity(Context context){
        Activity activity = getActivity(context);
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }
}
