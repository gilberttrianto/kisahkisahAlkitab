package com.glbrt.kisah_kisahalkitab.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import com.glbrt.kisah_kisahalkitab.ItemClickListener;
import com.glbrt.kisah_kisahalkitab.KategoriKisahViewModel;
import com.glbrt.kisah_kisahalkitab.KategoriKisahViewModelFactory;
import com.glbrt.kisah_kisahalkitab.KisahAlkitabViewModel;
import com.glbrt.kisah_kisahalkitab.KisahAlkitabViewModelFactory;
import com.glbrt.kisah_kisahalkitab.R;
import com.glbrt.kisah_kisahalkitab.adapter.MenuCeritaViewAdapter;
import com.glbrt.kisah_kisahalkitab.entities.KategoriKisah;
import com.glbrt.kisah_kisahalkitab.models.ListPilihJudulCerita;

import java.util.ArrayList;
import java.util.List;

public class MenuCeritaActivity extends AppCompatActivity {

    private RecyclerView rvJudulCerita;
    private List<KategoriKisah> mPilihData = new ArrayList<>();
    private MenuCeritaViewAdapter menuCeritaViewAdapter;

    private KategoriKisahViewModel kategoriKisahViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cerita);

        kategoriKisahViewModel = new ViewModelProvider(this, new KategoriKisahViewModelFactory(getApplication()))
                .get(KategoriKisahViewModel.class);
//        kategoriKisahViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance
//                (getApplication())).get(KategoriKisahViewModel.class);



        rvJudulCerita = findViewById(R.id.rv_Storylist);

        // mengatur grid column card view
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

//        rvJudulCerita.setLayoutManager(new LinearLayoutManager(this));
        rvJudulCerita.setLayoutManager(new GridLayoutManager(this,gridColumnCount));
        menuCeritaViewAdapter = new MenuCeritaViewAdapter((ItemClickListener<KategoriKisah>) this::onKategoriKisahItemClick);
        rvJudulCerita.setAdapter(menuCeritaViewAdapter);

        kategoriKisahViewModel.getKategorikisahList().observe(this, kategoriKisahs -> {
            mPilihData = kategoriKisahs;
            menuCeritaViewAdapter.setmData(mPilihData);
        });

//        insertDummyData();
    }

    private void onKategoriKisahItemClick(KategoriKisah kategoriKisah, int i) {
        Intent intent = new Intent(this, DetailCeritaActivity.class);
        intent.putExtra("KISAH_KATEGORI_ID", kategoriKisah.getId());
        startActivity(intent);
    }


    // Masukkan judul & gambar ke menu cerita
//    private void insertDummyData() {
//        String[] judulCeritaList = getResources().getStringArray(R.array.judul_kisah);
//        TypedArray gambarCeritaResource = getResources().obtainTypedArray(R.array.gambar_kisah);
//
//
//        mPilihData.clear();
//
//        // Masukkan gambar & teks ke model ListPilihJudulCerita --> card view --> menuceritaactivity
//        for (int i = 0; i < judulCeritaList.length ; i++) {
//            mPilihData.add(new ListPilihJudulCerita(judulCeritaList[i], gambarCeritaResource.getResourceId(i, 0)));
//        }
//
//        gambarCeritaResource.recycle();
//
//        //update data di adapter
//        menuCeritaViewAdapter.notifyDataSetChanged();
//    }
}