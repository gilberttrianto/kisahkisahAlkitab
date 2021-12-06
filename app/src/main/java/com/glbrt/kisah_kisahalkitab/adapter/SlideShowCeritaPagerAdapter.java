package com.glbrt.kisah_kisahalkitab.adapter;

import android.annotation.SuppressLint;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.glbrt.kisah_kisahalkitab.R;
import com.glbrt.kisah_kisahalkitab.entities.KisahAlkitab;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SlideShowCeritaPagerAdapter extends PagerAdapter {

    private List<KisahAlkitab> kisahAlkitabList = new ArrayList<>();

    private MediaPlayer mediaPlayer;
//    private MediaMetadataRetriever mmr;
    private Handler handler = new Handler();
    private Runnable runnable;

    public SlideShowCeritaPagerAdapter(List<KisahAlkitab> kisahAlkitabList) {
        this.kisahAlkitabList = kisahAlkitabList;
    }

    public void setData(List<KisahAlkitab> kisahAlkitabList) {
        this.kisahAlkitabList = kisahAlkitabList;
        notifyDataSetChanged();
    }

    @SuppressLint("DefaultLocale")
    private String convertDurationFormat (int duration) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration)-
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.list_main_cerita, container, false);

        ImageView ivGambarCerita = view.findViewById(R.id.iv_gambar_cerita);
        TextView tvNarasi = view.findViewById(R.id.tv_narasi);
        ImageView btnPlay = view.findViewById(R.id.ibtn_play);
        ImageView btnPause = view.findViewById(R.id.ibtn_pause);
        SeekBar seekBar = view.findViewById(R.id.sk_bar);
        TextView playerDuration = view.findViewById(R.id.player_duration);
        TextView playerPosition = view.findViewById(R.id.player_position);

        int drawable =
                container.getResources().getIdentifier(kisahAlkitabList.get(position).getGambar(), "drawable",
                        container.getContext().getPackageName());

        Glide.with(container.getContext()).load(drawable).into(ivGambarCerita);

        // image button
        tvNarasi.setText(kisahAlkitabList.get(position).getNarasi());

        mediaPlayer = MediaPlayer.create(container.getContext(), R.raw.ac11);
//        handler = new Handler();
//        mmr = new MediaMetadataRetriever();
        runnable = new Runnable() {
            @Override
            public void run() {
//                System.out.println("testing runnabel");
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this, 500);
            }
        };

        int duration = mediaPlayer.getDuration();

//        int current_pos = mediaPlayer.getCurrentPosition();

        String strDuration = convertDurationFormat(duration);
        playerDuration.setText(strDuration);
//        int minDuration = duration - mediaPlayer.getCurrentPosition();
//        playerPosition.setText(current_pos);
//        playerPosition.setText(convertDurationFormat(current_pos));
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
//        playerDuration.setText(strDuration);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide play button
                btnPlay.setVisibility(View.GONE);
                //show pause button
                btnPause.setVisibility(View.VISIBLE);
                //start media player
                mediaPlayer.start();
                //seek bar
                seekBar.setMax(mediaPlayer.getDuration());
                handler.postDelayed(runnable,0);
//                System.out.println("testing play");
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide pause button
                btnPause.setVisibility(View.GONE);
                //show play button
                btnPlay.setVisibility(View.VISIBLE);
                //pause media player
                mediaPlayer.pause();
                handler.removeCallbacks(runnable);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
//                playerPosition.setText(convertDurationFormat(mediaPlayer.getCurrentPosition()));
                playerPosition.setText(convertDurationFormat(mediaPlayer.getCurrentPosition()));
                System.out.println("testing seekbar");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btnPause.setVisibility(View.GONE);
                btnPlay.setVisibility(View.VISIBLE);
                mediaPlayer.seekTo(0);
//                System.out.println("testing complete");
            }
        });

        container.addView(view);

        return view;
    }



//    @SuppressLint("DefaultLocale")
//    private String convertFormat (int duration) {
//        return String.format("%02d:%02d"
//                , TimeUnit.MILLISECONDS.toMinutes(duration)
//                , TimeUnit.MILLISECONDS.toSeconds(duration) -
//                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
//    }

//    public String timerConversion(long value) {
//        String audioTime;
//        int dur = (int) value;
//        int hrs = (dur / 3600000);
//        int mns = (dur / 60000) % 60000;
//        int scs = dur % 60000 / 1000;
//
//        if (hrs > 0) {
//            audioTime = String.format("%02d:%02d:%02d", hrs, mns, scs);
//        } else {
//            audioTime = String.format("%02d:%02d", mns, scs);
//        }
//        return audioTime;
//    }

    @Override
    public int getCount() {
        return kisahAlkitabList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        handler.removeCallbacks(runnable);
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

}
