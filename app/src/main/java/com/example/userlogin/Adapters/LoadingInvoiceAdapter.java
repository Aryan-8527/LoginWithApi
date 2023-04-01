package com.example.userlogin.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userlogin.Loadinglineinvoice;
import com.example.userlogin.Models.LoadingInvoiceModel;
import com.example.userlogin.R;

import java.util.List;

public class LoadingInvoiceAdapter extends RecyclerView.Adapter<LoadingInvoiceAdapter.ViewHolder> {

    List<LoadingInvoiceModel> loadinginvoicemodellist ;
    Context context;

    public LoadingInvoiceAdapter(List<LoadingInvoiceModel> loadinginvoicemodellist, Context context) {
        this.loadinginvoicemodellist = loadinginvoicemodellist;
        this.context = context;
    }

    @NonNull
    @Override
    public LoadingInvoiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutinvoice , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadingInvoiceAdapter.ViewHolder holder, int position) {

        LoadingInvoiceModel model = loadinginvoicemodellist.get(position);
        holder.invoiceno.setText(model.getNo());
        holder.invoicecustomerno.setText(model.getCustomer_No());
        holder.invoicecustomername.setText(model.getCustomer_Name());
        holder.invoicetransportername.setText(model.getTransporter_Name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ino = holder.invoiceno.getText().toString();
                String iCname = holder.invoicecustomername.getText().toString();
                String iCno = holder.invoicecustomerno.getText().toString();

                Intent i = new Intent(context , Loadinglineinvoice.class);
                i.putExtra("invoiceno", ino);
                i.putExtra("invoicecustomername" , iCname);
                i.putExtra("invoicecustomerno" , iCno);
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return loadinginvoicemodellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView invoiceno , invoicecustomerno , invoicecustomername , invoicetransportername ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            invoiceno = itemView.findViewById(R.id.loadinginvoice_No);
            invoicecustomerno = itemView.findViewById(R.id.loadinginvoice_Customer_No);
            invoicecustomername = itemView.findViewById(R.id.loadinginvoice_Customer_Name);
            invoicetransportername = itemView.findViewById(R.id.loadinginvoice_Transporter_Name);
        }
    }
}
