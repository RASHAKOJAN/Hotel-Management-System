package entity;

import java.util.Date;

public class Rezervasyon {
    private int id;
    private int oid;
    private int uid;
    private int fiyat;
    private Date alma_zaman;
    private Date teslim_zaman;
    
    public Rezervasyon(){
        
    }

    public Rezervasyon(int id, int oid, int uid, int fiyat, Date alma_zaman, Date teslim_zaman) {
        this.id = id;
        this.oid = oid;
        this.uid = uid;
        this.fiyat = fiyat;
        this.alma_zaman = alma_zaman;
        this.teslim_zaman = teslim_zaman;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public Date getAlma_zaman() {
        return alma_zaman;
    }

    public void setAlma_zaman(Date alma_zaman) {
        this.alma_zaman = alma_zaman;
    }

    public Date getTeslim_zaman() {
        return teslim_zaman;
    }

    public void setTeslim_zaman(Date teslim_zaman) {
        this.teslim_zaman = teslim_zaman;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final Rezervasyon other = (Rezervasyon) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rezervasyon{" + "id=" + id + ", oid=" + oid + ", uid=" + uid + ", fiyat=" + fiyat + ", alma_zaman=" + alma_zaman + ", teslim_zaman=" + teslim_zaman + '}';
    }
    
}
