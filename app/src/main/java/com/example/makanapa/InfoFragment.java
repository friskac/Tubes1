package com.example.makanapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InfoFragment extends Fragment {
    private static InfoFragment infoFragment;
    private FoodListener foodListener;
    private Presenter presenter;
    private TextView tvMenu;
    private TextView tvDeskripsi;
    private TextView tvTag;
    private TextView tvBahan;
    private TextView tvLangkah;
    private TextView tvLokasi;
    private Food food;
    private FloatingActionButton btnEdit;

    private InfoFragment(){}

    public static InfoFragment newInstance(FoodListener foodListener, Presenter presenter){
        if (infoFragment == null) {
            infoFragment = new InfoFragment();
        }
        infoFragment.foodListener = foodListener;
        infoFragment.presenter = presenter;
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


        this.btnEdit = view.findViewById(R.id.btn_edit);
        this.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoFragment.presenter.changePage(FoodListener.PAGE4,false);
                infoFragment.presenter.changeMenu(food);
            }
        });

        return view;
    }

    public void resetInfo(){
        this.tvDeskripsi.setText("-");
        this.tvTag.setText("-");
        this.tvBahan.setText("-");
        this.tvLangkah.setText("-");
        this.tvLokasi.setText("Tidak ada");
    }

    public void setInfo(Food food){
        this.resetInfo();
        this.food = food;
        this.tvMenu.setText(food.getTitle().toString());
        if(!food.getDeskripsi().equals("")){
            this.tvDeskripsi.setText(food.getDeskripsi().toString());
        }
        if(!food.getBahan().equals("")){
            this.tvBahan.setText(food.getBahan().toString());
        }
        if(!food.getTag().equals("")){
            this.tvTag.setText(food.getTag().toString());
        }
        if(!food.getLangkah().equals("")){
            this.tvLangkah.setText(food.getLangkah().toString());
        }
        if(!food.getLokasi().equals("")){
            this.tvLokasi.setText(food.getLokasi().toString());
        }
    }
}
