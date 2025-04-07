package BL;

import java.util.Date;

public class Tiquetes{
    protected int codigo;
    protected String descripcion;
    protected String estado;
    protected int usuarioCreador;
    protected int tecnicoAsignado;
    protected String notas;

    public Tiquetes(){}

    public Tiquetes(int codigo,String descripcion,String estado,int usuarioCreador,int tecnicoAsignado,String notas){
        this.codigo=codigo;
        this.descripcion=descripcion;
        this.estado=estado;
        this.usuarioCreador=usuarioCreador;
        this.tecnicoAsignado=tecnicoAsignado;
        this.notas=notas;
    }

    public void mostrarInfo(){
        System.out.println("Código: "+codigo+", Descripción: "+descripcion);
        System.out.println("Estado: "+estado);
        System.out.println("Creador: "+usuarioCreador+", Técnico: "+tecnicoAsignado+", Notas: "+notas);
    }

    @Override
    public String toString(){
        return"Código: "+codigo+", Descripción: "+descripcion+", Estado: "+estado+", Creador: "+usuarioCreador+", Técnico: "+tecnicoAsignado+", Notas: "+notas;
    }
}

//Subclase TiqueteIncidente
class TiqueteIncidente extends Tiquetes{
    private Date fechaSolucion;
    private String descripcionSolucion;
    private String impacto;

    public TiqueteIncidente(int codigo,String descripcion,String estado,int usuarioCreador,int tecnicoAsignado,String impacto,String notas){
        super(codigo,descripcion,estado,usuarioCreador,tecnicoAsignado,notas);
        this.impacto=impacto;
        this.fechaSolucion=null;
        this.descripcionSolucion="";
    }

    public void marcarResuelto(Date fechaSolucion,String descripcionSolucion){
        this.fechaSolucion=fechaSolucion;
        this.descripcionSolucion=descripcionSolucion;
    }

    @Override
    public String toString(){
        return super.toString()+", Impacto: "+impacto+", Fecha solución: "+fechaSolucion+", Descripción solución: "+descripcionSolucion;
    }
}

//Subclase TiqueteCambio
class TiqueteCambio extends Tiquetes{
    private String fechaRequerida;
    private String fechaEjecucion;
    private String pasosRequeridos;

    public TiqueteCambio(int codigo,String descripcion,String estado,int usuarioCreador,int tecnicoAsignado,String fechaRequerida,String fechaEjecucion,String pasosRequeridos,String notas){
        super(codigo,descripcion,estado,usuarioCreador,tecnicoAsignado,notas);
        this.fechaRequerida=fechaRequerida;
        this.fechaEjecucion=fechaEjecucion;
        this.pasosRequeridos=pasosRequeridos;
    }

    public void marcarResuelto(String fechaEjecucion){
        this.fechaEjecucion=fechaEjecucion;
    }

    @Override
    public String toString(){
        return super.toString()+", Fecha requerida: "+fechaRequerida+", Fecha de ejecución: "+fechaEjecucion+", Pasos requeridos: "+pasosRequeridos;
    }
}

//Subclase TiqueteServicio
class TiqueteServicio extends Tiquetes{
    private Date fechaEjecucion;
    private String justificacionServicio;
    private int prioridad;

    public TiqueteServicio(int codigo,String descripcion,String estado,int usuarioCreador,int tecnicoAsignado,String justificacionServicio,int prioridad,String notas){
        super(codigo,descripcion,estado,usuarioCreador,tecnicoAsignado,notas);
        this.fechaEjecucion=null;
        this.justificacionServicio=justificacionServicio;
        this.prioridad=prioridad;
    }

    public void marcarResuelto(Date fechaEjecucion){
        this.fechaEjecucion=fechaEjecucion;
    }

    @Override
    public String toString(){
        return super.toString()+", Fecha ejecución: "+fechaEjecucion+", Justificación: "+justificacionServicio+", Prioridad: "+prioridad;
    }
}
