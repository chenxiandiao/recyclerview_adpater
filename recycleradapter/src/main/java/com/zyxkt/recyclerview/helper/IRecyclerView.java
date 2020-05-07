package com.zyxkt.recyclerview.helper;



import com.zyxkt.recyclerview.BaseRecyclerAdapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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

    boolean enableRefresh();
}
