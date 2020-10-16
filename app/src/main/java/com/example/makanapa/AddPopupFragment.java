package com.example.makanapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

public class AddPopupFragment extends DialogFragment {
    private static AddPopupFragment popupFragment;
    private FoodListener listener;

    public AddPopupFragment(){}

    public static AddPopupFragment newInstance(FoodListener foodListener){
        if (popupFragment == null){
            popupFragment = new AddPopupFragment();
        }
        popupFragment.listener = foodListener;
        return popupFragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_popupadd,container,false);
        return view;
    }
}
