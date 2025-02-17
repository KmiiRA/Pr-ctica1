import java.util.Scanner;

    public class MenuGestionarTiquetes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//Especificar usuario, formulario de ingreso que solicite contraseña
        while(true) {
            System.out.println("Menú Gestion de Usuarios");
            System.out.println("1- Lista de Tiquetes");
            System.out.println("2- Crear Tiquete");
            System.out.println("3- Modificar Tiquete(Cambiar estado del tiquete)");
            System.out.println("4- Eliminar Tiquete");
            System.out.println("5- Regresar al Menú Principal");
            System.out.println("Ingrese una opción:");
            int opcion = sc.nextInt();
            Scanner.nextLine();

            switch(opcion) {
                case 1:
                    System.out.println("Lista de Tiquetes");
                    //Lista de tiquetes y sus datos
                    break;
                case 2:
                    System.out.println("Crear Tiquete");
                    //Formulario para crear el tiquete
                    break;
                case 3:
                    System.out.println("Modificar Tiquete");
                    break;
                case 4:
                    System.out.println("Cambiar estado del tiquete");
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