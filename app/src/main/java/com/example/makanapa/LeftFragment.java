package com.example.makanapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LeftFragment extends Fragment {

    private static LeftFragment leftFragment;
    private FoodListener foodListener;
    private Presenter presenter;
    protected Button btnExit;

    public static LeftFragment newInstance(FoodListener foodListener, Presenter presenter){
        if (leftFragment==null){
            leftFragment = new LeftFragment();
        }
        leftFragment.foodListener = foodListener;
        leftFragment.presenter = presenter;
        return leftFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        this.btnExit = view.findViewById(R.id.btn_exit);
        this.btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               leftFragment.presenter.closeApplication();
            }
        });

        return view;
    }
}
