package controller;

import dao.oda_KategoriDao;
import entity.Oda_kategori;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class oda_KategoriController implements Serializable{
    
    private List<Oda_kategori> ilist;
    private oda_KategoriDao idao;
    private Oda_kategori oda ;

    public oda_KategoriController() {
        this.ilist = new ArrayList();
        this.idao = new oda_KategoriDao();
    }
    
    public void updateForm(Oda_kategori oda) {
        this.oda = oda;
    }
    public void clearForm() {
        this.oda = new Oda_kategori();

    }
    public void update() {
        this.getIdao().edit(this.oda);
        this.clearForm();
    }

    public void delete(Oda_kategori oda) {
        this.getIdao().delete(oda);
        this.clearForm();
    }

    public void create() {
        this.getIdao().insert(this.oda);
        this.clearForm();
    }
 

    public Oda_kategori getOda() {
        if(this.oda == null)
            this.oda = new Oda_kategori();
        return oda;
    }

    public void setOda(Oda_kategori oda) {
        this.oda = oda;
    }

    public oda_KategoriDao getIdao() {
        if(this.idao == null)
            this.idao = new oda_KategoriDao();
        return idao;
    }

    public void setIdao(oda_KategoriDao idao) {
        this.idao = idao;
    }

    public List<Oda_kategori> getIlist() {
        this.ilist = this.getIdao().getOdaKategori();
        return ilist;
    }

    public void setIlist(List<Oda_kategori> ilist) {
        this.ilist = ilist;
    }  
    
}
