/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proble2;

import paquete2.Calificaciones;
import paquete3.Enlace;

/**
 *
 * @author omerb
 */
public class Proble2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Enlace c=new Enlace();
        c.establecerDataEstudiante();
        for (Calificaciones cal : c.obtenerDataEstudiante()) {
            System.out.println(cal);
        }
    }
    
}
