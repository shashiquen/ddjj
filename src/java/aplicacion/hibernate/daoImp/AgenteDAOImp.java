/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.daoImp;

import aplicacion.dao.AgenteDAO;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Agente;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author EMILCE
 */
public class AgenteDAOImp implements Serializable,AgenteDAO{

    @Override
    public void agregarAgente(Agente agente) {
        agente.setEstado(true);
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(agente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarAgente(Agente agente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarAgente(Agente agente) {
        agente.setEstado(true);
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(agente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Agente getAgente(int legalo) {
       Session session=HibernateUtil.getSessionFactory().openSession();
       Criteria criteria = session.createCriteria(Agente.class);
       criteria.add(Restrictions.eq("legajo", legalo));
       Agente agente = null;
      
         if (!criteria.list().isEmpty()) {
            agente=(Agente)criteria.list().get(0);
        }
         return agente;
    }

    @Override
    public Agente obtenerPorUsuario(Usuario usuario) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Agente.class);
        criteria.createAlias("usuarios", "u");
        if (usuario == null) {
            System.out.println("el usuario es nulo");
            
        }else{
            
        System.out.println("nombre de usuario"+usuario.getNombre());
        }
        criteria.add(Restrictions.like("u.nombre", usuario.getNombre()));
        
        Agente agente=null;
        
        if(!criteria.list().isEmpty()){
            agente= (Agente)criteria.list().get(0);
            
        }
        session.close();
        return agente;
    }

    @Override
    public boolean validarLegajo(int legajo) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Agente.class);
        criteria.add(Restrictions.eq("legajo",legajo));
        boolean esValido = false;
        if (criteria.list().isEmpty()) {
            esValido = true;
        }
        return esValido;
    }

    }
    

