package entity;

import java.util.Date;

public class Etkinlik {
    private int id;
    private String aciklama;
    private String gun;
    private Date acma_zaman;
    private Date kapatma_zaman;
    private int fiyat;

    public Etkinlik() {
    }

    public Etkinlik(int id, String aciklama, String gun, Date acma_zaman, Date kapatma_zaman, int fiyat) {
        this.id = id;
        this.aciklama = aciklama;
        this.gun = gun;
        this.acma_zaman = acma_zaman;
        this.kapatma_zaman = kapatma_zaman;
        this.fiyat = fiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public Date getAcma_zaman() {
        return acma_zaman;
    }

    public void setAcma_zaman(Date acma_zaman) {
        this.acma_zaman = acma_zaman;
    }

    public Date getKapatma_zaman() {
        return kapatma_zaman;
    }

    public void setKapatma_zaman(Date kapatma_zaman) {
        this.kapatma_zaman = kapatma_zaman;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Etkinlik other = (Etkinlik) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etkinlik{" + "id=" + id + ", aciklama=" + aciklama + ", gun=" + gun + ", acma_zaman=" + acma_zaman + ", kapatma_zaman=" + kapatma_zaman + ", fiyat=" + fiyat + '}';
    }
    
    
}
