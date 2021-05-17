package controller;

import dao.restoranDao;
import entity.Restoran;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class restoranController implements Serializable {
    private List<Restoran> ilist;
    private restoranDao idao;
    private Restoran restoran ;

    public restoranController() {
        this.ilist = new ArrayList();
        this.idao = new restoranDao();
    }
   
    
    public void updateForm(Restoran restoran) {
        this.restoran = restoran;
    }
    public void clearForm() {
        this.restoran = new Restoran();

    }
    public void update() {
        this.getIdao().edit(this.restoran);
        this.clearForm();
    }

    public void delete(Restoran restoran) {
        this.getIdao().delete(restoran);
        this.clearForm();
    }

    public void create() {
        this.getIdao().insert(this.restoran);
        this.clearForm();
    }
 

    public Restoran getRestoran() {
        if(this.restoran == null)
            this.restoran = new Restoran();
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public restoranDao getIdao() {
        if(this.idao == null)
            this.idao = new restoranDao();
        return idao;
    }

    public void setIdao(restoranDao idao) {
        this.idao = idao;
    }

    public List<Restoran> getIlist() {
        this.ilist = this.getIdao().getRestoran();
        return ilist;
    }

    public void setIlist(List<Restoran> ilist) {
        this.ilist = ilist;
    }   
    
}
