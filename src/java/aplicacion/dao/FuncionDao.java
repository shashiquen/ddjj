/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Funcion;
import java.util.List;

/**
 *
 * @author EMILCE
 */
public interface FuncionDao {
  Funcion obtenerFuncion(int codigo);
  public List<Funcion>obtenerTodoFuncion(); 
}
