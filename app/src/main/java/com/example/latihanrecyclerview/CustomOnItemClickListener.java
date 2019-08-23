package com.example.latihanrecyclerview;

import android.view.View;

public class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;
    public CustomOnItemClickListener(int positon, OnItemClickCallback onItemClickCallback) {
        this.position = positon;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view,position);
    }
    public interface OnItemClickCallback{
        void onItemClicked(View view, int position);
    }

}
