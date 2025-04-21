package BL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tiquetes{
    public int codigo;
    public String descripcion;
    public String estado;
    public int usuarioCreador;
    public int tecnicoAsignado;
    public List<String> notasExtra=new ArrayList<>();

    public Tiquetes(){}

    public Tiquetes(int codigo,String descripcion,String estado,int usuarioCreador,int tecnicoAsignado){
        this.codigo=codigo;
        this.descripcion=descripcion;
        this.estado=estado;
        this.usuarioCreador=usuarioCreador;
        this.tecnicoAsignado=tecnicoAsignado;
    }

    public void mostrarInfo(){
        System.out.println("Código: "+codigo+", Descripción: "+descripcion);
        System.out.println("Estado: "+estado);
        System.out.println("Creador: "+usuarioCreador+", Técnico: "+tecnicoAsignado);
    }

    public void agregarNota(String nota){
        notasExtra.add(nota);
    }

    public void mostrarNotas(){
        if(notasExtra.isEmpty()){
            System.out.println("Sin notas adicionales.");
        }else{
            System.out.println("Notas:");
            for(String nota:notasExtra){
                System.out.println("- "+nota);
            }
        }
    }

    public String getNotasComoTexto(){
        if(notasExtra.isEmpty())return "Sin notas adicionales.";
        StringBuilder sb=new StringBuilder("Notas:");
        for(String nota:notasExtra){
            sb.append("\n- ").append(nota);
        }
        return sb.toString();
    }

    public String getEstado(){
        return estado;
    }

    public Usuarios getUsuarioCreador(){
        return GestionarUsuarios.buscarUsuarioPorCodigo(usuarioCreador);
    }

    public Usuarios getUsuarioTecnico(){
        return GestionarUsuarios.buscarUsuarioPorCodigo(tecnicoAsignado);
    }

    @Override
    public String toString(){
        return"Código: "+codigo+", Descripción: "+descripcion+", Estado: "+estado+", Creador: "+usuarioCreador+", Técnico: "+tecnicoAsignado;
    }
}

//Subclase TiqueteCambio
class TiqueteCambio extends Tiquetes{
    private String fechaRequerida;
    private String fechaEjecucion;
    private String pasosRequeridos;

    public TiqueteCambio(int codigo,String descripcion,String estado,int usuarioCreador,int tecnicoAsignado,String fechaRequerida,String fechaEjecucion,String pasosRequeridos){
        super(codigo,descripcion,estado,usuarioCreador,tecnicoAsignado);
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

//Subclase TiqueteIncidente
class TiqueteIncidente extends Tiquetes{
    private Date fechaSolucion;
    private String descripcionSolucion;
    private String impacto;

    public TiqueteIncidente(int codigo,String descripcion,String estado,int usuarioCreador,int tecnicoAsignado,String impacto){
        super(codigo,descripcion,estado,usuarioCreador,tecnicoAsignado);
        this.fechaSolucion=null;
        this.descripcionSolucion="";
        this.impacto=impacto;
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

//Subclase TiqueteServicio
class TiqueteServicio extends Tiquetes{
    private Date fechaEjecucion;
    private String justificacionServicio;
    private int prioridad;

    public TiqueteServicio(int codigo,String descripcion,String estado,int usuarioCreador,int tecnicoAsignado,String justificacionServicio,int prioridad){
        super(codigo,descripcion,estado,usuarioCreador,tecnicoAsignado);
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

