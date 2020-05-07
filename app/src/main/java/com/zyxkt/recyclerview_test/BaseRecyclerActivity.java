package com.zyxkt.recyclerview_test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zyxkt.R;
import com.zyxkt.contract.DataContract;

import java.util.List;

public abstract class BaseRecyclerActivity<T> extends AppCompatActivity
        implements IRecyclerView<T>, SwipeRefreshHelper.SwipeRefreshListener
        , DataContract.LoadingView {

    private TextView tvState;
    private RecyclerViewHelper recyclerViewHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        recyclerViewHelper = new RecyclerViewHelper.Builder(this, this).build();
        tvState = findViewById(R.id.tv_state);
    }

    protected abstract int getLayoutId();


    @Override
    public SwipeRefreshLayout createSwipeRefresh() {
        return findViewById(R.id.swipe_refresh_layout);
    }

    @Override
    public int[] colorRes() {
        return new int[0];
    }

    @Override
    public RecyclerView createRecyclerView() {
        return findViewById(R.id.recycler_view);
    }


    @Override
    public RecyclerView.LayoutManager createLayoutManager() {
        return new GridLayoutManager(this, 1);
    }

    @Override
    public RecyclerView.ItemDecoration createItemDecoration() {
        return new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
    }


    @Override
    public void showLoading() {
        tvState.setText("Loading");
        tvState.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmpty() {
        tvState.setText("Empty");
        tvState.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFail() {
        tvState.setText("Fail");
        tvState.setVisibility(View.VISIBLE);
    }

    protected void notifyAdapterDataSetChanged(List datas, int position) {
        tvState.setVisibility(View.GONE);
        recyclerViewHelper.notifyAdapterDataSetChanged(datas, position);
    }


    @Override
    public int pageSize() {
        return 50;
    }
}
