package com.example.qurandatabaseapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SurahNames extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surah_names);

        ListView AllSurahList = findViewById(R.id.surahListView);
        DBHelper dbHelper  = new DBHelper(SurahNames.this);

        dbHelper.getAllSurah();
        ArrayList<Tsurah> list = dbHelper.getAllSurah();
        //Log.d("nameOFSurah", list.get(2).getSurahNameE()+"\taaaaaaaaaaaaaaaaaaaaaaaaaa");
        SurahNamesAdapter arrayAdapter = new SurahNamesAdapter (this,list);


        AllSurahList.setAdapter(arrayAdapter);

        AllSurahList.setOnItemClickListener((adapterView, view, i, l) -> {
            DBHelper dbHelper1 = new DBHelper(SurahNames.this);
            Tsurah s= (Tsurah) adapterView.getItemAtPosition(i);
        });
    }
}
