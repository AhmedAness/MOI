package com.example.moi.view.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moi.R;

import java.util.ArrayList;
import java.util.List;

public class Violation_List_Adapter extends RecyclerView.Adapter<Violation_List_Adapter.ViewHolder> {

    private List<String> mData;
    private List<String> SelectedItems=new ArrayList<>();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public Violation_List_Adapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.violations_list_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.ViolationName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (!SelectedItems.contains(mData.get(getAdapterPosition()))){
                SelectedItems.add(mData.get(getAdapterPosition()));
                view.setBackgroundColor(view.getResources().getColor(R.color.Gray));
            }else {
                SelectedItems.remove(mData.get(getAdapterPosition()));
                view.setBackgroundColor(view.getResources().getColor(R.color.White));
            }

            if (mClickListener != null) mClickListener.onSelectViolation(SelectedItems);

        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onSelectViolation( List<String> SelectedItems);
    }
}