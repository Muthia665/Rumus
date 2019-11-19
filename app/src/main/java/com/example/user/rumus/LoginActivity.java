package com.example.user.rumus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.rumus.model.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;
    BaseApiService apiService;
    ProgressDialog progressDialog;
    TextView txtRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        txtRegis = findViewById(R.id.txtRegis);
        apiService = ConfigApi.getApiService();

        txtRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Loading .  .  .");
                progressDialog.setCancelable(false);
                progressDialog.setIndeterminate(true);
                progressDialog.setTitle("Login");
                progressDialog.show();

                requestLogin();

            }
        });

//        //jika sudah login maka langsung ke mainActivity
//        if (sharePrefManager.getceksudahLogin()){
//            Intent i = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(i);
//            finish();
//        }

    }


    private void requestLogin() {
        apiService.login(edtUsername.getText().toString(), edtPassword.getText().toString()).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    try {
                        if (response.body().isSukses()) {
                            Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                            Intent i =new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Server is Down", Toast.LENGTH_SHORT).show();
                Log.e("debug", "onFailure : Error = " + t.toString());
                progressDialog.dismiss();
            }
        });
    }
}
