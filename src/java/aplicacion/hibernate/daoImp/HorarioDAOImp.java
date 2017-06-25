/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.daoImp;

import aplicacion.dao.HorarioDAO;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Horario;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author EMILCE
 */
public class HorarioDAOImp implements Serializable,HorarioDAO{

    @Override
    public void agregarHorario(Horario horario) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(horario);
        session.getTransaction().commit();
        session.close();
    }
    
}
