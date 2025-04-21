package BL;

import DAO.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionarUsuarios {
    private static List<Usuarios> usuarios = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public static void listarUsuarios() {
        usuarios = UsuarioDAO.listar();
        if (usuarios.isEmpty()) {
            System.out.println("No existen usuarios registrados.");
        } else {
            for (Usuarios u : usuarios) {
                u.mostrarInfo();
            }
        }
    }

    public static String listarUsuariosComoTexto() {
        usuarios = UsuarioDAO.listar();
        if (usuarios.isEmpty()) return "No hay usuarios registrados.";
        StringBuilder sb = new StringBuilder();
        for (Usuarios u : usuarios) {
            sb.append(u.toString()).append("\n");
        }
        return sb.toString();
    }

    public static void registrarUsuario() {
        int codigo = 0;
        try {
            System.out.print("Código: ");
            codigo = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Primer Apellido: ");
        String primerApellido = sc.nextLine();
        System.out.print("Segundo Apellido: ");
        String segundoApellido = sc.nextLine();
        System.out.print("Correo Electrónico: ");
        String correo = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();
        System.out.print("Tipo (Administrador, Creador, Técnico): ");
        String tipo = sc.nextLine();

        Usuarios nuevo = new Usuarios(codigo, nombre, primerApellido, segundoApellido, correo, telefono, password, tipo);
        if (UsuarioDAO.insertar(nuevo)) {
            usuarios.add(nuevo);
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("Error al registrar usuario en la base de datos.");
        }
    }

    public static void modificarUsuario() {
        int codigo = 0;
        try {
            System.out.print("Ingrese el código del usuario a modificar: ");
            codigo = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
            return;
        }

        for (Usuarios u : usuarios) {
            if (u.getCodigo() == codigo) {
                System.out.println("Ingrese los nuevos datos:");
                System.out.print("Nuevo nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Nuevo primer apellido: ");
                String primerApellido = sc.nextLine();
                System.out.print("Nuevo segundo apellido: ");
                String segundoApellido = sc.nextLine();
                System.out.print("Nuevo correo electrónico: ");
                String email = sc.nextLine();
                System.out.print("Nuevo teléfono: ");
                String telefono = sc.nextLine();
                System.out.print("Nueva contraseña: ");
                String password = sc.nextLine();
                System.out.print("Nuevo tipo: ");
                String tipo = sc.nextLine();

                u.setNombre(nombre);
                u.setPrimerApellido(primerApellido);
                u.setSegundoApellido(segundoApellido);
                u.setCorreoElectronico(email);
                u.setTelefono(telefono);
                u.setPassword(password);
                u.setTipo(tipo);

                System.out.println("Usuario modificado con éxito.");
                return;
            }
        }

        System.out.println("No se encontró un usuario con ese código.");
    }

    public static boolean modificarUsuarioPorId(int id, String nuevoNombre) {
        for (Usuarios u : usuarios) {
            if (u.getCodigo() == id) {
                u.setNombre(nuevoNombre);
                return true;
            }
        }
        return false;
    }

    public static void eliminarUsuario() {
        int codigo = 0;
        try {
            System.out.print("Ingrese el código del usuario a eliminar: ");
            codigo = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
            return;
        }

        Usuarios encontrado = null;
        for (Usuarios u : usuarios) {
            if (u.getCodigo() == codigo) {
                encontrado = u;
                break;
            }
        }

        if (encontrado != null) {
            usuarios.remove(encontrado);
            System.out.println("Usuario eliminado con éxito.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static boolean eliminarUsuarioPorId(int id) {
        for (Usuarios u : usuarios) {
            if (u.getCodigo() == id) {
                usuarios.remove(u);
                return true;
            }
        }
        return false;
    }

    public static Usuarios buscarUsuarioPorCodigo(int codigo){
        for(Usuarios u:usuarios){
            if(u.getCodigo()==codigo){
                return u;
            }
        }
        return null;
    }
}



