package dao;

import entity.Restoran;
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

public class restoranDao {
    private DBConnection db = new DBConnection();
    private Connection c = db.connect();

    public List<Restoran> getRestoran() {
        List<Restoran> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from restoran");
            while (rs.next()) {
                Restoran tmp = new Restoran(rs.getInt("id"),rs.getString("aciklama"),rs.getString("gun"),rs.getDate("acma"),rs.getDate("kapatma"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(restoranDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
    
    public void edit(Restoran restoran) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update restoran set aciklama=?,gun=?,acma=?,kapatma=? where id=?");
            pst.setString(1, restoran.getAciklama());
            pst.setString(2, restoran.getGun());
            pst.setDate(3, (Date) restoran.getAcma());
            pst.setDate(4, (Date) restoran.getKapatma());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void insert(Restoran restoran) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into restoran (aciklama, gun, acma, kapatma) values (?,?,?,?)");
            pst.setString(1, restoran.getAciklama());
            pst.setString(2, restoran.getGun());
            pst.setDate(3, (Date) restoran.getAcma());
            pst.setDate(4, (Date) restoran.getKapatma());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public Restoran find(Long id) {
        Restoran i = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from restoran where id=" + id);
            rs.next();
            i = new Restoran();
            i.setId(rs.getInt("id"));
            i.setAciklama(rs.getString("aciklama"));
            i.setGun(rs.getString("gun"));
            i.setAcma(rs.getDate("acma"));
            i.setKapatma(rs.getDate("kapatma"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void delete(Restoran restoran) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from restoran where id=" + restoran.getId());
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
