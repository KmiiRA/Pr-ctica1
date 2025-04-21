package BL;

import DAO.TiqueteDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionarTiquetes {
    private static List<Tiquetes> tiquetes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static List<Tiquetes> getTiquetes() {
        return tiquetes;
    }

    public static void listarTiquetes() {
        tiquetes = TiqueteDAO.listar();
        if (tiquetes.isEmpty()) {
            System.out.println("No existen tiquetes registrados.");
        } else {
            for (Tiquetes t : tiquetes) {
                t.mostrarInfo();
                t.mostrarNotas();
            }
        }
    }

    public static void crearTiquete() {
        System.out.println("Seleccione el tipo de tiquete:");
        System.out.println("1 - Incidente");
        System.out.println("2 - Cambio");
        System.out.println("3 - Servicio");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Código: ");
        int codigo = Integer.parseInt(sc.nextLine());
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        System.out.print("Usuario creador (ID): ");
        int creador = Integer.parseInt(sc.nextLine());
        System.out.print("Técnico asignado (ID): ");
        int tecnico = Integer.parseInt(sc.nextLine());
        System.out.print("Nota: ");
        String nota = sc.nextLine();

        Tiquetes t = null;
        switch (tipo) {
            case 1:
                System.out.print("Impacto: ");
                String impacto = sc.nextLine();
                t = new TiqueteIncidente(codigo, descripcion, estado, creador, tecnico, impacto);
                break;
            case 2:
                System.out.print("Fecha requerida: ");
                String fechaReq = sc.nextLine();
                System.out.print("Fecha ejecución: ");
                String fechaEjec = sc.nextLine();
                System.out.print("Pasos: ");
                String pasos = sc.nextLine();
                t = new TiqueteCambio(codigo, descripcion, estado, creador, tecnico, fechaReq, fechaEjec, pasos);
                break;
            case 3:
                System.out.print("Justificación: ");
                String justificacion = sc.nextLine();
                System.out.print("Prioridad: ");
                int prioridad = Integer.parseInt(sc.nextLine());
                t = new TiqueteServicio(codigo, descripcion, estado, creador, tecnico, justificacion, prioridad);
                break;
            default:
                System.out.println("Opción inválida");
                return;
        }

        t.agregarNota(nota);
        if (TiqueteDAO.insertar(t)) {
            tiquetes.add(t);
            System.out.println("Tiquete creado con éxito.");
        } else {
            System.out.println("Error al guardar el tiquete.");
        }
    }

    public static String listarTiquetesComoTexto() {
        tiquetes = TiqueteDAO.listar();
        if (tiquetes.isEmpty()) return "No existen tiquetes registrados.";
        StringBuilder sb = new StringBuilder();
        for (Tiquetes t : tiquetes) {
            sb.append(t.toString()).append("\n").append(t.getNotasComoTexto()).append("\n");
        }
        return sb.toString();
    }

    public static boolean eliminarTiquetePorCodigo(int codigo) {
        for (Tiquetes t : tiquetes) {
            if (t.codigo == codigo) {
                tiquetes.remove(t);
                return true;
            }
        }
        return false;
    }

    public static boolean modificarEstadoTiquete(int codigo, String nuevoEstado) {
        for (Tiquetes t : tiquetes) {
            if (t.codigo == codigo) {
                t.estado = nuevoEstado;
                return true;
            }
        }
        return false;
    }

    public static void crearTiqueteCambio(int codigo,String descripcion,String estado,int usuario,int tecnico,String fechaReq,String fechaEjec,String pasos,String notas){
        Tiquetes t=new TiqueteCambio(codigo,descripcion,estado,usuario,tecnico,fechaReq,fechaEjec,pasos);
        t.agregarNota(notas);
        if(TiqueteDAO.insertar(t)){
            tiquetes.add(t);
            System.out.println("Tiquete de cambio creado correctamente.");
        }else{
            System.out.println("Error al guardar el tiquete de cambio.");
        }
    }

    public static void crearTiqueteIncidente(int codigo,String descripcion,String estado,int usuario,int tecnico,String impacto,String notas){
        Tiquetes t=new TiqueteIncidente(codigo,descripcion,estado,usuario,tecnico,impacto);
        t.agregarNota(notas);
        if(TiqueteDAO.insertar(t)){
            tiquetes.add(t);
            System.out.println("Tiquete de incidente creado correctamente.");
        }else{
            System.out.println("Error al guardar el tiquete de incidente.");
        }
    }

    public static void crearTiqueteServicio(int codigo,String descripcion,String estado,int usuario,int tecnico,String justificacion,int prioridad,String notas){
        Tiquetes t=new TiqueteServicio(codigo,descripcion,estado,usuario,tecnico,justificacion,prioridad);
        t.agregarNota(notas);
        if(TiqueteDAO.insertar(t)){
            tiquetes.add(t);
            System.out.println("Tiquete de servicio creado correctamente.");
        }else{
            System.out.println("Error al guardar el tiquete de servicio.");
        }
    }


    public static int getCantidadTotal() {
        return tiquetes.size();
    }

    public static int getCantidadPorTipo(String tipo) {
        int contador = 0;
        for (Tiquetes t : tiquetes) {
            if (t.getClass().getSimpleName().equals(tipo)) {
                contador++;
            }
        }
        return contador;
    }

    public static String[][] getCantidadPorEstado() {
        int abiertos = 0, enProceso = 0, cerrados = 0;
        for (Tiquetes t : tiquetes) {
            String estado = t.getEstado();
            if (estado.equals("Abierto")) {
                abiertos++;
            } else if (estado.equals("En Proceso")) {
                enProceso++;
            } else if (estado.equals("Cerrado")) {
                cerrados++;
            }
        }
        String[][] resultado = {
                {"Abierto", String.valueOf(abiertos)},
                {"En Proceso", String.valueOf(enProceso)},
                {"Cerrado", String.valueOf(cerrados)}
        };
        return resultado;
    }

    public static String[][] getCantidadPorTecnico() {
        GestionarUsuarios.getUsuarios();

        ArrayList<Integer> codigos = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        for (Tiquetes t : tiquetes) {
            int cod = t.getUsuarioTecnico().getCodigo();
            int index = codigos.indexOf(cod);
            if (index != -1) {
                cantidades.set(index, cantidades.get(index) + 1);
            } else {
                codigos.add(cod);
                cantidades.add(1);
            }
        }

        String[][] resultado = new String[codigos.size()][2];
        for (int i = 0; i < codigos.size(); i++) {
            resultado[i][0] = String.valueOf(codigos.get(i));
            resultado[i][1] = String.valueOf(cantidades.get(i));
        }

        return resultado;
    }



    public static String[][] getCantidadPorCreador() {
        GestionarUsuarios.getUsuarios();

        ArrayList<Integer> codigos = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        for (Tiquetes t : tiquetes) {
            int cod = t.getUsuarioCreador().getCodigo();
            int index = codigos.indexOf(cod);
            if (index != -1) {
                cantidades.set(index, cantidades.get(index) + 1);
            } else {
                codigos.add(cod);
                cantidades.add(1);
            }
        }

        String[][] resultado = new String[codigos.size()][2];
        for (int i = 0; i < codigos.size(); i++) {
            resultado[i][0] = String.valueOf(codigos.get(i));
            resultado[i][1] = String.valueOf(cantidades.get(i));
        }

        return resultado;
    }


}
