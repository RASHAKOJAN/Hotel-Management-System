package dao;

import entity.Oda_kategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class oda_KategoriDao {
    
    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    public List<Oda_kategori> getOdaKategori() {
        List<Oda_kategori> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from oda_kategori");
            while (rs.next()) {
                Oda_kategori tmp = new Oda_kategori(rs.getInt("id"),rs.getString("isim"),rs.getString("tarif"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(oda_KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
    
    public void edit(Oda_kategori oda) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update oda_kategori set isim=?,tarif=? where id=?");
            pst.setString(1, oda.getIsim());
            pst.setString(2, oda.getTarif());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void insert(Oda_kategori oda) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into oda_kategori (isim, tarif) values (?,?)");
            pst.setString(1, oda.getIsim());
            pst.setString(2, oda.getTarif());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public Oda_kategori find(Long id) {
        Oda_kategori i = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from oda_kategori where id=" + id);
            rs.next();
            i = new Oda_kategori();
            i.setId(rs.getInt("id"));
            i.setIsim(rs.getString("isim"));
            i.setTarif(rs.getString("tarif"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void delete(Oda_kategori oda) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from oda_kategori where id=" + oda.getId());
        } catch (SQLException ex) {
        }
    }

    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = this.getDb().connect();
        }
        return c;
    }

    public void setDb(DBConnection db) {
        this.db = db;
    }

    public void setC(Connection c) {
        this.c = c;
    }
}
