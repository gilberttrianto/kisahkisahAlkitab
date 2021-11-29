package com.glbrt.kisah_kisahalkitab.entities;

import static androidx.room.ForeignKey.CASCADE;
import static androidx.room.ForeignKey.NO_ACTION;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;

@Entity(tableName = "tb_kisah_alkitab",
    foreignKeys =
            @ForeignKey(entity = KategoriKisah.class,
                    parentColumns = "id_kategori",
                    childColumns = "kategori_kisah_id",
                    onUpdate = CASCADE,
                    onDelete = NO_ACTION)
    )
public class KisahAlkitab{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_kisah")
    private long id;

    @ColumnInfo(name = "gambar")
    private String gambar;

    @ColumnInfo(name = "narasi")
    private String narasi;

    @ColumnInfo(name = "audio")
    private String audio;

    @ColumnInfo(name = "kategori_kisah_id")
    private long kategori_kisah_id;

//    private long kategori_kisah_id;


    // Relasi antar table
//    @Embedded
//    public KategoriKisah kategoriKisah;
//    @Relation(
//            parentColumn = "id_kategori",
//            entityColumn = "kategori_kisah_id"
//    )

//    public List<KisahAlkitab> kisahAlkitabs;

    public KisahAlkitab() {

    }

    public KisahAlkitab(String gambar, String narasi, String audio, long kategori_kisah_id) {
        this.gambar = gambar;
        this.narasi = narasi;
        this.audio = audio;
        this.kategori_kisah_id = kategori_kisah_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNarasi() {
        return narasi;
    }

    public void setNarasi(String narasi) {
        this.narasi = narasi;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public long getKategori_kisah_id() {
        return kategori_kisah_id;
    }

    public void setKategori_kisah_id(long kategori_kisah_id) {
        this.kategori_kisah_id = kategori_kisah_id;
    }
}
