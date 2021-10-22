package com.glbrt.kisah_kisahalkitab;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.glbrt.kisah_kisahalkitab.dao.KisahAlkitabDao;
import com.glbrt.kisah_kisahalkitab.entities.KategoriKisah;
import com.glbrt.kisah_kisahalkitab.entities.KisahAlkitab;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {KategoriKisah.class, KisahAlkitab.class}, version = 1)
public abstract  class KisahAlkitabDatabase extends RoomDatabase {
    public abstract KisahAlkitabDao kisahAlkitabDao();

    private static volatile KisahAlkitabDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService dbWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static KisahAlkitabDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (KisahAlkitabDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            KisahAlkitabDatabase.class,
                            "db_kisahalkitab")
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    
    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbWriterExecutor.execute(() -> {
                KisahAlkitabDao kisahAlkitabDao = INSTANCE.kisahAlkitabDao();
//                int sizeData = kisahAlkitabDao.loadAllByIds(kate)

            });

        }
    };
    
}
