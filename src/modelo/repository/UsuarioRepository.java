package modelo.repository;

import conexion.ConexionBD;
import modelo.entity.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioRepository {
    private Connection conn;

    public UsuarioRepository() {
        conn = ConexionBD.getInstance().getConnection();
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            Statement sentencia = conn.createStatement();
            String query = "SELECT * FROM usuario";
            ResultSet result = sentencia.executeQuery(query);

            while (result.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(result.getInt("id_usuario"));
                usuario.setNombres(result.getString("nombres"));
                usuario.setApellidos(result.getString("apellidos"));
                usuario.setCi(result.getInt("ci"));
                if (result.getString("nro_celular") != null) {
                    usuario.setNroCelular(result.getInt("nro_celular"));
                }
                lista.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
