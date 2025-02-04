package model;

import java.util.ArrayList;

public class Alumno extends Usuario {
	private String dni_alumno;
   // private String nombre;
    private ArrayList<String> asignatura;
    private ArrayList<Double> notas;
  //  private String contraseña;

   
    /*public void agregarNota(String modulo, double nota) {
        asignatura.add(modulo);
        notas.add(nota);
    }*/

public Alumno(String nombre, String apellidos, String direccion, String pass) {
	super(nombre, apellidos, direccion, pass);
}
public Alumno(String nombre, String apellidos, String direccion, String pass, String dni_alumno) {
	super(nombre, apellidos, direccion, pass);
	this.dni_alumno = dni_alumno;
}
public String getDni_alumno() {
	return dni_alumno;
}
public ArrayList<String> getAsignatura() {
	return asignatura;
}
public ArrayList<Double> getNotas() {
	return notas;
}
public void setDni_alumno(String dni_alumno) {
	this.dni_alumno = dni_alumno;
}
public void setAsignatura(ArrayList<String> asignatura) {
	this.asignatura = asignatura;
}
public void setNotas(ArrayList<Double> notas) {
	this.notas = notas;
}
@Override
public String toString() {
	return "Alumno [dni_alumno=" + dni_alumno + ", asignatura=" + asignatura + ", notas=" + notas + "]";
}


 
}
