/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.daoImp;

import aplicacion.dao.UsuarioDAO;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alba Alejandrina
 */
public class UsuarioDaoImp implements Serializable, UsuarioDAO{

    @Override
    public Usuario validarUsuario(String nombre, String password) {
        Usuario usuario=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombre",nombre));
        criteria.add(Restrictions.like("password", password));
        if(!criteria.list().isEmpty()){
            usuario=(Usuario)criteria.list().get(0);
        }
        
        return usuario;
    }
    
}
