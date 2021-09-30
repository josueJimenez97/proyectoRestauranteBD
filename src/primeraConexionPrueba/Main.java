package primeraConexionPrueba;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) {
//        primeraConexionPrueba.PruebaConexionPostgres pruebaPostgres = new primeraConexionPrueba.PruebaConexionPostgres();
//        Connection connPostgre = pruebaPostgres.connectDatabase();

        PruebaConexionMysql pruebaMysql = new PruebaConexionMysql();
        Connection connMysql = pruebaMysql.conectarMySQL();

        sc = new Scanner(System.in);
        System.out.println("1 -> insert usuario");
        System.out.println("2 -> update usuario");
        System.out.println("3 -> delete usuario");
        System.out.println("4 -> select usuario");
        System.out.println("0 -> salir");

        int opcion = sc.nextInt();
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    insertUsuario(connMysql);
                    break;
                case 2:
                    updateUsuario(connMysql);
                    break;
                case 3:
                    deleteUsuario(connMysql);
                    break;
                case 4:
                    exampleSelect(connMysql);
                    break;
                default:
                    System.out.println("No existe esa opcion!");
            }
            System.out.println();
            System.out.println("1 -> insert usuario");
            System.out.println("2 -> update usuario");
            System.out.println("3 -> delete usuario");
            System.out.println("0 -> salir");

            opcion = sc.nextInt();
        }

    }

    public static void insertUsuario(Connection conn) {
        System.out.println("nombre del usuario: ");
        sc.nextLine();
        String nombres = sc.nextLine();

        System.out.println("apellidos del usuario: ");
        String apellidos = sc.nextLine();

        System.out.println("ci del usuario: ");
        int ci = sc.nextInt();
        exampleInsert(conn, nombres, apellidos, ci);
        exampleSelect(conn);

    }

    public static void updateUsuario(Connection conn) {
        System.out.println("actualizar usuario");

        System.out.println("nombres:");
        sc.nextLine();
        String nombres = sc.nextLine();

        System.out.println("nro celular:");
        int nroCelular = sc.nextInt();

        System.out.println("id del usuario");
        int idUsuario = sc.nextInt();
        exampleUpdate(conn, nombres, nroCelular, idUsuario);
        exampleSelect(conn);
    }

    public static void deleteUsuario(Connection conn) {
        System.out.println("eliminar usuariooo");
        System.out.println("id usuario: ");
        int idUsuario= sc.nextInt();

        exampleDelete(conn,idUsuario);
        exampleSelect(conn);
    }


    public static void exampleSelect(Connection conn) {
        System.out.println();
        System.out.println("Datos de la tabla usuario");
        try {
            Statement sentencia = conn.createStatement();
            String query = "SELECT * FROM usuario";
            ResultSet result = sentencia.executeQuery(query);

            while (result.next()) {
                // Leer registro
                System.out.print(result.getString(1) + " ");
                System.out.print(result.getString("nombres") + " ");
                System.out.print(result.getString("apellidos") + " ");
                System.out.print(result.getInt("ci") + " ");
                System.out.println(result.getString("nro_celular") + " ");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void exampleInsert(Connection conn, String nombres, String apellidos, int ci) {
        try {
            String query = "insert into usuario(nombres,apellidos,ci) values (?,?,?)";
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setString(1, nombres);
            sentencia.setString(2, apellidos);
            sentencia.setInt(3, ci);

            int result = sentencia.executeUpdate();
            System.out.println("filas afectadas insert " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void exampleUpdate(Connection conn, String nombres, int nroCelular, int idUsuario) {
        try {
            String query = "update usuario " +
                    "set nombres= ?, nro_celular= ? " +
                    "where id_usuario = ?";
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setString(1, nombres);
            sentencia.setInt(2, nroCelular);
            sentencia.setInt(3, idUsuario);
            int result = sentencia.executeUpdate();
            System.out.println("filas afectadas update " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exampleDelete(Connection conn, int idUsuario) {
        try {
            String query = "delete from usuario\n" +
                    "where id_usuario = ?";
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setInt(1,idUsuario);
            int result = sentencia.executeUpdate();
            System.out.println("filas afectadas delete " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
