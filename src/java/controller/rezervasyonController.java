package controller;

import dao.rezervasyonDao;
import entity.Rezervasyon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class rezervasyonController implements Serializable{
    private List<Rezervasyon> ilist;
    private rezervasyonDao idao;
    private Rezervasyon rezervasyon ;
    
     public rezervasyonController() {
        this.ilist = new ArrayList();
        this.idao = new rezervasyonDao();
    }
    
      public void updateForm(Rezervasyon rezervasyon) {
        this.rezervasyon = rezervasyon;
    }
    public void clearForm() {
        this.rezervasyon = new Rezervasyon();

    }
    public void update() {
        this.getIdao().edit(this.rezervasyon);
        this.clearForm();
    }

    public void delete(Rezervasyon rezervasyon) {
        this.getIdao().delete(rezervasyon);
        this.clearForm();
    }

    public void create() {
        this.getIdao().insert(this.rezervasyon);
        this.clearForm();
    }
 

    public Rezervasyon getRezervasyon() {
        if(this.rezervasyon == null)
            this.rezervasyon = new Rezervasyon();
        return rezervasyon;
    }

    public void setRezervasyon(Rezervasyon rezervasyon) {
        this.rezervasyon = rezervasyon;
    }

    public rezervasyonDao getIdao() {
        if(this.idao == null)
            this.idao = new rezervasyonDao();
        return idao;
    }

    public void setIdao(rezervasyonDao idao) {
        this.idao = idao;
    }

    public List<Rezervasyon> getIlist() {
        this.ilist = this.getIdao().getRezervasyon();
        return ilist;
    }

    public void setIlist(List<Rezervasyon> ilist) {
        this.ilist = ilist;
    }   
}
