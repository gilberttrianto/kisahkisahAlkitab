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
                    kategoriKisah = new KategoriKisah("Hujan Hujan \n Hujan","mc4");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 5
                    kategoriKisah = new KategoriKisah("Keluarga Nuh \n Diselamatkan","mc5");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita6
                    kategoriKisah = new KategoriKisah("Janji Allah \n pada Abram","mc6");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita7
                    kategoriKisah = new KategoriKisah("Ishak Anak \n dan Pengorbanan","mc7");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita8
                    kategoriKisah = new KategoriKisah("Yakub \n Menipu Esau ","mc8");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita9
                    kategoriKisah = new KategoriKisah("Kisah \n Yusuf ","mc9");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita10
                    kategoriKisah = new KategoriKisah("Musa \n Lahir ","mc10");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    Cerita 11
                    kategoriKisah = new KategoriKisah("Semak \n Menyala","mc11" );
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 12
                    kategoriKisah = new KategoriKisah("Berjalan di \n Tengah Laut","mc12");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 13
                    kategoriKisah = new KategoriKisah("Musa Berbicara \n pada Allah","mc13");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 14
                    kategoriKisah = new KategoriKisah("Dinding Yerikho\n Roboh","mc14");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 15
                    kategoriKisah = new KategoriKisah("Simson, \n Orang Terkuat","mc15");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 16
                    kategoriKisah = new KategoriKisah("Allah Mendengar \n Doa Hana","mc16");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    Cerita 17
                    kategoriKisah = new KategoriKisah("Saul Menjadi\n Raja","mc17" );
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 18
                    kategoriKisah = new KategoriKisah("Daud \n dan Raksasa","mc18");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 19
                    kategoriKisah = new KategoriKisah("Bait \n Allah","mc19");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 20
                    kategoriKisah = new KategoriKisah("Salomo, Raja \n yang Bijaksana","mc20");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 21
                    kategoriKisah = new KategoriKisah("Elia Naik \n Kereta Berapi","mc21");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita22
                    kategoriKisah = new KategoriKisah("Lagu \n Gembala","mc22");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita23
                    kategoriKisah = new KategoriKisah("Tiga Orang di \n Tengah Api","mc23");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita24
                    kategoriKisah = new KategoriKisah("Daniel di \n Goa Singa ","mc24");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita25
                    kategoriKisah = new KategoriKisah("Yunus Lari \n dari Tuhan ","mc25");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita26
                    kategoriKisah = new KategoriKisah("Maria \n dan Malaikat ","mc26");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita27
                    kategoriKisah = new KategoriKisah("Yesus \n Lahir ","mc27");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    Cerita 28
                    kategoriKisah = new KategoriKisah("Gembala Mengunjungi \n Bayi Yesus","mc28" );
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 29
                    kategoriKisah = new KategoriKisah("Orang Majus \n Membawa Hadiah","mc29");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 30
                    kategoriKisah = new KategoriKisah("Yesus \n Kecil","mc30");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 31
                    kategoriKisah = new KategoriKisah("Yohanes \n Membaptis Yesus","mc31");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 32
                    kategoriKisah = new KategoriKisah("Yesus Mengajar \n Orang Banyak","mc32");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 33
                    kategoriKisah = new KategoriKisah("Mujizat Yesus \n yang Pertama","mc33");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    Cerita 34
                    kategoriKisah = new KategoriKisah("Yesus Memilih \n Dua Belas Murid","mc34" );
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 35
                    kategoriKisah = new KategoriKisah("Bekal \n Seorang Anak","mc35");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 36
                    kategoriKisah = new KategoriKisah("Yesus Berjalan \n diatas Air.","mc36");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 37
                    kategoriKisah = new KategoriKisah("Orang Buta \n Bisa Melihat","mc37");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 38
                    kategoriKisah = new KategoriKisah("Orang Samaria \n yang Baik Hati.","mc38");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita39
                    kategoriKisah = new KategoriKisah("Anak yang \n Hilang","mc39");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita40
                    kategoriKisah = new KategoriKisah("Persembahan \n Janda Miskin","mc40");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita41
                    kategoriKisah = new KategoriKisah("Perjamuan \n terakhir ","mc41");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita42
                    kategoriKisah = new KategoriKisah("Yesus \n ditangkap ","mc42");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita43
                    kategoriKisah = new KategoriKisah("Yesus \n Mati ","mc43");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita44
                    kategoriKisah = new KategoriKisah("Yesus \n Hidup Kembali ","mc44");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    Cerita 45
                    kategoriKisah = new KategoriKisah("Yesus Kembali \n ke Sorga.","mc45" );
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 46
                    kategoriKisah = new KategoriKisah("Roh Kudus \n Datang","mc46");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 47
                    kategoriKisah = new KategoriKisah("Pengemis di \n Gerbang Indah","mc47");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 48
                    kategoriKisah = new KategoriKisah("Saulus \n Bertemu Yesus","mc48");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 49
                    kategoriKisah = new KategoriKisah("Dorkas \n Hidup Kembali","mc49");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 50
                    kategoriKisah = new KategoriKisah("Paulus \n Mengabarkan Injil.","mc50");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);
//                    cerita 51
                    kategoriKisah = new KategoriKisah("Yesus Akan \n datang Kembali.","mc51");
                    kisahAlkitabDao.insertKategoriKisah(kategoriKisah);

//                    DATA CERITA

