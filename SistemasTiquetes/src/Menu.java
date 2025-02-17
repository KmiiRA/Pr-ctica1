import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al Sistema de Tiquetes");
        System.out.println("Menú principal");
        System.out.println("1- Gestión de Usuarios");
        System.out.println("2- Gestión de Tiquetes");
        System.out.println("3- Salir");
        System.out.println("Ingrese una opción: ");
        int opcion = sc.nextInt();
        Scanner.nextLine();

        switch(opcion) {
            case 1:
                GestionarUsuarios.gestionarUsuarios();
                break;
            case 2:
                GestionarTiquetes.gestionarTiquetes();
                break;
            case 3:
                System.out.println("Saliendo del sistema");
                return;
            default:
                System.out.println("Opcion no valida");
        }
    }
}
