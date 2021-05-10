package dao;

import entity.Etkinlik;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class etkinlikDao {
    
    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    public List<Etkinlik> getEtkinlik() {
        List<Etkinlik> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from etkinlik");
            while (rs.next()) {
                Etkinlik tmp = new Etkinlik(rs.getInt("id"),rs.getString("aciklama"),rs.getString("gun"),rs.getDate("acma_zaman"),rs.getDate("kapatma_zaman"),rs.getInt("fiyat"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(etkinlikDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
    
    public void edit(Etkinlik etkinlik) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update etkinlik set gun=?, acma_zaman=?, kapatma_zaman=?, fiyat=? where id=?");
            pst.setString(1, etkinlik.getGun());
            pst.setDate(2, (Date) etkinlik.getAcma_zaman());
            pst.setDate(3, (Date) etkinlik.getKapatma_zaman());
            pst.setInt(4, etkinlik.getFiyat());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void insert(Etkinlik etkinlik) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into etkinlik (aciklama, gun, acma_zaman, kapatma_zaman, fiyat) values (?,?,?,?,?)");
            pst.setString(1, etkinlik.getAciklama());
            pst.setString(2, etkinlik.getGun());
            pst.setDate(3, (Date) etkinlik.getAcma_zaman());
            pst.setDate(4, (Date) etkinlik.getKapatma_zaman());
            pst.setInt(5, etkinlik.getFiyat());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public Etkinlik find(Long id) {
        Etkinlik i = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from etkinlik where id=" + id);
            rs.next();
            i = new Etkinlik();
            i.setId(rs.getInt("id"));
            i.setAciklama(rs.getString("aciklama"));
            i.setGun(rs.getString("gun"));
            i.setAcma_zaman(rs.getDate("acma_zaman"));
            i.setKapatma_zaman(rs.getDate("kapatma_zaman"));
            i.setFiyat(rs.getInt("fiyat"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void delete(Etkinlik etkinlik) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from etkinlik where id=" + etkinlik.getId());
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
