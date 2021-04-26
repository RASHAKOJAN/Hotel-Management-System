package dao;

import entity.Oda;
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

public class odaDao {

    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    public List<Oda> getOda() {
        List<Oda> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from oda");
            while (rs.next()) {
                Oda tmp = new Oda(rs.getInt("id"),rs.getInt("oda_no"),rs.getString("isim"),rs.getString("boyut"),rs.getInt("fiyat"),rs.getInt("oid"),rs.getInt("kid"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(odaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
    
    public void edit(Oda oda) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update oda set fiyat=? where id=?");
            pst.setInt(1, oda.getFiyat());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void insert(Oda oda) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into oda (oda_no, isim, boyut, fiyat, oid, kid) values (?,?,?,?,?,?)");
            pst.setInt(1, oda.getOda_no());
            pst.setString(2, oda.getIsim());
            pst.setString(3, oda.getBoyut());
            pst.setInt(4, oda.getFiyat());
            pst.setInt(5, oda.getOid());
            pst.setInt(6, oda.getKid());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public Oda find(Long id) {
        Oda i = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from oda where id=" + id);
            rs.next();
            i = new Oda();
            i.setId(rs.getInt("id"));
            i.setOda_no(rs.getInt("oda_no"));
            i.setIsim(rs.getString("isim"));
            i.setBoyut(rs.getString("boyut"));
            i.setFiyat(rs.getInt("fiyat"));
            i.setOid(rs.getInt("oid"));
            i.setKid(rs.getInt("kid"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void delete(Oda oda) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from oda where id=" + oda.getId());
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
