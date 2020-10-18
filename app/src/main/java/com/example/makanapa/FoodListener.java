package com.example.makanapa;

public interface FoodListener {
//    hlm utama
    public static final int PAGE1 = 1;
//    hlm menu
    public static final int PAGE2 = 2;
//    hlm info
    public static final int PAGE3 = 3;
    void changePage(int page, boolean isPop);
    void showPopup();
    void setInfo(Food food);
    void addLine(Food food);
    void closeApplication();
}
