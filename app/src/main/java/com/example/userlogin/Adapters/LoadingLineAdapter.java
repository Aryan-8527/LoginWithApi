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

import java.util.List;

public class LoadingLineAdapter extends RecyclerView.Adapter<LoadingLineAdapter.Viewholder> {
    List<LoadingLineModel> loadinglinemodellist ;
    Context context;

    public LoadingLineAdapter(List<LoadingLineModel> loadinglinemodellist, Context context) {
        this.loadinglinemodellist = loadinglinemodellist;
        this.context = context;
    }

    @NonNull
    @Override
    public LoadingLineAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutline , parent , false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadingLineAdapter.Viewholder holder, int position) {
        LoadingLineModel model = loadinglinemodellist.get(position);
        holder.description_2.setText(model.getDescription_2());
        holder.length.setText(model.getLength());
        holder.quantity.setText(model.getQuantity());
        holder.freestock.setText(model.getFree_Stock());
        holder.uom.setText(model.getUOM());
        holder.diameter.setText(model.getDiameter());
        holder.loadingpieces.setText(model.getLoaded_Pieces());
        holder.pieces.setText(model.getPieces());
    }

    @Override
    public int getItemCount() {
        return loadinglinemodellist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView description_2 , length , quantity , freestock , uom , diameter , loadingpieces , pieces;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            description_2 =itemView.findViewById(R.id.tv_desciption2);
            length = itemView.findViewById(R.id.tv_length);
            quantity = itemView.findViewById(R.id.tv_quantity);
            freestock = itemView.findViewById(R.id.tv_freestock);
            uom = itemView.findViewById(R.id.tv_uom);
            diameter = itemView.findViewById(R.id.tv_diameter);
            loadingpieces = itemView.findViewById(R.id.tv_loadedpieces);
            pieces = itemView.findViewById(R.id.tv_pieces);
        }
    }
}
