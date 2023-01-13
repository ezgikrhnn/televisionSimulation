package TelevizyonSimulasyonu;


import java.sql.SQLOutput;
import java.util.Scanner;


import java.sql.SQLOutput;
import java.util.Scanner;

public class televizyonSimulasyonu {
    static Scanner tara = new Scanner(System.in); //kullanıcıdan menu icin deger almam gerekiyor.
    static Televizyon tv; //diye bir referans daha oluşturuyorum.
    public static void main(String[] args) {


        menuGoster();


        //kullanıcı 0'a basana kadar bu menu surekli olarak gosterilsin. bool degerle yapalım:
        boolean cikis = false;
        while(cikis == false){
            System.out.println("seciminiz: (menuyu gormek icin 8'i tuslayiniz) ");
            int secim = tara.nextInt(); //kullanıcıdan secimini alıyorum.

            switch (secim){
                case 1:
                    tvKurveKanallariOlustur();
                    break;
                case 2:
                    tvAc();
                    break;
                case 3:
                    sesArttir();
                    break;
                case 4:
                    sesAzalt();
                    break;
                case 5:
                    kanalDegistir();
                case 6:
                    kanalBilgisiniGoster();
                case 7:
                    tvKapat();
                    break;

                case 8:
                    menuGoster();
                    break;
                case 0:
                    System.out.println("sistemden cikiyor.");
                    cikis = true; //kullanıcı cıkmak istedigi icin yeniden menu gosterilmesin.
                    break;
                default:
                    System.out.println("0 ile 8 arasinda bir deger giriniz!");
                    break;
            }
        }
    }

    private static void menuGoster(){
        System.out.println("******MENU******");
        System.out.println(
                "0 --> CIKIS\n"+
                        "1 --> TELEVİZYONU KUR\n" +
                        "2 --> TELEVİZYONU AC\n" +
                        "3 --> SESİ AC\n" +
                        "4 --> SESİ KAPAT\n" +
                        "5 --> KANAL DEGİSTİR\n" +
                        "6 --> KANAL BİLGİSİNİ GOSTER\n" +
                        "7 --> TELEVİZYONU KAPAT\n" +
                        "8 --> MENUYU GOSTER\n");

    }

    private static void tvKurveKanallariOlustur(){

        if(tv == null){  //her seferinde televizyon oluşturmasın diye bunu yapıyorum:
            tara.nextLine(); //bir kere boyle boş çalıştırırsam kullanıcıdan input alırken sırasıyla ister sorun olmaz.
            System.out.println("televizyonun markasini giriniz: ");
            String marka = tara.nextLine();
            System.out.println("televizyonun boyutunu giriniz: ");
            String boyut = tara.nextLine();

            tv = new Televizyon(marka, boyut);
            System.out.println(tv);
        }else{ // değilse daha önceden bir nesne oluşturulduysa:
            System.out.println(tv);
        }//bu sayede ben bir tv ekledikten sonra surekli istemeyecek cunku null olmayacak.
    }


    private static void tvAc(){
        if(tv != null){ //yani cunku televizyon henuz oluşturulmamışssa açmamın bir anlamı da olmayacaktır.
            tv.tvAc();  //tvAc çalıştır
        }else{
            System.out.println("önce tvyi kurun ve kanallari oluşturun");
        }
    }

    private static void tvKapat(){
        if(tv != null){ //televizyon oluşturuldu mu diye kontrol ediyorum.
            tv.tvKapat();
        }else{  //tv kurulu değilse kapatma komutu çalışmasın diye yaptıgım uyarı
            System.out.println("once tvyi kurun ve kanallari oluşturun");
        }
    }

    private static void sesArttir(){
        if(tv != null){
            tv.sesArttir();
        }else{
            System.out.println("ses arttirmak icin once tv'yi kurun");
        }
    }

    private static void sesAzalt(){
        if(tv != null){
            tv.sesAzalt(); //televizyonun açık kapalı oldugunu kontrol etmek bu metodun işi.
        }else{
            System.out.println("ses azaltmak icin once tv'yi kurun");
        }
    }

    private static void kanalDegistir(){
        if(tv != null){
            System.out.println("hangi kanali gormek istiyorsunuz?\n");
            int acilmasiIstenenKanal = tara.nextInt(); //kullanıcıdan alalım
            tv.kanalDegistir(acilmasiIstenenKanal);
        }else{
            System.out.println("once tv'yi kurun ve kanallari olusturun.");
        }
    }

    private static void kanalBilgisiniGoster(){
        if(tv != null){
            tv.aktifKanaliGoster();
        }else{
            System.out.println("once tv'yi kurun ve kanallari olusturun.");
        }
    }

}
