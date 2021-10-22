package com.glbrt.kisah_kisahalkitab;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.glbrt.kisah_kisahalkitab.entities.KisahAlkitab;

import java.util.List;

public class KisahAlkitabViewModel extends AndroidViewModel {

    private AlkitabRespository alkitabRespository;
//    private final LiveData<List<KisahAlkitab>> kisahAlkitabList;

    public KisahAlkitabViewModel(@NonNull Application application) {
        super(application);

        alkitabRespository = new AlkitabRespository(application);
//        kisahAlkitabList = alkitabRespository.
    }

}
