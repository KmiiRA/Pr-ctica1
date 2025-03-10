package BL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class GestionarUsuarios{
    private static List<Usuarios> usuarios = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void listarUsuarios(){
        if (usuarios.isEmpty()){
            System.out.println("No existen usuarios registrados.");
        } else{
            for (Usuarios u : usuarios){
                u.mostrarInfo();
            }
        }
    }

    public static void registrarUsuario(){
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();
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

        usuarios.add(new Usuarios(codigo, nombre, primerApellido, segundoApellido, correo, telefono, password));
        System.out.println("Usuario registrado con éxito.");
    }

    public static void modificarUsuario(){
        System.out.print("Ingrese el código del usuario a modificar: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        for(Usuarios u : usuarios){
            if (u.getCodigo() == codigo){
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

                u.setNombre(nombre);
                u.setPrimerApellido(primerApellido);
                u.setSegundoApellido(segundoApellido);
                u.setCorreoElectronico(email);
                u.setTelefono(telefono);
                u.setPassword(password);

                System.out.println("Usuario modificado con éxito.");
                return;
            }
        }

        System.out.println("No se encontró un usuario con ese código.");
    }

    public static void eliminarUsuario(){
        System.out.print("Ingrese el código del usuario a eliminar: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        if(usuarios.removeIf(u -> u.getCodigo() == codigo)){
            System.out.println("Usuario eliminado con éxito.");
        }else{
            System.out.println("No se encontró un usuario con ese código.");
        }
    }

}
