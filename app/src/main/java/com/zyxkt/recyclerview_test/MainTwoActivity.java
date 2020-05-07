package com.zyxkt.recyclerview_test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.zyxkt.BasicAdapter;
import com.zyxkt.R;
import com.zyxkt.contract.DataContract;
import com.zyxkt.presenter.MainPresenter;
import com.zyxkt.recyclerview.BaseRecyclerAdapter;

import java.util.List;

public class MainTwoActivity extends BaseRecyclerActivity<String> implements DataContract.LoadDataView<String> {

    private static final String TAG = "MainActivity";
    private Button btnClick;

    private BaseRecyclerAdapter<String> adapter;
    private DataContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_two;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnClick = findViewById(R.id.btn_click);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getData();
            }
        });


        presenter = new MainPresenter(this, this);

        presenter.getEmptyData();
    }

    @Override
    public BaseRecyclerAdapter<String> createRecycleViewAdapter() {
        adapter = new BasicAdapter(R.layout.item_text, null);

        adapter.setRequestLoadMoreListener(new BaseRecyclerAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.getData();
            }
        },createRecyclerView());
        return adapter;
    }

    @Override
    public void onRefresh() {
        presenter.refresh();
    }

    @Override
    public void addData(List<String> data, int position) {
        notifyAdapterDataSetChanged(data, position);
    }

}
