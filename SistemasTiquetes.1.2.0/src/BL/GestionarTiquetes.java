package BL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GestionarTiquetes{
    private static List<Tiquetes> tiquetes=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);

    public static void listarTiquetes(){
        if(tiquetes.isEmpty()){
            System.out.println("No existen tiquetes registrados.");
        }else{
            for(Tiquetes t:tiquetes){
                t.mostrarInfo();
                t.mostrarNotas();
            }
        }
    }

    public static String listarTiquetesComoTexto(){
        if(tiquetes.isEmpty())return "No existen tiquetes registrados.";
        StringBuilder sb=new StringBuilder();
        for(Tiquetes t:tiquetes){
            sb.append(t.toString()).append("\n");
            sb.append(t.getNotasComoTexto()).append("\n\n");
        }
        return sb.toString();
    }

    public static void crearTiquete(){
        System.out.println("\nSeleccione el tipo de tiquete a crear:");
        System.out.println("1 - Tiquete de Incidente");
        System.out.println("2 - Tiquete de Cambio");
        System.out.println("3 - Tiquete de Servicio");
        System.out.print("Opción: ");
        int tipo=0;
        try{
            tipo=Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Por favor ingrese un número válido.");
            return;
        }

        System.out.print("Código: ");
        int codigo=0;
        try{
            codigo=Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Por favor ingrese un número válido.");
            return;
        }

        System.out.print("Descripción: ");
        String descripcion=sc.nextLine();
        System.out.print("Estado: ");
        String estado=sc.nextLine();
        System.out.print("Usuario Creador (ID): ");
        int usuarioCreador=sc.nextInt();
        System.out.print("Técnico Asignado (ID): ");
        int tecnicoAsignado=sc.nextInt();
        sc.nextLine();
        System.out.print("Notas: ");
        String notas=sc.nextLine();

        switch(tipo){
            case 1:
                System.out.print("Impacto: ");
                String impacto=sc.nextLine();
                crearTiqueteIncidente(codigo,descripcion,estado,usuarioCreador,tecnicoAsignado,impacto,notas);
                break;
            case 2:
                System.out.print("Fecha Requerida (YYYY-MM-DD): ");
                String fechaRequerida=sc.nextLine();
                System.out.print("Fecha de Ejecución (YYYY-MM-DD): ");
                String fechaEjecucion=sc.nextLine();
                System.out.print("Pasos Requeridos: ");
                String pasosRequeridos=sc.nextLine();
                crearTiqueteCambio(codigo,descripcion,estado,usuarioCreador,tecnicoAsignado,fechaRequerida,fechaEjecucion,pasosRequeridos,notas);
                break;
            case 3:
                System.out.print("Justificación del servicio: ");
                String justificacion=sc.nextLine();
                System.out.print("Nivel de prioridad: ");
                int prioridad=Integer.parseInt(sc.nextLine());
                crearTiqueteServicio(codigo,descripcion,estado,usuarioCreador,tecnicoAsignado,justificacion,prioridad);
                break;
            default:
                System.out.println("Opción no válida. No se creó ningún tiquete.");
                return;
        }

        System.out.println("Tiquete creado con éxito.");
    }

    public static void modificarTiquete(){
        int codigo=0;
        try{
            System.out.print("Ingrese el código del tiquete a modificar: ");
            codigo=Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Por favor ingrese un número válido.");
            return;
        }
        for(Tiquetes t:tiquetes){
            if(t.codigo==codigo){
                System.out.print("Ingrese el nuevo estado: ");
                t.estado=sc.nextLine();
                System.out.println("Estado del tiquete actualizado.");
                return;
            }
        }
        System.out.println("No se encontró ningun tiquete con ese código.");
    }

    public static void eliminarTiquete(){
        int codigo=0;
        try{
            System.out.print("Ingrese el código del tiquete a eliminar: ");
            codigo=Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Por favor ingrese un número válido.");
            return;
        }
        Tiquetes encontrado=null;
        for(Tiquetes t:tiquetes){
            if(t.codigo==codigo){
                encontrado=t;
                break;
            }
        }
        if(encontrado!=null){
            tiquetes.remove(encontrado);
            System.out.println("Tiquete eliminado con éxito.");
        }else{
            System.out.println("No se encontró un tiquete con ese código.");
        }
    }

    public static void cambiarEstadoTiquete(){
        System.out.print("Ingrese el código del tiquete: ");
        int codigo=0;
        try{
            codigo=Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Código inválido");
            return;
        }

        for(Tiquetes t:tiquetes){
            if(t.codigo==codigo){
                System.out.println("Estado actual: "+t.estado);
                System.out.print("Ingrese nuevo estado (Asignado, En Progreso, Resuelto, Cancelado): ");
                String nuevoEstado=sc.nextLine();
                t.estado=nuevoEstado;
                System.out.println("Estado actualizado");
                return;
            }
        }

        System.out.println("No se encontró un tiquete con ese código");
    }

    public static void agregarNota(){
        System.out.print("Ingrese el código del tiquete: ");
        int codigo=0;
        try{
            codigo=Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Código no válido");
            return;
        }

        for(Tiquetes t:tiquetes){
            if(t.codigo==codigo){
                System.out.print("Escriba la nota a agregar: ");
                String nota=sc.nextLine();
                t.agregarNota(nota);
                System.out.println("Nota agregada");
                return;
            }
        }

        System.out.println("No se encontró un tiquete con ese código");
    }

    public static void asignarTecnico(){
        System.out.print("Ingrese el código del tiquete: ");
        int codigo=0;
        try{
            codigo=Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Código no válido");
            return;
        }

        for(Tiquetes t:tiquetes){
            if(t.codigo==codigo){
                System.out.print("ID del técnico a asignar: ");
                int tecnico=0;
                try{
                    tecnico=Integer.parseInt(sc.nextLine());
                }catch(NumberFormatException e){
                    System.out.println("ID no válido");
                    return;
                }
                t.tecnicoAsignado=tecnico;
                System.out.println("Técnico asignado correctamente");
                return;
            }
        }

        System.out.println("No se encontró un tiquete con ese código");
    }

    public static void listarTiquetesPorEstado(){
        System.out.print("Ingrese el estado: ");
        String estado=sc.nextLine();
        boolean encontrado=false;
        for(Tiquetes t:tiquetes){
            if(t.estado.equalsIgnoreCase(estado)){
                t.mostrarInfo();
                t.mostrarNotas();
                encontrado=true;
            }
        }
        if(!encontrado){
            System.out.println("No hay tiquetes con ese estado");
        }
    }

    public static void listarTiquetesPorCreador(){
        System.out.print("Ingrese ID del creador: ");
        int id=0;
        try{
            id=Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("ID no válido");
            return;
        }
        boolean encontrado=false;
        for(Tiquetes t:tiquetes){
            if(t.usuarioCreador==id){
                t.mostrarInfo();
                t.mostrarNotas();
                encontrado=true;
            }
        }
        if(!encontrado){
            System.out.println("No hay tiquetes de ese creador");
        }
    }

    public static void listarTiquetesPorTecnico(){
        System.out.print("Ingrese ID del técnico: ");
        int id=0;
        try{
            id=Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("ID no válido");
            return;
        }
        boolean encontrado=false;
        for(Tiquetes t:tiquetes){
            if(t.tecnicoAsignado==id){
                t.mostrarInfo();
                t.mostrarNotas();
                encontrado=true;
            }
        }
        if(!encontrado){
            System.out.println("No hay tiquetes asignados a ese técnico");
        }
    }

    public static void mostrarEstadisticas(){
        int total=tiquetes.size();
        int incidentes=0;
        int cambios=0;
        int servicios=0;
        Map<String,Integer> estados=new HashMap<>();

        for(Tiquetes t:tiquetes){
            if(t instanceof TiqueteIncidente){
                incidentes++;
            }else if(t instanceof TiqueteCambio){
                cambios++;
            }else if(t instanceof TiqueteServicio){
                servicios++;
            }

            estados.put(t.estado,estados.getOrDefault(t.estado,0)+1);
        }

        System.out.println("Total de tiquetes: "+total);
        System.out.println("Incidentes: "+incidentes);
        System.out.println("Cambios: "+cambios);
        System.out.println("Servicios: "+servicios);
        System.out.println("Por estado:");
        for(String e:estados.keySet()){
            System.out.println("- "+e+": "+estados.get(e));
        }
    }

    //Crear Tiquete de Incidente
    public static void crearTiqueteIncidente(int codigo,String descripcion,String estado,int creador,int tecnico,String impacto,String nota){
        TiqueteIncidente t=new TiqueteIncidente(codigo,descripcion,estado,creador,tecnico,impacto);
        t.agregarNota(nota);
        tiquetes.add(t);
    }

    //Crear Tiquete de Cambio
    public static void crearTiqueteCambio(int codigo,String descripcion,String estado,int creador,int tecnico,String fechaReq,String fechaEjec,String pasos,String nota){
        TiqueteCambio t=new TiqueteCambio(codigo,descripcion,estado,creador,tecnico,fechaReq,fechaEjec,pasos);
        t.agregarNota(nota);
        tiquetes.add(t);
    }

    //Crear Tiquete de Servicio
    public static void crearTiqueteServicio(int codigo,String descripcion,String estado,int creador,int tecnico,String justificacion,int prioridad,String nota){
        TiqueteServicio t=new TiqueteServicio(codigo,descripcion,estado,creador,tecnico,justificacion,prioridad);
        t.agregarNota(nota);
        tiquetes.add(t);
    }

    //Eliminar tiquete por código
    public static boolean eliminarTiquetePorCodigo(int codigo){
        for(Tiquetes t:tiquetes){
            if(t.codigo==codigo){
                tiquetes.remove(t);
                return true;
            }
        }
        return false;
    }

    //Modificar estado de tiquete
    public static boolean modificarEstadoTiquete(int codigo,String nuevoEstado){
        for(Tiquetes t:tiquetes){
            if(t.codigo==codigo){
                t.estado=nuevoEstado;
                return true;
            }
        }
        return false;
    }

}
