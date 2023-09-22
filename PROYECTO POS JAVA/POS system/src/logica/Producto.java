package logica;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String nombre;
    private double precio;
    private List<String> ingredientes;

    public Producto(String nombre, double precio, List<String> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = new ArrayList<>(ingredientes);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<String> getIngredientes() {
        return new ArrayList<>(ingredientes);
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = new ArrayList<>(ingredientes);
    }
}