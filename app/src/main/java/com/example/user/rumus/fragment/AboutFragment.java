package com.example.user.rumus.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.rumus.AdapterList;
import com.example.user.rumus.DetailActivity;
import com.example.user.rumus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    ListView listView;

    String judul[] = {
            "Persegi", "Persegi Panjang", "Segitiga", "Jajar Genjang", "Trapesium", "Layang - Layang", "Belah Ketupat", "Lingkaran"
    };

    int gambar[] = {
            R.drawable.persegi, R.drawable.persegipanjang, R.drawable.segitiga, R.drawable.jajargenjang, R.drawable.trapesium, R.drawable.layang, R.drawable.belahketupat, R.drawable.lingkarang
    };

    int isi[] = {
            R.string.Persegi, R.string.Persegi_Panjang, R.string.Segitiga, R.string.Jajar_Genjang, R.string.Trapesium, R.string.Layang_layang, R.string.Belah_ketupat, R.string.Lingkaran
    };

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        listView = v.findViewById(R.id.listView);

        AdapterList adapterList = new AdapterList(getActivity(), judul, gambar, isi);
        listView.setAdapter(adapterList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("judul", judul[position]);
                intent.putExtra("gambar", gambar[position]);
                intent.putExtra("isi", isi[position]);

                startActivity(intent);
            }
        });

        return v;
    }

}
