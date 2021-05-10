package entity;

public class Etk_uye {
    private int id;
    private int uid;
    private int eid;
    private int toplam;

    public Etk_uye() {
    }

    public Etk_uye(int id, int uid, int eid, int toplam) {
        this.id = id;
        this.uid = uid;
        this.eid = eid;
        this.toplam = toplam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getToplam() {
        return toplam;
    }

    public void setToplam(int toplam) {
        this.toplam = toplam;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
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
        final Etk_uye other = (Etk_uye) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etk_uye{" + "id=" + id + ", uid=" + uid + ", eid=" + eid + ", toplam=" + toplam + '}';
    }
    
    
}
