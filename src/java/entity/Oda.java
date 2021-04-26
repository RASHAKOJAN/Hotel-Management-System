package entity;


public class Oda {
    private int id;
    private int oda_no;
    private String isim;
    private String boyut;
    private int fiyat;
    private int oid;
    private int kid;

    public Oda() {
    }

    public Oda(int id, int oda_no, String isim, String boyut, int fiyat, int oid, int kid) {
        this.id = id;
        this.oda_no = oda_no;
        this.isim = isim;
        this.boyut = boyut;
        this.fiyat = fiyat;
        this.oid = oid;
        this.kid = kid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOda_no() {
        return oda_no;
    }

    public void setOda_no(int oda_no) {
        this.oda_no = oda_no;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Oda other = (Oda) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Oda{" + "id=" + id + ", oda_no=" + oda_no + ", isim=" + isim + ", boyut=" + boyut + ", fiyat=" + fiyat + ", oid=" + oid + ", kid=" + kid + '}';
    }
    
    
    
}
