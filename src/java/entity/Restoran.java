package entity;

import java.util.Date;

public class Restoran {
    private int id;
    private String aciklama;
    private String gun;
    private Date acma;
    private Date kapatma;

    public Restoran() {
    }

    public Restoran(int id, String aciklama, String gun, Date acma, Date kapatma) {
        this.id = id;
        this.aciklama = aciklama;
        this.gun = gun;
        this.acma = acma;
        this.kapatma = kapatma;
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

    public Date getAcma() {
        return acma;
    }

    public void setAcma(Date acma) {
        this.acma = acma;
    }

    public Date getKapatma() {
        return kapatma;
    }

    public void setKapatma(Date kapatma) {
        this.kapatma = kapatma;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
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
        final Restoran other = (Restoran) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Restoran{" + "id=" + id + ", aciklama=" + aciklama + ", gun=" + gun + ", acma=" + acma + ", kapatma=" + kapatma + '}';
    }
    
    
    
}
