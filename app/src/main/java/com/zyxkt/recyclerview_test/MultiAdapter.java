package com.zyxkt.recyclerview_test;


import android.widget.TextView;

import com.zyxkt.R;
import com.zyxkt.model.MultiItem;
import com.zyxkt.recyclerview.BaseMultiRecyclerAdapter;
import com.zyxkt.recyclerview.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MultiAdapter extends BaseMultiRecyclerAdapter<MultiItem> {


    public MultiAdapter(@Nullable List<MultiItem> data) {
        super(data);

        addItemType(MultiItem.textType, R.layout.item_text);
        addItemType(MultiItem.imageType, R.layout.item_text);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MultiItem item) {

        int viewType = helper.getItemViewType();

        if (viewType == MultiItem.textType) {
            ((TextView) helper.itemView.findViewById(R.id.tv_content)).setText("welcom to china");
        } else if (viewType == MultiItem.imageType) {
            ((TextView) helper.itemView.findViewById(R.id.tv_content)).setText("welcom to hangzhou");
        }
    }
}
