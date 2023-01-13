package TelevizyonSimulasyonu;

public class MuzikKanali extends Kanal { //kalıtım yaptım

    private String muzikTuru;
    public MuzikKanali(String adi, int kanalNo, String muzikTuru) {
        super(adi, kanalNo);
        this.muzikTuru = muzikTuru; // bu muzik türünü parametre olarak gelen müzik türüne ata
    }
}

