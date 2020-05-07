package com.zyxkt;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zyxkt.recyclerview.BaseRecyclerAdapter;
import com.zyxkt.recyclerview.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BasicAdapter extends BaseRecyclerAdapter<String> {

    private static final String TAG = "BasicAdapter";

    private TextView textView;

    public BasicAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {

        textView = helper.itemView.findViewById(R.id.tv_content);
        textView.setText("welcome to china");
        textView.setOnClickListener(listener);
    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e(TAG, "click");
        }
    };

}
