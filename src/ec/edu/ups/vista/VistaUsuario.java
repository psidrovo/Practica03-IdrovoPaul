
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Usuario;
import static ec.edu.ups.modelo.ValidarDatos.*;

/**
 *
 * @author Paul Idrovo
 */
public class VistaUsuario {
    
    public Usuario registrarUsuario() {
        System.out.println("***INGRESE LOS DATOS DEL USUARIO A REGISTRAR***");
        Usuario usRegistro = new Usuario();
        System.out.println("Ingrese la cedula");        
        usRegistro.setCedula(validarString());
        System.out.println("Ingrese el nombre");  
        usRegistro.setNombre(validarString());
        System.out.println("Ingrese el apellido");  
        usRegistro.setApellido(validarString());
        System.out.println("Ingrese el correo");  
        usRegistro.setCorreo(validarString());
        System.out.println("Ingrese la contraseña");  
        usRegistro.setContrasena(validarString());
        
        return usRegistro;
    }

    public String iniciarSesionUsuario() {
        String credencial;
        System.out.println("***INICIO DE SESION***");
        System.out.println("Ingrese su correo");
        credencial = validarString();
        System.out.println("Ingrese su contraseña"); 
        credencial=credencial+validarString();
        return credencial;
    }

    public void imprimirUsuario(Usuario Usuario) {
        System.out.println("SUS DATOS SON: \n" + Usuario.toString());
    }
}
