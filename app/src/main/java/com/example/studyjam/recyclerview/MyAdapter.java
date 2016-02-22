package com.example.studyjam.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] mDataset;
    private OnItemClickListener onItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view ;
        public TextView textView;
        public ViewHolder(View view) {
            super(view);
            this.view = view;
            textView = (TextView) view.findViewById(R.id.info_text);
        }

        public void setOnItemClickListener(final String element, final OnItemClickListener onItemClickListener){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    onItemClickListener.onItemClick(view, element);
                }
            });
        }
    }

    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.onItemClickListener = clickListener;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String contactName = mDataset[position];
        holder.textView.setText(contactName);
        if (onItemClickListener != null){
            holder.setOnItemClickListener(contactName, this.onItemClickListener);
        }

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}