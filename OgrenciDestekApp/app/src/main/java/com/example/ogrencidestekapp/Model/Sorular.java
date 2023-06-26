package com.example.ogrencidestekapp.Model;

public class Sorular {
    private String SorununKonusu;
    private String ImageUrl;

    public Sorular(String sorununKonusu, String imageUrl) {
        SorununKonusu = sorununKonusu;
        ImageUrl = imageUrl;
    }

    public Sorular() {
    }

    public String getSorununKonusu() {
        return SorununKonusu;
    }

    public void setSorununKonusu(String sorununKonusu) {
        SorununKonusu = sorununKonusu;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
