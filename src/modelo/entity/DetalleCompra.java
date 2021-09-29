package modelo.entity;

public class DetalleCompra {
    private Integer cantidad;
    private Double subTotal;
    private Producto producto;
    private Compra compra;

    public DetalleCompra(){

    }

    public DetalleCompra(Integer cantidad, Double subTotal, Producto producto, Compra compra) {
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.producto = producto;
        this.compra = compra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}
