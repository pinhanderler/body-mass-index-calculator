paket  com.sport_of_life.sportoflife.model ;

genel  sınıf  Kullanıcısı {

    özel  int id;
    private  String kullaniciAdi;
    özel  Dize reklamı;
    özel  String soyad;
    özel  String e-postası;
    özel  String dogumTarihi;
    özel  String sifre;

    public  int  getId () {
        dönüş kimliği;
    }

    herkese açık  geçersiz  setId ( int  id ) {
        bu . id = id;
    }

    public  String  getKullaniciAdi () {
        return kullaniciAdi;
    }

    public  void  setKullaniciAdi ( String  kullaniciAdi ) {
        bu . kullaniciAdi = kullaniciAdi;
    }

    public  String  getAd () {
        dönüş reklamı;
    }

    herkese açık  void  setAd ( Dize  reklamı ) {
        bu . ad = ad;
    }

    public  String  getSoyad () {
        dönüş soyad;
    }

    Kamu  geçersiz  setSoyad ( Dize  soyad ) {
        bu . soyad = soyad;
    }

    public  String  getEmail () {
        dönüş e-postası;
    }

    genel  void  setEmail ( Dize  e-postası ) {
        bu . email = email;
    }

    public  String  getDogumTarihi () {
        dönüş dogumTarihi;
    }

    herkese açık  geçersiz  setDogumTarihi ( String  dogumTarihi ) {
        bu . dogumTarihi = dogumTarihi;
    }

    public  String  getSifre () {
        dönüş eleği;
    }

    Kamu  geçersiz  setSifre ( Dize  sifre ) {
        bu . sifre = sifre;
    }
}
