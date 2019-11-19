package com.example.user.rumus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterList extends ArrayAdapter {
    private final Context context;
    private final String[] judul;
    private final int[] gambar;
    private final int[] isi;

    public AdapterList(Context context, String[] judul, int[] gambar, int[] isi) {
        super(context, R.layout.listitem, judul);
        this.context = context;
        this.judul = judul;
        this.gambar = gambar;
        this.isi = isi;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listitem, null, true);
        ImageView img = view.findViewById(R.id.imgItem);
        TextView txt = view.findViewById(R.id.txtItem);

        txt.setText(judul[position]);
        img.setImageResource(gambar[position]);

        return view;
    }
}
