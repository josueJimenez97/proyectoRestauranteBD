import conexion.ConexionBD;
import console.UsuarioConsola;
import modelo.entity.Compra;
import modelo.repository.CompraRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        configPostgresDB();
        configMysqlDB();
//        initMenu();
        CompraRepository compraRepository = new CompraRepository();
        ArrayList<Compra> listaCompras = compraRepository.listarTodo();
        for(Compra compra: listaCompras){
            System.out.println(compra);
        }
    }

    private static void initMenu(){
        Scanner sc = new Scanner(System.in);
        UsuarioConsola usuarioConsola = new UsuarioConsola();

        System.out.println("1 -> insert usuario");
        System.out.println("2 -> update usuario");
        System.out.println("3 -> delete usuario");
        System.out.println("4 -> listar usuario");
        System.out.println("0 -> salir");

        int opcion = sc.nextInt();
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    usuarioConsola.insertarUsuario();
                    break;
                case 2:
                    usuarioConsola.updateUsuario();
                    break;
                case 3:
                    usuarioConsola.deleteUsuario();
                    break;
                case 4:
                    usuarioConsola.mostrarUsuarios();
                    break;
                default:
                    System.out.println("No existe esa opcion!");
            }
            System.out.println();
            System.out.println("1 -> insert usuario");
            System.out.println("2 -> update usuario");
            System.out.println("3 -> delete usuario");
            System.out.println("4 -> listar usuario");
            System.out.println("0 -> salir");

            opcion = sc.nextInt();
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
