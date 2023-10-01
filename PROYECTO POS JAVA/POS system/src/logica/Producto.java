public class Producto {
    private int id;
    private int tipo;
    private String nombre;
    private double precioCompra;
    private double precioVenta;
    private int cantidad;

    public Producto(int id, int tipo, String nombre, double precioCompra, double precioVenta, int cantidad) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
    }

    // getters y setters
    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }
}
