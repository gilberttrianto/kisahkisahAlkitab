package com.glbrt.kisah_kisahalkitab.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.glbrt.kisah_kisahalkitab.R;

public class MainActivity extends AppCompatActivity {

    // Tombol di menu utama
    private Button btnLanjutkan, btnMenuUtama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLanjutkan = findViewById(R.id.btn_lanjutkan);
        btnMenuUtama = findViewById(R.id.btn_menu_cerita);

        btnMenuUtama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke activity menu cerita
                Intent intentMenucerita = new Intent(MainActivity.this, MenuCeritaActivity.class);
                startActivity(intentMenucerita);
            }
        });
    }
}