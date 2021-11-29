package com.glbrt.kisah_kisahalkitab.adapter;

import android.content.Context;
import android.media.SoundPool;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.glbrt.kisah_kisahalkitab.R;
import com.glbrt.kisah_kisahalkitab.entities.KategoriKisah;
import com.glbrt.kisah_kisahalkitab.models.ListMainCerita;

import java.util.List;

public class DetailCeritaViewAdapter extends RecyclerView.Adapter<DetailCeritaViewAdapter.ViewHolder> {

    private List<ListMainCerita> mData;
    private Context mContex;

    public DetailCeritaViewAdapter(List<ListMainCerita> mData, Context mContex) {
        this.mData = mData;
        this.mContex = mContex;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContex).inflate(R.layout.list_main_cerita,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListMainCerita listMainCerita = mData.get(position);
        holder.bindTo(listMainCerita);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvNarasi;
        private ImageView ivGambar;
//        private SoundPool audio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNarasi = itemView.findViewById(R.id.tv_judul_cerita);
            ivGambar = itemView.findViewById(R.id.iv_gambar_cerita);
//            audio = itemView.findViewById(R.id.ibtn_play);

            itemView.setOnClickListener(this);
        }

        void bindTo(ListMainCerita listMainCerita) {
            tvNarasi.setText(listMainCerita.getNarasi());
            Glide.with(mContex).load(listMainCerita.getImageResource()).into(ivGambar);
            // audio
//            audio.play(listMainCerita.getAudio(), 100, 100, 1,1,1);

        }

        @Override
        public void onClick(View v) {
        //pindah intent
            //get & set narasi, gambar, audio, idkategori

        }
    }
}
