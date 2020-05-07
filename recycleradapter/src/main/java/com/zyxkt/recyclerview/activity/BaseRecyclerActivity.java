
package com.zyxkt.recyclerview.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zyxkt.recyclerview.R;
import com.zyxkt.recyclerview.contract.DataContract;
import com.zyxkt.recyclerview.helper.IRecyclerView;
import com.zyxkt.recyclerview.helper.RecyclerViewHelper;
import com.zyxkt.recyclerview.helper.SwipeRefreshHelper;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView  ;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public abstract class BaseRecyclerActivity<T> extends AppCompatActivity
        implements IRecyclerView<T>, SwipeRefreshHelper.SwipeRefreshListener, DataContract.LoadingView {

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
        SwipeRefreshLayout refreshLayout =  findViewById(R.id.swipe_refresh_layout);
        refreshLayout.setEnabled(enableRefresh());
        return refreshLayout;
    }

    @Override
    public boolean enableRefresh() {
        return true;
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

