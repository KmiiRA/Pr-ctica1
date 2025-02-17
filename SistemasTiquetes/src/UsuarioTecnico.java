public class UsuarioTecnico {
    private int codigo;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String correoElectronico;
    private String telefono;
    private String password;
    private String rol;

    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getPrimerApellido() {return primerApellido;}
    public void setPrimerApellido(String primerApellido) {this.primerApellido = primerApellido;}

    public String getSegundoApellido() {return segundoApellido;}
    public void setSegundoApellido(String segundoApellido) {this.segundoApellido = segundoApellido;}

    public String getCorreoElectronico() {return correoElectronico;}
    public void setCorreoElectronico(String correoElectronico) {this.correoElectronico = correoElectronico;}

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getRol() {return rol;}
    public void setRol(String rol) {this.rol = rol;}

    public UsuarioTecnico() {}

    public UsuarioTecnico(int codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, String telefono, String password, String rol) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.password = password;
        this.rol = rol;
    }

}
