/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.CargoFuncionDAO;
import aplicacion.hibernate.daoImp.AgenteDAOImp;
import aplicacion.hibernate.daoImp.CargoFuncionDaoImp;
import aplicacion.modelo.dominio.Agente;
import aplicacion.modelo.dominio.CargosDeclarado;
import aplicacion.modelo.dominio.Funcion;
import aplicacion.modelo.dominio.Usuario;
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
public class CargoBean implements Serializable{
   private CargosDeclarado cargoDeclarado;
   private CargoFuncionDAO cargoDAO;

   

  
     @PostConstruct
    public void init(){
        cargoDeclarado = new CargosDeclarado();
        cargoDAO = new CargoFuncionDaoImp();
    } 
   
   public CargoBean() {
       cargoDeclarado = new CargosDeclarado();
       cargoDeclarado.setFunciones(new Funcion());
    } 
   
   
   
   
     public CargoFuncionDAO getCargoDAO() {
        return cargoDAO;
    }

    public void setCargoDAO(CargoFuncionDAO cargoDAO) {
        this.cargoDAO = cargoDAO;
    }

    public CargosDeclarado getCargoDeclarado() {
        return cargoDeclarado;
    }

    public void setCargoDeclarado(CargosDeclarado cargoDeclarado) {
        this.cargoDeclarado = cargoDeclarado;
    }
    
     public void agregarCargo(){
    CargoFuncionDAO cargoDao=new CargoFuncionDaoImp();
      cargoDao.agregarCargo(cargoDeclarado);
    
    }
     
     public void modificarCargo(){
     CargoFuncionDAO cargoDao = new CargoFuncionDaoImp();
       cargoDao.modificarCargo(cargoDeclarado);
     
     }
     
     public void eliminarCargo(){
     CargoFuncionDAO cargoDao = new CargoFuncionDaoImp();
     cargoDao.eliminarCargo(cargoDeclarado);
     
     }
     
    /*  public void recuperarCargo(Agente age){
        cargoDeclarado= cargoDAO.obtenerPorAgente(age);
        
        if(cargoDeclarado == null){
            cargoDeclarado = new CargosDeclarado();
        }
    } */
    
    
}
