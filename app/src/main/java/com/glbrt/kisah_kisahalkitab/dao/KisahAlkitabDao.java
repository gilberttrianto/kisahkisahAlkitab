package com.glbrt.kisah_kisahalkitab.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.glbrt.kisah_kisahalkitab.entities.KategoriKisah;
import com.glbrt.kisah_kisahalkitab.entities.KisahAlkitab;

import java.util.List;

@Dao
public interface KisahAlkitabDao {
    @Transaction
    @Query("SELECT * FROM tb_kisah_alkitab")
    public LiveData<List<KisahAlkitab>> getkategoriKisahAlkitab();

//    @Query("SELECT * FROM tb_kisah_alkitab WHERE kategori_kisah_id = :kategori_id")
//    public LiveData<List<KisahAlkitab>> getKategoriWhereid();

//    @Query("SELECT * FROM tb_kisah_alkitab WHERE kategori_kisah_id = :kategori_id")
//    public LiveData<List<KisahAlkitab>> loadListLiveData(long kategori_id);

    @Query("SELECT * FROM tb_kisah_alkitab WHERE kategori_kisah_id = :kategori_id")
    public LiveData<List<KisahAlkitab>> loadKisahAlkitabByKategoriId(long kategori_id);

    @Query("SELECT * FROM tb_kategori_kisah ORDER BY id_kategori ASC")
    public LiveData<List<KategoriKisah>> loadKategoriKisah();

    @Insert
    void insertAll(KisahAlkitab... kisahAlkitabs);

    @Delete
    void delete(KisahAlkitab... kisahAlkitabs);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertKisahAlkitab(KisahAlkitab... kisahAlkitab);

    @Delete
    void deleteKisahAlkitab(KisahAlkitab kisahAlkitab);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertKategoriKisah(KategoriKisah... kategoriKisah);

    @Delete
    void deleteKategoriKisah(KategoriKisah kategoriKisah);
}
