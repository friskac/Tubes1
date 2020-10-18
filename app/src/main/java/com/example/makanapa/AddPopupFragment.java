package com.example.makanapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class AddPopupFragment extends DialogFragment {
    private static AddPopupFragment popupFragment;
    private FoodListener listener;
    private Presenter presenter;
    private EditText etMenu;
    private EditText etDes;
    private EditText etBahan;
    private EditText etTag;
    private EditText etLangkah;
    private EditText etLokasi;
    private Button btnAdd;
    private Button btnCancel;

    public AddPopupFragment(){}

    public static AddPopupFragment newInstance(FoodListener foodListener, Presenter presenter){
        if (popupFragment == null){
            popupFragment = new AddPopupFragment();
        }
        popupFragment.listener = foodListener;
        popupFragment.presenter = presenter;
        return popupFragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_popupadd,container,false);
        this.etMenu = view.findViewById(R.id.et_menu);
        this.etDes = view.findViewById(R.id.et_deskripsi);
        this.etBahan = view.findViewById(R.id.et_bahan);
        this.etTag = view.findViewById(R.id.et_tag);
        this.etLangkah = view.findViewById(R.id.et_langkah);
        this.etLokasi = view.findViewById(R.id.et_lokasi);

        this.btnCancel = view.findViewById(R.id.btn_cancel);
        this.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etMenu.setText("");
                etDes.setText("");
                etBahan.setText("");
                etTag.setText("");
                etLangkah.setText("");
                etLokasi.setText("");
                popupFragment.dismiss();
            }
        });
        this.btnAdd = view.findViewById(R.id.btn_add);
        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title, deskripsi, tag, bahan, langkah, lokasi;
                title = etMenu.getText().toString();
                deskripsi = etDes.getText().toString();
                tag = etTag.getText().toString();
                bahan = etBahan.getText().toString();
                langkah = etLangkah.getText().toString();
                lokasi = etLokasi.getText().toString();
                popupFragment.presenter.addFood(title, deskripsi, tag, bahan, langkah, lokasi);
                etMenu.setText("");
                etDes.setText("");
                etBahan.setText("");
                etTag.setText("");
                etLangkah.setText("");
                etLokasi.setText("");
                popupFragment.dismiss();
            }
        });

        return view;
    }
}
