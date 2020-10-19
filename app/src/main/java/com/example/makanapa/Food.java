package com.example.makanapa;

public class Food {
    protected String title;
    protected String deskripsi;
    protected String tag;
    protected String bahan;
    protected String langkah;
    protected String lokasi;
    protected boolean isFavourite;

    public Food(String title, String des, String tag, String bahan, String langkah, String lokasi ){
        this.title = title;
        this.deskripsi = des;
        this.tag = tag;
        this.bahan = bahan;
        this.langkah = langkah;
        this.lokasi = lokasi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String des) {
        this.deskripsi = des;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String b) {
        this.bahan = b;
    }

    public String getLangkah() {
        return langkah;
    }

    public void setLangkah(String l) {
        this.langkah = l;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String l) {
        this.lokasi = l;
    }

}
