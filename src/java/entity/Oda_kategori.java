package entity;

public class Oda_kategori {
    private int id;
    private String isim;
    private String tarif;

    public Oda_kategori() {
    }

    public Oda_kategori(int id, String isim, String tarif) {
        this.id = id;
        this.isim = isim;
        this.tarif = tarif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
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
        final Oda_kategori other = (Oda_kategori) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Oda_kategori{" + "id=" + id + ", isim=" + isim + ", tarif=" + tarif + '}';
    }
    
    
}
