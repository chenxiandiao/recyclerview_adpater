package com.zyxkt.contract;

import java.util.List;

public interface DataContract {


    interface LoadingView {
        void showLoading();

        void showEmpty();

        void showFail();
    }

    interface LoadDataView<T> {

        void addData(List<T> data, int position);
    }


    interface Presenter {
        void getData();

        void getEmptyData();

        void refresh();
    }
}
