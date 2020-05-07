package com.zyxkt.model;

import com.zyxkt.recyclerview.MultiItemEntity;

public class MultiItem implements MultiItemEntity {


    public static final int textType = 1;
    public static final int imageType = 2;


    private int itemType;

    public MultiItem(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
