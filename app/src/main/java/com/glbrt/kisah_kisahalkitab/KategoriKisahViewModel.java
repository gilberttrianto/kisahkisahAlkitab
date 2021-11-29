package com.glbrt.kisah_kisahalkitab;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.glbrt.kisah_kisahalkitab.entities.KategoriKisah;

import java.util.List;

public class KategoriKisahViewModel extends AndroidViewModel {

    private AlkitabRespository alkitabRespository;
    private final LiveData<List<KategoriKisah>> kategorikisahList;

    public KategoriKisahViewModel(@NonNull Application application) {
        super(application);

        alkitabRespository = new AlkitabRespository(application);
        kategorikisahList = alkitabRespository.getKategoriKisahList();

    }

    public LiveData<List<KategoriKisah>> getKategorikisahList() {
        return kategorikisahList;
    }
}
