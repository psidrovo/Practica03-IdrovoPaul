
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
    
    public void imprimirTelefono(Usuario Usuario) {
        System.out.println("Ingrese el codigo del telefono");
        int codigo = validarInt();
        if(Usuario.buscar(codigo)!=null){
            System.out.println("Su Telefono es: \n" + Usuario.buscar(codigo).toString());
        }else{
            System.out.println("No esxiste un telefono con el odigo "+codigo);
        }
    }
    
    public void imprimirUsuarioTelefonos(Usuario Usuario) {
        System.out.println("SUS TELEFONOS SON: \n" + Usuario.getDirectorio().toString());
    }
    
    public String imprimirUsuarioTelefonos() {
        System.out.println("Ingrese el correo del usuario");
        String credencial = validarString();
        return credencial;
    }
}
