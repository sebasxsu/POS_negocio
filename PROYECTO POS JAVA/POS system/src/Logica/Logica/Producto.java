package Logica;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private List<Ingrediente> ingredientes;

    
    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = new ArrayList<>();
    }

    public Producto(int id, String nombre, double precio, List<Ingrediente> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        if (ingredientes != null) {
            this.ingredientes = ingredientes;
        } else {
            this.ingredientes = new ArrayList<>();
        }
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
        this.precio += ingrediente.getCostoAdicional();
    }

    public void quitarIngrediente(Ingrediente ingrediente) {
        if (this.ingredientes.remove(ingrediente)) {
            // no se modifica el precio
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
}

