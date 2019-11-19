package com.example.user.rumus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.rumus.model.ResponseRegis;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText Edtnama, Edtusername, Edtpassword;
    Button Btnregister;
    ProgressDialog ProgressDialog;
    TextView Txtlogin;

    BaseApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Edtnama = findViewById(R.id.edtnama);
        Edtusername = findViewById(R.id.edtUsername);
        Edtpassword = findViewById(R.id.edtPassword);
        Btnregister = findViewById(R.id.btnRegister);

        Txtlogin = findViewById(R.id.txtLogin);

        Txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        apiService = ConfigApi.getApiService();

        Btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog = new ProgressDialog(RegisterActivity.this);
                ProgressDialog.setTitle("Register");
                ProgressDialog.setMessage("Loading . . .");
                ProgressDialog.setCancelable(false);
                ProgressDialog.show();

                requestRegister();
            }
        });
    }

    private void requestRegister() {
        apiService.register(Edtnama.getText().toString(), Edtusername.getText().toString(), Edtpassword.getText().toString()).enqueue(new Callback<ResponseRegis>() {
            @Override
            public void onResponse(Call<ResponseRegis> call, Response<ResponseRegis> response) {
                if (response.isSuccessful()){
                    Log.i("debug", "onResponse : BERHASIL");
                    ProgressDialog.dismiss();
                    try{
                        if (response.body().isSukses()) {
                            Toast.makeText(RegisterActivity.this, response.body().getPesan(), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, response.body().getPesan(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.i("debug", "onResponse : GAGAL");
                    ProgressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegis> call, Throwable t) {
                Log.e("debug", "onFailure : ERROR = " + t.getMessage());
                Toast.makeText(RegisterActivity.this, "Server is Down, Check the Internet Connection !", Toast.LENGTH_SHORT).show();
                ProgressDialog.dismiss();
            }
        });
    }
}
