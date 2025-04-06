package BL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionarTiquetes{
    private static List<Tiquetes> tiquetes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void listarTiquetes(){
        if(tiquetes.isEmpty()){
            System.out.println("No existen tiquetes registrados.");
        }else{
            for (Tiquetes t : tiquetes){
                t.mostrarInfo();
            }
        }
    }

    public static void crearTiquete(){
        System.out.println("\nSeleccione el tipo de tiquete a crear:");
        System.out.println("1 - Tiquete de Incidente");
        System.out.println("2 - Tiquete de Cambio");
        System.out.println("3 - Tiquete de Servicio");
        System.out.print("Opción: ");
        int tipo = 0;
        try{
            tipo = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Por favor ingrese un número válido.");
            return;
        }
        System.out.print("Código: ");
        int codigo = 0;
        try{
            codigo = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Por favor ingrese un número válido.");
            return;
        }
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        System.out.print("Usuario Creador (ID): ");
        int usuarioCreador = sc.nextInt();
        System.out.print("Técnico Asignado (ID): ");
        int tecnicoAsignado = sc.nextInt();
        sc.nextLine();
        System.out.print("Notas: ");
        String notas = sc.nextLine();

        switch (tipo){
            case 1://Tiquete de Incidente
                System.out.print("");
                String impacto = sc.nextLine();
                tiquetes.add(new TiqueteIncidente(codigo, descripcion, estado, usuarioCreador, tecnicoAsignado, impacto, notas));
                break;
            case 2://Tiquete de Cambio
                System.out.print("Fecha Requerida (Formato YYYY-MM-DD): ");
                String fechaRequerida = sc.nextLine();
                System.out.print("Fecha de Ejecución (Formato YYYY-MM-DD): ");
                String fechaEjecucion = sc.nextLine();
                System.out.print("Pasos Requeridos: ");
                String pasosRequeridos = sc.nextLine();
                tiquetes.add(new TiqueteCambio(codigo, descripcion, estado, usuarioCreador, tecnicoAsignado, null, null, pasosRequeridos, notas));
                break;
            case 3://Tiquete de Servicio
                System.out.print("Nivel de prioridad: ");
                String prioridad = sc.nextLine();
                tiquetes.add(new TiqueteServicio(codigo, descripcion, estado, usuarioCreador, tecnicoAsignado, prioridad, notas));
                break;
            default:
                System.out.println("Opción no válida. No se creó ningún tiquete.");
                return;
        }

        System.out.println("Tiquete creado con éxito.");
    }

    public static void modificarTiquete(){
        int codigo = 0;
        try{
            System.out.print("Ingrese el código del tiquete a modificar: ");
            codigo = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Por favor ingrese un número válido.");
            return;
        }
        for(Tiquetes t : tiquetes){
            if(t.codigo == codigo){
                System.out.print("Ingrese el nuevo estado: ");
                t.estado = sc.nextLine();
                System.out.println("Estado del tiquete actualizado.");
                return;
            }
        }
        System.out.println("No se encontró ningun tiquete con ese código.");
    }

    public static void eliminarTiquete(){
        int codigo = 0;
        try{
            System.out.print("Ingrese el código del tiquete a eliminar: ");
            codigo = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
            return;
        }
        Tiquetes encontrado = null;
        for(Tiquetes t : tiquetes){
            if (t.codigo == codigo){
                encontrado = t;
                break;
            }
        }
        if (encontrado != null){
            tiquetes.remove(encontrado);
            System.out.println("Tiquete eliminado con éxito.");
        }else{
            System.out.println("No se encontró un tiquete con ese código.");
        }
    }
}
