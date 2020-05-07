package com.zyxkt.recyclerview.helper;



import com.zyxkt.recyclerview.BaseRecyclerAdapter;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class RecyclerViewHelper<T> {

    private SwipeRefreshLayout swipeRefresh; // 下拉控件
    private SwipeRefreshHelper swipeRefreshHelper; // 下拉刷新的工具类
    private RecyclerView recyclerView; // RecyclerView
    private BaseRecyclerAdapter<T> adapter; // 适配器
    private RecyclerView.LayoutManager layoutManager; // 布局管理
    private RecyclerView.ItemDecoration itemDecoration; // 条目分割
    private int pageSize;

    private SwipeRefreshHelper.SwipeRefreshListener listener; // 下拉刷新、加载更多监听

    private RecyclerViewHelper(Builder<T> builder) {
        this.swipeRefresh = builder.create.createSwipeRefresh();
        this.recyclerView = builder.create.createRecyclerView();
        this.pageSize = builder.create.pageSize();
        this.adapter = builder.create.createRecycleViewAdapter();
        this.layoutManager = builder.create.createLayoutManager();
        this.itemDecoration = builder.create.createItemDecoration();

        this.listener = builder.listener;

        int[] colorRes = builder.create.colorRes();
        if (swipeRefresh != null) {
            if (colorRes == null) {
                swipeRefreshHelper = SwipeRefreshHelper.createSwipeRefreshHelper(swipeRefresh);
            } else {
                swipeRefreshHelper = SwipeRefreshHelper.createSwipeRefreshHelper(swipeRefresh, colorRes);
            }
        }
        init();
    }

    private void init() {
        // RecyclerView初始化
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        if (itemDecoration != null) recyclerView.addItemDecoration(itemDecoration);

        // 下拉刷新的操作
        if (swipeRefreshHelper != null) {
            swipeRefreshHelper.setSwipeRefreshListener(new SwipeRefreshHelper.SwipeRefreshListener() {
                @Override
                public void onRefresh() {
//                    dismissSwipeRefresh();
                    if (listener != null) listener.onRefresh();
                }
            });
        }
    }

    private void dismissSwipeRefresh() {
        if (swipeRefresh != null && swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        }
    }

    public void notifyAdapterDataSetChanged(List<T> datas, int position) {
        // 首次加载或者下拉刷新后都要重置页码
        if (position == 0) {
            adapter.refreshData(datas);
            dismissSwipeRefresh();
        } else {
            adapter.addData(datas);
        }

        if (position == 0 && datas.size() >= pageSize) {
            adapter.setLoadMoreEnable(true);
            return;
        }

        if (position != 0) {
            if (datas.size() >= pageSize) {
                adapter.loadMoreComplete();
            } else {
                adapter.loadMoreEnd();
            }
//            adapter.loadMoreFail();
        }
    }


    public static class Builder<T> {
        private IRecyclerView<T> create; // 初始化接口
        private SwipeRefreshHelper.SwipeRefreshListener listener; // 下拉监听

        public Builder(IRecyclerView<T> create, SwipeRefreshHelper.SwipeRefreshListener listener) {
            this.create = create;
            this.listener = listener;
        }

        public RecyclerViewHelper build() {
            // 参数的校验
            return new RecyclerViewHelper<>(this);
        }
    }

}
