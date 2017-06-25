/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;

/**
 *
 * @author Alba Alejandrina
 */
public interface UsuarioDAO {
    
    /**
     * Valida la existencia de un Usuario
     * @param nombreUsuario
     * @param password
     * @return null si no existe
     */
    Usuario validarUsuario(String nombreUsuario,String password);
}
