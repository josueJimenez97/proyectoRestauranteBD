package modelo.entity;

public class TamanioProducto {
    private Integer idTamanioProducto;
    private String descripcion;
    private TipoProducto tipoProducto;

    public TamanioProducto() {

    }

    public TamanioProducto(Integer idTamanioProducto, String descripcion, TipoProducto tipoProducto) {
        this.idTamanioProducto = idTamanioProducto;
        this.descripcion = descripcion;
        this.tipoProducto = tipoProducto;
    }

    public Integer getIdTamanioProducto() {
        return idTamanioProducto;
    }

    public void setIdTamanioProducto(Integer idTamanioProducto) {
        this.idTamanioProducto = idTamanioProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
