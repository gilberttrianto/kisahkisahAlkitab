package com.glbrt.kisah_kisahalkitab.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.glbrt.kisah_kisahalkitab.ItemClickListener;
import com.glbrt.kisah_kisahalkitab.R;
import com.glbrt.kisah_kisahalkitab.activities.DetailCeritaActivity;
import com.glbrt.kisah_kisahalkitab.activities.MenuCeritaActivity;
import com.glbrt.kisah_kisahalkitab.entities.KategoriKisah;
import com.glbrt.kisah_kisahalkitab.models.ListPilihJudulCerita;

import java.util.ArrayList;
import java.util.List;

public class MenuCeritaViewAdapter extends RecyclerView.Adapter<MenuCeritaViewAdapter.ViewHolder> {

    private List<KategoriKisah> mData = new ArrayList<>();
    private ItemClickListener<KategoriKisah> itemClickListener;

    public MenuCeritaViewAdapter(ItemClickListener<KategoriKisah> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setmData(List<KategoriKisah> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MenuCeritaViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // View adapter --> listView card
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pilihan_cerita, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KategoriKisah kategoriKisah = mData.get(position);
        holder.bindTo(kategoriKisah);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvJudulCerita;
        private ImageView ivGambarJudul;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJudulCerita = itemView.findViewById(R.id.tv_judul_cerita);
            ivGambarJudul = itemView.findViewById(R.id.iv_gambar_judul);

        }

        void bindTo(KategoriKisah kategoriKisah) {
            // set & get judul cerita
            tvJudulCerita.setText(kategoriKisah.getJudul());
            // set & get gambar judul
            int drawable =
                    itemView.getResources().getIdentifier(kategoriKisah.getGambar_judul(), "drawable",
                            itemView.getContext().getPackageName());

            Glide.with(itemView).load(drawable).into(ivGambarJudul);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(kategoriKisah, getAdapterPosition());
                }
            });

        }



    }
}
