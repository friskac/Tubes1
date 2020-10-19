package com.example.makanapa;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements FoodListener{

    private Presenter presenter;
    private FragmentManager fragmentManager;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private LeftFragment leftFragment;
    private MenuFragment menuFragment;
    private AddPopupFragment addPopupFragment;
    private FoodListAdapter adapter;
    private LobbyFragment lobbyFragment;
    private InfoFragment infoFragment;
    private EditFragment editFragment;
    private Stack<Integer> state;
    private int lastState;
    private Storage storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.storage = new Storage(this);
        this.state = new Stack<>();
        this.presenter = new Presenter(this);
        this.adapter = new FoodListAdapter(this,this.presenter,this);
        this.lobbyFragment = LobbyFragment.newInstance(this.presenter);
        this.menuFragment = MenuFragment.newInstance(this,presenter, adapter);
        this.infoFragment = InfoFragment.newInstance(this, this.presenter);
        this.editFragment = EditFragment.newInstance(this,this.presenter);
        this.addPopupFragment = AddPopupFragment.newInstance(this, this.presenter);
        this.fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, this.infoFragment);
        ft.hide(this.infoFragment);
        ft.add(R.id.fragment_container,this.editFragment);
        ft.hide(this.editFragment);
        ft.add(R.id.fragment_container, this.lobbyFragment).commit();
        this.leftFragment = LeftFragment.newInstance(this,presenter);

        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.openDrawer, R.string.closeDrawer);
        drawer.addDrawerListener(abdt);
        abdt.syncState();

        this.lastState = FoodListener.PAGE1;

    }

    @Override
    public void changePage(int page, boolean isPop) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(this.lastState != page && !isPop){
            this.state.push(this.lastState);
        }
        this.lastState = page;
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
            if (this.infoFragment.isAdded()) {
                ft.hide(this.infoFragment);
            }
            if (this.editFragment.isAdded()){
                ft.hide(this.editFragment);
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
            if (this.infoFragment.isAdded()) {
                ft.hide(this.infoFragment);
            }
            if (this.editFragment.isAdded()){
                ft.hide(this.editFragment);
            }
        }
        else if (page == FoodListener.PAGE3){
            if (this.infoFragment.isAdded()){
                ft.show(this.infoFragment);
            }
            else{
                ft.add(R.id.fragment_container,this.infoFragment).addToBackStack(null);
            }
            if (this.menuFragment.isAdded()) {
                ft.hide(this.menuFragment);
            }
            if (this.lobbyFragment.isAdded()){
                ft.hide(this.lobbyFragment);
            }
            if (this.editFragment.isAdded()){
                ft.hide(this.editFragment);
            }
        }
        else if (page == FoodListener.PAGE4){
            if (this.editFragment.isAdded()){
                ft.show(this.editFragment);
            }
            else{
                ft.add(R.id.fragment_container,this.editFragment).addToBackStack(null);
            }
            if (this.menuFragment.isAdded()) {
                ft.hide(this.menuFragment);
            }
            if (this.lobbyFragment.isAdded()){
                ft.hide(this.lobbyFragment);
            }
            if (this.infoFragment.isAdded()){
                ft.hide(this.infoFragment);
            }
        }
        ft.commit();
    }

    @Override
    public void showPopup() {
        this.addPopupFragment.show(fragmentManager,"");
    }

    @Override
    public void addLine(Food food) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        this.menuFragment.addLine(food);
        ft.commit();
    }

    @Override
    public void setInfo(Food food) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        this.infoFragment.setInfo(food);
        ft.commit();
    }

    @Override
    public void changeMenu(Food food) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        this.editFragment.setMenu(food);
        ft.commit();
    }


    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        if(!this.state.isEmpty()){
            changePage(this.state.pop(), true);
        }
        else {
            closeApplication();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.storage.saveAll(this.adapter.listItem);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(this.storage.getMenu().size() != 0) {
            this.adapter.listItem = this.storage.getMenu();
        }
    }
}