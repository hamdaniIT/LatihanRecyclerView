package com.example.latihanrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder> {
    private Context context;

    public ListPresidentAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<President> getListPresidents() {
        return listPresidents;
    }

    public void setListPresidents(ArrayList<President> listPresidents) {
        this.listPresidents = listPresidents;
    }

    private ArrayList<President> listPresidents;
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemRow= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_president,viewGroup,false);
        return new CategoryViewHolder(itemRow);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListPresidents().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListPresidents().get(position).getRemarks());
        Glide.with(context)
                .load(getListPresidents().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listPresidents.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
