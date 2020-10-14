package com.example.makanapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class LobbyFragment extends Fragment {
    private static LobbyFragment lobbyFragment;
    private Presenter presenter;
    private Button btnCari;

    private LobbyFragment(){

    }
    public static LobbyFragment newInstance(Presenter presenter){
        if (lobbyFragment == null){
            lobbyFragment = new LobbyFragment();
        }
        lobbyFragment.presenter = presenter;
        return lobbyFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_lobby,container,false);
        this.btnCari = view.findViewById(R.id.btn_cari);
        this.btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.changePage(FoodListener.PAGE2);
            }
        });
        return view;
    }
}
