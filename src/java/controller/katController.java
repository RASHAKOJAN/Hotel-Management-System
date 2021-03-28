package controller;

import dao.katDao;
import entity.Kat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class katController implements Serializable {

    private List<Kat> ilist;
    private katDao idao;
    private Kat kat ;

    public void updateForm(Kat kat) {
        this.kat = kat;
    }
    public void clearForm() {
        this.kat = new Kat();

    }
    public void update() {
        this.getIdao().edit(this.kat);
        this.clearForm();
    }

    public void delete() {
        this.getIdao().delete(this.kat);
        this.clearForm();
    }

    public void create() {
        this.getIdao().insert(this.kat);
        this.clearForm();
    }

    public katController() {
        this.ilist = new ArrayList();
        idao = new katDao();
    }

    public List<Kat> getIlist() {
        this.ilist = this.getIdao().getKat();
        return ilist;
    }

    public void setIlist(List<Kat> ilist) {
        this.ilist = ilist;
    }

    public katDao getIdao() {
        return idao;
    }

    public void setIdao(katDao idao) {
        this.idao = idao;
    }

}
