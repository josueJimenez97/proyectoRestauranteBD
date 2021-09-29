package conexion;

import modelo.entity.Usuario;
import modelo.repository.UsuarioRepository;

import java.sql.Connection;
import java.util.ArrayList;

public class TestConnect {
    public static void main(String[] args) {
//        configPostgresDB();
        configMysqlDB();
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        ArrayList<Usuario> listaUsuarios = usuarioRepository.obtenerUsuarios();
        for(Usuario u : listaUsuarios){
            System.out.println(u.toString());
        }
    }

    private static void configPostgresDB(){
        ConexionBD.driver = "org.postgresql.Driver";
        ConexionBD.url = "jdbc:postgresql://localhost:5432/";
        ConexionBD.database = "restaurante_bd";
        ConexionBD.user= "postgres";
        ConexionBD.password= "postgres";
    }

    private static void configMysqlDB(){
        ConexionBD.driver = "com.mysql.cj.jdbc.Driver";
        ConexionBD.url = "jdbc:mysql://localhost:3306/";
        ConexionBD.database = "restaurant_bd";
        ConexionBD.user= "root";
        ConexionBD.password= "root";
    }


}
