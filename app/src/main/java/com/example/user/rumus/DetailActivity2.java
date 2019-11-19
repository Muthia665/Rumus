package com.example.user.rumus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity2 extends AppCompatActivity {

    TextView txtJudul, txtIsi;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_2);

        txtJudul = findViewById(R.id.txtdetailjudul);
        txtIsi = findViewById(R.id.txtdetailIsi);
        img = findViewById(R.id.imgDetail);

        Intent a = getIntent();
        String judul = a.getStringExtra("judul");
        int gambar = a.getIntExtra("gambar", 0);
        int isi = a.getIntExtra("isi", 0);

        txtJudul.setText(judul);
        img.setImageResource(gambar);
        txtIsi.setText(isi);
    }
}
