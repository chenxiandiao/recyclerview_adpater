package com.zyxkt.recyclerview_test;


import android.util.Log;

import com.zyxkt.R;
import com.zyxkt.model.MultiItem;
import com.zyxkt.recyclerview.BaseRecyclerAdapter;
import com.zyxkt.recyclerview.activity.BaseRecyclerActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 *  多布局测试
 */
public class MainActivity extends BaseRecyclerActivity<MultiItem> {

    private static final String TAG = "MainActivity";

    private BaseRecyclerAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public RecyclerView.LayoutManager createLayoutManager() {
        return new GridLayoutManager(this, 10);
    }

    @Override
    public BaseRecyclerAdapter<MultiItem> createRecycleViewAdapter() {
        final List<MultiItem> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new MultiItem(MultiItem.textType));
        }

        for (int i = 0; i < 10; i++) {
            data.add(new MultiItem(MultiItem.imageType));
        }


        adapter = new MultiAdapter(data);

        adapter.setSpanSizeLookup(new BaseRecyclerAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                int type = data.get(position).getItemType();
                if (type == MultiItem.textType) {
                    return 1;
                } else if (type == MultiItem.imageType) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });

        adapter.setRequestLoadMoreListener(new BaseRecyclerAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.e(TAG, "LOAD MORE");
            }
        },createRecyclerView());
        return adapter;
    }

    @Override
    public void onRefresh() {

    }
}
