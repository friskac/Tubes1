package com.example.makanapa;

public class Menu {
    public static String[] foodStringArr = { "Nasi Goreng Biasa", "Nasi Goreng Telor", "Nasi Goreng Ayam",
             };
    public static Food[] foodObjectArr = {
            new Food("Ayam Goreng", "Makanan Indonesia", "Indonesia",
                    "Ayam, bawang putih, tepung terigu, minyak goreng, garam","1. Panaskan minyak di api kecil\n2. masukkan bawang putih",
                    "rumah makan sunda"),
            new Food("Nasi Goreng", "makanan Indonesia", "Indonesia", "Minyak secukupnya, Nasi, telur, kecap, bawang putih, cabai, garam",
                    "Masak bawang menggunakan minyak dengan api kecil sampai kecoklatan", "warung makan")
    };
}
