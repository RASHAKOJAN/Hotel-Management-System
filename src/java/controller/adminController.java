package controller;

import dao.adminDao;
import entity.Admin;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named
@SessionScoped
public class adminController implements Serializable {
    
    private Admin admin;
    private adminDao dao;
    
    public String login() {
        boolean result = dao.validate(this.admin.getUsername(), this.admin.getPassword());
        if(result){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.admin);
                return "/adminPages/home?faces-redirect=true";
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hata "));
            return "adminLogin";
        }
    }
    
    /*public String login() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean result = dao.validate(admin.getUsername(), admin.getPassword());
        if (result != false) {
            try {
                context.getExternalContext().getSessionMap().put("valid_user", this.admin);
                return "/adminPages/home?faces-redirect=true";
                //context.getExternalContext().redirect("adminPages/home.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("username and password not found"));
           
        } 
        return "/login";
    }*/
    
    
    /*public String validateUsernamePasswordAdmin() {
        
        boolean valid = adminDao.validate(username, password);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            return "login?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "index?faces-redirect=true";
        }
    }*/
    
    public Admin getAdmin() {
        if(this.admin == null )
            this.admin = new Admin();
        return admin;
    }
    
    public void setAdmin(Admin admin){
        this.admin = admin;
    }
    
    
}
