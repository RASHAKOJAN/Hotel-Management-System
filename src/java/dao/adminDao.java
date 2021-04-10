package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBConnection;

public class adminDao {

    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    
    public boolean validate(String username, String password) {
		try {
			PreparedStatement pst = this.getC().prepareStatement("select username, password from Admin where username = "+"'"+username+"'"+"and password ="+"'"+password+"'");
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
