/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

/**
 *
 * @author omerb
 */
public class Trabajador {
    private String cedula;
    private String nombres;
    private String correo;
    private double sueldo;
    private String mesDelSueldo;

    public Trabajador(String ced, String nomb, String corr, double suel, String mesDelSuel) {
        cedula = ced;
        nombres = nomb;
        correo = corr;
        sueldo = suel;
        mesDelSueldo = mesDelSuel;
    }

    public void establecerCedula(String cedu) {
        cedula = cedu;
    }

    public void establecerNombres(String nomb) {
        nombres = nomb;
    }

    public void establecerCorreo(String corr) {
        correo = corr;
    }

    public void establecerSueldo(double suel) {
        sueldo = suel;
    }

    public void establecerMesDelSueldo(String mesDelSuel) {
        mesDelSueldo = mesDelSuel;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public String obtenerNombres() {
        return nombres;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    public String obtenerMesDelSueldo() {
        return mesDelSueldo;
    }
    
    @Override
    public String toString(){
        String cadena=String.format("Trabajador\n"
                + "Cedula: %s\n"
                + "Nombre: %s\n"
                + "Correo: %s\n"
                + "Sueldo: %.2f\n"
                + "Mes de Sueldo: %s\n", cedula,nombres,correo,sueldo,mesDelSueldo);
        return cadena;
    }
}
