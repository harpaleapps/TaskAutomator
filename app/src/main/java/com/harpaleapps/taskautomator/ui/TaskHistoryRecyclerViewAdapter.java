package com.harpaleapps.taskautomator.ui;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.harpaleapps.taskautomator.R;
import com.harpaleapps.taskautomator.modle.ViewModel;

import java.util.ArrayList;

public class TaskHistoryRecyclerViewAdapter extends RecyclerView
        .Adapter<TaskHistoryRecyclerViewAdapter.DataObjectHolder> {
    private static String LOG_TAG = "TaskHistoryRecyclerViewAdapter";
    private final int rowLayoutId;
    private ArrayList<ViewModel> mDataset = new ArrayList<>();
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        TextView label;
        TextView dateTime;

        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.nameTextView);
            dateTime = (TextView) itemView.findViewById(R.id.descriptionTextView);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (myClickListener != null) {
                myClickListener.onItemClick(getAdapterPosition(), v);
            }
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public TaskHistoryRecyclerViewAdapter(int rowLayoutId) {
        this.rowLayoutId = rowLayoutId;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(rowLayoutId, parent, false);
        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.label.setText(mDataset.get(position).getName());
        holder.dateTime.setText(mDataset.get(position).getDescription());
    }

    public void addItems(ArrayList<ViewModel> dataset) {
        mDataset.addAll(dataset);
        notifyDataSetChanged();
    }

    public void addItem(ViewModel dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    public void deleteAll() {
        mDataset.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}
