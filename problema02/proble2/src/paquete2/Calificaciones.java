/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

/**
 *
 * @author omerb
 */
public class Calificaciones {

    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    private double nota3;
    private double promedio;

    public Calificaciones(String nomb, String ape, double not1, double not2, double not3) {
        nombre = nomb;
        apellido = ape;
        nota1 = not1;
        nota2 = not2;
        nota3 = not3;
    }

    public void establecerNombre(String nomb) {
        nombre = nomb;
    }

    public void establecerApellido(String ape) {
        apellido = ape;
    }

    public void establecerNota1(double not1) {
        nota1 = not1;
    }

    public void establecerNota2(double not2) {
        nota2 = not2;
    }

    public void establecerNota3(double not3) {
        this.nota3 = not3;
    }

    public void establecerPromedio() {
        promedio = (nota1 + nota2 + nota3) / 3;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public double obtenerNota1() {
        return nota1;
    }

    public double obtenerNota2() {
        return nota2;
    }

    public double obtenerNota3() {
        return nota3;
    }

    public double obtenerPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        String cadena = String.format("%s %s\n"
                + " Calificaciones\n"
                + "  %.2f\n"
                + "  %.2f\n"
                + "  %.2f\n"
                + " Promedio: %.2f\n", nombre, apellido,
                nota1, nota2, nota3, promedio);
        return cadena;
    }
}
