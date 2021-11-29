package com.glbrt.kisah_kisahalkitab;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class KisahAlkitabViewModelFactory implements ViewModelProvider.Factory {
    private Application application;
    private long kategori_id;

    public KisahAlkitabViewModelFactory(Application application, long kategori_id) {
        this.application = application;
        this.kategori_id = kategori_id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new KisahAlkitabViewModel(application, kategori_id) ;
    }
}
