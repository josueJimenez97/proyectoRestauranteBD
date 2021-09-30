package modelo.repository;

import modelo.entity.Compra;
import modelo.entity.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompraRepository extends Repository {

    public ArrayList<Compra> listarTodo() {
        ArrayList<Compra> listaCompras = new ArrayList<>();
        try {
            Statement sentencia = conn.createStatement();
            String query = "SELECT * FROM compra";
            ResultSet result = sentencia.executeQuery(query);

            while (result.next()) {
                Compra compra = new Compra();
                Usuario usuario = new Usuario();

                compra.setIdCompra(result.getInt("idcompra"));
                compra.setTotal(result.getDouble("total"));
                compra.setFechaCompra(result.getDate("fecha_compra"));
                usuario.setIdUsuario(result.getInt("id_usuario"));
                compra.setUsuario(usuario);
                listaCompras.add(compra);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        actualizarUsuarioCompra(listaCompras);
        return listaCompras;
    }

    private void actualizarUsuarioCompra(ArrayList<Compra> lista) {
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        for (Compra compra : lista) {
            Usuario usuarioCompleto = usuarioRepository.encontrarPorId(compra.getUsuario().getIdUsuario());
            compra.setUsuario(usuarioCompleto);
        }
    }

    private void actualizarUsuarioCompra(Compra compra) {
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        Usuario usuarioCompleto = usuarioRepository.encontrarPorId(compra.getUsuario().getIdUsuario());
        compra.setUsuario(usuarioCompleto);
    }
}
