
package Logica;

public class Ingrediente {
    private int id;
    private String nombre;
    private double costoAdicional;

    public Ingrediente(int id, String nombre, double costoAdicional) {
        this.id = id;
        this.nombre = nombre;
        this.costoAdicional = costoAdicional;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }
}
	


