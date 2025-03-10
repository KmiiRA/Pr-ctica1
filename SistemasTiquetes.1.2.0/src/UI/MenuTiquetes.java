package UI;

import BL.GestionarTiquetes;
import java.util.Scanner;

public class MenuTiquetes{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\nMenú Gestión de Tiquetes");
            System.out.println("1- Lista de Tiquetes");
            System.out.println("2- Crear Tiquete");
            System.out.println("3- Modificar Tiquete");
            System.out.println("4- Eliminar Tiquete");
            System.out.println("5- Regresar al Menú Principal");
            System.out.print("Ingrese una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    GestionarTiquetes.listarTiquetes();
                    break;
                case 2:
                    GestionarTiquetes.crearTiquete();
                    break;
                case 3:
                    GestionarTiquetes.modificarTiquete();
                    break;
                case 4:
                    GestionarTiquetes.eliminarTiquete();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
