package com.glbrt.kisah_kisahalkitab.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_kategori_kisah")
public class KategoriKisah {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_kategori")
    private long id;

    @ColumnInfo(name = "judul")
    private String judul;

    @ColumnInfo(name = "gambar_judul")
    private String gambar_judul;

    public KategoriKisah() {
    }

    public KategoriKisah(String judul, String gambar_judul) {
        this.judul = judul;
        this.gambar_judul = gambar_judul;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar_judul() {
        return gambar_judul;
    }

    public void setGambar_judul(String gambar_judul) {
        this.gambar_judul = gambar_judul;
    }
}
