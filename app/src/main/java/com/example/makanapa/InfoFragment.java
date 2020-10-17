package com.example.makanapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {
    private static InfoFragment infoFragment;
    private FoodListener foodListener;
    private FoodListAdapter adapter;
    private TextView tvMenu;
    private TextView tvDeskripsi;
    private TextView tvTag;
    private TextView tvBahan;
    private TextView tvLangkah;
    private TextView tvLokasi;

    private InfoFragment(){}

    public static InfoFragment newInstance(){
        if (infoFragment == null) {
            infoFragment = new InfoFragment();
        }
//        infoFragment.foodListener = foodListener;
        return infoFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        this.tvMenu = view.findViewById(R.id.tv_menu);
        this.tvDeskripsi = view.findViewById(R.id.tv_deskripsi);
        this.tvBahan = view.findViewById(R.id.tv_bahan);
        this.tvTag = view.findViewById(R.id.tv_tag);
        this.tvLangkah = view.findViewById(R.id.tv_langkah);
        this.tvLokasi = view.findViewById(R.id.tv_lokasi);

        return view;
    }

    public void setInfo(Food food){
        this.tvMenu.setText(food.getTitle().toString());
        this.tvDeskripsi.setText(food.getDeskripsi().toString());
        this.tvTag.setText(food.getTag().toString());
        this.tvBahan.setText(food.getBahan().toString());
        this.tvLangkah.setText(food.getLangkah().toString());
        this.tvLokasi.setText(food.getLokasi().toString());
    }
}
