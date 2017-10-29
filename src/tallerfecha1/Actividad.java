package tallerfecha1;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johan
 */
public class Actividad {

 
    private int id;
    private String nombre,descripcion,recreador;
    private Date fechai;
    private Time horainicio,horafin;
    private Timestamp fecharegistro1;

    public Actividad(int id, String nombre, String descripcion, String recreador, Date fechai, Time horainicio, Time horafin, Timestamp fecharegistro1) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.recreador = recreador;
        this.fechai = fechai;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.fecharegistro1 = fecharegistro1;
    }
    public static Actividad crear(int id, String nombre, String descripcion, String recreador, Date fechai, Time horainicio, Time horafin, Timestamp fecharegistro1)  {
        return new Actividad(id,nombre,descripcion,recreador,fechai,horainicio,horafin,fecharegistro1 );
    }
    public String getRecreador() {
        return recreador;
    }

    public void setRecreador(String recreador) {
        this.recreador = recreador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechai() {
        return fechai;
    }

    public void setFechai(Date fechai) {
        this.fechai = fechai;
    }

    public Time getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Time horainicio) {
        this.horainicio = horainicio;
    }

    public Time getHorafin() {
        return horafin;
    }

    public void setHorafin(Time horafin) {
        this.horafin = horafin;
    }

    public Timestamp getFecharegistro1() {
        return fecharegistro1;
    }

    public void setFecharegistro1(Timestamp fecharegistro1) {
        this.fecharegistro1 = fecharegistro1;
    }

            
}
