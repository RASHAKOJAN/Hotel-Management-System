package dao;

import entity.Kat;
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

public class katDao {
     private DBConnection db = new DBConnection();
    private Connection c = db.connect();

    public List<Kat> getKat() {
        List<Kat> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from kat");
            while (rs.next()) {
                Kat tmp = new Kat(rs.getInt("id"),rs.getInt("kat_no"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(katDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }

    public Kat find(Long id) {
        Kat i = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from kat where id=" + id);
            rs.next();
            i = new Kat();
            i.setId(rs.getInt("id"));
            i.setKat_no(rs.getInt("kat_no"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void insert(Kat kat) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into  kat (kat_no) values (?)");
            pst.setInt(1, kat.getKat_no());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public void edit(Kat kat) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update kat set kat_no=? where id=?");
            pst.setInt(1, kat.getKat_no());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void delete(Kat kat) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from kat where id=" + kat.getId());
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
