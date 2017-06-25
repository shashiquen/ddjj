/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.UsuarioDAO;
import aplicacion.hibernate.daoImp.UsuarioDaoImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Alba Alejandrina
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
    
    
    
    @PostConstruct
    public void init(){
        usuario=new Usuario();
        usuarioDAO= new UsuarioDaoImp();
        
    }
    
    
    public Usuario validarUsuario(String nombre, String password){
       
        return usuarioDAO.validarUsuario(nombre,password);
    }
    
    
    
    
    
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    
    
}
