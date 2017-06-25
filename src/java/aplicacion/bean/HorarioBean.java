/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.HorarioDAO;
import aplicacion.hibernate.daoImp.HorarioDAOImp;
import aplicacion.modelo.dominio.Horario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author EMILCE
 */
@ManagedBean
@ViewScoped
public class HorarioBean implements Serializable{
    private Horario horario;
    private HorarioDAO horarioDao;
   
    
     public HorarioBean() {
       
    }
     
     
      @PostConstruct
    public void init(){
        horario = new Horario();
        horarioDao= new HorarioDAOImp();
    }
     
     
     
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public HorarioDAO getHorarioDao() {
        return horarioDao;
    }

    public void setHorarioDao(HorarioDAO horarioDao) {
        this.horarioDao = horarioDao;
    }
   
     public void agregarHorario(){
      HorarioDAO horarioDao = new HorarioDAOImp();
      horarioDao.agregarHorario(horario);
     
     }
   
    
}
