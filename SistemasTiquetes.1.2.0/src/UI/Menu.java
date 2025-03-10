package UI;

import java.util.Scanner;

public class Menu{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n Bienvenido al Sistema de bl.Tiquetes");
            System.out.println("Menú Principal");
            System.out.println("1-Gestión de bl.Usuarios");
            System.out.println("2- Gestión de bl.Tiquetes");
            System.out.println("3- Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    MenuUsuarios.main(null);
                    break;
                case 2:
                    MenuTiquetes.main(null);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
