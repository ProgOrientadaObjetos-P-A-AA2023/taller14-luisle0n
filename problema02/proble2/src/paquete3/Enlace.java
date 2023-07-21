/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete3;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import paquete2.Calificaciones;



public class Enlace {

    /**
     * Connect to a sample database
     *
     * @return
     */
    private Connection conn;
    private ArrayList<Calificaciones> lista;

    public void establecerConexion() {

        try {
            // db parameters  
            String url ="jdbc:sqlite:bd/base001.base";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarClificaciones(Calificaciones cal) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO estudiante (nombre, apellido, calificacion1, calificacion2, calificacion3) "
                    + "values ('%s', '%s', %s, %s, %s);", cal.obtenerNombre(),cal.obtenerApellido()
            ,cal.obtenerNota1(),cal.obtenerNota2(),cal.obtenerNota3());
            
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarCalicacion");
            System.out.println(e.getMessage());

        }
    }

    public void establecerDataEstudiante() {
        lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from estudiante;";
            ResultSet rs = statement.executeQuery(data);
            agregarEstudiante(rs);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarEstudiante");
            System.out.println(e.getMessage());

        }

    }

    public ArrayList<Calificaciones> obtenerDataEstudiante() {
        return lista;
    }

    public void agregarEstudiante(ResultSet rs) {
        try {
            while (rs.next()) {
                
                Calificaciones cal = new Calificaciones(rs.getString("nombre"),
                        rs.getString("apellido"),rs.getDouble("calificacion1"),
                rs.getDouble("calificacion2"),rs.getDouble("calificacion3"));
                cal.establecerPromedio();
                lista.add(cal);
            }
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: agregarCalificaicones");
            System.out.println(e.getMessage());

        }
    }
}
