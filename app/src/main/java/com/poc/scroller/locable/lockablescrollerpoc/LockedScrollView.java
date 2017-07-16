package com.poc.scroller.locable.lockablescrollerpoc;

import android.view.View;
import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;

import java.util.EmptyStackException;

public class LockedScrollView extends ScrollView {

    public LockedScrollView(Context context) {
        super(context);
        super.setFillViewport(true);
    }


    public LockedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setFillViewport(true);

    }

    public LockedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        super.setFillViewport(true);
    }
}
