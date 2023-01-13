package TelevizyonSimulasyonu;



import java.util.ArrayList;

public class Televizyon {
    private String marka;
    private String boyut;
    private ArrayList<Kanal> kanallar; //array list oluşturuyorm ve içinde kanal türünde nesneler olacak.
    //bu işlemle sınıf içnde sınıf tanımladım yani kompozisyon yaptım.

    private boolean acik;
    private int ses;

    private int aktifKanal;

    //bu televizyondan bir nesne üretildiginde mutlaka marka ve boyutun parametre olarak verilmesi için const. tanımladım:
    public Televizyon(String marka, String boyut) {
        this.marka = marka;
        this.boyut = boyut;
        kanallar = new ArrayList<>(); //boyle yapmam gerekiyor ki bunun için bellekte bir yapı oluşturulabilsin, içine eleman eklenip çıkartılabilsin.

        kanallariOlustur(); //markayı modeli ata ve bununla beraber kanallari da oluştur.
        this.acik = false;
        ses = 10;

        aktifKanal=1;
    }

    // private oldukları için getter ve setterlarını da oluşturuyorum:
    public String getBoyut() {

        return boyut;
    }

    public void setBoyut(String boyut) {

        this.boyut = boyut;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {

        this.marka = marka;
    }

    @Override
    public String toString() {
        return "marka: " + marka + " boyut: " + boyut + " olan tv olusturuldu.";
    }


    private void kanallariOlustur() {
        HaberKanali cnn = new HaberKanali("cnn", 1, "Genel Haber");
        kanallar.add(cnn); /// cnn'i de array liste eklemeyi unutmuyorum.
        MuzikKanali dreamTurk = new MuzikKanali("dream turk", 2, "yerli");
        kanallar.add(dreamTurk); // arrayLİste ekleme yapıyorum.
        HaberKanali beinSpor = new HaberKanali("bein spor", 3, "spor haber");
        kanallar.add(beinSpor);
        MuzikKanali kralpop = new MuzikKanali("kral pop", 4, "yerli");
        kanallar.add(kralpop);
    }

    public void tvAc() {
        if (acik == false) { //yani televizyon kapalıysa televizyon açılsın
            acik = true;
            System.out.println("tv acildi");
        } else {
            System.out.println("tv zaten acik"); //acıksa ve yine açmaya çalısıyorsak bunu desin
        }
    }

    public void tvKapat() {
        if (acik == true) {
            acik = false;
        }else{
            System.out.println("tv zaten kapali"); //kapalıysa yine kapatmaya çalışıyorsak bunu desin.
        }
    }

    public void sesArttir(){
        if(ses < 20 && acik ==true){
            ses++;
            System.out.println("ses seviyesi: " +ses);
        }else{
            System.out.println("maksimum ses seviyesindesiniz ya da tv kapali.");
        }
    }

    public void sesAzalt(){
        if(ses >0 && acik == true){
            ses--;
            System.out.println("ses seviyesi: " +ses);
        }else{
            System.out.println("minimum ses seviyesindesinz ya da tv kapali.");
        }
    }

    public void kanalDegistir(int acilmasIstenenKanal){
        if(acik==true){
            if(acilmasIstenenKanal !=aktifKanal){
                if(acilmasIstenenKanal <= kanallar.size() && acilmasIstenenKanal >= 0){
                    aktifKanal = acilmasIstenenKanal; //iste bu işlem kanal değişitirme islemidir
                    System.out.println("kanal: " +acilmasIstenenKanal+ " bilgi: " +kanallar.get(aktifKanal-1).kanalBilgisiniGoster());
                    //index numarasından dolayı -1 yaptım.
                }else{
                    System.out.println("gecerl bir kanal numarası giriniz.");
                }
            }else{
                System.out.println("zaten " +aktifKanal);
            }
        }else{
            System.out.println("once televizyonu aciniz:");
        }
    }

    public void aktifKanaliGoster() {
        if (acik == true) {
            System.out.println("aktif kanal: " + kanallar.get(aktifKanal-1));
        }else{
            System.out.println("once televizyonu aciniz");
        }
    }
}

