package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MainActivity extends AppCompatActivity {

    EditText USERID , PASSWORD ;
    Button LOGIN ;

    Datamodel datamodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USERID = findViewById(R.id.ed_userid);
        PASSWORD = findViewById(R.id.ed_password);
        LOGIN = findViewById(R.id.bt_login);

        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = USERID.getText().toString();
                String pass = PASSWORD.getText().toString();
                if (user.isEmpty() || user.length()<2) {
                    USERID.setError("userid greter than 2");
                }
                if (pass.isEmpty() || pass.length()<6) {
                    PASSWORD.setError("password fill & greter than 6");
                }

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "http://103.125.53.126:9222/api/LoadingList?userid="+user+"&password="+pass;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject obj = new JSONObject(response);
                                    String status = obj.getString("TotalQuantity");
                                    if (status.equals("0.0")) {
                                        String message = obj.getString("Result");
                                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                                    } else if (status.equals("False")) {
                                        SharedPreferences sp = getSharedPreferences("credentials", MODE_PRIVATE);

                                        String userid = datamodel.getUserid();
                                        String password = datamodel.getPassword();
                                        SharedPreferences.Editor editor = sp.edit();
                                        editor.putString("userid", userid);
                                        editor.putString("password", password);
                                        editor.commit();
                                        Intent i = new Intent(MainActivity.this, MainActivity2.class);
                                        startActivity(i);
                                        finish();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                queue.add(stringRequest);
            }
        });
    }
    }