//                    Cerita 1
                    KisahAlkitab kisahAlkitab = new KisahAlkitab("c15","Tuhan Menciptakan Langit dan Bumi \n Kejadian 1:1-23","jc1",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c11","Pada hari pertama, Allah menciptakan langit dan bumi, dan Allah menciptakan terang dan gelap lalu memisahkan yang terang dari pada yang gelap karena terang itu baik maka Allah menciptakan langit dan bumi beserta terang dan gelap.","ac11",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c12","Pada hari kedua, Allah membuat udara. Kita menyebutnya langit-langit adalah ruang yang sangat besar dan tinggi dan lebar. Sampai tidak ada batasnya.","ac12",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c13","Hal yang sangat indah terjadi pada hari yang ketiga! Allah membuat sungai-sungai yang jernih dan laut-laut yang biru. Ia menanam gandum yang keemasan, pohon apel, dan pohon anggur. Lalu ia tersenyum, karena semuanya benar-benar sangat baik.","ac13",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c14","Hari Keempat juga seru! Allah memasang matahari yang besar dan hangat dilangit siang dan ia memasang bulan yang keperakan dan bintang yang berkelap kelip dilangit malam sebagai penerang dunia.","ac14",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c15","Hari kelima, Allah menciptakan berbagai macam macam ikan dan burung. Ia juga membuat ikan pari yang bersayap lebar, ikan cucut yang mempunyai pedang dan gurita yang bertangan banyak. Ia membuat burung nuri, burung cendrawasih dan itik yang berenang dan berkuak. Itu adalah hari yang indah!","ac15",1);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    Cerita 2
                    kisahAlkitab = new KisahAlkitab("c23","Allah Menciptakan Manusia \n Kejadian 1:24-31","jc2",2);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c21","Allah bekerja keras pada hari keenam untuk menciptakan hewan menciptakan anjing yang lucu, kucing yang imut dan kangguru. Ia menciptakan kelinci berbulu lembut, landak  berduri, gajah yang besar dan tikus yang kecil.","ac21",2);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c22","Akhirnya, Allah menciptakan manusia seorang laki-laki bernama Adam dan seorang perempuan bernama Hawa. Ia menyuruh mereka mempunyai anak-anak dan menjaga dunianya.","ac22",2);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c23","Allah memberikan gandum dan padi untuk dimakan Adam dan Hawa, Ia memberi apel, anggur, pisang, dan jeruk untuk dimakan. Dan Ia memberi tumbuhan hijau untuk dimakan hewan dan burung. Allah selalu memelihara umat-Nya.","ac23",2);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c24","Semua yang diciptakan Tuhan sangat baik dan Tuhan tersenyum karena Ia telah selesai menciptakan dunia. Lalu, pada hari ketujuh Tuhan beristirahat.","ac24",2);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 3
                    kisahAlkitab = new KisahAlkitab("c32","Ular di Taman \n Kejadian 3:1-24","jc3",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c31","Allah membiarkan Adam dan Hawa tinggal di taman indah bernama Eden. Pada sore hari, Allah akan datang dan berjalan-jalan di taman. Adam dan Hawa bisa berbicara pada Allah. Ia adalah sahabat mereka.","ac31",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c32","Allah memberitahu Adam dan Hawa, mereka boleh makan buah dari semua pohon di taman kecuali dari pohon di tengah taman Eden. Kalau mereka makan buah pohon itu mereka akan tahu bedanya jahat dan baik.","ac32",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c33","“Stttt” Suatu hari seekor ular berbicara kepada Hawa. Ular adalah hewan liar paling cerdik dari semua ciptaan Allah.","ac33",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c34","Ular berkata ”Allah melarang engkau makan buah dari pohon di tengah taman. Tetapi itu adalah buah paling enak di seluruh taman. Ayolah, makan saja buah itu. Buah itu akan membuatmu bijaksana seperti Allah”, maka Hawa makan buah itu dan memberikan separuh kepada Adam.","ac34",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c35","Malam itu Tuhan datang berjalan-jalan di taman. Ia memanggil ”Adam??? dimana engkau?” Adam bersembunyi. Allah berfirman, ”Ada apa? Apakah kau makan buah pohon pengetahuan yang baik dan jahat?”.","ac35",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c36","Adam berkata kepada Allah bahwa Hawa memberikan buah itu lalu Hawa berkata, ular telah menipunya sampai ia makan buah itu. Allah marah sekali. Adam dan Hawa tidak taat kepadanya. Lalu, Allah mengusir mereka dari taman yang indah untuk selamanya. Itu adalah hari yang paling menyedihkan.","ac36",3);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 4
                    kisahAlkitab = new KisahAlkitab("c43","Hujan Hujan Hujan \n Kejadian 6:9-7;16","jc4",4);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c41","Waktu berjalan terus dan orang-orang yang di dunia berbuat jahat, seperti Adam dan Hawa. Hanya Nuh satu-satunya orang baik yang masih tersisa di bumi. Ia mengasihi Allah dan taat padanya.","ac41",4);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c42","Allah memberitahu Nuh bahwa Dia akan membanjiri dunia dengan air. Tetapi Dia berjanji akan menyelamatkan Nuh dan keluarganya dari banjir. Dan Dia akan berjanji akan  menyelamatkan juga sebagian dari hewan di dunia.","ac42",4);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c43","Allah memberi tahu Nuh bagaimana caranya membuat kapal besar yang disebut bahtera untuk menyelamatkan keluarganya dan hewan-hewan maka, Nuh membuat kapal seperti yang diperintahkan Tuhan. Kapal itu mempunyai satu jendela panjang dan satu pintu besar. Nuh mengoleskan ter di luar dan di dalam kapal, supaya tidak bocor.","ac43",4);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c44","Kapal besar itu akhirnya selesai! Allah menyuruh Nuh masuk ke kapal. Jadi, Nuh dan istrinya, tiga anaknya, dan tiga menantunya masuk ke dalam kapal. Lalu Allah menyuruh dua ekor hewan dan setiap jenisnya masuk ke dalam kapal Nuh, seekor hewan jantan dan seekor betina.","ac44",4);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c45","Akhirnya Allah menutup pintu besar itu. Hujan mulai turun. Mulanya gerimis, lalu hujan deras! Air terus bertambah tinggi. Hujan turun selama empat puluh hari dan empat puluh malam. Seluruh dunia tertutup air. Hewan dan orang di dalam kapal selamat. Semua yang lain mati. ","ac45",4);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 5
                    kisahAlkitab = new KisahAlkitab("c54","Keluarga Nuh Diselamatkan \n Kejadian 7:17-9:29","jc5",5);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c51","Kapal besar, Nuh dan keluarganya selamat dan kering. Kapal itu mengapung diatas air selama 150 hari dan 5 bulan penuh! Allah ingat dengan janji-Nya untuk menyelamatkan Nuh.","ac51",5);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c52","Tik.Tik.Tik… Hujan berhenti turun dari langit, air berhenti membanjiri dari sungai-sungai. Dan Allah membuat angin untuk mengeringkan daratan. Angin itu bertiup dan bertiup! Semua orang dan hewan di kapal merasa senang banjir sudah berlalu.","ac52",5);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c53","Buk!! Suatu hari kapal berhenti mengapung, kapal itu terdampar di puncak gunung. Air mulai surut, beberapa minggu kemudian, daratan di bumi sudah kering. Maka, keluarga Nuh dan semua hewan keluar dari kapal. Itu adalah dunia yang baru dan bersih.","ac53",5);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c54","Allah menyuruh keluarga Nuh dan para hewan untuk mempunyai banyak anak. Lalu Allah berjanji: Ia berfirman, Ia tidak akan pernah menghancurkan bumi dengan air lagi, lalu Ia meletakan pelangi yang indah di langit sebagai tanda perjanjiannya dan sampai hari ini, Allah menepati janjiNya itu.","ac54",5);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 6
                    kisahAlkitab = new KisahAlkitab("c65","Janji Allah pada Abram \n Kejadian 15:1-17:5","jc6",6);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c61","Abram adalah orang yang sangat baik. Allah sangat sayang kepadanya, tetapi Abram merasa sedih ia sudah tua dan berumur 100 tahun dan ia belum mempunya anak.","ac61",6);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c62","Suatu malam Allah berbicara pada Abram dalam mimpi. Allah berfirman Ia akan melindungi Abram, Ia akan memberikan hadiah besar pada Abram.","ac62",6);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c63","Abram berkata kepada Allah, bahwa ia tidak ingin hadiah, ia tidak ingin punya lebih banyak tanah atau ternak domba atau uang, ia hanya ingin mempunyai anak.","ac63",6);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c64","Lalu Allah membuat Abram terkejut! Ia menyuruh Abram keluar, Allah berfirman ”Lihat ke langit, ada sangat banyak bintang sampai kau tidak bisa menghitungnya, sebanyak itulah anak cucumu nanti!” Kemudian Allah mengganti nama Abram menjadi Abraham, yang artinya ”Bapak dari banyak bangsa”.","ac64",6);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 7
                    kisahAlkitab = new KisahAlkitab("c74","Ishak -Anak dan Pengorbanan \n Kejadian 21:1-5; 22:1-18","jc7",7);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c71","Abram adalah orang yang sangat baik. Allah sangat sayang kepadanya, tetapi Abram merasa sedih ia sudah tua dan berumur 100 tahun dan ia belum mempunya anak.","ac71",7);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c72","Suatu malam Allah berbicara pada Abram dalam mimpi. Allah berfirman Ia akan melindungi Abram, Ia akan memberikan hadiah besar pada Abram.","ac72",7);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c73","Abram berkata kepada Allah, bahwa ia tidak ingin hadiah, ia tidak ingin punya lebih banyak tanah atau ternak domba atau uang, ia hanya ingin mempunyai anak.","ac73",7);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c74","Lalu Allah membuat Abram terkejut! Ia menyuruh Abram keluar, Allah berfirman ”Lihat ke langit, ada sangat banyak bintang sampai kau tidak bisa menghitungnya, sebanyak itulah anak cucumu nanti!” Kemudian Allah mengganti nama Abram menjadi Abraham, yang artinya ”Bapak dari banyak bangsa”.","ac74",7);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 8
                    kisahAlkitab = new KisahAlkitab("c84","Yakub Menipu Esau \n Kejadian 25:29-34","jc8",8);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c81","Suatu Hari anak bungsu Ishak, Yakub membuat sepanci sup kacang. Kakaknya, Esau baru saja pulang dari berburu dan ia lapar sekali.","ac81",8);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c82","Hmmm…… Sup itu enak dan harum sekali “pikir Esau” ia berkata kepada Yakub ”Aku minta sedikit sup kacang itu, aku lapar sekali dan aku letih","ac82",8);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c83","Lalu Yakub menipu Esau, katanya ”Kau boleh makan sup ini kalau kau menyerahkan hakmu sebagai anak sulung.” Anak lelaki sulung biasanya kelak menjadi kepala keluarga.","ac83",8);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c84","Esau yang sangat lapar sampai ia berjanji memberikan haknya sebagai anak sulung kepada Yakub. Lalu Yakub memberikan roti dan sup pada Esau. Esau bodoh sekali memberikan haknya sebagai kepala keluarga hanya untuk semangkuk sup","ac84",8);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 9
                    kisahAlkitab = new KisahAlkitab("c95","Kisah Yusuf\n Kejadian 37-45","jc9",9);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c91","Yakub mempunyai dua belas anak laki-laki tapi Yusuf adalah anak kesayangannya. Ia memberikan jubah indah pada Yusuf, ini membuat saudara-saudara Yusuf yang lain marah. Mereka menjual Yusuf kepada pedagang budak yang pergi ke Mesir","ac91",9);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c92","Yusuf mengenali saudara-saudaranya, tetapi mereka tidak mengenali Yusuf. Ketika mereka tahu, mereka sangat takut. Mereka sudah berbuat jahat kepada Yusuf. Mereka mengira Yusuf juga akan berbuat jahat kepada mereka.","ac92",9);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c93","Sekian tahun kemudian, saudara-saudara Yusuf datang ke Mesir untuk membeli makanan, di negeri mereka sudah lama tidak ada hujan yang menjadikan gandum tidak bisa tumbuh. Mereka harus minta makanan kepada saudara mereka, Yusuf.","ac93",9);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c94","Yusuf mengenali saudara-saudaranya, tetapi mereka tidak mengenali Yusuf. Ketika mereka tahu, mereka sangat takut. Mereka sudah berbuat jahat kepada Yusuf. Mereka mengira Yusuf juga akan berbuat jahat kepada mereka.","ac94",9);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c95","Tetapi Yusuf memberikan mereka kejutan, ia sangat baik dan ia menyuruh mereka pulang untuk menjemput ayah mereka dan semua harta mereka. Ia memberikan mereka tanah di Mesir dan banyak makanan. Allah telah mengubah kejahatan menjadi kebaikan","ac95",9);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 10
                    kisahAlkitab = new KisahAlkitab("c102","Musa Lahir\n Keluaran 2:1-10","jc10",10);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c101","Yusuf tinggal di Mesir selama puluhan tahun lalu ia meninggal. Bertahun-tahun kemudian datanglah seorang raja baru yang memerintah Mesir. Ia tidak ingat perbuatan baik Yusuf bagi Mesir dan Ia memperlakukan bangsa keturunan Yusuf, bangsa Israel seperti budak. Ia menyuruh mereka bekerja, bekerja, bekerja!!!!","ac101",10);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c102","Seorang wanita Israel melahirkan anak laki-laki yang bernama Musa. Ia menyembunyikan Musa dari orang-orang Mesir yang jahat selama tiga bulan, lalu ia tidak bisa lagi menyembunyikan anaknya.","ac102",10);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c103","Ibu Musa membuat keranjang kecil seperti perahu dan meletakan bayi musa di dalamnya. Ia meletakan keranjang itu dekat tepi sungai Nil. Kakak perempuan Musa, Miriam menunggu di dekatnya untuk melihat apa yang akan terjadi.","ac103",10);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c104","Tidak lama kemudian putri Raja datang ke sungai untuk mandi namun ia menemukan keranjang itu dan bayi Musa. Oaaaa!! Musa menangis dan putri Raja merasa kasihan.","ac104",10);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c105","Miriam bertanya kepada purti Raja, apakah ia ingin mencari perawat bayi untuk Musa. Sang putri berkata “Ya, tentu” Jadi Miriam membantu supaya ibu Musa sendiri yang merawatnya.","ac105",10);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c106","Setelah Musa cukup besar, ibunya membawanya ke istana. Sang putri mengangkatnya sebagai anak, dan Musa tinggal di istana. Dan memang, itu sudah rencana Tuhan bagi Musa!","ac106",10);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 11
                    kisahAlkitab = new KisahAlkitab("c111","Semak Menyala\n Keluaran 3:1-4:17","jc11",11);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c112","Setelah dewasa, Musa pergi dari Mesir. Suatu hari ia sedang menggembalakan domba. “Wow! Apa itu???” Musa melihat ada semak yang menyala ditengah api, tetapi semak itu tidak terbakar.","ac111",11);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c113","Musa mendekati untuk melihat semak menyala itu, lalu Allah berfirman kepadanya dari tengah api itu “Musa!!! Musa! Jangan datang lebih dekat lagi! Lepaskan alas kakimu, kau akan berada di tanah yang suci.","ac112",11);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c114","Allah menyuruh Musa kembali ke Mesir. Ia ingin Musa memimpin bangsa Israel keluar dari perbudakan di Mesir. Musa takut dan berkata “Tuhan, Mengapa saya? Tolong kirim orang lain saja.","ac113",11);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c115","Maka Tuhan menyuruh kakak Musa, Harun untuk menemaninya ke Mesir. Dan Tuhan mengajari Musa bagaimana melakukan mujizat dengan tongkatnya, agar raja Mesir percaya pada Allah. Lalu Musa dan Harun pergi ke Mesir untuk membawa bangsa Israel keluar dari perbudakan.","ac114",11);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 12
                    kisahAlkitab = new KisahAlkitab("c124","Berjalan di Tengah Laut\n Keluaran 14:10-31","jc12",12);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c121","Musa dan Harun memimpin bangsa Israel keluar dari Mesir tetapi pasukan Mesir mengejar mereka, pasukan itu mengejar umat Allah melintasi gurun.","ac121",12);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c122","Lalu bangsa Israel berhenti. Ada masalah besar, Laut Merah yang ada di depan mereka dan pasukan Mesir di belakang mereka. Mereka terjebak dan mereka takut sekali.","ac122",12);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c123","Musa menyuruh orang Israel melihat kuasa Allah bekerja, ia mengangkat tongkatnya di atas Laut Merah dan Allah membelah laut dengan angin kencang untuk membuat tanah yang kering bisa dilalui oleh bangsa Israel.","ac123",12);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c124","Umat Allah berjalan sampai ke seberang Laut Merah kemudian pasukan Mesir mengejar dengan kereta mereka, Koplak! Koplak! Koplak!! Mereka mengejar umat Allah sampai ke tengah laut.","ac124",12);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c125","Allah membuat beberapa roda kereta terlepas dan bangsa Mesir kerepotan mengendalikan kereta mereka. Lalu Allah menyuruh Musa mengangkat tangannya ke atas laut dan Musa mengangkat tangannya “byurrr, byurrrrrr!!!” tiba-tiba Laut Merah yang semula terbelah menjadi tertutup kembali dan menenggelamkan pasukan-pasukan Mesir yang mengejar Musa dan umat Allah sudah selamat ke seberang.","ac125",12);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 13
                    kisahAlkitab = new KisahAlkitab("c134","Musa Berbicara pada Allah\n Keluaran 19:11-20:21","jc13",13);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c131","Tiga bulan kemudian, bangsa Israel tiba di gunung bernama Sinai, mereka berkemah di gurun dekat gunung itu.","ac131",13);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c132","Musa mendaki gunung itu untuk berbicara dengan Allah lalu ia melihat ada asap tebal dan gelap di puncak karena Allah turun ke gunung di tengah api yang sangat besar.","ac132",13);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c133","Allah mengasihi bangsa Israel dan Ia telah memilih mereka untuk tugas yang sangat istimewa, Allah memberi Musa sepuluh perintah bijaksana untuk diikuti bangsa itu dan perintah ini akan membantu mereka hidup dengan baik.","ac133",13);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c134","Allah menulis sepuluh perintah itu di lempengan batu dengan jari-Nya sendiri dan Musa membawanya turun gunung pada bangsa Israel. Lalu Musa membacakan sepuluh perintah itu pada umat Allah.","ac134",13);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c134","Sepuluh Perintah Allah:" +
                            "\n1.	Akulah TUHAN, Allahmu, Jangan menyembah berhala, berbaktilah kepada-Ku saja, dan cintailah Aku lebih dari segala sesuatu." +
                            "\n2.	Jangan menyebut Nama TUHAN Allahmu dengan tidak hormat." +
                            "\n3.	Kuduskanlah hari TUHAN." +
                            "\n4.	Hormatilah ibu-bapamu." +
                            "\n5.	Jangan membunuh.","ac135a",13);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c134","6.	Jangan berzinah." +
                            "\n7.	Jangan mencuri." +
                            "\n8.	Jangan bersaksi dusta tentang sesamamu." +
                            "\n9.	Jangan mengingini istri sesamamu." +
                            "\n10. Jangan mengingini milik sesamamu secara tidak adil.","ac135b",13);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 14
                    kisahAlkitab = new KisahAlkitab("c144","Dinding Yerikho Roboh \n Yosua 6 ","jc14",14);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c141","Baris ayo baris!!! Seru Yosua pada pasukan Israel, mereka akan mengalahkan Yerikho. Allah telah berjanji pada Yosua mereka akan memenangkan pertempuran itu.","ac141",14);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c142","Orang-orang Yerikho merasa takut dan mereka tahu Allah menyertai pasukan Israel jadi mereka mengunci diri di balik tembok kota dan menunggu.","ac142",14);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c143","Akhirnya pasukan Israel tiba dan pada hari pertama pasukan berkeliling di tembok kota Yerikho satu kali. Tujuh imam memimpin pasukan.","ac143",14);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c144","Hari kedua pasukan Israel berkeliling tembok satu kali lagi dan mereka melakukan itu setiap hari selama enam hari. Peti berisi sepuluh perintah Allah ditandu dibelakang para imam untuk menunjukan Allah menyertai mereka.","ac144",14);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c145","Pada hari ketujuh pasukan Israel berkeliling tembok kota Yerikho tujuh kali dan kemudian para imam meniup panjang terompet mereka, ”ahhh ooooo….” kemudian bangsa Israel berseru ”Serang….” dan tembok Yerikho pun roboh. Pasukan yang disertai Allah menang.","ac145",14);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 15
                    kisahAlkitab = new KisahAlkitab("c153","Simson, Orang Terkuat\n Hakim-hakim 13:24;16","jc15",15);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c151","Hakim umat Allah yang lain adalah Simson, Allah melarang Simson untuk memotong rambutnya, selama Simson taat, Allah akan membuatnya kuat. Ia adalah orang terkuat di seluruh dunia!","ac151",15);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c152","Simson jatuh cinta pada Delila. Musuh-musuh Simson berjanji akan memberi uang pada Delila kalau ia mau menipu Simson, mereka ingin tahu mengapa Simson sangat kuat, mereka bermaksud untuk membunuhnya.","ac152",15);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c153","Delila bekerja keras untuk mengetahui rahasia Simson, ia memohon dan menangis dan Simson pun tidak mau memberi tahu. Delila mengikat Simson dengan tali baru namun Simson mampu memutuskannya. Delila kembali melakukan hal yang sama namun dengan tali busur dan kembali lagi Simson bisa kabur dari ikatan tali tersebut. Akhirnya Simson bosan diganggu terus lalu ia mengatakan kepada Delila bahwa rahasia kekuatannya adalah rambutnya yang panjang.","ac153",15);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c154","Kress...Kress...Kress… suara pisau Delila yang sedang memotong rambut Simson dikala Simson  tertidur. Simson tidak taat kepada Allah dan seluruh kekuatanya hilang dan kemudian musuh-musuh Simson menangkapnya.","ac154",15);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c155","Ketika rambut Simson sudah panjang kembali Allah membuatnya cukup kuat untuk menghancurkan banyak musuh.","ac155",15);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 16
                    kisahAlkitab = new KisahAlkitab("c163","Allah Mendengar Doa Hana\n 1 Samuel 1:1-2:11","jc16",16);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c161","Hana sangat sedih, ia ingin punya bayi laki-laki tetapi Allah berkata belum menjawab doa nya. Suatu hari, di kemah suci Allah Hana menangis dan berdoa ia berjanji pada Allah kalau Allah memberinya seorang anak laki-laki ia akan mengembalikan anak itu pada Tuhan untuk melayani Tuhan seumur hidupnya.","ac161",16);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c162","Imam Eli melihat Hana berdoa ia mengira Hana mabuk dan Hana berkata bahwa ia sedang mendoakan masalahnya. Eli berkata ”Besarkan hatimu, kiranya Allah memberikan apa yang kau minta.” Hana merasa lebih baik dan ia berhenti menangis.","ac162",16);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c163","Allah mendengar doa Hana dan ia memberikan seorang anak laki-laki dan Hana menamai anaknya Samuel. Hana sangat bahagia.","ac163",16);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c164","Ketika Samuel sudah cukup besar Hana membawanya ke kemah suci. Ia meninggalkan Samuel kecil pada imam Eli. Samuel tumbuh besar dan melayani Tuhan di rumah-Nya. Ia menjadi nabi besar bagi umat Allah. Hana pun menepati janjinya pada Allah.","ac164",16);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 17
                    kisahAlkitab = new KisahAlkitab("c173","Saul Menjadi Raja\n 1 Samuel 9:15-10:24","jc17",17);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c171","Allah selalu memelihara umat-Nya, Israel. Tapi israel menginginkan seorang raja. Mereka ingin seperti bangsa-bangsa lain di sekeliling mereka.","ac171",17);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c172","Samuel sudah menjadi nabi besar lalu Allah berkata pada Samuel “Besok aku akan mengirim seorang pria padamu, ia dari keluarga Benyamin dan kau harus mengurapi dia menjadi pemimpin umat-Ku”.","ac172",17);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c173","Keesokan harinya seperti yang dikatakan Allah, seorang pria menemui Samuel. Namanya Saul lalu Allah berfirman pada Samuel ”Inilah orang yang kukatakan padamu, ia akan memerintah umat-Ku” Samuel menuangkan minyak zaitun ke kepala Saul sebagai tanda ia menjadi raja.","ac173",17);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c174","Beberapa hari kemudian, Samuel mengumpulkan umat Allah dan mereka berdiri dalam kelompok suku dan keluarga. Ketika suku-suku berjalan melewati Samuel dan Allah memilih suku Benyamin. Kemudian ia memilih kelompok keluarga Matri, dari keluarga itu Allah memilih Saul.","ac174",17);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c175","Tapi tidak ada yang bisa menemukan Saul! Allah berfirman “Ia bersembunyi di belakang barang-barang” Ketika mereka mengeluarkan Saul, ia lebih tinggi daripada semua orang Israel dan bangsa itu berseru ”Hidup Raja!!!!!!”.","ac175",17);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 18
                    kisahAlkitab = new KisahAlkitab("c185","Daud dan Raksasa\n 1 Samuel 17","jc18",18);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c181","Pasukan Israel ada di satu bukit. Musuh mereka bangsa Filistin ada di bukit lain, sebuah lembah besar memisahkan mereka. Musuh mereka mempunyai seorang raksasa di dalam pasukannya yang bernama Goliat tingginya hampir tiga meter!","ac181",18);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c182","Setiap hari Goliat menantang Israel untuk mengirim seorang untuk melawannya tetapi prajurit Israel takut pada raksasa itu. Suatu saat seorang anak gembala bernama Daud datang ke perkemahan ia berkata kepada Raja Saul ”Aku akan melawan Raksasa itu.","ac182",18);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c183","Saul berkata ”Daud, kau masih anak-anak” jawab Daud ”Allah membantuku membunuh, Ia akan menolongku membunuh raksasa itu juga” Daud memilih lima butir batu dari sungai kecil lalu mengambil ali-alinya dan pergi untuk melawan raksasa itu.","ac183",18);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c184","Brakkk!!!.... Raksasa itu berjalan untuk menyerang Daud dan ia memakai baju zirah berat dan membawa tombak yang besar. Daud memilih sebutir batu dan meletakanya di ali-alinya ia memutar ali-alinya dengan kuat, Zing…! Batu itu melayang di udara dan tepat mengenai kepala raksasa itu, Goliat pun roboh.","ac184",18);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c185","Daud berlari mendekati raksasa itu dan membunuhnya, Allah telah membantu seorang anak gembala untuk membunuh raksasa! Musuh-musuh Israel menjadi takut dan berlari dari umat Allah.","ac185",18);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 19
                    kisahAlkitab = new KisahAlkitab("c196","Bait Allah\n1 1 Raja-raja 5-6","jc19",19);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c191","Akhirnya bangsa Israel hidup dengan damai, perang sudah berlalu. Putra Daud, Salomo sekarang sudah menjadi Raja Israel. Allah telah berjanji kepada Daud bahwa Salomo boleh membangun Bait Allah dan ini adalah bangunan di mana umat Allah bisa menyembahnya.","ac191",19);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c192","Salomo memerlukan waktu tujuh tahun untuk membangun Bait Allah. Lebih dari 183.000 orang membantunya membangun tempat itu mereka adalah penebang kayu, pahat, pemotong batu dan perajin emas.","ac192",19);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c193","Para penebang kayu menebang kayu aras khusus di negara Lebanon dan mereka mengapungannya lewat sungai dan kemudian mereka membawa pohon itu di daratan sampai Yerusalem.","ac193",19);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c194","Bait Allah mempunyai tiga ruangan, pekarangan depan adalah tempat dimana semua umat Allah boleh beribadah dan hanya imam yang boleh masuk ke ruangan berikutnya tempat Kudus dan ruangan ketiga adalah ruangan khusus Tuhan disebut Maha Kudus. Imam Besar masuk keruangan ini hanya sekali setahun.","ac194",19);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c195","Ketika sudah selesai Bait Allah tampak sangat indah, seluruh dinding dilapisi emas. Setiap pintu dilapisi emas dan bahkan lantainya dilapisi emas juga. Itu adalah bangunan terindah di dunia dan itu adalah Rumah Tuhan.","ac195",19);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 20
                    kisahAlkitab = new KisahAlkitab("c204","Salomo, Raja yang Bijaksana\n 1 Raja-raja 10:1-10","jc20",20);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c201","Allah membuat Raja Salomo sebagai orang paling kaya dan bijaksana di seluruh dunia dan ia sangat terkenal.","ac201",20);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c202","Ratu Syeba mendengar tentang kebijaksanaan dan kekayaan Salomo jadi ia datang untuk melihat apakah itu benar dan ia membawa banyak pelayan dan ia juga membawa banyak unta yang mengangkut rempah-rempah, perhiasan dan banyak emas.","ac202",20);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c203","Ratu Syeba menguji kebijaksanaan Raja Salomo, ia bertanya banyak hal sulit tetapi Raja Salomo bisa menjawab semuanya! Ratu Syeba melihat bahwa Salomo benar-benar sangat bijaksana","ac203",20);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c204","Salomo menunjukan seluruh kekayaannya pada Ratu Syeba. Ratu sangat terpesona dan ia berkata ”Kekayaanmu dua kali lebih banyak daripada yang dikatakan orang” kemudian ia memberikan rempah-rempah dan perhiasan yang dibawanya pada Salomo, Ratu juga memberikan 4.500 kg emas! Salomo memang adalah orang paling kaya dan bijaksana di dunia.","ac204",20);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 21
                    kisahAlkitab = new KisahAlkitab("c213","Elia Naik Kereta Berapi\n 2 Raja-raja 2:1-15","jc21",21);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c211","Elia adalah nabi besar untuk Tuhan dan sekarang sudah waktunya bagi Tuhan untuk membawa Elia ke sorga. Elisa adalah pembantu Elia mereka berjalan ke sungai Yordan bersama-sama.","ac211",21);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c211","Elia berkata pada Elisa “apa yang bisa aku lakukan untukmu sebelum aku pergi?” Elisa berkata ”Berikanlah dua bagian rohmu” Elia berkata ”Kalau kau bisa melihat aku ketika aku pergi kau akan mendapatkannya”","ac212",21);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c212","Wshh!.... Tiba-tiba sebuah kereta dan kuda dari api muncul dan kereta itu datang ke antara Elia dan Elisa. Elia melepaskan jubahnya untuk Elisa.","ac213",21);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c213","Kemudian Elisa melihat Elia naik angin beliung dan angin beliung membawa Elia ke sorga dan Elisa melihatnya terjadi. Tapi ia tidak pernah melihat Elia lagi.","ac214",21);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c214","Elisa menyobek jubahnya sendiri untuk menunjukan betapa sedihnya dia, kemudian Elisa mengambil jubah Elia dan pergi. Alkitab mencatat bahwa Elisa melakukan mujizat dua kali lebih banyak daripada Elia! Ini karena Allah memberikan dua bagian roh Elia pada Elisa.","ac215",21);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 22
                    kisahAlkitab = new KisahAlkitab("c225","Lagu Gembala\n Mazmur 23","jc22",22);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c221","Ini adalah salah satu lagu yang ditulis oleh Daud. Ia mungkin menyanyikan lagu ini pada Raja Saul.","ac221",22);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c222","Tuhan seperti gembala dan aku dombanya Ia memberikan semua yang aku butuhkan. Ia memberi aku tempat istirahat dan seperti domba beristirahat di padang rumput yang hijau.","ac222",22);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c223","Aku tidak akan kehausan kalau Tuhan dekat. Ia akan menunjukan tempat air yang paling segar lalu aku segera minum dan menjadi kuat kembali.","ac223",22);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c224","Tuhan menuntun aku di jalan yang benar bahkan kalau aku harus berjalan di dalam lembah yang gelap aku tidak takut karena Ia akan selalu ada disana untuk melindungi dan menuntun aku.","ac224",22);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c225","Tuhan memberi aku cukup makanan bahkan di depan musuh-musuhku Ia membuat aku kaya, Ia memberikan lebih banyak dari yang aku minta! Aku tahu bahwa kebaikan dan kasih Tuhan akan selalu bersamaku seumur hidupku dan Aku akan tinggal bersama-Nya selamanya.","ac225",22);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 23
                    kisahAlkitab = new KisahAlkitab("c234","Tiga Orang di Tengah Api\n Daniel 3:1-30","jc23",23);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c231","Bangsa Yehuda ditawan sebagai budak di Babilonia dan raja Babilonia tidak mengenal Tuhan, ia membangun patung emas besar untuk disembah orang, ketika musik berbunyi semua orang harus menyembah pada patung dan kalau mereka tidak menyembah mereka akan dilemparkan ke perapian yang besar.","ac231",23);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c232","Bum...bum..treet… Musik berbunyi, semua orang menyembah patung kecuali tiga orang Yahudi yaitu Sadrakh, Mesakh dan Abednego tahu bahwa mereka hanya boleh menyembah Tuhan yang ada di sorga. Mereka tidak mau menyembah patung.","ac232",23);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c233","Raja Babilonia menjadi sangat marah, ia berkata “Kalian bertiga harus menyembah patung emasku, kalau tidak aku akan melemparkan kalian ke api. Lalu tidak akan ada dewa yang bisa menyelamatkan kalian” Tapi Sadrakh, Mesakh dan Abednego tidak mau menyembah patung.","ac233",23);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c234","Api yang besar menyala-nyala di perapian dan panasnya tujuh kali lebih panas dari api biasanya, para prajurit mengikat ketiga orang itu dan melemparkannya ke api. Tapi ketika raja memandang, ia melihat ada empat orang yang didalam api. Mereka kelihatan berjalan-jalan dan api tidak menyakiti mereka.","ac234",23);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c235","Raja Babilonia menyuruh ketiga orang itu dikeluarkan dari api kemudian ia memuji Allah! Ia berkata ”Allahmu telah mengirim malaikat untuk menyelamatkan kalian dari api, tidak ada dewa lain yang bisa menyelamatkan umat-Nya seperti ini” Dan ia benar.","ac235",23);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

