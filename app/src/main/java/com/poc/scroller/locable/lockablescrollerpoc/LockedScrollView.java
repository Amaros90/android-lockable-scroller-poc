package com.poc.scroller.locable.lockablescrollerpoc;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;

public class LockedScrollView extends ScrollView {

    public boolean ShouldScroll = false;
    public boolean IsLocked = true;

    public LockedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setFillViewport(true);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);

        this.getChildAt(0).addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

                LockedScrollView parentScroll = ((LockedScrollView)v.getParent());

                if (parentScroll.IsLocked && parentScroll.ShouldScroll) {
                    parentScroll.scrollTo(parentScroll.getScrollX(), parentScroll.getScrollY() + (bottom - oldBottom));
                }
            }
        });
    }
}
