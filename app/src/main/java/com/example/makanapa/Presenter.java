package com.example.makanapa;

public class Presenter {
    public FoodListener listener;
    //init array food

    public Presenter(MainActivity mainActivity){
        this.listener = mainActivity;

        //this.arrayfood = new array list
    }
    public void changePage(int page){
        this.listener.changePage(page);
    }
    public void showPopup(){
        this.listener.showPopup();
    }
    public void closeApplication(){this.listener.closeApplication();}
}
