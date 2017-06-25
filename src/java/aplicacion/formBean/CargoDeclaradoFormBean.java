/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.formBean;

import aplicacion.bean.AgenteBean;
import aplicacion.bean.CargoBean;
import aplicacion.dao.AgenteDAO;
import aplicacion.hibernate.daoImp.AgenteDAOImp;
import aplicacion.modelo.dominio.Agente;
import aplicacion.modelo.dominio.CargosDeclarado;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author EMILCE
 */
@ManagedBean
@ViewScoped
public class CargoDeclaradoFormBean implements Serializable {

    @ManagedProperty(value = "#{cargoBean}")
    private CargoBean cargoBean;
    @ManagedProperty(value = "#{agenteBean}")
    private AgenteBean agenteBean;
    private AgenteDAO agenteDao;

    public AgenteDAO getAgenteDao() {
        return agenteDao;
    }

    public void setAgenteDao(AgenteDAO agenteDao) {
        this.agenteDao = agenteDao;
    }

    public AgenteBean getAgenteBean() {
        return agenteBean;
    }

    public void setAgenteBean(AgenteBean agenteBean) {
        this.agenteBean = agenteBean;
    }

    public CargoBean getCargoBean() {
        return cargoBean;
    }

    public void setCargoBean(CargoBean cargoBean) {
        this.cargoBean = cargoBean;
    }

    public CargoDeclaradoFormBean() {
        cargoBean = new CargoBean();
        agenteBean = new AgenteBean();
    }

    @PostConstruct
    public void init() {
        Iterator iterator = agenteBean.getAgente().getCargosDeclaradoses().iterator();
        while (iterator.hasNext()) {
            cargoBean.setCargoDeclarado((CargosDeclarado) iterator.next());
        }
    }

    public void agregarCargo() {
        FacesContext facescontext = FacesContext.getCurrentInstance();
        try {
            agenteDao = new AgenteDAOImp();
            Agente agente = (Agente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agenteSession");
            cargoBean.getCargoDeclarado().setAgentes(agente);
            cargoBean.agregarCargo();
            CargoBean cargo = new CargoBean();    
            facescontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo grabado exitosamente", "Cargo grabado exitosamente"));
        } catch (Exception e) {
            e.printStackTrace();
            facescontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Cargo no grabado!!!", "Cargo no grabado!!!"));
        }
    }

    public void modificarCargo() {
        cargoBean.modificarCargo();
        FacesContext facescontext = FacesContext.getCurrentInstance();
        facescontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo modificado exitosamente", "Cargo modificado exitosamente"));
    }

    public void eliminarCargo() {
        cargoBean.eliminarCargo();
        FacesContext facescontext = FacesContext.getCurrentInstance();
        facescontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo eliminado exitosamente", "Cargo eliminado exitosamente"));
    }
}
