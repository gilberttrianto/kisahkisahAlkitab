package com.glbrt.kisah_kisahalkitab.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.glbrt.kisah_kisahalkitab.KategoriKisahViewModel;
import com.glbrt.kisah_kisahalkitab.KisahAlkitabViewModel;
import com.glbrt.kisah_kisahalkitab.KisahAlkitabViewModelFactory;
import com.glbrt.kisah_kisahalkitab.R;
import com.glbrt.kisah_kisahalkitab.StoryNxtPreference;
import com.glbrt.kisah_kisahalkitab.adapter.SlideShowCeritaPagerAdapter;
import com.glbrt.kisah_kisahalkitab.entities.KisahAlkitab;

import java.util.ArrayList;
import java.util.List;

public class DetailCeritaActivity extends AppCompatActivity {

    private SlideShowCeritaPagerAdapter slideShowCeritaPagerAdapter;
    private List<KisahAlkitab> kisahAlkitabList = new ArrayList<>();

    private ViewPager viewPager;
    private KisahAlkitabViewModel kisahAlkitabViewModel;

    private int currentPage;

    private StoryNxtPreference storyNxtPreference;

    private boolean firstUse = true;
    private long kisah_kategori_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cerita);

        storyNxtPreference = new StoryNxtPreference(this);

        if (getIntent().getExtras() == null ) {
            // dari btnLanjutkan
            kisah_kategori_id = storyNxtPreference.getStoryKategori();
        } else {
            // dari MenuCerita
            kisah_kategori_id = getIntent().getLongExtra("KISAH_KATEGORI_ID",0);
        }

        kisahAlkitabViewModel = new ViewModelProvider(this, new KisahAlkitabViewModelFactory(getApplication(),
                kisah_kategori_id)).get(KisahAlkitabViewModel.class);
//        kisahAlkitabViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance
//                (getApplication())).get(KisahAlkitabViewModel.class);

        viewPager = findViewById(R.id.view_pager_cerita);

        slideShowCeritaPagerAdapter = new SlideShowCeritaPagerAdapter(kisahAlkitabList);
        viewPager.setAdapter(slideShowCeritaPagerAdapter);

        kisahAlkitabViewModel.getKisahAlkitabList().observe(this, kisahAlkitabs -> {
            kisahAlkitabList = kisahAlkitabs;
            slideShowCeritaPagerAdapter.setData(kisahAlkitabList);

            if (getIntent().getExtras() == null ) {
                int lastSeenPage = storyNxtPreference.getStoryPageKisah();
//                System.out.println("Dari btnLanjutkan:" + lastSeenPage);
                viewPager.setCurrentItem(lastSeenPage);
            }

        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                storyNxtPreference.setStory(kisah_kategori_id, currentPage);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        currentPage = viewPager.getCurrentItem();
//        System.out.println("Current Page:" + currentPage);
//
//        storyNxtPreference.setStory(kisah_kategori_id, currentPage);
//    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//
//    }
}