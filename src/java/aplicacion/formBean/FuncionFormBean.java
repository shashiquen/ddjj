/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.formBean;

import aplicacion.bean.FuncionBean;
import aplicacion.modelo.dominio.Funcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author EMILCE
 */
@ManagedBean
@ViewScoped
public class FuncionFormBean implements Serializable{
  @ManagedProperty(value = "#{funcionBean}")
  private FuncionBean funcionBean;
  private List<Funcion>funciones;
  
  
      public FuncionFormBean() {
        funcionBean = new FuncionBean();
        funciones = new ArrayList<>();
    }
       @PostConstruct   // indica cual inicia primero
    public void init(){
      obtenerFunciones();
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }

    public FuncionBean getFuncionBean() {
        return funcionBean;
    }

    public void setFuncionBean(FuncionBean funcionBean) {
        this.funcionBean = funcionBean;
    }
  
  
    
    private void obtenerFunciones(){
      funciones= funcionBean.obtenerFunciones();
    }
    
}
