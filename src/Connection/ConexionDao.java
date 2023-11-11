/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class ConexionDao
{

    private static Connection conn = null;
   private static  String base_datos = "xe";
    // private String url,user,pass;
    private static String url = "jdbc:oracle:thin:@149.56.47.191:1521:"+base_datos;
    private static String user = "APPLICACION";
    private static String pass = "PWD123";



    public static Connection conectar()
    {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, user, pass);
            conn.setAutoCommit(false);
            if (conn != null) {
                System.out.println("Conexion exitosa");
            }else{
                System.out.println("Error: no se logro la conexion a la base de datos");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: no se logro la conexion a la base de datos");
        }
        return conn;
    }

    public void desconectar()
    {
        try {
            conn.close();
            System.out.println("Se desconecto de la base de datos");
        } catch (Exception e) {
            System.out.println("Error: No se logro hacer la desconexion");
        }
    }
}
