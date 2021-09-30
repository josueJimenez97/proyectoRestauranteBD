package modelo.repository;

import conexion.ConexionBD;
import modelo.entity.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioRepository extends Repository {

    public ArrayList<Usuario> listarTodos() {
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

    public Usuario encontrarPorId(int idUsuario) {
        Usuario usuario = null;
        try {
            String query = "select * from usuario where id_usuario = ?";
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setInt(1, idUsuario);
            ResultSet result = sentencia.executeQuery();
            if (result.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(result.getInt("id_usuario"));
                usuario.setNombres(result.getString("nombres"));
                usuario.setApellidos(result.getString("apellidos"));
                usuario.setCi(result.getInt("ci"));

                if (result.getString("nro_celular") != null) {
                    usuario.setNroCelular(result.getInt("nro_celular"));
                }
            } else {
                System.out.println("No hay resultados para id: " + idUsuario);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public boolean insertar(Usuario usuario) {
        boolean res = false;
        try {
            String query = "insert into usuario(nombres,apellidos,ci,nro_celular) values (?,?,?,?)";
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setString(1, usuario.getNombres());
            sentencia.setString(2, usuario.getApellidos());
            sentencia.setInt(3, usuario.getCi());
            sentencia.setInt(4, usuario.getNroCelular());

            int result = sentencia.executeUpdate();
            System.out.println("filas afectadas insert " + result);
            res = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean actualizar(Usuario usuario) {
        boolean res = false;
        try {
            String query = "update usuario " +
                    "set nombres= ?, apellidos = ? , ci = ? , nro_celular= ? " +
                    "where id_usuario = ?";
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setString(1, usuario.getNombres());
            sentencia.setString(2, usuario.getApellidos());
            sentencia.setInt(3, usuario.getCi());
            sentencia.setInt(4, usuario.getNroCelular());
            sentencia.setInt(5, usuario.getIdUsuario());

            int result = sentencia.executeUpdate();
            System.out.println("filas afectadas update " + result);
            res = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean eliminarPorId(int idUsuario) {
        boolean res = false;
        try {
            String query =  "delete from usuario " +
                            "where id_usuario = ?";
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setInt(1, idUsuario);
            int result = sentencia.executeUpdate();
            System.out.println("filas afectadas delete " + result);
            res = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
