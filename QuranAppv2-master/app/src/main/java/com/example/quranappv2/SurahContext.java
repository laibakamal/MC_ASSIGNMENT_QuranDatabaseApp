package com.example.quranappv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class SurahContext extends AppCompatActivity {
    Store store;
    DataBaseHelper db;
    ListView l;



    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_surah_context);
        store = new Store();
        recyclerView = findViewById(R.id.recyclerView2);
        db = new DataBaseHelper(SurahContext.this);
        ArrayList<Ayat> ayat = db.getAyat();
        ArrayList<Ayat> thisSurahAyat = new ArrayList<>();
        Intent i = getIntent();
        if(i.getExtras() != null) {
            int index = Integer.parseInt(i.getStringExtra("index"));
            index++;
            if(index > 1)
                thisSurahAyat.add(ayat.get(0));
            for (int ind = 0; ind < ayat.size(); ind++) {
                String id = ayat.get(ind).getSuratId();
                int idi = Integer.parseInt(id);
                if (idi == index) {
                    thisSurahAyat.add(ayat.get(ind));
                }
            }
        }




        recyclerView = findViewById(R.id.recyclerView2);


        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(SurahContext.this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AyatRecyclerViewAdapter(thisSurahAyat) ;
        recyclerView.setAdapter(adapter);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_gallery)
                {
                    Intent intent = new Intent(SurahContext.this, AllParahs.class);
                    startActivity(intent);
                }

                else if(item.getItemId()==R.id.nav_slideshow)
                {
                    Intent intent = new Intent(SurahContext.this, AllSurahs.class);
                    startActivity(intent);
                }
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}