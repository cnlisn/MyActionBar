package com.lisn.common;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/**
 * @author LiShan
 * @date 2019/10/24
 */
public final class ActionIconView extends AppCompatImageView {

    public ActionIconView(Context context) {
        this(context, null);
    }

    public ActionIconView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionIconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(heightSize, heightSize);
    }
}
