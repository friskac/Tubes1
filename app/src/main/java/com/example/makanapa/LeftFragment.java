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
    protected Button btnMenu;
    protected Button btnHome;

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
        this.btnMenu= view.findViewById(R.id.btn_menu);
        this.btnHome = view.findViewById(R.id.btn_home);
        this.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftFragment.presenter.changePage(FoodListener.PAGE1, true);
                leftFragment.presenter.closeDrawers();
            }
        });
        this.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftFragment.presenter.changePage(foodListener.PAGE2, true);
                leftFragment.presenter.closeDrawers();
            }
        });

        this.btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftFragment.presenter.closeDrawers();
                leftFragment.presenter.closeApplication();
            }
        });

        return view;
    }
}
