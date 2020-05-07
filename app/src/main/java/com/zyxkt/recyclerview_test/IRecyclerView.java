package com.zyxkt.recyclerview_test;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.zyxkt.recyclerview.BaseRecyclerAdapter;

public interface IRecyclerView<T> {

    /** 创建SwipeRefresh下拉 */
    SwipeRefreshLayout createSwipeRefresh();

    /** SwipeRefresh下拉颜色 */
    int[] colorRes();

    /** 创建RecycleView */
    RecyclerView createRecyclerView();

    /** 创建RecycleView.Adapter */
    BaseRecyclerAdapter<T> createRecycleViewAdapter();

    /** 创建RecycleView */
    RecyclerView.LayoutManager createLayoutManager();

    /** 创建RecycleView分割线 */
    RecyclerView.ItemDecoration createItemDecoration();

    int pageSize();
}
