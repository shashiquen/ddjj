/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Agente;
import aplicacion.modelo.dominio.Usuario;

/**
 *
 * @author EMILCE
 */
public interface AgenteDAO {
    
    void agregarAgente(Agente agente);
    void eliminarAgente(Agente agente);
    void modificarAgente(Agente agente);
    Agente getAgente(int legalo);
    Agente obtenerPorUsuario(Usuario usuario);
    boolean validarLegajo(int legajo);
}
