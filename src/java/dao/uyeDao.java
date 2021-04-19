package dao;

import entity.Uye;
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

public class uyeDao {
    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    
    public boolean validate(String username, String password) {
		try {
			PreparedStatement pst = this.getC().prepareStatement("select username, password from Uye where username = "+"'"+username+"'"+"and password ="+"'"+password+"'");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
                            
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} catch(NullPointerException e){
                    System.err.println(e.getMessage()+"hereeeees Problem");
                }
		return false;
	}
    
     public List<Uye> getUye() {
        List<Uye> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from Uye");
            while (rs.next()) {
                Uye tmp = new Uye(rs.getInt("id"), rs.getString("isim"),rs.getString("username"), rs.getString("email"), rs.getString("phone"),rs.getString("password"),rs.getString("address"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(uyeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
     
     public void insert(Uye uye) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into  uye (isim, username, email, phone, password, address) values (?,?,?,?,?,?)");
            pst.setString(1, uye.getIsim());
            pst.setString(2, uye.getUsername());
            pst.setString(3, uye.getEmail());
            pst.setString(4, uye.getPhone());
            pst.setString(5, uye.getPassword());
            pst.setString(5, uye.getAddress());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void delete(Uye uye) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from uye where id=" + uye.getId());
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
