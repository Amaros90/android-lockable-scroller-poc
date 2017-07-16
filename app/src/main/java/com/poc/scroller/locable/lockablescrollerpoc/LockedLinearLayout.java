package com.poc.scroller.locable.lockablescrollerpoc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.EmptyStackException;

public class LockedLinearLayout extends LinearLayout {
    public LockedLinearLayout(Context context) {
        super(context);
    }

    public LockedLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public LockedLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
