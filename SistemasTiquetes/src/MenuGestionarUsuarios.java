import java.util.Scanner;

public class MenuGestionarUsuarios{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Menú Gestion de Usuarios");
            System.out.println("1- Lista de Usuarios");
            System.out.println("2- Registrar Usuario");
            System.out.println("3- Modificar Usuario");
            System.out.println("4- Eliminar Usuario");
            System.out.println("5- Regresar al Menú Principal");
            System.out.println("Ingrese una opción:");
            int opcion = sc.nextInt();
            Scanner.nextLine();

            switch(opcion) {
                case 1:
                    System.out.println("Lista de Usuarios");
                    //Lista de usuarios registrados y sus datos
                    break;
                case 2:
                    System.out.println("Registrar Usuario");
                    //Formulario para registar usuario segun sus función
                    break;
                case 3:
                    System.out.println("Modificar Usuario");
                    //Se busca el usuario a modificar y se realiza la modificación
                    break;
                case 4:
                    System.out.println("Eliminar Usuario");
                    //Se busca el usuario a eliminar
                    break;
                case 5:
                    System.out.println("Regresando al menú principal");
                    return;
                default:
                    System.out.println("Opcion no valida");
            }


        }
    }
}
