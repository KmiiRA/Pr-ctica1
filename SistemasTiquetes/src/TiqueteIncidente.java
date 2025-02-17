import java.util.Date;

public class TiqueteIncidente {
    private int codigo;
    private String descripcion;
    private String estado;
    private int usuarioCreador;
    private int tecnicoAsignado;
    private Date fechaSolucion;
    private String descripcionSolucion;
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

    public Date getFechaSolucion() {return fechaSolucion;}
    public void setFechaSolucion(Date fechaSolucion) {this.fechaSolucion = fechaSolucion;}

    public String getDescripcionSolucion() {return descripcionSolucion;}
    public void setDescripcionSolucion(String descripcionSolucion) {this.descripcionSolucion = descripcionSolucion;}

    public String getNotas() {return notas;}
    public void setNotas(String notas) {this.notas = notas;}

    public TiqueteIncidente(int codigo, String descripcion, String estado, int usuarioCreador, int tecnicoAsignado, Date fechaSolucion, String descripcionSolucion, String notas) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuarioCreador = usuarioCreador;
        this.tecnicoAsignado = tecnicoAsignado;
        this.fechaSolucion = fechaSolucion;
        this.descripcionSolucion = descripcionSolucion;
        this.notas = notas;
    }
    public TiqueteIncidente() {}
}
