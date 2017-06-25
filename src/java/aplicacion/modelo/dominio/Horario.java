package aplicacion.modelo.dominio;
// Generated 12/06/2017 23:12:43 by Hibernate Tools 4.3.1




/**
 * Horario generated by hbm2java
 */
public class Horario  implements java.io.Serializable {


     private int codigo;
     private CargosDeclarado cargosDeclarados;
     private String dia;
     private double desde;
     private double hasta;
     private boolean estado;

    public Horario() {
    }

    public Horario(int codigo, CargosDeclarado cargosDeclarados, String dia, double desde, double hasta, boolean estado) {
       this.codigo = codigo;
       this.cargosDeclarados = cargosDeclarados;
       this.dia = dia;
       this.desde = desde;
       this.hasta = hasta;
       this.estado = estado;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public CargosDeclarado getCargosDeclarados() {
        return this.cargosDeclarados;
    }
    
    public void setCargosDeclarados(CargosDeclarado cargosDeclarados) {
        this.cargosDeclarados = cargosDeclarados;
    }
    public String getDia() {
        return this.dia;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }
    public double getDesde() {
        return this.desde;
    }
    
    public void setDesde(double desde) {
        this.desde = desde;
    }
    public double getHasta() {
        return this.hasta;
    }
    
    public void setHasta(double hasta) {
        this.hasta = hasta;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }




}


