package com.example.makanapa;

import java.util.Stack;

public class Presenter {
    public FoodListener listener;

    public Presenter(MainActivity mainActivity){
        this.listener = mainActivity;
    }
    public void changePage(int page, boolean isPop){
        this.listener.changePage(page, isPop);
    }
    public void showPopup(){
        this.listener.showPopup();
    }
    public void setInfo(Food food){
        System.out.println(food.getBahan());
        this.listener.setInfo(food);
    }
    public void closeApplication(){this.listener.closeApplication();}
}
