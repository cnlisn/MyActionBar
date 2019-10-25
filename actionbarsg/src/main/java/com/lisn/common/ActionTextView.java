package com.lisn.common;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
/**
 * @author LiShan
 * @date 2019/10/24
 */
public final class ActionTextView extends AppCompatTextView {

    public ActionTextView(Context context) {
        this(context, null);
    }

    public ActionTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
