
package ec.edu.ups.test;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.modelo.Usuario;
import static ec.edu.ups.modelo.ValidarDatos.validarInt;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;

/**
 *
 * @author Paul Idrovo
 */
public class Test {
        // vista
        static VistaUsuario vistaU = new VistaUsuario();
        static VistaTelefono vistaT = new VistaTelefono();
        //DAOs
        static UsuarioDao usuarioDao = new UsuarioDao();
        static TelefonoDao telefonoDao = new TelefonoDao();
        // controlador
        static ControladorUsuario controladorUsuario = new ControladorUsuario(vistaU, usuarioDao, telefonoDao);
        static ControladorTelefono controladorTelefono = new ControladorTelefono(vistaT, telefonoDao);
    public static void main(String[] args) {
        

        boolean inicio=true;
        while(inicio){
            System.out.println("---MENU DIRECTORIO TELEFONICO---");
            System.out.println("1. Registrarse");
            System.out.println("2. Inicio de Sesion");
            System.out.println("3. Imprimir directorio telefonico");
            System.out.println("4. Imprimir directorio de una persona con su correo");
            System.out.println("5. SALIR");

            int opcion = validarInt();

            switch (opcion) {
                //Registrarse
                case 1: controladorUsuario.registrar();
                        break;

                //Inicio de Sesion
                case 2: Usuario us =controladorUsuario.inicioSesion();
                        if(us!=null){
                            menuSesionIniciada();
                        }else{
                            System.out.println("ERROR INICIO SESION \nREVISE SU CORREO Y/O CONTRASEÑA");
                        }
                        break;

                //Imprimir directorio telefonico
                case 3: controladorTelefono.verTelefonos();
                        break;  
                //Imprimir directorio de una persona con su correo
                case 4: controladorUsuario.verTelefonosCorreo();
                        break; 

                //SALIR
                case 5: inicio=false ;
                        System.out.println("\tGRACIAS");;
                        break;  

                default:
                        System.err.println("\tSE INGRESO UN NUMERO NO VALIDO -- > VUELVA INTENTARLO");;
                        break;
            }
        }
    }
   
    public static void menuSesionIniciada(){
        boolean inicio=true;
        while(inicio){
            System.out.println("---MENU DIRECTORIO TELEFONICO DE USUARIO---");
            System.out.println("1. Agregar nuevo Telefono");
            System.out.println("2. Editar Telefono");
            System.out.println("3. Eliminar Telefono");
            System.out.println("4. Buscar Telefono");
            System.out.println("5. Visualizar Telefonos");
            System.out.println("6. CERRAR SESSION");

            int opcion = validarInt();

            switch (opcion) {
                //Agregar nuevo Telefono
                case 1: int codigo = controladorTelefono.crearNuevoTelefono();
                        controladorUsuario.agregarTelefono(codigo);
                        break;

                //Editar Telefono
                case 2: int codigoEditado = controladorTelefono.actualizar();
                        controladorUsuario.actualizarTelefono(codigoEditado);
                        break;
                //Eliminar Telefono
                case 3: int codigoEliminado=controladorTelefono.eliminar();
                        controladorUsuario.eliminarTelefono(codigoEliminado);
                        break;  
                //Visualizar Telefonos
                case 4: controladorUsuario.verTelefonoCodigo();
                        break; 
                        
                //Visualizar Telefonos
                case 5: controladorUsuario.verTelefonos();
                        break; 

                //CERRAR SESSION
                case 6: inicio=false ;
                        System.out.println("\tSESION FINALIZADA");;
                        break;  

                default:
                        System.err.println("\tSE INGRESO UN NUMERO NO VALIDO -- > VUELVA INTENTARLO");;
                        break;
            }
        }
    }
}
