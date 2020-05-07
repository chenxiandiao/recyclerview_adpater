package com.zyxkt;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleHolder> {

    private static final String TAG = "SampleAdapter";

    @NonNull
    @Override
    public SampleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_text, viewGroup, false);

        Log.e(TAG, "onCreateViewHolder: ");

        return new SampleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleHolder sampleHolder, int i) {
        Log.e(TAG, "onBindViewHolder: ");
        sampleHolder.tvContent.setText("hello world");
    }


    @Override
    public int getItemViewType(int position) {
        Log.e(TAG, "getItemViewType: ");
        return super.getItemViewType(position);

    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: ");
        return 200;
    }


    class SampleHolder extends RecyclerView.ViewHolder {

        TextView tvContent;

        public SampleHolder(@NonNull View itemView) {
            super(itemView);

            tvContent = itemView.findViewById(R.id.tv_content);

        }
    }
}
