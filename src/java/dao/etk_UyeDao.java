package dao;

import entity.Etk_uye;
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

public class etk_UyeDao {
    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    public List<Etk_uye> getEtk_uye() {
        List<Etk_uye> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from etk_uye");
            while (rs.next()) {
                Etk_uye tmp = new Etk_uye(rs.getInt("id"),rs.getInt("uid"),rs.getInt("eid"),rs.getInt("toplam"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(etk_UyeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
    
    public void edit(Etk_uye etk_uye) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update etk_uye set uid=?, eid=?, toplam=? where id=?");
            pst.setInt(1, etk_uye.getUid());
            pst.setInt(2,etk_uye.getEid());
            pst.setInt(3,etk_uye.getToplam());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void insert(Etk_uye etk_uye) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into etkinlik (uid, eid, toplam) values (?,?,?)");
            pst.setInt(1, etk_uye.getUid());
            pst.setInt(2, etk_uye.getEid());
            pst.setInt(3, etk_uye.getToplam());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public Etk_uye find(Long id) {
        Etk_uye i = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from etk_uye where id=" + id);
            rs.next();
            i = new Etk_uye();
            i.setId(rs.getInt("id"));
            i.setUid(rs.getInt("uid"));
            i.setEid(rs.getInt("eid"));
            i.setToplam(rs.getInt("toplam"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void delete(Etk_uye etk_uye) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from etk_uye where id=" + etk_uye.getId());
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
