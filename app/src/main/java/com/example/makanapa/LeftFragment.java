package com.example.makanapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LeftFragment extends Fragment {

    private static LeftFragment leftFragment;

    public static LeftFragment newInstance(){
        if (leftFragment==null){
            leftFragment = new LeftFragment();
        }
        return leftFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        return view;
    }
}
