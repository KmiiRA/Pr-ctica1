package DAO;

import BL.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TiqueteDAO {

    public static boolean insertar(Tiquetes t){
        String sql="INSERT INTO tiquetes (Codigo, Descripcion, Estado, UsuarioCreador, TecnicoAsignado, Tipo) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection conn=ConexionBD.conectar();
            PreparedStatement stmt=conn.prepareStatement(sql)){

            stmt.setInt(1,t.codigo);
            stmt.setString(2,t.descripcion);
            stmt.setString(3,t.estado);
            stmt.setInt(4,t.usuarioCreador);
            stmt.setInt(5,t.tecnicoAsignado);
            stmt.setString(6,t.getClass().getSimpleName()); // TiqueteIncidente, TiqueteCambio, etc.

            stmt.executeUpdate();
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static List<Tiquetes> listar(){
        List<Tiquetes> lista=new ArrayList<>();
        String sql="SELECT * FROM tiquetes";

        try(Connection conn=ConexionBD.conectar();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql)){

            while(rs.next()){
                int codigo=rs.getInt("Codigo");
                String descripcion=rs.getString("Descripcion");
                String estado=rs.getString("Estado");
                int usuario=rs.getInt("UsuarioCreador");
                int tecnico=rs.getInt("TecnicoAsignado");

                Tiquetes t=new Tiquetes(codigo,descripcion,estado,usuario,tecnico);
                t.agregarNota("Tiquete recuperado desde base de datos"); // opcional
                lista.add(t);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return lista;
    }
}


