package com.glbrt.kisah_kisahalkitab.models;


public class ListPilihJudulCerita {

    // Judul cerita
    private String title;
    // Gambar judul
    private int imageResource;

    public ListPilihJudulCerita(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }

}
