package com.glbrt.kisah_kisahalkitab.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

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
    public LiveData<List<KisahAlkitab>> loadAllByIds(long kategori_id);


}
