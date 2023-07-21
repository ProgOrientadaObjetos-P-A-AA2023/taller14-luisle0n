/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proble1;

import java.awt.BorderLayout;
import java.util.Scanner;
import jdk.javadoc.doclet.Taglet;
import paquete2.Trabajador;
import paquete3.Enlace;

/**
 *
 * @author omerb
 */
public class Proble1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cedula;
        String nombres;
        String correo;
        double sueldo;
        String mesDelSueldo;
        boolean ban2 = false;
        boolean ban = true;

        Enlace c = new Enlace();
        Scanner sc = new Scanner(System.in);

       do {
            System.out.println("Ingrese un Trabajador");
            System.out.println("Ingrese una cedula: ");
            cedula = sc.nextLine();
            System.out.println("Ingrese el nombre: ");
            nombres = sc.nextLine();
            System.out.println("Ingrese el Correo: ");
            correo = sc.nextLine();
            System.out.println("Ingrese el sueldo: ");
            sueldo = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese el mes de Sueldo: ");
            mesDelSueldo = sc.nextLine();
            Trabajador tra = new Trabajador(cedula,
                    nombres, correo, sueldo, mesDelSueldo);
            c.insertarTrabador(tra);
            do {
                String opc;
                System.out.print("Desea realizar otra opción (Si/No): ");
                opc=sc.nextLine();
                if (opc.equals("Si") || opc.equals("si")) {
                    ban2 = false;
                    ban = true;
                } else if (opc.equals("No") || opc.equals("no")) {
                    ban2 = false;
                    ban = false;
                } else {
                    System.out.println("Error......");
                    ban2=true;
                }
            } while (ban2);
        } while (ban);
       c.establecerDataTrabajador();
        for (int i = 0; i < c.obtenerDataTrabajador().size(); i++) {
            System.out.println(c.obtenerDataTrabajador().get(i));
        }
    }

}
