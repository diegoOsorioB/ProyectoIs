/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesG;

import BLL.UsuariosBLL;
import DAO.UsuarioDAO;
import DTO.Usuarios;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author diego
 */
public class NewMain
{
    UsuariosBLL ebo=new UsuariosBLL();
    UsuarioDAO dao=new UsuarioDAO();
    Usuarios usu=new Usuarios();
    String msj="";
    int msj1;
    
    public void insertar(){
        
         usu.setRol(1);
         usu.setCodigoUsuario(2);
        usu.setNombre("Diego");
        usu.setApellidoP("Osorio");
        usu.setTelefono(758792745);
        usu.setNombreUsuario("dieg12");
        usu.setContraseña("contra");
        usu.setEstatus("alta");
        //usu.setFechaAlta(Date.from(Instant.EPOCH));
        
       msj1=ebo.salvarUsuario(usu);
       
        if (msj1==1) {
            System.out.println("Se guardo con exito");
        } else {
            if (msj1==0) {
                System.out.println("Ocurrio un error al insertar la base de datos");
            } else {
                if (msj1==-1) {
                    System.out.println("Error no esperado");
                    
                } else {
                    if (msj1==-2) {
                        System.out.println("Verifique el usuario o contraseña que ya existe");
                    } else {
                        if (msj1==-4) {
                            System.out.println("No se conecto a la base de datos");
                        } else {
                        }
                    }
                }
            }
        }
      //  System.out.println(msj1);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        NewMain mn= new NewMain();
        mn.insertar();
    }
    
}
