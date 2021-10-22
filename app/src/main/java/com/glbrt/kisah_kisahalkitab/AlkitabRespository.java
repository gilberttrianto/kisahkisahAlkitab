package com.glbrt.kisah_kisahalkitab;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.glbrt.kisah_kisahalkitab.dao.KisahAlkitabDao;
import com.glbrt.kisah_kisahalkitab.entities.KisahAlkitab;

import java.util.List;

public class AlkitabRespository {

    private KisahAlkitabDao kisahAlkitabDao;
    private LiveData<List<KisahAlkitab>> kisahAlkitabList;

    AlkitabRespository(Application application) {
    }
}
