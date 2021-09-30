package modelo.repository;

import conexion.ConexionBD;

import java.sql.Connection;

public class Repository {
    protected Connection conn;

    public Repository() {
        conn = ConexionBD.getInstance().getConnection();
    }
}
