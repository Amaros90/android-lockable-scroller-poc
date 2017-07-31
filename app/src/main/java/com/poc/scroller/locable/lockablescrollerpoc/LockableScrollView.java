package com.poc.scroller.locable.lockablescrollerpoc;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;

public class LockableScrollView extends ScrollView {

    private boolean _enabled = true;

    public LockableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setFillViewport(true);
    }

    @Override
    public void addView(View layout, ViewGroup.LayoutParams params) {
        super.addView(layout, params);

        ((ViewGroup)layout).setOnHierarchyChangeListener(new OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View layout, View item) {
                if (_enabled) {
                    item.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                        @Override
                        public void onLayoutChange(View item, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        item.removeOnLayoutChangeListener(this);

                        int scrollViewY = ((LockableScrollView)item.getParent().getParent()).getScrollY();
                        int layoutPosition = ((View)item.getParent()).getTop();
                        boolean shouldScroll = item.getTop() + layoutPosition <= scrollViewY || item.getBottom() + getTop() <= scrollViewY;

                        Log.i("TEST", String.format("ADDED -> TOP: %d BOTTOM: %d LAYOUT-TOP: %d CURR-Y: %d SCROLLED: %s", item.getTop(), item.getBottom(), layoutPosition, scrollViewY, shouldScroll));

                        if (shouldScroll) {
                            final int childViewHeight = item.getHeight();

                            ((View)item.getParent()).addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                                @Override
                                public void onLayoutChange(View layout, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                                    layout.removeOnLayoutChangeListener(this);

                                    LockableScrollView scrollView = ((LockableScrollView)layout.getParent());
                                    scrollView.scrollTo(scrollView.getScrollX(), scrollView.getScrollY() + childViewHeight);
                                }
                            });
                        }
                        }
                    });
                }
            }

            @Override
            public void onChildViewRemoved(View layout, View item) {
                if (_enabled) {
                    int scrollViewY = ((LockableScrollView)layout.getParent()).getScrollY();
                    int layoutPosition = layout.getTop();
                    boolean shouldScroll = item.getTop() + layoutPosition <= scrollViewY || item.getBottom() + getTop() <= scrollViewY;

                    Log.i("TEST", String.format("REMOVED -> TOP: %d BOTTOM: %d LAYOUT-TOP: %d CURR-Y: %d SCROLLED: %s", item.getTop(), item.getBottom(), layoutPosition, scrollViewY, shouldScroll));

                    if (shouldScroll) {
                        final int childViewHeight = item.getHeight();

                        layout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                            @Override
                            public void onLayoutChange(View layout, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                                layout.removeOnLayoutChangeListener(this);

                                LockableScrollView scrollView = ((LockableScrollView)layout.getParent());
                                scrollView.scrollTo(scrollView.getScrollX(), scrollView.getScrollY() - childViewHeight);
                            }
                        });
                    }
                }
            }
        });
    }
}
