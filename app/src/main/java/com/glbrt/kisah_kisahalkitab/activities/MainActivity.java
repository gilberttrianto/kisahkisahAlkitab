package com.glbrt.kisah_kisahalkitab.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.glbrt.kisah_kisahalkitab.R;
import com.glbrt.kisah_kisahalkitab.StoryNxtPreference;
import com.glbrt.kisah_kisahalkitab.models.ListMainCerita;

public class MainActivity extends AppCompatActivity {

    // Tombol di menu utama
    private Button btnLanjutkan, btnMenuUtama;

    //sharedpreferences
    private ListMainCerita listMainCerita;
    private StoryNxtPreference storyNxtPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLanjutkan = findViewById(R.id.btn_lanjutkan);
        btnMenuUtama = findViewById(R.id.btn_menu_cerita);

        //
        storyNxtPreference = new StoryNxtPreference(this);


        btnMenuUtama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke activity menu cerita
                Intent intentMenucerita = new Intent(MainActivity.this, MenuCeritaActivity.class);
                startActivity(intentMenucerita);
            }
        });

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailCeritaActivity.class);
                TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(MainActivity.this);
                taskStackBuilder.addNextIntentWithParentStack(intent);
                taskStackBuilder.startActivities();
            }
        });

        //cek kodisi ada nilai atau belum dari shrdpreferences
//        private void cekExitingStrPreference() {
//            listMainCerita = storyNxtPreference.getStory();
            //cek kondisi
        }

        // perlu pakai onActifity on result
        // protected void onACtivitiyResulf
//    }

    @Override
    protected void onResume() {
        super.onResume();
        if (storyNxtPreference.getStoryPageKisah() == 0 ) {
            btnLanjutkan.setVisibility(View.GONE);
        } else {
            btnLanjutkan.setVisibility(View.VISIBLE);
        }
    }
}