package BL;

//Clase principal
public class Usuarios{
    protected int codigo;
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String correoElectronico;
    protected String telefono;
    protected String password;

    public Usuarios(){}

    public Usuarios(int codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, String telefono, String password){
        this.codigo = codigo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.password = password;
    }

    public void mostrarInfo(){
        System.out.println("Código: " + codigo + ", Nombre: " + nombre + " " + primerApellido + " " + segundoApellido);
    }

    @Override
    public String toString(){
        return "Código: " + codigo + ", Nombre: " + nombre + " " + primerApellido + " " + segundoApellido + ", Correo: " + correoElectronico + ", Teléfono: " + telefono;
    }

    public int getCodigo(){return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}

    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getPrimerApellido(){return primerApellido;}
    public void setPrimerApellido(String primerApellido) {this.primerApellido = primerApellido;}

    public String getSegundoApellido(){return segundoApellido;}
    public void setSegundoApellido(String segundoApellido){this.segundoApellido = segundoApellido;}

    public String getCorreoElectronico(){return correoElectronico;}
    public void setCorreoElectronico(String correoElectronico){this.correoElectronico = correoElectronico;}

    public String getTelefono(){return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getPassword(){return password;}
    public void setPassword(String password) {this.password = password;}
}

//Subclase Administrador
class Administrador extends Usuarios{
    private boolean estado;

    public Administrador(int codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, String telefono, String password, boolean estado){
        super(codigo, nombre, primerApellido, segundoApellido, correoElectronico, telefono, password);
        this.estado = estado;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Estado: " + (estado ? "Activo" : "Inactivo"));
    }

    @Override
    public String toString(){
        return super.toString() + ", Estado: " + (estado ? "Activo" : "Inactivo");
    }

    public boolean getEstado(){return estado;}
    public void setEstado(boolean estado) { this.estado = estado; }
}

// Subclase Creador
class Creador extends Usuarios{
    private String departamento;

    public Creador(int codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, String telefono, String password, String departamento){
        super(codigo, nombre, primerApellido, segundoApellido, correoElectronico, telefono, password);
        this.departamento = departamento;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Departamento: " + departamento);
    }

    @Override
    public String toString(){
        return super.toString() + ", Departamento: " + departamento;
    }

    public String getDepartamento(){ return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
}

//Subclase Técnico
class Tecnico extends Usuarios{
    private String rol;

    public Tecnico(int codigo, String nombre, String primerApellido, String segundoApellido, String correoElectronico, String telefono, String password, String rol){
        super(codigo, nombre, primerApellido, segundoApellido, correoElectronico, telefono, password);
        this.rol = rol;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Rol: " + rol);
    }

    @Override
    public String toString(){
        return super.toString() + ", Rol: " + rol;
    }

    public String getRol(){ return rol;}
    public void setRol(String rol) { this.rol = rol;}
}
