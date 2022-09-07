package com.example.quranappv2;






import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AyatRecyclerViewAdapter extends RecyclerView.Adapter<AyatRecyclerViewAdapter.MyVH> {

    List<Ayat> friendsList;
    public AyatRecyclerViewAdapter(List<Ayat> friendsList) {
        this.friendsList = friendsList;
    }

    @NonNull
    @Override
    public AyatRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translated_ayat, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AyatRecyclerViewAdapter.MyVH holder, int position) {
        holder.data=friendsList.get(position);
        holder.ayat.setText(holder.data.getArabicText());
        holder.translation.setText(holder.data.getUrduMehmood());
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView ayat;
        TextView translation;
        Ayat data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            ayat = itemView.findViewById(R.id.textView4);
            translation = itemView.findViewById(R.id.textView5);
        }
    }
}





//import android.content.Context;
//import android.graphics.Typeface;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import java.util.List;
//
//public class AyatCustomListConfig extends ArrayAdapter<Ayat> {
//    public AyatCustomListConfig(@NonNull Context context, int resource,
//                                 @NonNull List<Ayat> objects) {
//        super(context, resource, objects);
//    }
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        Ayat s =  getItem(position);
//        convertView = LayoutInflater.from(getContext()).inflate(R.layout.translated_ayat,parent,
//                false);
//        TextView arabic = convertView.findViewById(R.id.textView4);
//        TextView translation = convertView.findViewById(R.id.textView5);
//        arabic.setText(s.getArabicText());
//        translation.setText(s.getUrduFateh());
//        Typeface typeface = Typeface.createFromAsset(
//                getContext().getAssets(),
//                "noorehuda.ttf");
//        Typeface urduface = Typeface.createFromAsset(
//                getContext().getAssets(),
//                "Jameel Noori Nastaleeq.ttf");
//        arabic.setTypeface(typeface);
//        translation.setTypeface(urduface);
//        return convertView;
//    }
//}
