import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Basic connection to PostgreSQL database.
 * Conexión básica a la base de datos PostgreSQL.
 */
public class PruebaConexionPostgres {

    /**
     * We establish the connection with the database <b>customerdb</b>.
     * Establecemos la conexión con la base de datos <b>customerdb</b>.
     */
    public Connection connectDatabase() {

        Connection connection = null;
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            // Database connect
            // Conectamos con la base de datos
            String host = "localhost:5432";
            String db = "restaurante_bd";
            String user= "postgres";
            String password = "postgres";
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+"/"+db, user, password);

            boolean valid = connection.isValid(50000);
            if(valid){
                System.out.println("Conectado a la base de datos " + db +" desde postgres");
            }else{
                System.out.println("Timeout en postgres");
            }

        } catch (java.sql.SQLException e) {
            System.out.println("Error: " + e);
        }
        return connection;
    }
}


