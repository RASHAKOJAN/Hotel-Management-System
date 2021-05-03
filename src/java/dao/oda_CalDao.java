package dao;

import entity.Oda_cal;
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

public class oda_CalDao {
    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    public List<Oda_cal> getOda_cal() {
        List<Oda_cal> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from oda_cal");
            while (rs.next()) {
                Oda_cal tmp = new Oda_cal(rs.getInt("id"),rs.getInt("oid"),rs.getInt("cid"),rs.getString("gun"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(oda_CalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
    
    public void edit(Oda_cal oda) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update oda_cal set oid = ?,cid=?,gun =? where id=?");
            pst.setString(1, oda.getGun());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void insert(Oda_cal oda) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into oda_cal (oid, cid, gun) values (?,?,?)");
            pst.setInt(1, oda.getOid());
            pst.setInt(2, oda.getCid());
            pst.setString(3, oda.getGun());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public Oda_cal find(Long id) {
        Oda_cal i = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from oda_cal where id=" + id);
            rs.next();
            i = new Oda_cal();
            i.setId(rs.getInt("id"));
            i.setOid(rs.getInt("oid"));
            i.setCid(rs.getInt("cid"));
            i.setGun(rs.getString("gun"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void delete(Oda_cal oda) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from oda_cal where id=" + oda.getId());
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
