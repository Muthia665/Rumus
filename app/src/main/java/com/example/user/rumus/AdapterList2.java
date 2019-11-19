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

public class AdapterList2 extends ArrayAdapter {
    private final Context context2;
    private final String[] judul2;
    private final int[] gambar2;
    private final int[] isi2;

    public AdapterList2 (Context context, String[] judul2, int[] gambar2, int[] isi2) {
        super(context, R.layout.listitem, judul2);
        this.context2 = context;
        this.judul2 = judul2;
        this.gambar2 = gambar2;
        this.isi2 = isi2;
}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context2.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listitem, null, true);
        ImageView img = view.findViewById(R.id.imgItem);
        TextView txt = view.findViewById(R.id.txtItem);


        txt.setText(judul2[position]);
        img.setImageResource(gambar2[position]);

        return view;
    }
}

