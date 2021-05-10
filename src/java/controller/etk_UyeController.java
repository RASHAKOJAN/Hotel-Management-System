package controller;

import dao.etk_UyeDao;
import entity.Etk_uye;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class etk_UyeController implements Serializable{
    
    private List<Etk_uye> ilist;
    private etk_UyeDao idao;
    private Etk_uye etkinlik ;

    public etk_UyeController() {
        this.ilist = new ArrayList();
        this.idao = new etk_UyeDao();
    }
    
    public void updateForm(Etk_uye etkinlik) {
        this.etkinlik = etkinlik;
    }
    public void clearForm() {
        this.etkinlik = new Etk_uye();

    }
    public void update() {
        this.getIdao().edit(this.etkinlik);
        this.clearForm();
    }

    public void delete(Etk_uye etkinlik) {
        this.getIdao().delete(etkinlik);
        this.clearForm();
    }

    public void create() {
        this.getIdao().insert(this.etkinlik);
        this.clearForm();
    }
 

    public Etk_uye getEtk_Uye() {
        if(this.etkinlik == null)
            this.etkinlik = new Etk_uye();
        return etkinlik;
    }

    public void setEtk_Uye(Etk_uye etkinlik) {
        this.etkinlik = etkinlik;
    }

    public etk_UyeDao getIdao() {
        if(this.idao == null)
            this.idao = new etk_UyeDao();
        return idao;
    }

    public void setIdao(etk_UyeDao idao) {
        this.idao = idao;
    }

    public List<Etk_uye> getIlist() {
        this.ilist = this.getIdao().getEtk_uye();
        return ilist;
    }

    public void setIlist(List<Etk_uye> ilist) {
        this.ilist = ilist;
    }   
    
}
