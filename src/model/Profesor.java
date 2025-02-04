package model;

import java.util.List;

public class Profesor {
    private String nombre;
    private List<String> modulos;

    public Profesor(String nombre, List<String> modulos) {
        this.nombre = nombre;
        this.modulos = modulos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getModulos() {
        return modulos;
    }
}

