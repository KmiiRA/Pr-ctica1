package DAO;

import BL.Usuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public static boolean insertar(Usuarios usuario) {
        String sql = "INSERT INTO usuarios (Codigo, Nombre, PrimerApellido, SegundoApellido, Correo, Telefono, Password, Tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuario.getCodigo());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getPrimerApellido());
            stmt.setString(4, usuario.getSegundoApellido());
            stmt.setString(5, usuario.getCorreoElectronico());
            stmt.setString(6, usuario.getTelefono());
            stmt.setString(7, usuario.getPassword());
            stmt.setString(8, usuario.getTipo());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Usuarios> listar() {
        List<Usuarios> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuarios u = new Usuarios(
                        rs.getInt("Codigo"),
                        rs.getString("Nombre"),
                        rs.getString("PrimerApellido"),
                        rs.getString("SegundoApellido"),
                        rs.getString("Correo"),
                        rs.getString("Telefono"),
                        rs.getString("Password"),
                        rs.getString("Tipo")
                );
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
