package model;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private ArrayList<String> modulos;
    private ArrayList<Double> notas;
    private String contraseña;

    public Alumno(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.modulos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarNota(String modulo, double nota) {
        modulos.add(modulo);
        notas.add(nota);
    }

    public ArrayList<String> getModulos() {
        return modulos;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }
}
