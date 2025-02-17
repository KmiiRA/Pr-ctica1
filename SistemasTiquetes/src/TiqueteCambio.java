import java.util.Date;

public class TiqueteCambio {
    private int codigo;
    private String descripcion;
    private String estado;
    private int usuarioCreador;
    private int tecnicoAsignado;
    private Date fechaRequerida;
    private Date fechaEjecucion;
    private String pasosRequeridos;
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

    public Date getFechaRequerida() {return fechaRequerida;}
    public void setFechaRequerida(Date fechaEjecucion) {this.fechaRequerida = fechaRequerida;}

    public Date getFechaEjecucion() {return fechaEjecucion;}
    public void setFechaEjecucion(Date fechaEjecucion) {this.fechaEjecucion = fechaEjecucion;}

    public String getPasosRequeridos() {return pasosRequeridos;}
    public void setPasosRequeridos(String pasosRequeridos) {this.pasosRequeridos = pasosRequeridos;}

    public String getNotas() {return notas;}
    public void setNotas(String notas) {this.notas = notas;}

    public TiqueteCambio(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado, Date fechaRequerida, Date fechaEjecucion, String pasosRequeridos, String notas) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuarioCreador = usuarioCreador;
        this.tecnicoAsignado = tecnicoAsignado;
        this.fechaRequerida = fechaRequerida;
        this.fechaEjecucion = fechaEjecucion;
        this.pasosRequeridos = pasosRequeridos;
        this.notas = notas;
    }
    public TiqueteCambio() {}
}