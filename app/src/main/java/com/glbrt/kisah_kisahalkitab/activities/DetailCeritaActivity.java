package com.glbrt.kisah_kisahalkitab.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.glbrt.kisah_kisahalkitab.KategoriKisahViewModel;
import com.glbrt.kisah_kisahalkitab.KisahAlkitabViewModel;
import com.glbrt.kisah_kisahalkitab.KisahAlkitabViewModelFactory;
import com.glbrt.kisah_kisahalkitab.R;
import com.glbrt.kisah_kisahalkitab.StoryNxtPreference;
import com.glbrt.kisah_kisahalkitab.adapter.SlideShowCeritaPagerAdapter;
import com.glbrt.kisah_kisahalkitab.entities.KisahAlkitab;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DetailCeritaActivity extends AppCompatActivity {

    private SlideShowCeritaPagerAdapter slideShowCeritaPagerAdapter;
    private List<KisahAlkitab> kisahAlkitabList = new ArrayList<>();

    private ViewPager viewPager;
    private KisahAlkitabViewModel kisahAlkitabViewModel;

    private int currentPage;

    private StoryNxtPreference storyNxtPreference;

    private boolean firstUse = true;
    private long kisah_kategori_id;

    // AUDIO
//    private ImageView btnPlay, btnPause;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private ImageView btnPlay, btnPause;
    private TextView plyrDurasi, plyrPlayer;
    private SeekBar seekBar;

    private TextView tvSlide;

    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cerita);

        btnPlay = findViewById(R.id.ibtn_play);
        btnPause = findViewById(R.id.ibtn_pause);
        plyrPlayer = findViewById(R.id.player_position);
        plyrDurasi = findViewById(R.id.plyr_duration);
        seekBar = findViewById(R.id.sk_bar);

        tvSlide = findViewById(R.id.tv_slide);

        storyNxtPreference = new StoryNxtPreference(this);

        if (getIntent().getExtras() == null) {
            // dari btnLanjutkan
            kisah_kategori_id = storyNxtPreference.getStoryKategori();
        } else {
            // dari MenuCerita
            kisah_kategori_id = getIntent().getLongExtra("KISAH_KATEGORI_ID", 0);
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

            if (getIntent().getExtras() == null) {
                int lastSeenPage = storyNxtPreference.getStoryPageKisah();
                viewPager.setCurrentItem(lastSeenPage);
                tvSlide.setText(String.format("%01d/%01d", lastSeenPage +1 , kisahAlkitabList.size()));
                prepareAudio(kisahAlkitabList.get(lastSeenPage));
            } else {
                tvSlide.setText(String.format("%01d/%01d", 1, kisahAlkitabList.size()));
                prepareAudio(kisahAlkitabList.get(0));
            }

            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playAudio();
                }
            });

            btnPause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pauseAudio();
                }
            });

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                    if (mediaPlayer != null) {
//
//                    } else {
//                        Toast.makeText(DetailCeritaActivity.this, "mediaplayer null", Toast.LENGTH_SHORT).show();
//                    }
                    if (fromUser) {
                        mediaPlayer.seekTo(progress);
                    }
                    plyrPlayer.setText(convertDurationFormat(mediaPlayer.getCurrentPosition()));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
//                    mediaPlayer.seekTo(seekBar.getProgress());
                }
            });

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    btnPause.setVisibility(View.GONE);
                    btnPlay.setVisibility(View.VISIBLE);
                    mediaPlayer.seekTo(0);
                }
            });

        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                tvSlide.setText(String.format("%01d/%01d", currentPage + 1, kisahAlkitabList.size()));
                storyNxtPreference.setStory(kisah_kategori_id, currentPage);
                btnPlay.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.GONE);
                prepareAudio(kisahAlkitabList.get(currentPage));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler.removeCallbacks(runnable);
//        mediaPlayer.stop();
        mediaPlayer.release();
//        mediaPlayer = null;
    }

    @SuppressLint("DefaultLocale")
    private String convertDurationFormat(int duration) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }

    public void prepareAudio(KisahAlkitab kisahAlkitab) {
        try {
            mediaPlayer.reset();
            System.out.println("nama package: " + getPackageName());
            Uri audioUri = Uri.parse("android.resource://"+ getPackageName() + "/raw/" + kisahAlkitab.getAudio());
            System.out.println("nama uri: " + audioUri.toString());
            mediaPlayer.setDataSource(this, audioUri);
            mediaPlayer.prepare();

        } catch (Exception e) {
            e.printStackTrace();
//            Toast.makeText(DetailCeritaActivity.this, "gagal: " + e.getMessage(),  Toast.LENGTH_SHORT).show();
        }
    }

    public void playAudio() {
        try {
            mediaPlayer.start();
            btnPlay.setVisibility(View.GONE);
            btnPause.setVisibility(View.VISIBLE);

            int duration = mediaPlayer.getDuration();

            String strDuration = convertDurationFormat(duration);
            plyrDurasi.setText(strDuration);
            seekBar.setProgress(mediaPlayer.getCurrentPosition());

            runnable = new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer.isPlaying()) {
                        seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    }
                    handler.postDelayed(this, 500);
                }
            };
            seekBar.setMax(mediaPlayer.getDuration());
            handler = new Handler();
            handler.postDelayed(runnable, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pauseAudio() {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                btnPause.setVisibility(View.GONE);
                btnPlay.setVisibility(View.VISIBLE);
                handler.removeCallbacks(runnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            handler.removeCallbacks(runnable);
            mediaPlayer.release();
        }
    }
}