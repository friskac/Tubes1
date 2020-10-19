package com.example.makanapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class EditFragment extends Fragment {
    private static EditFragment editFragment;
    private FoodListener listener;
    private Presenter presenter;
    private EditText editMenu;
    private EditText editDes;
    private EditText editBahan;
    private EditText editTag;
    private EditText editLangkah;
    private EditText editLokasi;
    private Button btnSave;
    private Food food;

    private EditFragment(){}

    public static EditFragment newInstance(FoodListener listener, Presenter presenter){
        if (editFragment== null){
            editFragment = new EditFragment();
        }
        editFragment.listener = listener;
        editFragment.presenter = presenter;
        return editFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        this.editMenu = view.findViewById(R.id.edit_menu);
        this.editDes = view.findViewById(R.id.edit_deskripsi);
        this.editBahan = view.findViewById(R.id.edit_bahan);
        this.editTag = view.findViewById(R.id.edit_tag);
        this.editLangkah = view.findViewById(R.id.edit_langkah);
        this.editLokasi = view.findViewById(R.id.edit_lokasi);
        this.btnSave = view.findViewById(R.id.btn_save);
        this.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String menu = editMenu.getText().toString();
                String des = editDes.getText().toString();
                String bahan = editBahan.getText().toString();
                String tag = editTag.getText().toString();
                String langkah = editLangkah.getText().toString();
                String lokasi = editLokasi.getText().toString();
                food.setTitle(menu);
                food.setDeskripsi(des);
                food.setBahan(bahan);
                food.setTag(tag);
                food.setLangkah(langkah);
                food.setLokasi(lokasi);
                editFragment.presenter.changePage(FoodListener.PAGE2, false);
            }
        });

        return view;
    }

    public void resetInfo(){
        this.editMenu.setText("");
        this.editDes.setText("");
        this.editBahan.setText("");
        this.editTag.setText("");
        this.editLangkah.setText("");
        this.editLokasi.setText("");
    }

    public void setMenu(Food food){
        this.resetInfo();
        this.food = food;
        if (!food.getTitle().equals("")){
            this.editMenu.setText(food.getTitle().toString());
        }
        if(!food.getDeskripsi().equals("")){
            this.editDes.setText(food.getDeskripsi().toString());
        }
        if(!food.getBahan().equals("")){
            this.editBahan.setText(food.getBahan().toString());
        }
        if(!food.getTag().equals("")){
            this.editTag.setText(food.getTag().toString());
        }
        if(!food.getLangkah().equals("")){
            this.editLangkah.setText(food.getLangkah().toString());
        }
        if(!food.getLokasi().equals("")){
            this.editLokasi.setText(food.getLokasi().toString());
        }
    }
}
