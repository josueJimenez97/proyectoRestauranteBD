import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
//        PruebaConexionPostgres pruebaPostgres = new PruebaConexionPostgres();
//        Connection connPostgre = pruebaPostgres.connectDatabase();

        PruebaConexionMysql pruebaMysql = new PruebaConexionMysql();
        Connection connMysql = pruebaMysql.conectarMySQL();

//        exampleInsert(connMysql);
//        exampleSelect(connMysql);

//          exampleUpdate(connMysql);
//          exampleSelect(connMysql);

        exampleDelete(connMysql);
        exampleSelect(connMysql);

    }

    public static void exampleSelect(Connection conn) {
        PruebaConexionMysql pruebaMysql = new PruebaConexionMysql();
        Connection connMysql = pruebaMysql.conectarMySQL();

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

    public static void exampleInsert(Connection conn) {
        PruebaConexionMysql pruebaMysql = new PruebaConexionMysql();
        Connection connMysql = pruebaMysql.conectarMySQL();
        try {
            Statement sentencia = conn.createStatement();
            String query = "insert into usuario(nombres,apellidos,ci) values ('juan','ramirez',223311)";
            int result = sentencia.executeUpdate(query);
            System.out.println("filas afectadas insert " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void exampleUpdate(Connection conn) {
        PruebaConexionMysql pruebaMysql = new PruebaConexionMysql();
        Connection connMysql = pruebaMysql.conectarMySQL();
        try {
            Statement sentencia = conn.createStatement();
            String query = "update usuario " +
                    "set nombres= 'grover', nro_celular= 911 " +
                    "where id_usuario = 5";
            int result = sentencia.executeUpdate(query);
            System.out.println("filas afectadas update " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exampleDelete(Connection conn) {
        try {
            Statement sentencia = conn.createStatement();
            String query = "delete from usuario\n" +
                    "where id_usuario = 6";
            int result = sentencia.executeUpdate(query);
            System.out.println("filas afectadas delete " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
