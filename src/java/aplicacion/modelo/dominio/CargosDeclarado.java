package aplicacion.modelo.dominio;
// Generated 12/06/2017 23:12:43 by Hibernate Tools 4.3.1


import aplicacion.modelo.dominio.Funcion;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CargosDeclarado generated by hbm2java
 */
public class CargosDeclarado  implements java.io.Serializable {


     private int codigo;
     private Agente agentes;
     private Funcion funciones;
     private String dependencia;
     private String imputacionPresupuestaria;
     private String calle;
     private int numCalle;
     private String localidad;
     private String provincia;
     private Date fechaIngreso;
     private String estadoCargo;
     private boolean estado;
     private String lugar;
     private Date fechaActual;
     private Set horarioses = new HashSet(0);

    public CargosDeclarado() {
    }

	
    public CargosDeclarado(int codigo, Agente agentes, Funcion funciones, String dependencia, String imputacionPresupuestaria, String calle, int numCalle, String localidad, String provincia, Date fechaIngreso, String estadoCargo, boolean estado, String lugar, Date fechaActual) {
        this.codigo = codigo;
        this.agentes = agentes;
        this.funciones = funciones;
        this.dependencia = dependencia;
        this.imputacionPresupuestaria = imputacionPresupuestaria;
        this.calle = calle;
        this.numCalle = numCalle;
        this.localidad = localidad;
        this.provincia = provincia;
        this.fechaIngreso = fechaIngreso;
        this.estadoCargo = estadoCargo;
        this.estado = estado;
        this.lugar = lugar;
        this.fechaActual = fechaActual;
    }
    public CargosDeclarado(int codigo, Agente agentes, Funcion funciones, String dependencia, String imputacionPresupuestaria, String calle, int numCalle, String localidad, String provincia, Date fechaIngreso, String estadoCargo, boolean estado, String lugar, Date fechaActual, Set horarioses) {
       this.codigo = codigo;
       this.agentes = agentes;
       this.funciones = funciones;
       this.dependencia = dependencia;
       this.imputacionPresupuestaria = imputacionPresupuestaria;
       this.calle = calle;
       this.numCalle = numCalle;
       this.localidad = localidad;
       this.provincia = provincia;
       this.fechaIngreso = fechaIngreso;
       this.estadoCargo = estadoCargo;
       this.estado = estado;
       this.lugar = lugar;
       this.fechaActual = fechaActual;
       this.horarioses = horarioses;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Agente getAgentes() {
        return this.agentes;
    }
    
    public void setAgentes(Agente agentes) {
        this.agentes = agentes;
    }
    public Funcion getFunciones() {
        return this.funciones;
    }
    
    public void setFunciones(Funcion funciones) {
        this.funciones = funciones;
    }
    public String getDependencia() {
        return this.dependencia;
    }
    
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
    public String getImputacionPresupuestaria() {
        return this.imputacionPresupuestaria;
    }
    
    public void setImputacionPresupuestaria(String imputacionPresupuestaria) {
        this.imputacionPresupuestaria = imputacionPresupuestaria;
    }
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumCalle() {
        return this.numCalle;
    }
    
    public void setNumCalle(int numCalle) {
        this.numCalle = numCalle;
    }
    public String getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getEstadoCargo() {
        return this.estadoCargo;
    }
    
    public void setEstadoCargo(String estadoCargo) {
        this.estadoCargo = estadoCargo;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getLugar() {
        return this.lugar;
    }
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public Date getFechaActual() {
        return this.fechaActual;
    }
    
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }
    public Set getHorarioses() {
        return this.horarioses;
    }
    
    public void setHorarioses(Set horarioses) {
        this.horarioses = horarioses;
    }




}


