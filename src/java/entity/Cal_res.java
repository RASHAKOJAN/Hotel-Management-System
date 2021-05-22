package entity;

public class Cal_res {
    
    private int id;
    private int cid;
    private int rid;

    public Cal_res() {
    }

    public Cal_res(int id, int cid, int rid) {
        this.id = id;
        this.cid = cid;
        this.rid = rid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
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
        final Cal_res other = (Cal_res) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cal_res{" + "id=" + id + ", cid=" + cid + ", rid=" + rid + '}';
    }
    
    
}
