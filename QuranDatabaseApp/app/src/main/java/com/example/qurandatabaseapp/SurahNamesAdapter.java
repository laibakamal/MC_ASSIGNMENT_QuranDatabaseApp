package com.example.qurandatabaseapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SurahNamesAdapter extends ArrayAdapter<Tsurah>  {

    public SurahNamesAdapter(@NonNull Context context, ArrayList<Tsurah> surah) {
        super(context, 0, surah);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Tsurah myclass = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.surah, parent, false);
        TextView no = convertView.findViewById(R.id.num);
        no.setText(String.valueOf( myclass.getSurahID()));

        TextView surahNameE = convertView.findViewById(R.id.nameE);
        surahNameE.setText( myclass.getSurahNameE());

        TextView surahNameU = convertView.findViewById(R.id.nameU);
        surahNameU.setText( myclass.getSurahNameU());
        TextView nazool = convertView.findViewById(R.id.nazool);
        nazool.setText( myclass.getNazool());

        return convertView;
    }
}