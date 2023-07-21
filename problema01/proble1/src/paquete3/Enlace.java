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
import paquete2.Trabajador;


public class Enlace {

    /**
     * Connect to a sample database
     *
     * @return
     */
    private Connection conn;
    private ArrayList<Trabajador> lista;

    public void establecerConexion() {

        try {
            // db parameters  
            String url ="jdbc:sqlite:bd/base01.bd";
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

    public void insertarTrabador(Trabajador tra) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO Trabajadores (cedula, nombres, sueldo, mesSueldo, correo) "
                    + "values ('%s', '%s', %s, '%s', '%s');", tra.obtenerCedula(),tra.obtenerNombres(),
                     tra.obtenerSueldo(),tra.obtenerMesDelSueldo(),tra.obtenerCorreo());
            
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarTrabajador");
            System.out.println(e.getMessage());

        }
    }

    public void establecerDataTrabajador() {
        lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from Trabajadores;";
            ResultSet rs = statement.executeQuery(data);
            agregarTrabajador(rs);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarTrabajador");
            System.out.println(e.getMessage());

        }

    }

    public ArrayList<Trabajador> obtenerDataTrabajador() {
        return lista;
    }

    public void agregarTrabajador(ResultSet rs) {

        try {
            while (rs.next()) {
                
                Trabajador tra = new Trabajador(rs.getString("cedula"),
                        rs.getString("nombres"),rs.getString("correo"),
                rs.getDouble("sueldo"),rs.getString("mesSueldo"));
                lista.add(tra);
            }
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: agregarTrabajador");
            System.out.println(e.getMessage());

        }
    }
}
