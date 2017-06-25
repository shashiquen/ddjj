/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Agente;
import aplicacion.modelo.dominio.CargosDeclarado;

/**
 *
 * @author EMILCE
 */
public interface CargoFuncionDAO {
    void agregarCargo(CargosDeclarado cargoFuncion);
    void modificarCargo(CargosDeclarado cargoFuncion);
    void eliminarCargo(CargosDeclarado cargoFuncion);
    CargosDeclarado obtenerPorAgente(Agente agente);
    
}
