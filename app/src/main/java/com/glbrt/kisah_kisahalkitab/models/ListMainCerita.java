package com.glbrt.kisah_kisahalkitab.models;

import android.media.SoundPool;

import com.glbrt.kisah_kisahalkitab.entities.KisahAlkitab;

import java.util.List;

public class ListMainCerita {

    // get data kisah alkitab
    private List<KisahAlkitab> kisahAlkitabs;
    // Narasi
    private String narasi;
    // Gambar
    private int imageResource;
    // id
    private int id;

    private SoundPool audio;

    public ListMainCerita(List<KisahAlkitab> kisahAlkitabs, String narasi, int imageResource, int id, SoundPool audio) {
        this.kisahAlkitabs = kisahAlkitabs;
        this.narasi = narasi;
        this.imageResource = imageResource;
        this.id = id;
        this.audio = audio;
    }

    public List<KisahAlkitab> getKisahAlkitabs() {
        return kisahAlkitabs;
    }

    public void setKisahAlkitabs(List<KisahAlkitab> kisahAlkitabs) {
        this.kisahAlkitabs = kisahAlkitabs;
    }

    public String getNarasi() {
        return narasi;
    }

    public void setNarasi(String narasi) {
        this.narasi = narasi;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SoundPool getAudio() {
        return audio;
    }

    public void setAudio(SoundPool audio) {
        this.audio = audio;
    }
}
