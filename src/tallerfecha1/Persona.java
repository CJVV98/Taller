/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerfecha1;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author johan
 */
public class Persona {
    private int id,cedula,edad;
    private String nombre, apellido, tipo;
    private Date fechanac;
    private Timestamp fecharegistro;


    public Persona(int id, int cedula, int edad, String nombre, String apellido, String tipo, Date fechanac, Timestamp fecharegistro) {
        this.id = id;
        this.cedula = cedula;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.fechanac = fechanac;
        this.fecharegistro = fecharegistro;
    }

   

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public Timestamp getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

 

  
     public static Persona crear(int id, int cedula, int edad, String nombre, String apellido, String tipo,Date fechanac, Timestamp fecharegistro) {
        return new Persona(id,cedula,edad,nombre,apellido,tipo,fechanac,fecharegistro );
    }

}
