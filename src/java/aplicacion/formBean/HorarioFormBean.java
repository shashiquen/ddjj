/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.formBean;

import aplicacion.bean.CargoBean;
import aplicacion.bean.HorarioBean;
import aplicacion.dao.CargoFuncionDAO;
import aplicacion.hibernate.daoImp.CargoFuncionDaoImp;
import aplicacion.modelo.dominio.CargosDeclarado;
import aplicacion.modelo.dominio.Horario;
import aplicacion.modelo.dominio.HorarioLista;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author EMILCE
 */
@ManagedBean
@ViewScoped
public class HorarioFormBean implements Serializable {

    @ManagedProperty(value = "#{horarioBean}")
    private HorarioBean horarioBean;
    @ManagedProperty(value = "#{cargoBean}")
    private CargoBean cargoBean;

    private List<Horario> listaHorarios;
    
    private HorarioLista horario;

    private List<HorarioLista> listaHoras;
    
    private String dia;
    private Double diaDesde;
    private Double diaHasta;

    public HorarioFormBean() {
        CargosDeclarado cargo = new CargosDeclarado();
        cargo.setCodigo(17);

        listaHorarios = new ArrayList<>();
        listaHorarios.add(new Horario(1, cargo, "Domingo", 12, 14, true));
        /* listaHorarios.add(new Horario(2, cargo,"Lunes",14, 17, true));
       listaHorarios.add(new Horario(3, cargo,"Martes",10, 12, true));
       listaHorarios.add(new Horario(4, cargo,"Miercoles",8, 10, true));
       listaHorarios.add(new Horario(5, cargo,"Jueves",13, 15, true));
       listaHorarios.add(new Horario(6, cargo,"Viernes",16, 17, true));
       listaHorarios.add(new Horario(7, cargo,"Sabado",19, 21, true));
       listaHorarios.add(new Horario(8, cargo,"Domingo",0, 0, true)); */

    }
    
    public String addAction(){
        this.horario = new HorarioLista();
        Random rn = new Random();
        switch(this.dia){
            case "LUNES" :
                this.horario.setHorarioId(rn.nextInt());
                this.horario.setLunesDesde(this.diaDesde);
                this.horario.setLunesHasta(this.diaHasta);
                break;
        }
        
        this.listaHoras.add(this.horario);
        RequestContext.getCurrentInstance().update("frmHorarios:listaHora");
        return "";
    }
    
    
    public void onRowEdit(RowEditEvent event) {
        HorarioLista horario = (HorarioLista) event.getObject();
        FacesMessage msg = new FacesMessage("Horario Editado", horario.getHorarioId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((HorarioLista) event.getObject()).getHorarioId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public CargoBean getCargoBean() {
        return cargoBean;
    }

    public void setCargoBean(CargoBean cargoBean) {
        this.cargoBean = cargoBean;
    }

    public CargoFuncionDAO getCargoDao() {
        return cargoDao;
    }

    public void setCargoDao(CargoFuncionDAO cargoDao) {
        this.cargoDao = cargoDao;
    }
    private CargoFuncionDAO cargoDao;

    public HorarioBean getHorarioBean() {
        return horarioBean;
    }

    public void setHorarioBean(HorarioBean horarioBean) {
        this.horarioBean = horarioBean;
    }

    public List<Horario> getListaHorarios() {
        return listaHorarios;
    }

    public void setListaHorarios(List<Horario> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    @PostConstruct
    public void init() {

        Iterator iterator = cargoBean.getCargoDeclarado().getHorarioses().iterator();
        this.listaHoras = new ArrayList<HorarioLista>();
        while (iterator.hasNext()) {

            horarioBean.setHorario((Horario) iterator.next());
        }

    }

    public void agregarHorario() {
        horarioBean.agregarHorario();

    }

    public void limpiar() {

    }

    public List<HorarioLista> getListaHoras() {
        return listaHoras;
    }

    public void setListaHoras(List<HorarioLista> listaHoras) {
        this.listaHoras = listaHoras;
    }

    public HorarioLista getHorario() {
        return horario;
    }

    public void setHorario(HorarioLista horario) {
        this.horario = horario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Double getDiaDesde() {
        return diaDesde;
    }

    public void setDiaDesde(Double diaDesde) {
        this.diaDesde = diaDesde;
    }

    public Double getDiaHasta() {
        return diaHasta;
    }

    public void setDiaHasta(Double diaHasta) {
        this.diaHasta = diaHasta;
    }
    
}
