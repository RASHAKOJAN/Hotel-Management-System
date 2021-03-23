package dao;

import entity.Iletisim;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class iletisimDao {

    private DBConnection db = new DBConnection();
    private Connection c = db.connect();

    public List<Iletisim> getIletisim() {
        List<Iletisim> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from iletisim");
            while (rs.next()) {
                Iletisim tmp = new Iletisim(rs.getInt("id"), rs.getString("isim"), rs.getString("email"), rs.getString("msj"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(iletisimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }

    public Iletisim find(Long id) {
        Iletisim i = null;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from Iletisim where id=" + id);
            rs.next();
            i = new Iletisim();
            i.setId(rs.getInt("id"));
            i.setIsim(rs.getString("isim"));
            i.setEmail(rs.getString("email"));
            i.setMsj(rs.getString("msj"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void insert(Iletisim iletisim) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into  iletisim (isim, email, msj) values (?,?,?)");
            pst.setString(1, iletisim.getIsim());
            pst.setString(2, iletisim.getEmail());
            pst.setString(3, iletisim.getMsj());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void delete(Iletisim iletisim) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from iletisim where id=" + iletisim.getId());
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
