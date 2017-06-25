/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.formBean;

import aplicacion.bean.AgenteBean;
import aplicacion.bean.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alba Alejandrina
 */
@ManagedBean
@SessionScoped
public class UsuarioFormBean implements Serializable {

    private String nombreUsuario;
    private String password;

    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;

    @ManagedProperty(value = "#{agenteBean}")
    private AgenteBean agenteBean;

    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
        usuarioBean = new UsuarioBean();
    }

    public String validarUsuario() {
        String resultado = null;
        usuarioBean.getUsuario().setNombre(nombreUsuario);
        usuarioBean.getUsuario().setPassword(password);
        Usuario usuario = usuarioBean.validarUsuario(nombreUsuario, password);
        if (usuario != null) {
            recuperarAgente(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario valido"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuario);
            resultado = "/menuInicial?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El usuario no existe"));
            resultado = "/loginUsuario?faces-redirect=true";
        }
        return resultado;
    }

    public void recuperarAgente(Usuario usuario) {
        agenteBean.recuperarAgente(usuario);
    }

    public boolean verificarSesion() {
        boolean sesionValida = false;
        if ((FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado")) != null) {
            sesionValida = true;
        }
        return sesionValida;
    }

    public String recuperarUsuario() {
        Usuario usu = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usu.getNombre();
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión cerrada", "Sesión cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);

        String resultado = "/loginUsuario?faces-redirect=true";
        return resultado;
    }

    public AgenteBean getAgenteBean() {
        return agenteBean;
    }

    public void setAgenteBean(AgenteBean agenteBean) {
        this.agenteBean = agenteBean;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

}
