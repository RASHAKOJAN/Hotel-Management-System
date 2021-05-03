package entity;

public class Oda_cal {
    private int id ;
    private int oid;
    private int cid;
    private String gun;

    public Oda_cal() {
    }

    public Oda_cal(int id, int oid, int cid, String gun) {
        this.id = id;
        this.oid = oid;
        this.cid = cid;
        this.gun = gun;
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
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
        final Oda_cal other = (Oda_cal) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Oda_cal{" + "id=" + id + ", oid=" + oid + ", cid=" + cid + ", gun=" + gun + '}';
    }
    
    

    
}
