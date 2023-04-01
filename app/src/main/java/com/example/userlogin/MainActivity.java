package com.example.userlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    public EditText USERID , PASSWORD ;
    Button LOGIN ;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USERID = findViewById(R.id.ed_userid);
        PASSWORD = findViewById(R.id.ed_password);
        LOGIN = findViewById(R.id.bt_login);
        progressbar = findViewById(R.id.ProgressBar);

        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (USERID.getText().toString().isEmpty() || PASSWORD.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "UserId & Password not be Null !!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    checking(USERID.getText().toString() , PASSWORD.getText().toString());
                    progressbar.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void checking(String user , String pass  ) {
        USERID.setText(user);
        PASSWORD.setText(pass);

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://103.125.53.126:9222/api/LoadingList?userid=" + user + "&password=" + pass;


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            String status = obj.getString("Result");

                            if (status.equals("True")) {
                                SharedPreferences sp = getSharedPreferences("credentials", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sp.edit();
                                editor.commit();
                                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                                progressbar.setVisibility(View.GONE);
                                Toast.makeText(MainActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                                startActivity(i);
                            } else {
                                Toast.makeText(MainActivity.this, "Incorrect Userid & Password !! ", Toast.LENGTH_SHORT).show();
                                progressbar.setVisibility(View.GONE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override

            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Please Connect Internet", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }
}

