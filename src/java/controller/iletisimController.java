package controller;

import dao.iletisimDao;
import entity.Iletisim;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.*;
import javax.inject.Named;

@Named
@SessionScoped
public class iletisimController implements Serializable {
    private List<Iletisim> ilist ;
    private iletisimDao idao ;

    public iletisimController() {
        this.ilist = new ArrayList();
        idao = new iletisimDao();
    }
    
    public List<Iletisim> getIlist() {
        this.ilist= this.getIdao().getIletisim();
        return ilist;
    }

    public void setIlist(List<Iletisim> ilist) {
        this.ilist = ilist;
    }

    public iletisimDao getIdao() {
        return idao;
    }

    public void setIdao(iletisimDao idao) {
        this.idao = idao;
    }
    
}
