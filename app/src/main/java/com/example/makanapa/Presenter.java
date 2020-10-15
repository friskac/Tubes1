package com.example.makanapa;

public class Presenter {
    public FoodListener listener;

    public Presenter(MainActivity mainActivity){
        this.listener = mainActivity;
    }
    public void changePage(int page){
        this.listener.changePage(page);
    }
    public void closeApplication(){this.listener.closeApplication();}
}
