
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Telefono;
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

    public int buscarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el id del cliente a buscar");
        int id = entrada.nextInt();
        return id;
    }

    public void verCliente(Cliente cliente) {
        System.out.println("Datos del Cliente: " + cliente);
    }

    public void verClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("Datos del Cliente: " + cliente);
        }
    }
}
