package controller;

import dao.odaDao;
import entity.Oda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class odaController implements Serializable{
    private List<Oda> ilist;
    private odaDao idao;
    private Oda oda ;

    public odaController() {
        this.ilist = new ArrayList();
        this.idao = new odaDao();
    }
   
    
    public void updateForm(Oda oda) {
        this.oda = oda;
    }
    public void clearForm() {
        this.oda = new Oda();

    }
    public void update() {
        this.getIdao().edit(this.oda);
        this.clearForm();
    }

    public void delete(Oda oda) {
        this.getIdao().delete(oda);
        this.clearForm();
    }

    public void create() {
        this.getIdao().insert(this.oda);
        this.clearForm();
    }
 

    public Oda getOda() {
        if(this.oda == null)
            this.oda = new Oda();
        return oda;
    }

    public void setOda(Oda oda) {
        this.oda = oda;
    }

    public odaDao getIdao() {
        if(this.idao == null)
            this.idao = new odaDao();
        return idao;
    }

    public void setIdao(odaDao idao) {
        this.idao = idao;
    }

    public List<Oda> getIlist() {
        this.ilist = this.getIdao().getOda();
        return ilist;
    }

    public void setIlist(List<Oda> ilist) {
        this.ilist = ilist;
    }   
    
}
