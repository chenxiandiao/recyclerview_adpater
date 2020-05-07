package com.zyxkt.recyclerview;

import android.support.annotation.LayoutRes;
import android.util.SparseIntArray;

import java.util.List;

public abstract class BaseMultiRecyclerAdapter<T extends MultiItemEntity> extends BaseRecyclerAdapter<T> {

    /**
     * layouts indexed with their types
     */
    private SparseIntArray layouts;

    private static final int DEFAULT_VIEW_TYPE = -0xff;
    public static final int TYPE_NOT_FOUND = -404;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public BaseMultiRecyclerAdapter(List<T> data) {
        super(data);
    }


    @Override
    protected int getDefItemViewType(int position) {
        T item = mData.get(position);
        if (item != null) {
            return item.getItemType();
        }
        return DEFAULT_VIEW_TYPE;
    }

    @Override
    protected int getLayoutId(int viewType) {
        return layouts.get(viewType, TYPE_NOT_FOUND);
    }



    protected void addItemType(int type, @LayoutRes int layoutResId) {
        if (layouts == null) {
            layouts = new SparseIntArray();
        }
        layouts.put(type, layoutResId);
    }

}
