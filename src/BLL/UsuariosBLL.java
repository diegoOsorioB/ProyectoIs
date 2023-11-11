/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Connection.ConexionDao;
import DAO.UsuarioDAO;
import DTO.Usuarios;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author diego
 */
public class UsuariosBLL
{

    private String msj;
    private boolean ms = false;
    private int msj1;
    private UsuarioDAO usuDAO = new UsuarioDAO();

    public int salvarUsuario(Usuarios usu)
    {
        Connection con = ConexionDao.conectar();
        try {
            msj1 = usuDAO.guardarUsu(con, usu);
            con.commit();
        } catch (SQLException e) {
           msj1=0;//OCURRIO UN ERROR AL INSERTAR DATOS
        } catch (Exception ex) {
           msj1=-1;//OCURRIO UN ERROR NO ESPERADO
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                 msj1=-4;//ERROR EN LA CONEXION BASE DE DATOS
            }
        }
        return msj1;
    }
    
    
    

    public int modificarUsuario(Usuarios usu)
    {
        Connection con = ConexionDao.conectar();
        try {
            msj1 = usuDAO.modificarUsuario(con, usu);
            con.commit();
        } catch (SQLException e) {
           msj1=0;//OCURRIO UN ERROR AL INSERTAR DATOS
        } catch (Exception ex) {
           msj1=-1;//OCURRIO UN ERROR NO ESPERADO
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                 msj1=-4;//ERROR EN LA CONEXION BASE DE DATOS
            }
        }
        return msj1;
    }
    public boolean  validaCredenciales(Usuarios usu)
    {
        Connection con = ConexionDao.conectar();
        try {
            ms = usuDAO.verificaCredenciales(con, usu);
            con.commit();
        } catch (SQLException e) {
           ms=false;//OCURRIO UN ERROR AL INSERTAR DATOS
        } catch (Exception ex) {
           ms=false;//OCURRIO UN ERROR NO ESPERADO
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                ms=false;//ERROR EN LA CONEXION BASE DE DATOS
            }
        }
        return ms;
    }

    public void getUsuario(JTable tbl)
    {
        Connection con = ConexionDao.conectar();
        usuDAO.getUsuario(con, tbl);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void verifica(JTable tbl,String nom)
    {
        Connection con = ConexionDao.conectar();
        usuDAO.verifica(con,tbl, nom);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int eliminar(int id)
    {
        Connection con = ConexionDao.conectar();
        try {
            msj1 = usuDAO.eliminar(con, id);
            con.commit();
        } catch (SQLException e) {
           msj1=0;//OCURRIO UN ERROR AL INSERTAR DATOS
        } catch (Exception ex) {
           msj1=-1;//OCURRIO UN ERROR NO ESPERADO
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                 msj1=-4;//ERROR EN LA CONEXION BASE DE DATOS
            }
        }
        return msj1;
    }
    public int verificaM(Usuarios id)
    {
        Connection con = ConexionDao.conectar();
        try {
            msj1 = usuDAO.verificaM(con, id);
            con.commit();
        } catch (SQLException e) {
           msj1=0;//OCURRIO UN ERROR AL INSERTAR DATOS
        } catch (Exception ex) {
           msj1=-1;//OCURRIO UN ERROR NO ESPERADO
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                 msj1=-4;//ERROR EN LA CONEXION BASE DE DATOS
            }
        }
        return msj1;
    }
}
