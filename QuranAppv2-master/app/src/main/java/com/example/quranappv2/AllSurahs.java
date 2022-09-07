package com.example.quranappv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class AllSurahs extends AppCompatActivity {
    DataBaseHelper myDBHlpr;
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_all_surahs);
        myDBHlpr = new DataBaseHelper(this);
        List<Surah> surahs = myDBHlpr.getSurahs();
        l = findViewById(R.id.recyclerView1);
        SurahCustomListConfig list = new SurahCustomListConfig(this,0,surahs);
        l.setAdapter(list);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(AllSurahs.this, SurahContext.class);
                    intent.putExtra("index", l + "");
                    startActivity(intent);
            }
        });



        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_gallery)
                {
                    Intent intent = new Intent(AllSurahs.this, AllParahs.class);
                    startActivity(intent);
                }

                else if(item.getItemId()==R.id.nav_slideshow)
                {
                    Intent intent = new Intent(AllSurahs.this, AllSurahs.class);
                    startActivity(intent);
                }
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}