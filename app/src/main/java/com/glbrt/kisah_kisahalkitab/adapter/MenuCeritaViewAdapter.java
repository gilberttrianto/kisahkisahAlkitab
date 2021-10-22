package com.glbrt.kisah_kisahalkitab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.glbrt.kisah_kisahalkitab.R;
import com.glbrt.kisah_kisahalkitab.models.ListPilihJudulCerita;

import java.util.List;

public class MenuCeritaViewAdapter extends RecyclerView.Adapter<MenuCeritaViewAdapter.ViewHolder> {

    private List<ListPilihJudulCerita> mData;
    private Context mContext;

    public MenuCeritaViewAdapter(List<ListPilihJudulCerita> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MenuCeritaViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // View adapter --> listView card
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_pilihan_cerita, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListPilihJudulCerita listPilihJudulCerita = mData.get(position);
        holder.bindTo(listPilihJudulCerita);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvJudulCerita;
        private ImageView ivGambarJudul;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJudulCerita = itemView.findViewById(R.id.tv_judul_cerita);
            ivGambarJudul = itemView.findViewById(R.id.iv_gambar_judul);

            itemView.setOnClickListener(this);

        }

        void bindTo(ListPilihJudulCerita listPilihJudulCerita) {
            // set & get judul cerita
            tvJudulCerita.setText(listPilihJudulCerita.getTitle());
            // set & get gambar judul
            Glide.with(mContext).load(listPilihJudulCerita.getImageResource()).into(ivGambarJudul);


        }

        @Override
        public void onClick(View v) {
            // menuju ke activity cerita solo

        }
    }
}
