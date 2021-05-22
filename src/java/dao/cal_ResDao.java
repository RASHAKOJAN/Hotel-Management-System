package dao;

import entity.Cal_res;
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

public class cal_ResDao {
    
    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    public List<Cal_res> getOda() {
        List<Cal_res> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from cal_res");
            while (rs.next()) {
                Cal_res tmp = new Cal_res(rs.getInt("id"),rs.getInt("cid"),rs.getInt("rid"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cal_ResDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
    
    public void edit(Cal_res cal_res) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update cal_res set cid=?,rid=? where id=?");
            pst.setInt(1, cal_res.getCid());
            pst.setInt(2, cal_res.getRid());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void insert(Cal_res cal_res) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into cal_res (cid, rid) values (?,?)");
            pst.setInt(1, cal_res.getCid());
            pst.setInt(2, cal_res.getRid());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public Cal_res find(Long id) {
        Cal_res i = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from cal_res where id=" + id);
            rs.next();
            i = new Cal_res();
            i.setId(rs.getInt("id"));
            i.setCid(rs.getInt("cid"));
            i.setRid(rs.getInt("rid"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void delete(Cal_res cal_res) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from cal_res where id=" + cal_res.getId());
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
