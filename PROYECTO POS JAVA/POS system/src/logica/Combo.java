package logica;

import java.util.ArrayList;
import java.util.List;

public class Combo {
    private List<Producto> productos;
    private double precioTotal;

    public Combo(List<Producto> productos) {
        this.productos = new ArrayList<>(productos);
        this.precioTotal = calcularPrecioTotal();
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public void setProductos(List<Producto> productos) {
        this.productos = new ArrayList<>(productos);
        this.precioTotal = calcularPrecioTotal();
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        this.precioTotal = calcularPrecioTotal();
    }

    public void eliminarProducto(Producto producto) {
        this.productos.remove(producto);
        this.precioTotal = calcularPrecioTotal();
    }

    private double calcularPrecioTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void ajustarProducto(int index, List<String> modificaciones) {
        Producto producto = productos.get(index);
        producto.setIngredientes(modificaciones);
    }
}