//                    cerita 24
                    kisahAlkitab = new KisahAlkitab("c244","Daniel di Goa Singa\n Daniel 6:1-28","jc24",24);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c241","Daniel adalah salah seorang bangsa Yehuda di Babilonia dan ia adalah orang penting di bawah pemerintahan Raja Darius. Raja sangat menyukai Daniel karena Daniel rajin dan jujur.","ac241",24);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c242","Raja Darius bermaksud menjadikan Daniel pejabat tertinggi di kerajaannya ini membuat para pejabat lain marah dan mereka membuat rencana untuk menyingkirkan Daniel. Para pejabat meminta raja membuat hukum bahwa semua orang hanya boleh berdoa pada Raja Darius dan kalau ada yang berdoa pada yang lain ia akan dilemparkan ke goa yang berisi singa-singa.","ac242",24);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c243","Daniel mendengar tentang hukuman baru itu tetapi ia tetap berdoa tiga kali sehari pada Tuhan Allah, orang-orang jahat melaporkan ini pada raja dan raja sangat sedih ia tidak mau melukai Daniel tetapi hukum tidak bisa diubah dan ia terpaksa memasukan Daniel ke goa singa dan ia berkata ”Kiranya Tuhan yang kau layani menyelamatkan engkau","ac243",24);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c244","Raja tidak bisa tidur semalaman dan ia cemas akan Daniel, keesokan paginya ia cepat-cepat ke goa singa dan ingin memastikan bahwa daniel masih hidup. Allah telah menutup mulut-mulut singa agar singa itu tidak bisa melukai daniel.","ac244",24);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c245","Raja Darius menyuruh semua pejabat yang jahat dimasukan ke goa singa lalu ia mengeluarkan hukum baru bahwa hukum itu mengatakan semua orang yang di kerajaanya harus menghormati dan takut pada Allah Daniel. Hukum itu berbunyi ”Allah Daniel adalah Allah yang hidup dan Ia hidup selamanya","ac245",24);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 25
                    kisahAlkitab = new KisahAlkitab("c254","Yunus Lari dari Tuhan\n Yunus 1-4","jc25",25);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c251","Yunus adalah seorang nabi. Ia adalah salah satu juru bicara Tuhan, Allah berkata kepada Yunus ”Pergilah mengingatkan penduduk Niniwe, mereka telah melakukan hal-hal jahat”","ac251",25);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c252","Yunus tidak mau ke Niniwe jadi ia melarikan diri dari Allah dan ia pergi dengan kapal yang berlayar akan tetapi segera saja badai mengamuk tiba-tiba, byarr….. Byarrr!! Air masuk kedalam kapal yang ditumpangi Yunus dan para pelaut menjadi takut yang mengira kapal yang mereka tumpangi akan tenggelam.","ac252",25);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c253","Yunus berkata ”Badai ini datang karena kesalahan aku yang melarikan diri dari hadapan Allah, kalian harus melemparkan aku ke laut dan badai ini akan berhenti”. Para pelaut tidak mau melukai Yunus akan tetapi tidak ada cari lain untuk menyelamatkan kapal selain melemparkan Yunus kedalam laut.","ac253",25);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c254","Akhirnya para pelaut melemparkan Yunus ke laut dan Allah mengirimkan ikan besar untuk menelan Yunus, ia berada di perut ikan selama tiga hari penuh dan rumput laut yang licin dan berlendir memenuhi kepalanya, benar benar tidak enak!","ac254",25);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c255","Yunus menyesal telah lari dari Tuhan dan ia berdoa agar Tuhan mengampuni dan menolongnya dan kemudian Allah membuat ikan memuntahkan Yunus ke pantai. Yunus bangun dan pergi ke Niniwe untuk memperingatkan penduduk seperti yang diperintahkan Allah kepadanya.","ac255",25);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 26
                    kisahAlkitab = new KisahAlkitab("c263","Maria dan Malaikat\n Lukas 1:26-38","jc26",26);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c261","Maria adalah seorang gadis Yahudi ia baik hati dan belum menikah namun di suatu hari seorang malaikat bernama Gabriel datang untuk menemui Maria. Maria merasa takut. Gabriel berkata ”Jangan takut, Maria. Allah telah memilihmu untuk tugas istimewa!","ac261",26);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c262","Malaikat mengatakan bahwa Maria akan mempunyai seorang anak laki-laki. Ia akan menjadi bayi paling istimewa yang pernah lahir Ia adalah Anak Allah!.","ac262",26);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c263","Malaikat berkata “Namai bayi itu, Yesus, Ia akan menyelamatkan manusia dari kesalahan yang mereka lakukan” Maria berkata ”Aku hamba Allah biarlah terjadi seperti yang  mereka lakukan” lalu malaikat itu pergi.","ac263",26);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 27
                    kisahAlkitab = new KisahAlkitab("c274","Yesus Lahir\n Lukas 2 :1-7,","jc27",27);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c271","Pada zaman itu bangsa Yahudi diperintah oleh bangsa Romawi, penguasa Romawi Kaisar Agustus membuat peraturan baru ia berkata semua orang harus mendaftarkan diri dari kampung halamannya masing-masing.","ac271",27);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c272","Maria dan Yusuf pergi ke Betlehem untuk mendaftarkan nama mereka dan itu adalah perjalanan yang panjang dan melelahkan bagi Maria, sebentar lagi ia akan melahirkan bayinya.","ac272",27);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c273","Di Betlehem, Maria dan Yusuf mencari penginapan tetapi penginapan sudah penuh tidak ada kamar lagi untuk Maria dan Yusuf, jadi mereka menginap di kandang tempat ternak tinggal.","ac273",27);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c274","Malam itu juga bayi Maria Lahir! Maria membungkusnya dengan kain. Ia memakai palungan sebagai tempat tidur bayinya. Maria dan Yusuf menamai bayi itu Yesus seperti yang diperintahkan Allah. Itu adalah malam yang indah, Anak Allah telah Lahir.","ac274",27);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 28
                    kisahAlkitab = new KisahAlkitab("c286","Gembala Mengunjungi Bayi Yesus\n Lukas 2:8-20","jc28",28);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c281","Pada malam kelahiran Yesus beberapa gembala mendapat kejutan dan mereka sedang menjaga domba di padang rumput dekat sana. Tiba-tiba seorang malaikat Tuhan muncul dan para gembala itu sangat ketakutan.","ac281",28);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c282","Malaikat itu berkata “Jangan takut, aku membawa berita baik dan semua orang akan senang mendengarnya, hari ini Juruselamat telah lahir di Betlehem dan Ia adalah Kristus Tuhan! Kalian akan menemukan seorang bayi terbungkus kain dan berbaring di palungan. Nama Bayi itu adalah Yesus”.","ac282",28);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c283","Lalu sekelompok besar malaikat dari sorga mulai memuji Tuhan mereka bernyanyi ”Muliakan Tuhan di sorga! dan damai di bumi bagi orang yang menyukakan hati Tuhan.” lalu para malaikat itu hilang.","ac283",28);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c284","Para gembala berkata satu sama lain ”Ayo kita ke Betlehem dan melihat apa yang terjadi” dan mereka semua berangkat ke Betlehem.","ac284",28);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c285","Segera saja para gembala menemukan Bayi Yesus. Ia berbaring di palungan seperti kata malaikat. Para gembala menceritakan apa yang dikatakan malaikat tentang Yesus. Semua sangat tercengang.","ac285",28);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c286","Kemudian para gembala kembali ke domba-domba mereka, mereka memuji Tuhan dan bersyukur padaNya untuk semua yang telah mereka lihat dan dengar. Persis seperti kata malaikat, Anak Allah telah lahir!","ac286",28);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 29
                    kisahAlkitab = new KisahAlkitab("c294","Orang Majus Membawa Hadiah\n Matius 2:1-12","jc29",29);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c291","Ketika Yesus lahir, Allah memasang bintang baru di langit. Bintang itu menunjukan bahwa Anak Allah telah lahir. Ia akan menjadi Raja seluruh dunia.","ac291",29);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c292","Beberapa orang majus melihat bintang itu dan mereka adalah orang-orang bijaksana yang tinggal di timur, orang-orang majus mengikuti bintang baru itu sampai ke Yerusalem dan mereka ingin melihat sang bayi yang akan menjadi raja dan perjalanan itu memakan waktu yang lama.","ac292",29);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c293","Pada saat itu Herodes menjadi raja dan orang-orang majus ke tempat Herodes untuk bertanya ”Dimana bayi yang baru lahir dan akan menjadi raja orang Yahudi itu? Kami melihat bintangNya di timur. Kami datang untuk menyembah Dia","ac293",29);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c294","Ketika Herodes mendengar ada raja baru orang Yahudi, ia menjadi cemas dan ia mengira raja baru ini akan mengambil tahtanya. Ia memanggil semua imam dan ahli kitab suci untuk membantunya. Mereka berkata “Kristus lahir di Betlehem","ac294",29);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c295","Kemudian Herodes menemui orang-orang majus, ia berkata ”Pergilah ke Betlehem dan cari Anak itu, kalau sudah kalian temukan dan kembalilah ke sini dan beritahu aku. Aku ingin menyembah Dia juga” Tapi ketika mereka pergi, orang-orang majus mengikuti bintang baru itu lagi.","ac295",29);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c296","Bintang itu menuntun orang-orang majus ke tempat Yesus. Mereka sangat gembira! Mereka memberikan hadiah istimewa untuk Yesus, yaitu mur dan kemenyan dan mereka juga memberikan emas. Mereka berlutut dan menyembah Yesus.","ac296",29);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c297","Ketika orang-orang majus pergi, Allah berbicara pada mereka dalam mimpi dan ia melarang mereka kembali pada Herodes. Herodes ingin membunuh Yesus dan orang-orang majus pulang ke negara mereka lewat jalan lain.","ac297",29);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 30
                    kisahAlkitab = new KisahAlkitab("c305","Yesus Kecil\n Lukas 2:40-52","jc30",30);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c301","Yesus mulai besar dan Ia menjadi lebih kuat dan lebih pintar karena Allah selalu menyertai-Nya.","ac301",30);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c302","Setiap tahun orang tua Yesus pergi ke Yerusalem untuk mengikuti perayaan yang disebut Paskah dan ketika Yesus berumur dua belas tahun mereka pergi ke perayaan itu. Mereka pergi bersama teman-teman dan kerabatnya.","ac302",30);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c303","Ketika hari perayaan sudah berlalu orang tua Yesus mulai berjalan pulang dan Yesus kecil masih berada di Yerusalem akan tetapi orang tua-Nya tidak tahu karena mereka mengira ia bersama kerabat atau rombongan mereka","ac303",30);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c304","Mereka sudah berjalan satu hari lalu orang tua Yesus mulai mencari-Nya akan tetapi Ia tetap tidak ada dan mereka cepat-cepat kembali ke Yerusalem untuk mencari-Nya mereka mencari dan mencari selama tiga hari penuh.","ac304",30);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c305","Akhirnya mereka menemukan Yesus dan ternyata Ia berada di bait Allah sedang bercengkrama dengan ahli-ahli Firman Allah. Ia mendengarkan mereka dan bertanya dan semua tercengang melihat betapa bijaksananya Yesus pada umur semuda itu bahkan orang tuanya juga heran.","ac305",30);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c306","Ibu Yesus bertanya ”Nak, mengapa kau melakukan itu kepada kami??? Ayah-Mu dan aku sangat cemas, kami mencari-cari kamu” Yesus berkata ”Mengapa kalian mencari aku?? Seharusnya ibu tahu aku berada di rumah Allah.","ac306",30);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c307","Lalu Yesus pulang bersama orangtua-Nya dan Ia taat pada mereka, Ia terus tumbuh besar dan orang-orang menyukai Yesus dan Ia menyenangkan hati Allah.","ac307",30);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 31
                    kisahAlkitab = new KisahAlkitab("c313","Yohanes Membaptis Yesus\n Matius 3 : 13-17","jc31",31);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c311","Sekian tahun kemudian Yohanes pembaptis sedang berkhotbah di padang gurun dan Yesus pun datang untuk menemui Yohanes di sungai Yordan.","ac311",31);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c312","Yesus ingin Yohanes membaptis diri-Nya tetapi Yohanes mencoba menghentikan Yesus dan ia pun berkata ”Mengapa Engkau meminta aku membaptis Engkau??? Seharusnya akulah yang dibaptis oleh-Mu” Yesus pun berkata ”Kita harus melakukan semuanya dengan cara yang benar, jadi sekarang kau harus membaptis aku”","ac312",31);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c313","Yohanes dan Yesus pergi ke sungai Yordan dan membaptis Yesus disana dan kemudian Yesus muncul dari sungai.","ac313",31);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c314","Pada saat itu langit terbuka dan Roh Allah dalam bentuk merpati turun ke atas Yesus dan sebuah suara terdengar ”Ini adalah Anak-Ku, dan aku mengasihi dia. Aku sangat berkenan akan Dia.” itu adalah suara Allah.”","ac314",31);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 32
                    kisahAlkitab = new KisahAlkitab("c322","Yesus mengajar Orang Banyak\n Matius 5-7","jc32",32);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c321","Ketika umur Yesus sekitar tiga puluh tahun Ia mulai mengajar orang banyak yang mengikuti Dia dan mereka juga mendengarkan Yesus berbicara. Pada suatu hari Yesus pergi ke lereng bukit untuk mengajar banyak orang tentang Allah.","ac321",32);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c322","Hari itu Yesus berkata kepada banyak orang bahwa mereka itu seperti lampu “Kalian itu seperti lampu yang menerangi dunia jadi jangan sembunyikan cahayamu dibawah mangkuk dan hiduplah dengan baik supaya orang-orang melihat perbuatan baikmu dan juga hiduplah supaya mereka memuliakan Allah","ac322",32);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c323","Yesus juga berkata bahwa orang tidak boleh saling membenci karena itu Yesus berkata kita harus berdamai dengan orang lain jadi kita juga bisa berdamai dengan Allah.","ac323",32);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c324","Hal lain yang diajarkan Yesus adalah kasihanilah orang lain ”Jangan hanya menyayangi teman-teman namun sayangi juga musuh-musuhmu seperti kamu menyayangi dirimu sendiri” karena Allah di sorga juga menyayangi mereka.”,","ac324",32);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 33
                    kisahAlkitab = new KisahAlkitab("c334","Mujizat Yesus yang pertama\n Yohanes 2:1-12","jc33",33);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c331","Yesus dan murid-murid-Nya pergi ke pesta perkawinan pesta itu berada di kota kana di daerah yang bernama Galilea,ibu Yesus juga berada disana.","ac331",33);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c332","Tamu-tamu pesta sudah meminum habis semua anggur,ibu Yesus pun berkata padanya”Mereka kehabisan anggur” dan Yesus pun berkata”Aku belum bisa membantu ibu karena belum waktunya bagiKu untuk melakukan mujizat” tapi ibu--nya berkata pada para pelayan”Lakukan apa yang ia perintahkan","ac332",33);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c333","Yesus melihat enam tempayan atau guci besar dari tanah liat dan tiap tempayan itu bisa diisi sekitar seratus liter air dan Yesus menyuruh para pelayan untuk mengisi tempayan itu dengan air dan mereka mengisinya sampai penuh.","ac333",33);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c334","Yesus berkata pada para pelayan”Ambik sedikit air dari tempayan dan bawa ke pemimpin pesta”ketika ia mencicipinya air itu ternyata sudah berubah menjadi anggur,pemimpin pesta tidak tahu darimana para pelayan mendapatkan anggur”,","ac334",33);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c335","Pemimpin pesta berbicara pada pengantin pria dan ia pun berkata “Orang lain selalu menghidangkan anggur terbaik dulu tapi kau menghidangkan anggur terbaik belakangan” ini adalah mujizat Yesus pertama dan ketika murid-murid-Nya melihat apa yang terjadi mereka percaya kepada Yesus.","ac335",33);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 34
                    kisahAlkitab = new KisahAlkitab("c344","Yesus memilih dua belas murid\n Markus 3:13-19","jc34",34);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c341","Yesus memilih dua belas orang untuk menjadikan mereka pembantu istimewa-Nya dan mereka disebut para rasul atau murid-murid Yesus.Yesus ingin keduabelas orang ini selalu bersamanya kapanpun.","ac341",34);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c342","Keduabelas orang ini mempunyai tugas khusus membantu Yesus dan ia ingin mengirim mereka ke kota kota dan negri-negri lain dan disanalah mereka akan menceritakan kabar baik tentang Allah.","ac342",34);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c343","Yesus memberi kuasa khusus pada para rasul,mereka bisa mengusir roh jahat dari tubuh manusia dan mereka juga bisa melakukan hal-hal luar biasa untuk menunjukan Allah beserta mereka.","ac343",34);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c344","Inilah orang-orang yang dipilih Yesus menjadi murid Istimewah-Nya:Petrus,Andreas,Yakobus,Yohanes,Matius,Simon,Yakobus anak Alfeus,Filipus,Bartolomeus,Thomas,Tadeus dan Yudas iskariot.","ac345",34);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 35
                    kisahAlkitab = new KisahAlkitab("c355","Bekal seorang Anak\n Yohanes 6:1-15","jc35",35);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c351","Suatu hari dimana orang banyak datang untuk mendengarkan Yesus berkhotbah dan Yesus berkata pada filipus “ Dimana kita bisa membeli roti untuk memberi makan semua orang ini?” filipus pun menjawab”Kita harus menghabiskan upah satu bulan untuk membeli itu”","ac351",35);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c352","Andreas berkata “disini ada anak lelaki yang membawa bekal makan siang dan ia membawa lima roti dan dua ikan kecil namun itu tidak cukup untuk semua orang yang datang","ac352",35);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c353","Yesus berkata “Suruhlah orang-orang duduk dan disana banyak rumput.ditempat ada sekitar lima ribu orang yang duduk diatas rumput.","ac353",35);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c354","Yesus mengucapkan syukur kepada Allah untuk roti itu dan memberikannya pada orang-orang.ia melakukan hal yang sama pada ikan itu dan ia memberi mereka makan sebanyak mereka mau sampai mereka puas dan kenyang.","ac354",35);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c355","Setelah semua sudah selesai makan Yesus berkata kepada murid-muridnya “kumpulkanlah makanan yang masih tersisa dan jangan membuang buang makanan”ada dua belas keranjang potongan roti dan ikan yang masih tersisa.","ac355",35);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c356","Orang banyak melihat Yesus memberi makan ribuan orang dengan bekal makan siang seorang anak laki-laki dan itu adalah mukjizat,begitulah mereka tahu bahwa Yesus datang dari Allah.","ac356",35);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 36
                    kisahAlkitab = new KisahAlkitab("c364","Yesus berjalan diatas air.\n Matius 14:22-33","jc36",36);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c361","Yesus menyuruh murid-muridnya untuk pergi naik perahu dan ia menyuruh mereka pergi terlebih dahulu untuk menyebrangi danau.Yesus tinggal disana untuk mengucapkan selamat jalan pada orang banyak lalu ia naik ke bukit sendirian untuk berdoa.","ac361",36);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c362","Ketika Yesus selesai berdoa hari sudah sangat malam sekitar antara jam tiga pagi dan jam enam pagi,perahu murid Yesus mendapatkan kesulitan ditengah danau.angin dan gelombang membuat perahu murid Yesus terombang ambing di Danau.","ac362",36);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c363","Yesus  berjalan diatas air ke arah perahu dan murid-muridnya melihat ia datang akan tetapi mereka tidak menyadari bahwa Yesus yang datang","ac363",36);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c364","Yesus berkata kepada mereka ”jangan takut ini aku” Petrus menjawab”Tuhan kalau itu benar-benar engkau biarkan aku berjalan ke tempat mu di atas air” Yesus menjawab ”datanglah”,","ac364",36);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c365","Petrus turun dari perahu dan berjalan ke arah Yesus diatas air,lalu ia memikirkan tentang angin dan gelombang dan ia menjadi takut dan mulai tenggelam kedalam air.","ac365",36);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c366","Petrus mengira ia akan tenggelam ia berseru kepada Yesus”Tuhan,selamatkan aku” Yesus menolong Petrus dan ia berkata “Mengapa engkau ragu-ragu? Imanmu kecil” Yesus dan petrus berjalan bersama dan naik ke perahu,kemudian murid Yesus menyembah Yesus dan berkata”Engkau benar-benar anak Allah","ac366",36);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 37
                    kisahAlkitab = new KisahAlkitab("c373","Orang buta bisa melihat\n Yohanes 9:1-12","jc37",37);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c371","Yesus dan murid Yesus sedang berjalan-jalan dan melihat seorang buta dan orang itu sudah buta sejak lahir.Yesus berkata bahwa orang itu buta supaya Allah bisa menunjukan betapa berkuasanya ia.","ac371",37);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c372","Yesus meludah ke tanah dan membuat lumpur dan ia mengoleskan lumpur itu ke mata orang buta itu dan ia berkata pada orang buta itu “Pergilah dan cuci matamu di kolam siloam","ac372",37);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c373","Orang buta itu pergi ke kolam dan mencuci matanya lalu ia bisa melihat,kuasa Allah telah menyembuhkan dan orang yang melihat mujizat itu terkejut dan merek bertanya-tanya apakah itu benar orang buta atau bukan tapi orang buta itu berkata”Ya,aku adalah orang yang buta sejak lahir”","ac373",37);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c374","Orang-orang bertanya”Apa yang terjadi?bagaimana kau bisa melihat??” orang itu menceritakan apa yang dilakukan Yesus pada dia.","ac374",37);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 38
                    kisahAlkitab = new KisahAlkitab("c384","Orang samaria yang baik hati.\n Lukas 10:25-37","jc38",38);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c381","Yesus menceritakan kisah tentang sesama manusia yang baik ini pada seorang ahli taurat.ahli taurat adalah orang orang yang mempelajari hukum Allah,suatu hari seorang Yahudi sedang dalam perjalanan dari Yerusalem ke Yerikho namun ada beberapa perampok yang menyerangnya mereka menyobek jubahnya dan memukuli dai kemudian mereka meninggalkan terbaring di jalanan dan ia sudah hampir mati.","ac381",38);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c382","Seorang imam Yahudi lewat di jalan itu dan ia melihat seorang itu terbaring lemas tak berdaya.tapi ia tidak berhenti untuk menolong malah menyebrang dan terus berjalan","ac382",38);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c383","Kemudian seorang pembantu imam lewat juga dijalanan itu dan ia mendekati dan melihat orang yang terluka itu namun ia juga hanya menyebrang dan berjalan terus tidak berhenti untuk menolong","ac383",38);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c384","Akhirnya ada yang lewat seorang musuh bangsa Yahudi ia adalah seorang samaria,ketika ia melihat orang yang terluka ia merasa sangat kasihan dan ia membalut luka orang itu dan meletakan orang itu di keledainya dan membawanya ke penginapan disana ia merawat orang terluka itu.","ac384",38);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c385","Keesokan harinya orang samaria itu memberi dua keping uang pada pemilik penginapan dan ia berkata “Rawatlah orang ini kalau kau mengeluarkan uang lebih dari ini aku akan membayarnya lebih ketika aku kembali","ac385",38);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c386","Ketika cerita itu selesai Yesus bertanya kepada ahli taurat itu”Siapakah di antara ketiga orang ini yang menjadi sesama manusia yang baik pada orang terrluka itu? Ahli taurat itu menjawab”Orang yang berhenti dan menolongnya”dan Yesus membalas “Pergilah dan berbuatlah baik pada sesamamu manusia","ac386",38);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 39
                    kisahAlkitab = new KisahAlkitab("c393","Anak yang hilang \n Lukas 15:11-24","jc39",39);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c391","Yesus bercerita pada orang-orang farisi dan ahli taurat sebuah kisah tentang seorang bapak yang mempunyai dua anak laki-laki dan anak bungsu meminta bagian warisannya dan pergi dari rumah.","ac391",39);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c392","Anak bungsu pergi ke negeri yang jauh dan disana ia menghabiskan semua uangnya menghamburkan untuk hal-hal yang bodoh dan tidak penting,di negeri itu sudah lama tidak turun hujan jadi tidak cukup makanan untuk semua orang dan pemuda itu menjadi sangat kelaparan.","ac392",39);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c393","Ia mencoba mencari pekerjaan dan pekerjaan yang ia dapatkan hanyalah sebagai pengurus babi karena ia sangat lapar sampai ingin memakan babi yang diternak.","ac393",39);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c394","Lalu pemuda itu berpikir “apa aku benar-benar bodoh,bahkan pelayan ayahku punya cukup makanan akan tetapi aku disini kelaparan,aku akan pulang dan minta ayahku menerimaku sebagai pelayan”,jadi ia pulang kerumah.","ac394",39);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c395","Ketika anak itu masih jauh,ayahnya melihat  dia datang dan ia merasa kasihan melihat anaknya ia berlari dan memeluk nya lalu ia mengadakan pesta besar karena ia sangat bahagia anaknya yang hilang kembali lagi kerumah.","ac395",39);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 40
                    kisahAlkitab = new KisahAlkitab("c403","Persembahan Janda miskin \n Markus 12:41-44","jc40",40);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c401","Yesus sedang duduk dekat peti uang di bait Allah dan ia sedang mengamati orang yang memaasukan persembahannya untuk Tuhan.","ac401",40);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c402","Pertama datang orang kaya,mereka memasukan banyak uang kedalam kotak persembahan.","ac402",40);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c403","Kemudian datang seorang janda miskin,ia memasukan dua uang peser yang sangat  kecil dan uang ini bahkan tidak sampai lima puluh rupiah","ac403",40);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c404","Yesus memanggil murid-muridnya ia berkata “Janda miskin ini hanya memberi dua uang kecil akan tetapi sebenarnya ia memberi lebih banyak daripada semua orang kaya itu.karena orang kaya mempunyai banyak uang dan mereka memberi apa yang tidak mereka butuhkan namun ibu miskin ini memberikan semua yang ia miliki dan ia memerlukan uang itu untuk hidupnya.","ac404",40);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 41
                    kisahAlkitab = new KisahAlkitab("c412","Perjamuan terakhir  \n Lukas 22:7-20; 1 Korintus 11:23-26","jc41",41);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c411","Setiap tahun umat Allah makan jamuan paskha,jamuan itu membantu mereka mengingat bagaimana Allah menyelamatkan mereka dari perbudakan di Mesir,Yesus sudah menyuruh Petrus dan Yohanes menyiapkan jamuan Paskha.Mereka akan makan bersama di lantai atas sebuah rumah.","ac411",41);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c412","Ketika jamuan sudah siap,Yesus dan murid-murdnya duduk dan Yesus berkata”Aku makan jamuan paskah ini bersama kalian sebelum akaku matik dan kalau kita makan jamuan ini lagi kita akan berada di kerajaan Allah dan arti dari perjamuaan ini akan lebih jelas.","ac412",41);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c413","Yesus mengambil roti dan mengucap syukur pada Tuhan lalu ia memberikannya kepada murid-muridnya dan berkata “Roti ini akan mengingatkan kamu akan tubuhKu dan ingatlah aku ketika kamu memakannya.","ac413",41);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c414","Lalu Yesus mengambil secawan anggur dan ia mengucap syukur kepada Tuhan untuk itu lalu berkata “Cawan ini melambangkan perjanjian baru dari Allah untuk umatnya dan perjanjian baru akan dimulai ketika aku mati,anggur ini akan mengingatkan kamu akan pada darahku,ketika kamu meminum anggur lakukan untuk mengingat aku” setelah makan malam mereka menyanyikan satu lagu lalu pergi.","ac414",41);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c415","Sekarang setiap kali kita makan roti dan anggur perjamuan kudus kita akan selalu mengingat Yesus dan kita menunjukan pada orang lain tentang kematian dan kita akan terus melakukan ini sampai Yesus datang kembali.","ac415",41);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 42
                    kisahAlkitab = new KisahAlkitab("c423","Yesus ditangkap \n Markus 14:32-50","jc42",42);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c421","Setelah perjamuan terakhir,Yesus dan murid-muridnya pergi ke bukit zaitun dan ini adalah bukit yang banyak ditumbuhi pohon zaitun,Yesus pergi lebih jauh sendirian dan berdoa tiga kali pada saat itu murid-muridnya ketiduran.","ac421",42);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c422","Yesus kembali dan berkata “Bangun,kita harus pergi,orang yang akan menyerahkan aku pada musuh-musuhku sudah datang”,pada saat itu Yudas iskariot membawa sepasukan tentara dan orang-orang lain ke tempat Yesus,Yudas adalah salah satu murid Yesus.","ac422",42);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c423","Orang ini dikirim oleh imam-imam kepala,ahli taurat dan pemimpin Yahudi lainnya,mereka semua membawa pentungan dan pedang.Yudas memberitahu para prajurit untuk memperhatikan tandanya dan ia akan mencium orang yang adalah Yesus.","ac423",42);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c424","Yudas mendekati Yesus dan berkata”Guru,ia mencium Yesus lalu orang orang itu membawa Yesus.Yesus berkata” ini terjadi supaya apa yang dikatakan dalam kitab suci menjadi sebuah kenyataan” lalu semua murid Yesus meninggalkan dia dan melarikan diri.","ac424",42);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 43
                    kisahAlkitab = new KisahAlkitab("c434","Yesus Mati\n Matius 27:32-61; Markus 15:16-47","jc43",43);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c431","Yesus dibawa ke pengadilan karena orang orang berbohong tentang dia pada hakim.Yesus dinyatakan bersalah dan mereka memutuskan Yesus harus mati disalib","ac431",43);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c432","Pada hari Jumat para prajurit memukuli Yesus,ia sangat lemah dan ia tidak bisa membawa salib kayu yang berat ke tempat dimana mereka akan menyalibkan dia.para prajurit memaksa seorang bernama simeon untuk membawa salib Yesus.","ac432",43);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c433","Para prajurit membawa Yesus ke tempat yang disebut Golgota.ini adlaah sebuah bukit di luar kota Yerusalem dan mereka memaku Yesus ke salib lalu para prajurit mengundi pakaian Yesus pada saat itu jam sembilan pagi.","ac433",43);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c434","Sebuah tanda dipaku di salib Yesus,Tulisan yang berbunyi”Raja orang Yahudi” dua perampok juga dipaku di salib dan orang orang yang lewat hanya mengatakan hal-hal yang jahat kepada Yesus”Selamatkanlah Dirimu Sendiri dan turun dari salib itu kalau kau memang anak Allah”.","ac434",43);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c435","Tepat tengah hari,seluruh daerah itu menjadi gelap dengan berlangsung selama tiga jam.dan pada jam 3 sore Yesus mati demi untuk menebus seluruh dosa Dunia.","ac435",43);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c436","Ketika Yesus mati,tirai besar di bait Allah robek menjadi dua bagian dan tirai itu robek dari atas sampai bawah.ada gempa bumi dan batu-batu besar pecah,kuburan-kuburan terbuka dan orang-orang mati hidup kembali.para prajurit yang menjaga Yesus berkata”ia benar-benar Anak Allah”.","ac436",43);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c437","Hari Jum’at sore,Yesus dikubur dan ada seorang pria yang bernama Yusuf menguburkan Yesus di kuburan baru miliknya,sebuah batu besar dipasang di mulut goa tempat mengubur Yesus dan Yesus sudah mati para pengikutnya sangat sedih.","ac437",43);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 44
                    kisahAlkitab = new KisahAlkitab("c444","Yesus Hidup Kembali \n Matius 28:1-10","jc44",44);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c441","Hari minggu pagi-pagi sekali dua wanita pergi ke kuburan Yesus dan mereka adalah maria magdalena dan wanita lain bernama maria","ac441",44);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c442","Pada saat itu ada gempa bumi besar,seorang malaikat Tuhan turun dari sorga dna ia membantu mendorong batu besar yang menutupi kuburan Yesus,ia bersinar seterang kilat dan pakaiannya seputih salju.","ac442",44);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c443","Para prajurit yang menjaga kuburan sangat takut pada malaikat itu dan mereka gemetar ketakutan lalu mereka menjadi diam dan terpaku seperti orang mati.","ac443",44);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c444","Malaikat itu berkata pada kedua wanita itu “Jangan takut,aku tahu kalian mencari Yesus yang mati itu,ia tidak ada disini ia sudah bangkit dan hidup. Seperti yang dikatakannya,pergilah dan beritahu para pengikut-nya ia hidup.","ac444",44);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c445","Para wanita itu takut akan tetapi mereka sangat bahagia dan mereka berlari untuk memberitahu murid-murid Yesus apa yang telah terjadi,saat mereka pergi Yesus menemui mereka berlutut dan memegang kaki Yesus dan menyembah dia.Yesus berkata”jangan takut,pergilah dan suruhlah murid-muridku untuk ke Galilea,dan mereka akan bertemu aku disana.","ac445",44);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c446","Kedua wanita itu berlair untuk memberitahu murid-murid Yesus bahwa ia hidup lalu kesebelas murid Yesus pergi ke Galilea dan mereka naik ke sebuah bukit,seperti yang diperintahkan Yesus di bukit itu mereka melihat Yesus dan menyembah dia,Yesus hidup Kembali.","ac446",44);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);


                    //cerita 45
                    kisahAlkitab = new KisahAlkitab("c453","Yesus kembali ke Sorga. \n Kisah Para Rasul 1:6-12","jc45",45);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c451","Yesus dan murid-muridnya sedang bersama-sama,mereka berada di bukit zaitun dan sedikit di luar kota Yerusalem.Yesus tahu sudah waktu baginya untuk kembali ke sorga.ia berkata “Roh kudus akan turun atas kamu dan kamu akan menerima kuasa istimewa.","ac451",45);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c452","Yesus memberitahu murid-murnya apa yang harus mereka lakukan,ia berkata “Kamu harus memberitakan kabar baik tentang aku di Yerusalem dan semua daerah di Yudea lalu kamu harus memberikannya di seluruh daerah samaria.Lalu beritakanlah ke seluruh dunia.","ac452",45);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c453","Setelah berkata seperti itu Yesus terangkat ke udara dan semua muridnya memandangi dia,awan menutupi Yesus dan mereka tidak bisa melihatnya,selama ia pergi mereka terus memandang ke langit.","ac453",45);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c454","Tiba-tiba dua orang yang berpakaian putih cemerlang berdiri disamping mereka lalu mereka berkata “ mengapa kamu melihat terus ke langit? Sekarang kamu melihat Yesus naik ke surga dan jangantakut ia akan kembali dengan cara yang sama seperti ia pergi” kemudian murid-murid Yesus kembali ke Yerusalem.","ac454",45);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 46
                    kisahAlkitab = new KisahAlkitab("c463","Roh kudus datang\n Kisah Para Rasul 2","jc46",46);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c461","Ketika Yesus kembali ke sorga ia berjanji kepada murid-muridnya bahwa Roh kudus akan turun untuk membantu mereka dan kira-kira lima puluh hari kemudian pada hari pentakosta murid-murid Yesus berkumpul semua.","ac461",46);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c462","Tiba-tiba mereka mendengar suara yang keras,bunyinya berasal dari angin yang kencang dan suara itu memenuhi seluruh rumah tempat mereka berkumpul.","ac462",46);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c463","Lalu murid-murid Yesus melihat sesuatu yang aneh,mereka melihat apa yang tampak seperti lidah api dan lidah-lidah api ini turun ke atas tiap orang dirumah itu,lalu setiap orang dipenuhi Roh kudus dari Allah.mereka mulai berbicara dalam bahasa-bahasa berbeda dan Roh kudus membantu mereka.","ac463",46);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c464","Orang-orang Yahudi dari seluruh dunia sedang berkumpul di Yerusalem pada saat itu dan ketika mereka mendengar suara angin mereka datang sambil berlari,setiap orang mendengar murid-murid Yesus berbicara tentang Allah dalam bahasa mereka masing-masing,benar-benar menakjubkan.","ac464",46);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c465","Lalu Petrus berdiri dan menceritakan kabar baik tentang Yesus Kristus pada orang banyak,sekitar tiga ribu orang percaya pada cerita yang diucapkan Petrus dan dibaptis pada hari itu juga.","ac465",6);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 47
                    kisahAlkitab = new KisahAlkitab("c475","Pengemis Di gerbang Indah\n Kisah Para Rasul 3:1-10","jc47",47);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c471","Suatu hari Petrus dan Yohanes pergi ke Bait Allah,waktu itu jam tiga sore itu adalah waktu untuk doa harian di bait Allah.","ac471",47);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c472","Seorang pria lumpuh duduk di depan gerbang Bait Allah,Gerbang itu disebut Gerbang indah.orang itu sudah lumpuh seumur hidup dan setiap hari ia digotong kesana untuk mengemis dan meminta uang pada orang orang yang datang ke bait Allah.","ac472",47);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c473","Orang lumpuh itu melihat Petrus dan Yohanes lalu ia berkata “Maukah kau memberi orang miskin ini sedikit uang?” Petrus dan Yohanes memandang langsung pada orang itu dan mereka berkata “ Lihatlah kami” orang lumpuh itu memandang mereka dan ia mengira mereka akan memberikan uang.","ac473",47);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c474","Petrus berkata”Kami tidak punya uang tetapi ada yang lain yang bisa kami berikan dengan kuasa Yesus Kristus berdirilah dan berjalanlah”kemudian Petrus memegang tangan kanan orang itu dan membantunya berdiri.","ac474",47);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c475","Kaki orang itu menjadi lebih kuat begitu ia berdiri  dan ia pergi bersama Petrus dan Yohanes ke Bait Allah,ia berjalan dan melompat lompat sambil memuji Allah.","ac475",47);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c476","Semua orang tahu siapa orang itu,mereka tahu ia adalah orang lumpuh yang selalu duduk di dekat gerbang dan sekarang mereka melihatnya berjalan dan melompat-lompat dan mereka terkejut dan tercengang. Petrus mengatakan pada orang-orang itu bahawa pria itu disembuhkan oleh kuasa Yesus lalu semua orang mulai memuji Allah.","ac476",47);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 48
                    kisahAlkitab = new KisahAlkitab("c482","Saulus Bertemu Yesus\n Kisah Para Rasul 9:1-22","jc48",48);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c481","Saulus sedang dalam perjalanan dari Yerusalem ke Damaskus,ia pergi kesana untuk memasukan pengikut Yesus ke penjara dan ia membawa pasukan prajurit bersamanya.","ac481",48);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c482","Tiba-tiba ada cahaya terang dari langit menyinari Saulus dan ia jatuh ke tanah,lalu ada suara berkata “Saulus,saulus,mengapa engkau menyakiti aku??” saulus berkata”Siapa engkau,Tuhan?”Suara itu berkata”Aku Yesus yang kau sakiti itu.","ac482",48);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c483","Yesus menyuruh Saulus pergi ke Damaskus dan menunggu ia berkata Saulus akan diberitahu harus berbuat apa tetapi ketika Saulus membuka matanya ia menjadi buta.Pasukannya harus menuntunya sampai ke kota dan Saulus but selama tiga hari ia tidak makan atau minum apapun.","ac483",48);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c484","Tuhan mengirim seseorang bernama Ananias untuk menemui Saulus dan ia meletakkan tangannya ke atas Saulus dan berkata”Saulus,Yesus telah mengirim aku,sekarang kau akan bisa melihat kau juga akan dipenuhi Roh Kudus dari Allah” pada saat itu juga Saulus bisa melihat lagi,ia dibaptis dimulai memberitahu orang lain tentang kabar baik mengenai Yesus.","ac484",48);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 49
                    kisahAlkitab = new KisahAlkitab("c494","Dorkas Hidup Kembali \n Kisah Para Rasul 9:36-42","jc49",49);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c491","Di kota Ype ada seorang wanita bernama Dorkas,ia adalah pengikut  Yesus dan ia selalu berbuat baik dan menolong orang miskin.suatu hari Dorkas sakit dan mati,teman-temannya meletakkannya ia di ruang atas.","ac491",49);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c492","Petrus sedang berada di Lida sebuah kota dekat Yope,teman-teman Dorkas mengirim dua orang untuk menjemput Petrus dan mereka berkata “Cepat,Petrus ikutlah bersama kami!” Petrus segera berangkat bersama mereka ke Yope.","ac492",49);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c493","Ketika Petrus tiba mereka membawanya ke ruang atas,para wanita berdiri di sekeliling Petrus sambil menangis.Mereka mengenakan pakaian yang dibuat Dorkas untuk mereka dan mereka semua sangat sedih karena Dorkas sudah Meninggal.","ac493",49);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c494","Petrus menyuruh semua orang keluar dari ruangan dan ia berlutut dan berdoa pada Tuhan lalu ia berkata pada Dorkas “Dorkas,bangunlah!” segera saja Dorkas membuka matanya dan ia melihat Petrus dan bangun,Petrus membantunya berdiri.","ac494",49);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c495","Petrus memanggil semua teman Dorkas dan para pengikut Yesus keruang itu dan ia menunjukan bahwa Dorkas hidup kembali ,semua orang diseluruh Yope mendengar apa yang terjadi dan banyak orang menjadi percaya kepada Yesus.","ac495",49);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 50
                    kisahAlkitab = new KisahAlkitab("c504","Paulus mengabarkan Injil.\n Kisah Para Rasul 13:1-3; 14:8-15","jc50",50);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c501","Di Gereja antiokhia banyak nabi dan guru,disuatu hari Roh kudus datang kepada mereka lalu Roh Kudus berkata”Berikan barnabas  dan Paulus padaku,aku punya tugas khusu untuk mereka”seluruh jemaat berdoa dan berpuasa beberapa waktu dan pmereka mendoakan barnabas dan petrus dan memberikan mereka pergi.","ac501",50);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c502","Barnabas dan Paulus pergi ke banyak kota untuk Tuhan dan kemanapun mereka pergi mereka menceritakan kabar baik tentang Yesus dan akhirnya mereka tiba di sebuah kota bernama Listra.","slide1",50);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c503","Seorang lumpuh mendengarkan khotbah Paulus dan ia sudah lumpuh seumur hidup.Paulus melihat bahwa kepercayaan orang ini pada Tuhan bisa menyembuhkannya.Paulus berkata.”Berdirilah “ dan orang itu melompat dan mulai berjalan.","ac503",50);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c504","Orang banyak melihat apa yang terjadi dan mereka merasa sangat heran,mereka mengira Paulu dan Barnabas adalah dewa dan orang orang itu berseru “Para dewa telah menjadi manusia,mereka telah turun ke tempat kita.","ac504",50);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c505","Imam dewa Zeus mendengar berita itu mereka langsung membawa beberapa kerbau jantan dan bunga ke gerbang kota.mereka ingin menyembah Barnabas dan Paulus.","ac505",50);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c506","Tapi Barnabas dan Paulus mendengar apa yang dilakukan orang-orang itu,mereka berlari ke tnagah orang banyak untuk menghentikan mereka lalu mereka berkata” Mengapa kalian melakukan ini> kami orang biasa seperti kalian dan kamu bukan dewa,kami datang untuk menceritakan kabar baik dan tinggalkan dewa-dewa kalian dan percayalah pada Tuhan yang hidup!.","ac506",50);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c507","Tetapi beberapa orang Yahudi dari antiokhia membuat orang-orang marah pada Paulus dan mereka melempari Paulus dengan batu untuk membunuhnya,tetapi ia lolos.Paulus dan Barnabas meninggalkan Listera dan pergi ke Kota Derbe.","ac507",50);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);

                    //cerita 51
                    kisahAlkitab = new KisahAlkitab("c516","Yesus akan Datang kembali.\n Wahyu 1:1-3; 21:1-22:21","jc51",51);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c511","Yohanes adalah salah satu murid Yesus,suatu hari Yesus mengirim seorang malaikat kepada Yohanes lalu ia memberi Yohanes pesan yang indah dan ia menyuruh Yohanes menulis pesan itu dalam sebuah Kitab.malaikat itu berkata”Orang yang membaca firman Tuhan dan melakukannya akan berbahagia","ac511",51);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c512","Malaikat menunjukan banyak hal-hal indah pada Yohanes,satu hal yang dilihat Yohanes adalah kota mulia yang sangat indah.kota itu terbuat dari emas murni,dan kota itu berdiri di atas permata seperti safir zamrud dan topaz","ac512",51);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c513","Kota itu mempunyai dua belas gerbang yang dimana tiap gerbang terbuat dari sebuah mutiara bessara dan jalanan kota itu terbuat dari emas murni,tetapi emas itu jernih seperti kaca.","ac513",51);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c514","Tidak perlu matahari atau bulan di kota itu,kemuliaan Tuhan sangat terang sampai tidak pernah ada malam di sana.","ac514",51);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c515","Sungai yang jernih mengalir dari tahta Allah ditengah jalanan,sungai itu sebening kristal dan pohon kehidupan ada di kedua sisi sungai,ada dua belas benih buah di pohon itu.","ac515",51);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                    kisahAlkitab = new KisahAlkitab("c516","Lalu Yesus berkata”Dengarkan,Aku akan segera datang kembali,para pengikutku akan masuk ke kota mulia ini.mereka akan minum air kehidupan dan mereka akan makan dari pohon kehidupan dan mereka akan tinggal disini selamanya” dan Yohanes berkata”Amin….Datanglah,Tuhan Yesus.","ac516",51);
                    kisahAlkitabDao.insertKisahAlkitab(kisahAlkitab);
                }
            });

        }
    };
    
}
