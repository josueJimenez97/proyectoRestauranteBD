package modelo.entity;

public class Usuario {
    private Integer idUsuario;
    private String nombres;
    private String apellidos;
    private Integer ci;
    private Integer nroCelular;

    public Usuario(){

    }

    public Usuario(String nombres, String apellidos, Integer ci, Integer nroCelular) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
        this.nroCelular = nroCelular;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(Integer nroCelular) {
        this.nroCelular = nroCelular;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ci=" + ci +
                ", nroCelular=" + nroCelular +
                '}';
    }
}
