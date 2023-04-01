package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.userlogin.Adapters.LoadingLineAdapter;
import com.example.userlogin.Models.LoadingLineModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Loadinglineinvoice extends AppCompatActivity {

    TextView invoicenumbers , invoicecustomernames , invoicecustomernos ;
    ImageView invoiceqrscan ;
    TextView invoiceline , invoiceqty ;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadinglineinvoice);

        invoicenumbers = findViewById(R.id.tv_invoiceno);
        invoicecustomernames = findViewById(R.id.tv_invoicecustomername);
        invoicecustomernos = findViewById(R.id.tv_invoicecustomerno);
        invoiceqrscan = findViewById(R.id.img_invoicescanqr);
        invoiceline = findViewById(R.id.tv_invoicelines);
        invoiceqty = findViewById(R.id.tv_invoiceqcqty);

        recyclerView = findViewById(R.id.loadinglineinvoicerecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        String ino = intent.getStringExtra("invoiceno");
        String iCname = intent.getStringExtra("invoicecustomername");
        String iCno = intent.getStringExtra("invoicecustomerno");
        invoicenumbers.setText(ino);
        invoicecustomernames.setText(iCname);
        invoicecustomernos.setText(iCno);

        String yourDocumentNo = ino;

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://103.125.53.126:9222/api/LoadingLines?DocumentNo=" + yourDocumentNo;
        Log.d("Aryan", "onCreate: "+url);

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            List<LoadingLineModel> list = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                String valuelist = String.valueOf(jsonArray.length());
                                invoiceline.setText("Lines: "+valuelist);
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String Description_2 = jsonObject.getString("Description_2");
                                String Length = jsonObject.getString("Length");
                                String Quantity = jsonObject.getString("Quantity");
                                String Loading_Quantity = jsonObject.getString("Loading_Quantity");
                                String Remarks = jsonObject.getString("Remarks");
                                String Peices = jsonObject.getString("Peices");
                                String Pieces = jsonObject.getString("Pieces");

                                LoadingLineModel data = new LoadingLineModel(Description_2, Length, Quantity , Loading_Quantity,Remarks , Peices , Pieces  );
                                list.add(data);
                            }

                            LoadingLineAdapter adapter = new LoadingLineAdapter((ArrayList<LoadingLineModel>) list, Loadinglineinvoice.this);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Loadinglineinvoice.this, "Error to fetch Data", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
}