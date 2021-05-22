package dao;

import entity.Rezervasyon;
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

public class rezervasyonDao {
    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    public List<Rezervasyon> getRezervasyon() {
        List<Rezervasyon> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from rezervasyon");
            while (rs.next()) {
                Rezervasyon tmp = new Rezervasyon(rs.getInt("id"),rs.getInt("oid"),rs.getInt("uid"),rs.getInt("fiyat"),rs.getDate("alma_zaman"),rs.getDate("teslim_zaman"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(rezervasyonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
    
    public void edit(Rezervasyon rezervasyon) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update rezervasyon set fiyat=? where id=?");
            pst.setInt(1, rezervasyon.getFiyat());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void insert(Rezervasyon rezervasyon) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into rezervasyon (oid, uid, fiyat, alma_zaman, teslim_zaman) values (?,?,?,?,?)");
            pst.setInt(1, rezervasyon.getOid());
            pst.setInt(2, rezervasyon.getUid());
            pst.setInt(3, rezervasyon.getFiyat());
            pst.setDate(4, (Date) rezervasyon.getAlma_zaman());
            pst.setDate(5, (Date) rezervasyon.getTeslim_zaman());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public Rezervasyon find(Long id) {
        Rezervasyon i = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from rezervasyon where id=" + id);
            rs.next();
            i = new Rezervasyon();
            i.setId(rs.getInt("id"));
            i.setOid(rs.getInt("oid"));
            i.setUid(rs.getInt("uid"));
            i.setFiyat(rs.getInt("fiyat"));
            i.setAlma_zaman(rs.getDate("alma_zaman"));
            i.setTeslim_zaman(rs.getDate("teslim_zaman"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void delete(Rezervasyon rezervasyon) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from rezervasyon where id=" + rezervasyon.getId());
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
