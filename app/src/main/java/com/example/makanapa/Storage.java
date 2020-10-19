package com.example.makanapa;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.LinkedList;
import java.util.List;

public class Storage {
    protected SharedPreferences sharedPreferences;
    protected final static String NAMA_SHARED_PREF = "sp_nilai_display";


    public Storage(Context context){
        this.sharedPreferences = context.getSharedPreferences(NAMA_SHARED_PREF,0);
    }

    public void saveAll(List<Food> listItem){
        SharedPreferences.Editor editor = this.sharedPreferences.edit();

        int size = listItem.size();
        editor.putInt("menu_size", size);

        for(int i = 0; i < size; i++){
            String menu = "menu_" + i;
            String des = "deskripsi_" + i;
            String bahan = "bahan_" + i;
            String tag = "tag_" + i;
            String langkah = "langkah_" + i;
            String lokasi = "lokasi_" + i;

            editor.putString(menu, String.valueOf(listItem.get(i).getTitle()));
            editor.putString(des, String.valueOf(listItem.get(i).getDeskripsi()));
            editor.putString(bahan, String.valueOf(listItem.get(i).getBahan()));
            editor.putString(tag, String.valueOf(listItem.get(i).getTag()));
            editor.putString(langkah, String.valueOf(listItem.get(i).getLangkah()));
            editor.putString(lokasi, String.valueOf(listItem.get(i).getLokasi()));
        }
        editor.commit();
    }

    public List<Food> getMenu(){
        List<Food> list = new LinkedList<>();
        int size = this.sharedPreferences.getInt("menu_size", 0);

        for (int i = 0; i < size; i++){
            String title = this.sharedPreferences.getString("menu_" + i,"");
            String des = this.sharedPreferences.getString("deskripsi_"+i, "");
            String bahan = this.sharedPreferences.getString("bahan_"+i, "");
            String tag = this.sharedPreferences.getString("tag_"+i, "");
            String langkah = this.sharedPreferences.getString("langkah_"+i, "");
            String lokasi = this.sharedPreferences.getString("lokasi_"+i, "");

            Food food = new Food(title, des,tag,bahan,langkah,lokasi);
            list.add(food);
        }
        return list;
    }

}
