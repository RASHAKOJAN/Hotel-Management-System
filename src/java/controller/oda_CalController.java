package controller;

import dao.oda_CalDao;
import entity.Oda_cal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class oda_CalController implements Serializable {
    
    private List<Oda_cal> ilist;
    private oda_CalDao idao;
    private Oda_cal oda ;

    public oda_CalController() {
        this.ilist = new ArrayList();
        this.idao = new oda_CalDao();
    
    }
    
    public void updateForm(Oda_cal oda) {
        this.oda = oda;
    }
    public void clearForm() {
        this.oda = new Oda_cal();

    }
    public void update() {
        this.getIdao().edit(this.oda);
        this.clearForm();
    }

    public void delete(Oda_cal oda) {
        this.getIdao().delete(oda);
        this.clearForm();
    }

    public void create() {
        this.getIdao().insert(this.oda);
        this.clearForm();
    }
 

    public Oda_cal getOda() {
        if(this.oda == null)
            this.oda = new Oda_cal();
        return oda;
    }

    public void setOda(Oda_cal oda) {
        this.oda = oda;
    }

    public oda_CalDao getIdao() {
        if(this.idao == null)
            this.idao = new oda_CalDao();
        return idao;
    }

    public void setIdao(oda_CalDao idao) {
        this.idao = idao;
    }

    public List<Oda_cal> getIlist() {
        this.ilist = this.getIdao().getOda_cal();
        return ilist;
    }

    public void setIlist(List<Oda_cal> ilist) {
        this.ilist = ilist;
    }  
    
    
    
    
}
