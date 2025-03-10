package BL;

import java.util.Date;

//Clase principal
public class Tiquetes{
    protected int codigo;
    protected String descripcion;
    protected String estado;
    protected int usuarioCreador;
    protected int tecnicoAsignado;

    public Tiquetes(){}

    public Tiquetes(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuarioCreador = usuarioCreador;
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public void mostrarInfo(){
        System.out.println("Código: " + codigo + ", Descripción: " + descripcion);
        System.out.println("Estado: " + estado);
        System.out.println("Creador: " + usuarioCreador + ", Técnico: " + tecnicoAsignado);
    }

    @Override
    public String toString(){
        return"Código: " + codigo + ", Descripción: " + descripcion + ", Estado: " + estado +
                ", Creador: " + usuarioCreador + ", Técnico: " + tecnicoAsignado;
    }
}

//Subclase Tiquete Cambio
class TiqueteCambio extends Tiquetes{
    private Date fechaRequerida;
    private Date fechaEjecucion;
    private String pasosRequeridos;

    public TiqueteCambio(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado, Date fechaRequerida, String pasosRequeridos){
        super(codigo, descripcion, estado, usuarioCreador, tecnicoAsignado);
        this.fechaRequerida = fechaRequerida;
        this.pasosRequeridos = pasosRequeridos;
        this.fechaEjecucion = null;
    }

    public void marcarResuelto(Date fechaEjecucion){
        this.fechaEjecucion = fechaEjecucion;
    }

    @Override
    public String toString(){
        return super.toString() + ", Fecha requerida: " + fechaRequerida + ", Fecha de ejecución: " + fechaEjecucion + ", Pasos requeridos: " + pasosRequeridos;
    }
}

//Subclase Tiquete Incidente
class TiqueteIncidente extends Tiquetes{
    private Date fechaSolucion;
    private String descripcionSolucion;

    public TiqueteIncidente(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado){
        super(codigo, descripcion, estado, usuarioCreador, tecnicoAsignado);
        this.fechaSolucion = null;
        this.descripcionSolucion = "";
    }

    public void marcarResuelto(Date fechaSolucion, String descripcionSolucion){
        this.fechaSolucion = fechaSolucion;
        this.descripcionSolucion = descripcionSolucion;
    }

    @Override
    public String toString(){
        return super.toString() + ", Fecha solución: " + fechaSolucion + ", Descripción solución: " + descripcionSolucion;
    }
}

//Subclase Tiquete Servicio
class TiqueteServicio extends Tiquetes{
    private Date fechaEjecucion;
    private String justificacionServicio;
    private int prioridad;

    public TiqueteServicio(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado, String justificacionServicio, int prioridad){
        super(codigo, descripcion, estado, usuarioCreador, tecnicoAsignado);
        this.fechaEjecucion = null;
        this.justificacionServicio = justificacionServicio;
        this.prioridad = prioridad;
    }

    public void marcarResuelto(Date fechaEjecucion){
        this.fechaEjecucion = fechaEjecucion;
    }

    @Override
    public String toString(){
        return super.toString() + ", Fecha ejecución: " + fechaEjecucion + ", Justificación: " + justificacionServicio + ", Prioridad: " + prioridad;
    }
}
