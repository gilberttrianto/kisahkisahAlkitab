package com.glbrt.kisah_kisahalkitab;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.glbrt.kisah_kisahalkitab.dao.KisahAlkitabDao;
import com.glbrt.kisah_kisahalkitab.entities.KategoriKisah;
import com.glbrt.kisah_kisahalkitab.entities.KisahAlkitab;

import java.util.List;

public class AlkitabRespository {

    private KisahAlkitabDao kisahAlkitabDao;
    private LiveData<List<KategoriKisah>> kategoriKisahList;
    private LiveData<List<KisahAlkitab>> kisahAlkitabList;

    public LiveData<List<KategoriKisah>> getKategoriKisahList() {
        return kategoriKisahList;
    }

    public LiveData<List<KisahAlkitab>> getKisahAlkitabList() {
        return kisahAlkitabList;
    }

    AlkitabRespository(Application application) {
        KisahAlkitabDatabase kisahAlkitabDatabase = KisahAlkitabDatabase.getDatabase(application);
        kisahAlkitabDao = kisahAlkitabDatabase.kisahAlkitabDao();

        kategoriKisahList = kisahAlkitabDao.loadKategoriKisah();

    }

    AlkitabRespository(Application application, long kategori_id) {
        KisahAlkitabDatabase kisahAlkitabDatabase = KisahAlkitabDatabase.getDatabase(application);
        kisahAlkitabDao = kisahAlkitabDatabase.kisahAlkitabDao();

        kisahAlkitabList = kisahAlkitabDao.loadKisahAlkitabByKategoriId(kategori_id);

    }
}
