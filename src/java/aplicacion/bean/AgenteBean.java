/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.AgenteDAO;
import aplicacion.hibernate.daoImp.AgenteDAOImp;
import aplicacion.modelo.dominio.Agente;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author EMILCE
 */
@ManagedBean
@SessionScoped
public class AgenteBean implements Serializable {

    private Agente agente;
    private AgenteDAO agenteDAO;

    /**
     * Creates a new instance of AgenteBean
     */
    public AgenteBean() {

    }

    @PostConstruct
    public void init() {
        agente = new Agente();
        agenteDAO = new AgenteDAOImp();
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public AgenteDAO getAgenteDAO() {
        return agenteDAO;
    }

    public void setAgenteDAO(AgenteDAO agenteDAO) {
        this.agenteDAO = agenteDAO;
    }

    public void agregarAgente() {
        AgenteDAO agenteDao = new AgenteDAOImp();
        agenteDao.agregarAgente(this.agente);

    }

    public void modificarAgente() {
        AgenteDAO agenteDao = new AgenteDAOImp();
        agenteDao.modificarAgente(agente);

    }

    public void recuperarAgente(Usuario usu) {
        this.agente = agenteDAO.obtenerPorUsuario(usu);

        if (this.agente == null) {
            this.agente = new Agente();
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agenteSession", this.agente);
        }
    }

    public Agente buscarAgente(int legajo) {
        AgenteDAO agenteDAO = new AgenteDAOImp();
        agente = agenteDAO.getAgente(legajo);

        if (agente == null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El legajo ya existe", "El legajo ya existe"));

        }
        return agente;

    }

    /* public Agente validarAgente(int legajo){
     
     return agenteDAO.getAgente(legajo);
     
     } */
}
