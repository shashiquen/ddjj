/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.daoImp;

import aplicacion.dao.FuncionDao;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Funcion;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author EMILCE
 */
public class FuncionDAOImp implements Serializable,FuncionDao{

    @Override
    public List<Funcion> obtenerTodoFuncion() {
       Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Funcion.class);
        //criteria.add(Restrictions.eq("estado",true));
        criteria.addOrder(Order.asc("codigo"));
        List funcion=criteria.list();
        session.close();
        return funcion;
    }

    @Override
    public Funcion obtenerFuncion(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
