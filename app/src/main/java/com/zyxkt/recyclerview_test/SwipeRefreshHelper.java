package com.zyxkt.recyclerview_test;

import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * 下拉刷新的帮助类
 */
public class SwipeRefreshHelper {

    private SwipeRefreshLayout swipeRefresh;
    private SwipeRefreshListener swipeRefreshListener;

    static SwipeRefreshHelper createSwipeRefreshHelper(SwipeRefreshLayout swipeRefresh, @ColorRes int... colorResIds) {
        return new SwipeRefreshHelper(swipeRefresh, colorResIds);
    }

    private SwipeRefreshHelper(@Nullable SwipeRefreshLayout swipeRefresh, @ColorRes int... colorResIds) {
        this.swipeRefresh = swipeRefresh;
        init(colorResIds);
    }

    private void init(@ColorRes int... colorResIds) {
        if (colorResIds == null || colorResIds.length == 0) {
            swipeRefresh.setColorSchemeResources(android.R.color.holo_orange_dark,
                    android.R.color.holo_green_dark, android.R.color.holo_blue_dark);
        } else {
            swipeRefresh.setColorSchemeResources(colorResIds);
        }

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (swipeRefreshListener != null)
                    swipeRefreshListener.onRefresh();
            }
        });
    }

    public interface SwipeRefreshListener {
        void onRefresh();
    }

    void setSwipeRefreshListener(SwipeRefreshListener swipeRefreshListener) {
        this.swipeRefreshListener = swipeRefreshListener;
    }
}