/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.validaciones;

import aplicacion.bean.AgenteBean;
import aplicacion.modelo.dominio.Agente;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Emilce
 */
@FacesValidator ("legajoAgenteValidator")
public class LegajoAgenteValidators implements Validator{
    AgenteBean agenteBean= new AgenteBean();
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if(o!=null){
           
            Agente agente = null;
            
            agente =agenteBean.buscarAgente((int)o);
            if(agente!=null){
            throw new ValidatorException(new FacesMessage("El legajo ya existe"));
            }
          }
    }
 }
