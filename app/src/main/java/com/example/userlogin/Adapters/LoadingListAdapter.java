package com.example.userlogin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userlogin.Models.LoadingListModel;
import com.example.userlogin.R;

import java.util.List;

public class LoadingListAdapter extends RecyclerView.Adapter<LoadingListAdapter.ViewHolder> {

    List<LoadingListModel> loadinlistmodellist;
    Context context;

    public LoadingListAdapter(List<LoadingListModel> loadinlistmodellist, Context context) {
        this.loadinlistmodellist = loadinlistmodellist;
        this.context = context;
    }

    @NonNull
    @Override
    public LoadingListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist , parent , false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadingListAdapter.ViewHolder holder, int position) {
        LoadingListModel model = loadinlistmodellist.get(position);
        holder.listno.setText(model.getNo());
        holder.listcustomerno.setText(model.getCustomer_No());
        holder.listcustomername.setText(model.getCustomer_Name());
        holder.listtransportername.setText(model.getTransporter_Name());
    }

    @Override
    public int getItemCount() {
        return loadinlistmodellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView listno , listcustomerno , listcustomername , listtransportername ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            listno = itemView.findViewById(R.id.loadinglist_No);
            listcustomerno = itemView.findViewById(R.id.loadinglist_Customer_No);
            listcustomername = itemView.findViewById(R.id.loadinglist_Customer_Name);
            listtransportername = itemView.findViewById(R.id.loadinglist_Transporter_Name);
        }
    }

}
