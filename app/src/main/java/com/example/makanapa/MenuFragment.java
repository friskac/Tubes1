package com.example.makanapa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {
    private static MenuFragment menuFragment;
    private FoodListener listener;
    private FoodListAdapter adapter;
    private Presenter presenter;
    private ListView lv;
    private Button btnAdd;
    private TextView menuTitle;

    private MenuFragment(){

    }
    public static MenuFragment newInstance(FoodListener foodListener, Presenter presenter, FoodListAdapter adapter){
        if (menuFragment == null) {
            menuFragment = new MenuFragment();
        }
        menuFragment.listener = foodListener;
        menuFragment.presenter = presenter;
        menuFragment.adapter = adapter;
        return menuFragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.food_list_item,container,false);

        this.lv = view.findViewById(R.id.list_menu);
        this.menuTitle = view.findViewById(R.id.menu_title);
        this.lv.setAdapter(menuFragment.adapter);
        return view;
    }
}
