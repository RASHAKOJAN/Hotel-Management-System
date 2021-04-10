package dao;

import entity.Calisan;
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

public class calisanDao {
    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    
    public boolean validate(String username, String password) {
		try {
			PreparedStatement pst = this.getC().prepareStatement("select username, password from Calisan where username = "+"'"+username+"'"+"and password ="+"'"+password+"'");
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
    
     public List<Calisan> getIletisim() {
        List<Calisan> alist = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from Calisan");
            while (rs.next()) {
                Calisan tmp = new Calisan(rs.getInt("id"), rs.getString("isim"),rs.getString("username"), rs.getString("email"), rs.getString("phone"),rs.getString("password"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(calisanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
     
     public void insert(Calisan calisan) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into  calisan (isim, username, email, phone, password) values (?,?,?,?,?)");
            pst.setString(1, calisan.getIsim());
            pst.setString(2, calisan.getUsername());
            pst.setString(3, calisan.getEmail());
            pst.setString(4, calisan.getPhone());
            pst.setString(5, calisan.getPassword());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void delete(Calisan calisan) {
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from calisan where id=" + calisan.getId());
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
