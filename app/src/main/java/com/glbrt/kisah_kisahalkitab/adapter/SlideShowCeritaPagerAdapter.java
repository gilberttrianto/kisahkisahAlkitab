package com.glbrt.kisah_kisahalkitab.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.glbrt.kisah_kisahalkitab.R;
import com.glbrt.kisah_kisahalkitab.entities.KisahAlkitab;

import java.util.ArrayList;
import java.util.List;

public class SlideShowCeritaPagerAdapter extends PagerAdapter {

    private List<KisahAlkitab> kisahAlkitabList = new ArrayList<>();

    public SlideShowCeritaPagerAdapter(List<KisahAlkitab> kisahAlkitabList) {
        this.kisahAlkitabList = kisahAlkitabList;
    }

    public void setData(List<KisahAlkitab> kisahAlkitabList) {
        this.kisahAlkitabList = kisahAlkitabList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.list_main_cerita, container, false);

        ImageView ivGambarCerita = view.findViewById(R.id.iv_gambar_cerita);
        TextView tvNarasi = view.findViewById(R.id.tv_narasi);
        ImageView ibtnPlay = view.findViewById(R.id.ibtn_play);

        int drawable =
                container.getResources().getIdentifier(kisahAlkitabList.get(position).getGambar(), "drawable",
                        container.getContext().getPackageName());

        Glide.with(container.getContext()).load(drawable).into(ivGambarCerita);
        // image button
        tvNarasi.setText(kisahAlkitabList.get(position).getNarasi());
        container.addView(view);

        return view;
    }

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
    }
}
