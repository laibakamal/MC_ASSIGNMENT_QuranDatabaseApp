package com.example.quranappv2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SurahCustomListConfig extends ArrayAdapter<Surah> {
    public SurahCustomListConfig(@NonNull Context context, int resource,
                                 @NonNull List<Surah> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Surah s =  getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.surah_item,parent,
                false);
        TextView id = convertView.findViewById(R.id.textView);
        TextView name = convertView.findViewById(R.id.textView3);
        TextView nazool = convertView.findViewById(R.id.textView2);
        id.setText(s.getId());
        name.setText(s.getNameU());
        nazool.setText(s.getNazool());

        if(position%2==0)
        {
            convertView.setBackgroundColor(Color.rgb(255,193,193));
        }
        else
        {
            convertView.setBackgroundColor(Color.rgb(193, 239, 255));
        }


        return convertView;
    }
}
