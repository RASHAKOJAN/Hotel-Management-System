package dao;

import entity.Admin;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class adminDao {

    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    public boolean validate(String user, String password) {
		try {
			PreparedStatement pst = this.getC().prepareStatement("select username, password from Admin where username = ? and password = ?");
			pst.setString(1, user);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} 
		return false;
	}

    /*public Admin validate(String username, String password) {
        Admin i = null;
        try {
            PreparedStatement pst = this.getC().prepareStatement("Select username,password from Admin where username = ? and password = ?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                i = new Admin();
                i.setUsername(rs.getString("username"));
                i.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }*/

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


    /* public void insert(String uname, String password) {
        // Connector.getConnection();

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("INSERT INTO admin(uid,uname,password"
                    + ") VALUES(?,?,?)");
            pst.setLong(1, users_sayisi("users"));
            pst.setString(2, uname);
            pst.setString(3, password);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
 /*public boolean doesExist(String userName) {
        String userNameExsits = "";
        try {
            String query = "SELECT uname FROM users";
            Statement statement = (Statement) this.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                if (resultSet.getString("uname").equals(userName)) {
                    userNameExsits = userName;
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }*/
}
