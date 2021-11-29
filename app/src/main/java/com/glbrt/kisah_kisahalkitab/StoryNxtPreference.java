package com.glbrt.kisah_kisahalkitab;

import android.content.Context;
import android.content.SharedPreferences;

import com.glbrt.kisah_kisahalkitab.models.ListMainCerita;

public class StoryNxtPreference {

    private static final String PREFERENCES_NAME = "story_pref";
    private static final String ID_KATEGORI = "id_kategori";
    private static final String ID_PAGE= "id_page";


    private SharedPreferences sp;

    public StoryNxtPreference(Context context) {
        sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void setStory(long id_kategori, int id_page) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(ID_KATEGORI, id_kategori);
        editor.putInt(ID_PAGE, id_page);
        editor.apply();
    }

    public long getStoryKategori() {
        return sp.getLong(ID_KATEGORI,0);
    }

    public int getStoryPageKisah() {
        return sp.getInt(ID_PAGE,0);
    }


}
