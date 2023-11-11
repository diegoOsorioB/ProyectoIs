/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BLL.EncriptacionMD5;
import DTO.Usuarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javafx.scene.AccessibleAction;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class UsuarioDAO
{

    int msj;
    String msj1;

    public int guardarUsu(Connection con, Usuarios usu)
    {
        PreparedStatement pst = null;
        String sql = "INSERT INTO SEGURIDAD.Usuarios (ID_Usuario, ID_Rol, CodigoUsuario, Nombre, ApellidoP, Telefono, NombreUsuario, Contrasena, Estatus, FechaAlta)" +
"VALUES (SEGURIDAD.USUARIOS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, usu.getRol());
            pst.setInt(2, usu.getCodigoUsuario());
            pst.setString(3, usu.getNombre());
            pst.setString(4, usu.getApellidoP());
            pst.setLong(5, usu.getTelefono());
            pst.setString(6, usu.getNombreUsuario());
            pst.setString(7, usu.getContraseña());
            pst.setString(8, usu.getEstatus());
           // pst.setDate(9, (Date) usu.getFechaAlta());
            msj =1;//EXITO
            pst.execute();
            pst.close();

        } catch (SQLIntegrityConstraintViolationException e) {
            msj = -2; //YA EXISTE

        }
        catch(SQLException ex){
            msj =0;//OCURRIO UN ERROR AL INSERTAR DATOS
            System.out.println(ex);
        }catch(Exception exc){
            msj=-1;//ERROR NO ESPERADO
            System.out.println(exc);
        }
        System.out.println(msj);
        return msj;
    }

    public int modificarUsuario(Connection con, Usuarios usu)
    {

        PreparedStatement pst = null;
        String sql = "UPDATE SEGURIDAD.USUARIOS SET ID_ROL=?,CODIGOUSUARIO=?,NOMBRE=?,APELLIDOPAT=?,TELEFONO=?,NOMBRE_USUARIO=?,CONTRASENIA=?,ESTATUS=?,FECHA_ALTA=SYSDATE "
                + "WHERE CODIGOUSUARIO = "+usu.getCodigoUsuario()+"";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, usu.getRol());
            pst.setInt(2, usu.getCodigoUsuario());
            pst.setString(3, usu.getNombre());
            pst.setString(4, usu.getApellidoP());
            pst.setLong(5, usu.getTelefono());
            pst.setString(6, usu.getNombreUsuario());
            pst.setString(7, usu.getContraseña());
            pst.setString(8, usu.getEstatus());
          //  pst.setDate(9, (Date) usu.getFechaAlta());
            msj = 1;
            pst.execute();
            pst.close();
            System.out.println("Actualiz");
            return 1;
        } catch (SQLException e) {
            msj = -1;
            System.out.println(e);
        }

        return msj;
    }

    public void getUsuario(Connection con,JTable tbl)
    {
        DefaultTableModel model;
        String [] column={"ID","ID_ROL","CODIGO USUARIO","NOMBRE","APELLIDO PAT","TELEFONO","NOMBRE USUARIO","CONTRASEÑA","ESTATUS","FECHA ALTA"};
        model= new DefaultTableModel(null, column);
        
        String sql = "SELECT * FROM SEGURIDAD.USUARIOS ORDER BY 1";
        String[] filas=new String[7];
        
        Statement st=null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                model.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),
                rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
                
            }
            tbl.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void verifica(Connection con,JTable tbl,String nom)
    {
        DefaultTableModel model;
        String [] column={"ID","ID_ROL","CODIGO USUARIO","NOMBRE","APELLIDO PAT","TELEFONO","NOMBRE USUARIO","CONTRASEÑA","ESTATUS","FECHA ALTA"};
        model= new DefaultTableModel(null, column);
        
        String sql = "SELECT * FROM SEGURIDAD.USUARIOS WHERE NOMBRE LIKE '%"+nom+"%' ORDER BY 1";
        String[] filas=new String[7];
        
        Statement st=null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                model.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),
                rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
                
            }
            tbl.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public int verificaM(Connection con,Usuarios usu)
    {
        
        
        String sql = "SELECT * FROM SEGURIDAD.USUARIOS WHERE CODIGOUSUARIO ="+usu.getCodigoUsuario()+" ORDER BY 1";
       
        
        Statement st=null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                
                usu.setRol(rs.getInt(2));
                usu.setNombre(rs.getString(4));
                usu.setApellidoP(rs.getString(5));
                usu.setTelefono(rs.getInt(6));
                usu.setNombreUsuario(rs.getString(7));
                usu.setContraseña(rs.getString(8));
                usu.setEstatus(rs.getString(9));
                usu.setFechaAlta(rs.getDate(10));
return 1;
            }
            
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        return 7;
    }

    public int eliminar(Connection con, int id)
    {

        PreparedStatement pst = null;
        String sql = "DELETE FROM SEGURIDAD.USUARIOS WHERE ID=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            msj = 1;
            pst.execute();
            pst.close();
            return 1;
        } catch (SQLException e) {
            msj = -1;
        }

        return msj;
    }
    public boolean verificaCredenciales(Connection con, Usuarios usu)
    {

        PreparedStatement pst = null;
        ResultSet rs= null;
        String sql = "SELECT ID_ROL,NombreUsuario,Contrasena FROM SEGURIDAD.USUARIOS WHERE NombreUsuario=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,usu.getNombreUsuario());
            rs=pst.executeQuery();
            String conu,consq;
            String newC="";
        
//        char [] gen=rs.getString(3);
//        
//        for (int i = 0; i < gen.length; i++) {
//            newC+=gen[i];
//        }
            EncriptacionMD5 mn1=new EncriptacionMD5();
       
        
            if (rs.next()) {
                String psww= mn1.deecnode("root", rs.getString(3));
                if (usu.getContraseña().equals(psww)) {
                    System.out.println("Hola, si");
                    usu.setRol(rs.getInt(1));
                    return true;
                }
                else{
                     System.out.println(usu.getContraseña());
            System.out.println(psww);
                      System.out.println("Noooo");
                    return false;
                  
                }
            }
           
           return false;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
            
        }

       //return true;
    }

}
