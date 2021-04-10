package entity;

public class Calisan {
    
    private static final long serialVersionUID = 1L;
    private int id;
    private String isim;
    private String username;
    private String email;
    private String phone;
    private String password;

    public Calisan() {
    }

    public Calisan(int id, String isim, String username, String email, String phone, String password) {
        this.id = id;
        this.isim = isim;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Calisan{" + "id=" + id + ", isim=" + isim + ", username=" + username + ", email=" + email + ", phone=" + phone + ", password=" + password + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Calisan other = (Calisan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
