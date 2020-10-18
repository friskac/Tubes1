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
    public void addFood(String menu, String des, String bahan, String tag, String langkah, String lokasi){
        Food food = new Food (menu, des, bahan, tag, langkah, lokasi);
        this.listener.addLine(food);
    }

    public void closeApplication(){this.listener.closeApplication();}
}
