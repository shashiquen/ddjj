/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.FuncionDao;
import aplicacion.hibernate.daoImp.FuncionDAOImp;
import aplicacion.modelo.dominio.Funcion;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author EMILCE
 */
@ManagedBean
@ViewScoped
public class FuncionBean implements Serializable{
    private Funcion funcion;
    
    
     public FuncionBean() {
         funcion = new Funcion();
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
   
    public List<Funcion>obtenerFunciones(){
    FuncionDao funcionDao = new FuncionDAOImp();
       return funcionDao.obtenerTodoFuncion();
    }
   
    
}
