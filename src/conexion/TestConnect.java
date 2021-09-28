package conexion;

import java.sql.Connection;

public class TestConnect {
    public static void main(String[] args) {
        configPostgresDB();
//        configMysqlDB();
        Connection conn = ConexionBD.getInstance().getConnection();

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
