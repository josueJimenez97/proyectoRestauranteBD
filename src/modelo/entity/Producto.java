package modelo.entity;

public class Producto {
    private Integer idProducto;
    private String nombreProducto;
    private Double precio;
    private TipoProducto tipoProducto;
    private TamanioProducto tamanioProducto;

    public Producto() {

    }

    public Producto(Integer idProducto, String nombreProducto, Double precio,
                    TipoProducto tipoProducto, TamanioProducto tamanioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.tamanioProducto = tamanioProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public TamanioProducto getTamanioProducto() {
        return tamanioProducto;
    }

    public void setTamanioProducto(TamanioProducto tamanioProducto) {
        this.tamanioProducto = tamanioProducto;
    }
}
