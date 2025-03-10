package UI;

import BL.GestionarUsuarios;
import java.util.Scanner;

public class MenuUsuarios{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n Menú Gestión de Usuarios");
            System.out.println("1- Lista de Usuarios");
            System.out.println("2- Registrar Usuario");
            System.out.println("3- Modificar Usuario");
            System.out.println("4- Eliminar Usuario");
            System.out.println("5- Regresar al Menú Principal");
            System.out.print("Ingrese una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    GestionarUsuarios.listarUsuarios();
                    break;
                case 2:
                    GestionarUsuarios.registrarUsuario();
                    break;
                case 3:
                    GestionarUsuarios.modificarUsuario();
                    break;
                case 4:
                    GestionarUsuarios.eliminarUsuario();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
