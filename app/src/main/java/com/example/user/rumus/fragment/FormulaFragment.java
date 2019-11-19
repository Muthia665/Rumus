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
import com.example.user.rumus.AdapterList2;
import com.example.user.rumus.DetailActivity;
import com.example.user.rumus.DetailActivity2;
import com.example.user.rumus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormulaFragment extends Fragment {

    ListView listViewF;

    String judul2[] = {
            "Persegi", "Persegi Panjang", "Segitiga", "Jajar Genjang", "Trapesium", "Layang-Layang", "Belah Ketupat", "Lingkaran"
    };

    int gambar2[] = {
            R.drawable.persegi, R.drawable.persegipanjang, R.drawable.segitiga, R.drawable.jajargenjang, R.drawable.trapesium, R.drawable.layang, R.drawable.belahketupat, R.drawable.lingkarang
    };

    int isi2[] = {
            R.string.Persegi2, R.string.Persegi_Panjang_2, R.string.Segitiga_2, R.string.Jajar_Genjang_2, R.string.Trapesium_2, R.string.Layang_Layang_2, R.string.Belah_Ketupat_2, R.string.Lingkaran_2
    };

    public FormulaFragment() {
        // don't type anything here!
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_formula, container, false);
        listViewF = v.findViewById(R.id.listViewF);

        AdapterList2 adapterList2 = new AdapterList2(getActivity(), judul2, gambar2, isi2);
        listViewF.setAdapter(adapterList2);

        listViewF.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity2.class);
                intent.putExtra("judul", judul2[position]);
                intent.putExtra("gambar", gambar2[position]);
                intent.putExtra("isi", isi2[position]);

                startActivity(intent);
            }
        });

        return v;
    }

}