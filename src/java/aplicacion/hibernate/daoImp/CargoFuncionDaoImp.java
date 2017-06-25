/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.daoImp;

import aplicacion.dao.CargoFuncionDAO;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Agente;
import aplicacion.modelo.dominio.CargosDeclarado;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author EMILCE
 */
public class CargoFuncionDaoImp implements Serializable,CargoFuncionDAO{

    @Override
    public void agregarCargo(CargosDeclarado cargoFuncion) {
         cargoFuncion.setEstado(true);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cargoFuncion);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarCargo(CargosDeclarado cargoFuncion) {
        cargoFuncion.setEstado(true);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(cargoFuncion);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void eliminarCargo(CargosDeclarado cargoFuncion) {
        cargoFuncion.setEstado(false);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(cargoFuncion);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CargosDeclarado obtenerPorAgente(Agente agente) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(CargosDeclarado.class);
        criteria.createAlias("cargos", "c");
        if (agente == null) {
            System.out.println("el agente es nulo");
            
        }else{
            
        System.out.println("agente legajo"+agente.getLegajo());
        }
        criteria.add(Restrictions.like("c.legajo", agente.getLegajo()));
        
        CargosDeclarado cargo=null;
        
        if(!criteria.list().isEmpty()){
            cargo= (CargosDeclarado)criteria.list().get(0);
            
        }
        session.close();
        return cargo;
        }
    }
    

