package com.example.makanapa;

public interface FoodListener {
//    hlm utama
    public static final int PAGE1 = 1;
//    hlm menu
    public static final int PAGE2 = 2;
    void changePage(int page);
    void showPopup();
    void closeApplication();
}
