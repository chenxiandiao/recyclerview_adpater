package com.zyxkt.presenter;

import com.zyxkt.contract.DataContract;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements DataContract.Presenter {


    private DataContract.LoadingView view;
    private DataContract.LoadDataView dataView;
    private int page = 0;

    public MainPresenter(DataContract.LoadingView view, DataContract.LoadDataView dataView) {
        this.view = view;
        this.dataView = dataView;
    }

    @Override
    public void getData() {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            items.add("11");
        }

        dataView.addData(items, page);
        page++;
    }

    @Override
    public void getEmptyData() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        view.showEmpty();
    }

    @Override
    public void refresh() {
        page = 0;
        getData();
    }
}
