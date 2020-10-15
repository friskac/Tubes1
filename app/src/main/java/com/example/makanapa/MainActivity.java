package com.example.makanapa;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FoodListener{

    private Presenter presenter;
    private FragmentManager fragmentManager;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private LeftFragment leftFragment;
    private MenuFragment menuFragment;
    private FoodListAdapter adapter;
    private LobbyFragment lobbyFragment;
    private Button btnCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.presenter = new Presenter(this);
        this.adapter = new FoodListAdapter(this,this.presenter,this);
        this.lobbyFragment = LobbyFragment.newInstance(this.presenter);
        this.menuFragment = MenuFragment.newInstance(this,presenter, adapter);
        this.fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, this.lobbyFragment).commit();
        this.leftFragment = LeftFragment.newInstance(this,presenter);

        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.openDrawer, R.string.closeDrawer);
        drawer.addDrawerListener(abdt);
        abdt.syncState();

        this.btnCari = this.findViewById(R.id.btn_cari);
    }

    @Override
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if (page == FoodListener.PAGE1){
            if (this.lobbyFragment.isAdded()){
                ft.show(this.lobbyFragment);
            }
            else{
                ft.add(R.id.fragment_container,this.lobbyFragment);
            }
            if (this.menuFragment.isAdded()){
                ft.hide(this.menuFragment);
            }
        }
        else if (page == FoodListener.PAGE2){
            if (this.menuFragment.isAdded()){
                ft.show(this.menuFragment);
            }
            else{
                ft.add(R.id.fragment_container,this.menuFragment).addToBackStack(null);
            }
            if (this.lobbyFragment.isAdded()) {
                ft.hide(this.lobbyFragment);
            }
        }
        ft.commit();
    }
   @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }
}