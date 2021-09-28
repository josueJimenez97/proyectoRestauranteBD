package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    public static String driver = "";
    public static String url = "";
    public static String database = "";
    public static String user = "";
    public static String password = "";

    private static ConexionBD instance;
    private Connection connection;

    private ConexionBD() {
        try {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el Driver: " + ex);
            }
            connection = DriverManager.getConnection(url + database + "?serverTimezone=UTC", user, password);
            System.out.println("Conectado a la base de datos " + database);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConexionBD getInstance() {
        if (instance == null) {
            instance = new ConexionBD();
        }
        return instance;
    }
}
