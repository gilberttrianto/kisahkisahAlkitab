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
                if (kisahAlkitabDao.loadKategoriKisah().getValue() == null || kisahAlkitabDao.loadKategoriKisah().getValue().size() == 0) {
                    System.out.println("Masukkan data");
                    KategoriKisah kategoriKisah = new KategoriKisah("Tuhan Menciptakan Langit dan Bumi","k1" );
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
                    kategoriKisah = new KategoriKisah("Allah menciptakan manusia","k2");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
                    kategoriKisah = new KategoriKisah("Nabi nuh","k3");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
                    kategoriKisah = new KategoriKisah("Banjir","k4");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
                    kategoriKisah = new KategoriKisah("Nabi Musa","k5");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);


                    KisahAlkitab kisahAlkitab = new KisahAlkitab("k1","Tuhan Menciptakan Langit dan Bumi \n Kejadian 1:1","slide1",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("k1","Pada hari kedua, Allah membuat udara. Kita menyebutnya langit-langit adalah ruang yang sangat besar dan tinggi dan lebar. Sampai tidak ada batasnya.","slide2",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("k2","Hal yang sangat indah terjadi pada hari yang ketiga! Allah membuat sungai-sungai yang jernih dan laut-laut yang biru. Ia menanam gandum yang keemasan, pohon apel, dan pohon anggur. Lalu ia tersenyum, karena semuanya benar-benar sangat baik.","slide2",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("k3","Hari Keempat juga seru! Allah memasang matahari yang besar dan hangat dilangit siang dan ia memasang bulan yang keperakan dan bintang yang berkelap kelip dilangit malam sebagai penerang dunia.","slide3",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("k4","Hari kelima, Allah menciptakan berbagai macam macam ikan dan burung. Ia juga membuat ikan pari yang bersayap lebar, ikan cucut yang mempunyai pedang dan gurita yang bertangan banyak. Ia membuat burung nuri, burung cendrawasih dan itik yang berenang dan berkuak. Itu adalah hari yang indah!","slide4",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);


                }
            });

        }
    };
    
}
