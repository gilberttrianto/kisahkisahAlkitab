package com.glbrt.kisah_kisahalkitab;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class KategoriKisahViewModelFactory implements ViewModelProvider.Factory {
    private Application application;

    public KategoriKisahViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new KategoriKisahViewModel(application);
    }
}
