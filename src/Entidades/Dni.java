
package Entidades;

import java.util.Date;


public class Dni {
   int numeroDocumento;
   Date fechaNacimiento;
   Date emisionDni;
   String nombre;

    public Dni(int numeroDocumento, Date fechaNacimiento, Date emisionDni, String nombre) {
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.emisionDni = emisionDni;
        this.nombre = nombre;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getEmisionDni() {
        return emisionDni;
    }

    public void setEmisionDni(Date emisionDni) {
        this.emisionDni = emisionDni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
   
}
