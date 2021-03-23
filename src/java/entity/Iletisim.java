package entity;

public class Iletisim {
    private int id;
    private String isim;
    private String email;
    private String msj;

    public Iletisim() {
    }

    public Iletisim(int id, String isim, String email, String msj) {
        this.id = id;
        this.isim = isim;
        this.email = email;
        this.msj = msj;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    @Override
    public String toString() {
        return "Iletisim{" + "id=" + id + ", isim=" + isim + ", email=" + email + ", msj=" + msj + '}';
    }
    
}
