package BL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Clase principal
public class Tiquetes{
    protected int codigo;
    protected String descripcion;
    protected String estado;
    protected int usuarioCreador;
    protected int tecnicoAsignado;
    protected String notas;

    public Tiquetes(){}

    public Tiquetes(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado, String notas){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuarioCreador = usuarioCreador;
        this.tecnicoAsignado = tecnicoAsignado;
        this.notas = notas;
    }

    public void mostrarInfo(){
        System.out.println("Código: " + codigo + ", Descripción: " + descripcion);
        System.out.println("Estado: " + estado);
        System.out.println("Creador: " + usuarioCreador + ", Técnico: " + tecnicoAsignado);
        System.out.println("Notas: " + notas);
    }

    @Override
    public String toString(){
        return "Código: " + codigo + ", Descripción: " + descripcion + ", Estado: " + estado +
                ", Creador: " + usuarioCreador + ", Técnico: " + tecnicoAsignado + ", Notas: " + notas;
    }

    public int getCodigo(){return codigo;}
    public void setCodigo(int codigo){this.codigo = codigo;}

    public String getDescripcion(){return descripcion;}
    public void setDescripcion(String descripcion){ this.descripcion = descripcion;}

    public String getEstado(){return estado;}
    public void setEstado(String estado) {this.estado = estado;}

    public int getUsuarioCreador(){return usuarioCreador;}
    public void setUsuarioCreador(int usuarioCreador){this.usuarioCreador = usuarioCreador;}

    public int getTecnicoAsignado(){return tecnicoAsignado;}
    public void setTecnicoAsignado(int tecnicoAsignado){this.tecnicoAsignado = tecnicoAsignado;}

    public String getNotas(){return notas;}
    public void setNotas(String notas){this.notas = notas;}
}

// Subclase Tiquete Cambio
class TiqueteCambio extends Tiquetes{
    private Date fechaRequerida;
    private Date fechaEjecucion;
    private String pasosRequeridos;

    public TiqueteCambio(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado, Date fechaRequerida, Date fechaEjecucion, String pasosRequeridos, String notas){
        super(codigo, descripcion, estado, usuarioCreador, tecnicoAsignado, notas);
        this.fechaRequerida = fechaRequerida;
        this.fechaEjecucion = fechaEjecucion;
        this.pasosRequeridos = pasosRequeridos;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Fecha requerida: " + fechaRequerida);
        System.out.println("Fecha de ejecución: " + fechaEjecucion);
        System.out.println("Pasos requeridos: " + pasosRequeridos);
    }

    @Override
    public String toString(){
        return super.toString() + ", Fecha requerida: " + fechaRequerida + ", Fecha de ejecución: " + fechaEjecucion + ", Pasos requeridos: " + pasosRequeridos;
    }
}

// Subclase Tiquete Soporte
class TiqueteSoporte extends Tiquetes{
    private String categoria;
    private List<String> accionesRealizadas;

    public TiqueteSoporte(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado, String categoria, String notas){
        super(codigo, descripcion, estado, usuarioCreador, tecnicoAsignado, notas);
        this.categoria = categoria;
        this.accionesRealizadas = new ArrayList<>();
    }

    public void agregarAccion(String accion){
        accionesRealizadas.add(accion);
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Categoría de soporte: " + categoria);
        System.out.println("Acciones realizadas: " + accionesRealizadas);
    }

    @Override
    public String toString(){
        return super.toString() + ", Categoría: " + categoria + ", Acciones realizadas: " + accionesRealizadas;
    }
}

// Subclase Tiquete Incidente
class TiqueteIncidente extends Tiquetes{
    private String impacto;

    public TiqueteIncidente(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado, String impacto, String notas){
        super(codigo, descripcion, estado, usuarioCreador, tecnicoAsignado, notas);
        this.impacto = impacto;
    }

    public String getImpacto(){return impacto;}
    public void setImpacto(String impacto){ this.impacto = impacto;}

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Impacto: " + impacto);
    }

    @Override
    public String toString(){
        return super.toString() + ", Impacto: " + impacto;
    }
}
