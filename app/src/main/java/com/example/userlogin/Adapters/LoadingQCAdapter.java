package com.example.userlogin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userlogin.Models.LoadingQCModel;
import com.example.userlogin.R;

import java.util.List;

public class LoadingQCAdapter extends RecyclerView.Adapter<LoadingQCAdapter.Viewholder> {

    List<LoadingQCModel> loadingQCsize ;
    Context context;

    public LoadingQCAdapter(List<LoadingQCModel> loadingQCsize, Context context) {
        this.loadingQCsize = loadingQCsize;
        this.context = context;
    }

    @NonNull
    @Override
    public LoadingQCAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutqc , parent , false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadingQCAdapter.Viewholder holder, int position) {
        LoadingQCModel model = loadingQCsize.get(position);
        holder.qcno.setText(model.getNo());
        holder.qccustomerno.setText(model.getCustomer_No());
        holder.qccustomername.setText(model.getCustomer_Name());
        holder.qctransportername.setText(model.getTransporter_Name());

    }

    @Override
    public int getItemCount() {
        return loadingQCsize.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView qcno , qccustomerno , qccustomername , qctransportername ;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            qcno = itemView.findViewById(R.id.loadingqc_No);
            qccustomerno = itemView.findViewById(R.id.loadingqc_Customer_No);
            qccustomername = itemView.findViewById(R.id.loadingqc_Customer_Name);
            qctransportername = itemView.findViewById(R.id.loadingqc_Transporter_Name);
        }
    }
}
