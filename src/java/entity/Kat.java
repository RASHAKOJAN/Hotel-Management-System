package entity;

public class Kat {

    private int id;
    private int kat_no;

    public Kat() {
    }

    public Kat(int id, int kat_no) {
        this.id = id;
        this.kat_no = kat_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKat_no() {
        return kat_no;
    }

    public void setKat_no(int kat_no) {
        this.kat_no = kat_no;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
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
        final Kat other = (Kat) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kat{" + "id=" + id + ", kat_no=" + kat_no + '}';
    }
    
    

}