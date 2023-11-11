/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Connection.ConexionDao;
import java.util.Date;

/**
 *
 * @author diego
 */
public class Usuarios
{
    private int codigoUsuario;
    private String nombre;
    private String apellidoP;
    private long telefono;
    private String nombreUsuario;
    private String contraseña;
    private String estatus;
    private int rol;
    private Date FechaAlta;

    public Usuarios()
    {
    }

    public Usuarios(int codigoUsuario, String nombre, String apellidoP, long telefono, String nombreUsuario, String contraseña, String estatus, int rol, Date FechaAlta)
    {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.estatus = estatus;
        this.rol = rol;
        this.FechaAlta = FechaAlta;
    }

    /**
     * @return the codigoUsuario
     */
    public int getCodigoUsuario()
    {
        return codigoUsuario;
    }

    /**
     * @param codigoUsuario the codigoUsuario to set
     */
    public void setCodigoUsuario(int codigoUsuario)
    {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoP
     */
    public String getApellidoP()
    {
        return apellidoP;
    }

    /**
     * @param apellidoP the apellidoP to set
     */
    public void setApellidoP(String apellidoP)
    {
        this.apellidoP = apellidoP;
    }

    /**
     * @return the telefono
     */
    public long getTelefono()
    {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(long telefono)
    {
        this.telefono = telefono;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario()
    {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña()
    {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña)
    {
        this.contraseña = contraseña;
    }

    /**
     * @return the estatus
     */
    public String getEstatus()
    {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus)
    {
        this.estatus = estatus;
    }

    /**
     * @return the rol
     */
    public int getRol()
    {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(int rol)
    {
        this.rol = rol;
    }

    /**
     * @return the FechaAlta
     */
    public Date getFechaAlta()
    {
        return FechaAlta;
    }

    /**
     * @param FechaAlta the FechaAlta to set
     */
    public void setFechaAlta(Date FechaAlta)
    {
        this.FechaAlta = FechaAlta;
    }

    @Override
    public String toString()
    {
        return "Usuarios{" + "codigoUsuario=" + codigoUsuario + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", telefono=" + 
                telefono + ", nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + ", estatus=" + estatus + ", rol=" + rol + ", FechaAlta=" + FechaAlta + '}';
    }
    
    
    
   
}
