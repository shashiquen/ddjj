/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.formBean;

import aplicacion.bean.AgenteBean;
import aplicacion.modelo.dominio.Agente;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author EMILCE
 */
@ManagedBean
@SessionScoped
public class AgenteFormBean implements Serializable {

    @ManagedProperty(value = "#{agenteBean}")
    private AgenteBean agenteBean;

    private int legajo;
    private Agente agente;

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public AgenteBean getAgenteBean() {
        return agenteBean;
    }

    public void setAgenteBean(AgenteBean agenteBean) {
        this.agenteBean = agenteBean;
    }

    public AgenteFormBean() {
        agenteBean = new AgenteBean();
        agente = new Agente();
    }

    @PostConstruct
    public void init() {
        Usuario usu = (Usuario) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("usuarioValidado");

        agenteBean.recuperarAgente(usu);
        System.out.println("----------------" + agente.getLegajo());
    }

    public void agregarAgente() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        agenteBean.getAgente().setUsuarios(us);
        agenteBean.agregarAgente();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agenteSession", agenteBean.getAgente());
        FacesContext facesContex = FacesContext.getCurrentInstance();
        facesContex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agente grabado exitosamente", "Agente grabado exitosamente"));

    }

    public void modificarAgente() {
        agenteBean.modificarAgente();
        FacesContext facesContex = FacesContext.getCurrentInstance();
        facesContex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agente modificado exitosamente", "Agente modificado exitosamente"));
    }

    /* public Agente validarAgente(){
        
       agenteBean.getAgente().setLegajo(legajo);
        Agente agente = agenteBean.validarAgente(legajo);
          if (agente!=null) {
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agenteValido", agente); 
         }
          return agente;
     } */
}
