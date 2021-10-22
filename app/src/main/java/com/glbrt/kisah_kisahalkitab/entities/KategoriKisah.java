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

    public KategoriKisah() {
    }

    public KategoriKisah(String judul) {
        this.judul = judul;
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
}
