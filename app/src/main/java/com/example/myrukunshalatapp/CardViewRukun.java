package com.example.myrukunshalatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewRukun  extends RecyclerView.Adapter<CardViewRukun.CardViewHolder> {
    private final ArrayList<Rukun> listRukun;
    private OnItemClickCallback onItemClickCallback;

    public CardViewRukun(ArrayList<Rukun> list) {
        this.listRukun = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public CardViewRukun.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_rukun, parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewRukun.CardViewHolder holder, int position) {
        Rukun rukun = listRukun.get(position);
        Glide.with(holder.itemView.getContext())
                .load(rukun.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.iv_item_photo);
        holder.tvTittle.setText(rukun.getNama());
        holder.tvDetail.setText(rukun.getDetail());
        holder.btnBaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listRukun.get(holder.getAdapterPosition()));
                Toast.makeText(holder.itemView.getContext(), listRukun.get(holder.getAdapterPosition()).getNama(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listRukun.get(holder.getAdapterPosition()));
                Toast.makeText(holder.itemView.getContext(), listRukun.get(holder.getAdapterPosition()).getNama(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listRukun.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_item_photo;
        TextView tvTittle, tvDetail;
        Button btnBaca;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_item_photo = itemView.findViewById(R.id.iv_item_photo);
            tvTittle = itemView.findViewById(R.id.tvTittle);
            tvDetail = itemView.findViewById(R.id.tvDetail);
            btnBaca = itemView.findViewById(R.id.btnBaca);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Rukun rukun);
    }
}
