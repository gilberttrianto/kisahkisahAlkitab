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

//                    DATA JUDUL CERITA

//                    Cerita 1
                    KategoriKisah kategoriKisah = new KategoriKisah("Tuhan Menciptakan Langit dan Bumi","mc1" );
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 2
                    kategoriKisah = new KategoriKisah("Allah \n  Menciptakan Manusia","mc2");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 3
                    kategoriKisah = new KategoriKisah("Ular \n di Taman","mc3");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 4
                    kategoriKisah = new KategoriKisah("Hujan Hujan \n Hujan","k4");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 5
                    kategoriKisah = new KategoriKisah("Nabi Musa","k5");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);


//                    DATA CERITA

//                    Cerita 1
                    KisahAlkitab kisahAlkitab = new KisahAlkitab("c15","Tuhan Menciptakan Langit dan Bumi \n Kejadian 1:1","slide1",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("k1","Pada hari pertama, Allah menciptakan langit dan bumi, dan Allah menciptakan terang dan gelap lalu memisahkan yang terang dari pada yang gelap karena terang itu baik maka Allah menciptakan langit dan bumi beserta terang dan gelap.","slide2",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c12","Pada hari kedua, Allah membuat udara. Kita menyebutnya langit-langit adalah ruang yang sangat besar dan tinggi dan lebar. Sampai tidak ada batasnya.","slide2",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c13","Hal yang sangat indah terjadi pada hari yang ketiga! Allah membuat sungai-sungai yang jernih dan laut-laut yang biru. Ia menanam gandum yang keemasan, pohon apel, dan pohon anggur. Lalu ia tersenyum, karena semuanya benar-benar sangat baik.","slide2",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c14","Hari Keempat juga seru! Allah memasang matahari yang besar dan hangat dilangit siang dan ia memasang bulan yang keperakan dan bintang yang berkelap kelip dilangit malam sebagai penerang dunia.","slide3",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c15","Hari kelima, Allah menciptakan berbagai macam macam ikan dan burung. Ia juga membuat ikan pari yang bersayap lebar, ikan cucut yang mempunyai pedang dan gurita yang bertangan banyak. Ia membuat burung nuri, burung cendrawasih dan itik yang berenang dan berkuak. Itu adalah hari yang indah!","slide4",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    Cerita 2
                    kisahAlkitab = new KisahAlkitab("c15","Allah Menciptakan Manusia \n Kejadian 1:24-31","slide1",2);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c15","Allah bekerja keras pada hari keenam untuk menciptakan hewan menciptakan anjing yang lucu, kucing yang imut dan kangguru. Ia menciptakan kelinci berbulu lembut, landak  berduri, gajah yang besar dan tikus yang kecil.","slide1",2);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c22","Akhirnya, Allah menciptakan manusia seorang laki-laki bernama Adam dan seorang perempuan bernama Hawa. Ia menyuruh mereka mempunyai anak-anak dan menjaga dunianya.","slide1",2);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c15","Allah memberikan gandum dan padi untuk dimakan Adam dan Hawa, Ia memberi apel, anggur, pisang, dan jeruk untuk dimakan. Dan Ia memberi tumbuhan hijau untuk dimakan hewan dan burung. Allah selalu memelihara umat-Nya.","slide1",2);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c15","Semua yang diciptakan Tuhan sangat baik dan Tuhan tersenyum karena Ia telah selesai menciptakan dunia. Lalu, pada hari ketujuh Tuhan beristirahat.","slide1",2);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 3
                    kisahAlkitab = new KisahAlkitab("c32","Ular di Taman \n Kejadian 3:1-24","slide1",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c31","Allah membiarkan Adam dan Hawa tinggal di taman indah bernama Eden. Pada sore hari, Allah akan datang dan berjalan-jalan di taman. Adam dan Hawa bisa berbicara pada Allah. Ia adalah sahabat mereka.","slide1",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c32","Allah memberitahu Adam dan Hawa, mereka boleh makan buah dari semua pohon di taman kecuali dari pohon di tengah taman Eden. Kalau mereka makan buah pohon itu mereka akan tahu bedanya jahat dan baik.","slide1",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c33","“Stttt” Suatu hari seekor ular berbicara kepada Hawa. Ular adalah hewan liar paling cerdik dari semua ciptaan Allah.","slide1",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c34","Ular berkata ”Allah melarang engkau makan buah dari pohon di tengah taman. Tetapi itu adalah buah paling enak di seluruh taman. Ayolah, makan saja buah itu. Buah itu akan membuatmu bijaksana seperti Allah”, maka Hawa makan buah itu dan memberikan separuh kepada Adam.","slide1",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c35","Malam itu Tuhan datang berjalan-jalan di taman. Ia memanggil ”Adam??? dimana engkau?” Adam bersembunyi. Allah berfirman, ”Ada apa? Apakah kau makan buah pohon pengetahuan yang baik dan jahat?”","slide1",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c36","Adam berkata kepada Allah bahwa Hawa memberikan buah itu lalu Hawa berkata, ular telah menipunya sampai ia makan buah itu. Allah marah sekali. Adam dan Hawa tidak taat kepadanya. Lalu, Allah mengusir mereka dari taman yang indah untuk selamanya. Itu adalah hari yang paling menyedihkan.","slide1",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 4
                    kisahAlkitab = new KisahAlkitab("c32","Ular di Taman \n Kejadian 3:1-24","slide1",4);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                }
            });

        }
    };
    
}
