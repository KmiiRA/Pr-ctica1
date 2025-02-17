import java.util.Date;

public class TiqueteServicio {
    private int codigo;
    private String descripcion;
    private String estado;
    private int usuarioCreador;
    private int tecnicoAsignado;
    private Date fechaEjecucion;
    private String justificacion;
    private int prioridad;
    private String notas;

    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}

    public int getUsuarioCreador() {return usuarioCreador;}
    public void setUsuarioCreador(int usuarioCreador) {this.usuarioCreador = usuarioCreador;}

    public int getTecnicoAsignado() {return tecnicoAsignado;}
    public void setTecnicoAsignado(int tecnicoAsignado) {this.tecnicoAsignado = tecnicoAsignado;}

    public Date getFechaEjecucion() {return fechaEjecucion;}
    public void setFechaEjecucion(Date fechaEjecucion) {this.fechaEjecucion = fechaEjecucion;}

    public String getJustificacion() {return justificacion;}
    public void setJustificacion(String justificacion) {this.justificacion = justificacion;}

    public int getPrioridad() {return prioridad;}
    public void setPrioridad(int prioridad) {this.prioridad = prioridad;}

    public String getNotas() {return notas;}
    public void setNotas(String notas) {this.notas = notas;}

    public TiqueteServicio(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado, Date fechaEjecucion, String justificacion, int prioridad, String notas) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuarioCreador = usuarioCreador;
        this.tecnicoAsignado = tecnicoAsignado;
        this.fechaEjecucion = fechaEjecucion;
        this.justificacion = justificacion;
        this.prioridad = prioridad;
        this.notas = notas;
    }
    public TiqueteServicio() {}
}