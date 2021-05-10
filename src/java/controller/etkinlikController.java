package controller;

import dao.etkinlikDao;
import entity.Etkinlik;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class etkinlikController implements Serializable{
    
    private List<Etkinlik> ilist;
    private etkinlikDao idao;
    private Etkinlik etkinlik ;

    public etkinlikController() {
        this.ilist = new ArrayList();
        this.idao = new etkinlikDao();
    }
    
    public void updateForm(Etkinlik etkinlik) {
        this.etkinlik = etkinlik;
    }
    public void clearForm() {
        this.etkinlik = new Etkinlik();

    }
    public void update() {
        this.getIdao().edit(this.etkinlik);
        this.clearForm();
    }

    public void delete(Etkinlik etkinlik) {
        this.getIdao().delete(etkinlik);
        this.clearForm();
    }

    public void create() {
        this.getIdao().insert(this.etkinlik);
        this.clearForm();
    }
 

    public Etkinlik getEtkinlik() {
        if(this.etkinlik == null)
            this.etkinlik = new Etkinlik();
        return etkinlik;
    }

    public void setEtkinlik(Etkinlik etkinlik) {
        this.etkinlik = etkinlik;
    }

    public etkinlikDao getIdao() {
        if(this.idao == null)
            this.idao = new etkinlikDao();
        return idao;
    }

    public void setIdao(etkinlikDao idao) {
        this.idao = idao;
    }

    public List<Etkinlik> getIlist() {
        this.ilist = this.getIdao().getEtkinlik();
        return ilist;
    }

    public void setIlist(List<Etkinlik> ilist) {
        this.ilist = ilist;
    }   
}
