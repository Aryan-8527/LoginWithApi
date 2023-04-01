package com.example.userlogin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userlogin.Models.LoadingLineModel;
import com.example.userlogin.R;

import java.util.ArrayList;

public class LoadingLineAdapter extends RecyclerView.Adapter<LoadingLineAdapter.Viewholder> {
    ArrayList<LoadingLineModel> loadinglinemodellist ;
    Context context;

    public LoadingLineAdapter(ArrayList<LoadingLineModel> loadinglinemodellist, Context context) {
        this.loadinglinemodellist = loadinglinemodellist;
        this.context = context;
    }

    @NonNull
    @Override
    public LoadingLineAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlinelist, parent , false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadingLineAdapter.Viewholder holder, int position) {

        LoadingLineModel model = loadinglinemodellist.get(position);

        holder.description_2.setText(model.getDescription_2());
        holder.length.setText(model.getLength());
        holder.quantity.setText(model.getQuantity());
        holder.loadingquantity.setText(model.getLoading_Quantity());
        holder.remark.setText(model.getRemarks());
        holder.pieces1.setText(model.getPieces());
        holder.pieces.setText(model.getPieces());
        holder.lpeices.setText(model.getPeices());

    }

    @Override
    public int getItemCount() {
        return loadinglinemodellist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView description_2;
        TextView length;
        TextView quantity;
        TextView loadingquantity;
        TextView remark;
        TextView lpeices;
        TextView pieces1;
        TextView pieces;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            description_2 =itemView.findViewById(R.id.tv_desciption2);
            length = itemView.findViewById(R.id.tv_length);
            quantity = itemView.findViewById(R.id.tv_quantity);
            loadingquantity = itemView.findViewById(R.id.tv_loadingquantity);
            remark = itemView.findViewById(R.id.tv_remark);
            lpeices = itemView.findViewById(R.id.tv_length_peices);
            pieces1 = itemView.findViewById(R.id.tv_pieces1);
            pieces = itemView.findViewById(R.id.tv_pieces);
        }
    }
}
