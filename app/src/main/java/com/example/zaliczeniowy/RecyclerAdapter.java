package com.example.zaliczeniowy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<order> list_order;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTxt;
        TextView priceTxt;
        TextView IdTxt;
        ImageView imageList;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.Text_list);
            priceTxt = itemView.findViewById(R.id.Price_list);
            imageList = itemView.findViewById(R.id.Price_list);

        }
    }
    public RecyclerAdapter(List<order> list_order){
        this.list_order = list_order;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_recycler, parent, false);

        return new RecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.IdTxt.setText(list_order.get(position).getId());
        holder.nameTxt.setText(list_order.get(position).getName());
        holder.priceTxt.setText(list_order.get(position).getPrice());
        holder.imageList.setImageResource(list_order.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return 0;
    }




}
