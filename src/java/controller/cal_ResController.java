package controller;

import dao.cal_ResDao;
import entity.Cal_res;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class cal_ResController implements Serializable {
    
    private List<Cal_res> ilist;
    private cal_ResDao idao;
    private Cal_res cal_res ;

    public cal_ResController() {
        this.ilist = new ArrayList();
        this.idao = new cal_ResDao();
    }
   
    
    public void updateForm(Cal_res cal_res) {
        this.cal_res = cal_res;
    }
    public void clearForm() {
        this.cal_res = new Cal_res();

    }
    public void update() {
        this.getIdao().edit(this.cal_res);
        this.clearForm();
    }

    public void delete(Cal_res cal_res) {
        this.getIdao().delete(cal_res);
        this.clearForm();
    }

    public void create() {
        this.getIdao().insert(this.cal_res);
        this.clearForm();
    }
 

    public Cal_res getCal_res() {
        if(this.cal_res == null)
            this.cal_res = new Cal_res();
        return cal_res;
    }

    public void setCal_res(Cal_res cal_res) {
        this.cal_res = cal_res;
    }

    public cal_ResDao getIdao() {
        if(this.idao == null)
            this.idao = new cal_ResDao();
        return idao;
    }

    public void setIdao(cal_ResDao idao) {
        this.idao = idao;
    }

    public List<Cal_res> getIlist() {
        this.ilist = this.getIdao().getOda();
        return ilist;
    }

    public void setIlist(List<Cal_res> ilist) {
        this.ilist = ilist;
    }   
    
}
