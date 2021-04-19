package controller;

import dao.uyeDao;
import entity.Uye;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import util.DBConnection;

@Named
@SessionScoped
public class uyeController implements Serializable{
    
    
    private Uye uye = new Uye();
    private uyeDao dao;
    
    private DBConnection db = new DBConnection();
    private Connection c = db.connect();
    
    public boolean find(String username, String password) {
		try {
			PreparedStatement pst = this.getC().prepareStatement("select username, password from uye where username = "+"'"+username+"'"+"and password ="+"'"+password+"'");
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
    
     public String validate() {
         if(find(this.uye.getUsername(), this.uye.getPassword())){
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.uye);
                return "/musteriPages/home?faces-redirect=true";
         }else
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hata "));
            return "uyeLogin";
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

    public Uye getUye() {
        return uye;
    }
    
    
}
