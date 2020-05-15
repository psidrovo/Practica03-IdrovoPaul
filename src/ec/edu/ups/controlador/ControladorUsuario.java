
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.idao.ITelefono;
import ec.edu.ups.idao.IUsuario;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaUsuario;

/**
 * Clase ControladorUsuario. 
 * 
 * Esta clase manejara toda la informacion del usuario y ademas tendra acceso
 * a la lista de usuarios registrados que le pertenece a UsuarioDao, esto se debe
 * a que el cosntructor recibe al usuarioDao. Ademas podra hacer uso de los telefonos
 * disponibles en Telefono Dao
 * 
 * @author Paul Idrovo
 */

public class ControladorUsuario {
    
    private VistaUsuario vistaUsuario;
    private IUsuario UDao;
    private ITelefono TDao;
    private Usuario usuario;
    private Telefono telefono;
    
    public ControladorUsuario() {
    }
    /**
     * Constructor ControladorUsuario con valores iniciales.
     * Este constrcutor recibe la vista de Usuairo, el UsuarioDao y
     * el telefonoDao.
     * 
     * @see VistaUsuario
     * @see UsuarioDao
     * @see TelefonoDao
     * 
     * @param vistaU - objeto tipo VistaUsuario
     * @param usuarioDao - objeto tipo UsuarioDao
     * @param telefonoDao - objeto tipo TelefonoDao
     */
    public ControladorUsuario(VistaUsuario vistaU, UsuarioDao usuarioDao, TelefonoDao telefonoDao) {
        this.vistaUsuario=vistaU;
        this.UDao=usuarioDao;
        this.TDao=telefonoDao;
    }
    /**
     * Metodo Registrar.
     * 
     * Este metodo nos ayuda a registrar un usuario, para ello con la vistaUsuario
     * pedimos los datos para armar nuestro usuaario a registrar, de ahi UsuarioDao
     * mediante el metodo registrarUsuario se encarga de guardar dentro del map que 
     * tenemos disponible.
     * 
     * @see VistaUsuario
     * @see UsuarioDao
     */
    public void registrar() {
        usuario = vistaUsuario.registrarUsuario();
        UDao.create(usuario);
    }
    
    /**
     * Metodo inicoSesion.
     * 
     * Este metodo se encarga de pedir las credenciales mendiate la vistaUsuario
     * que tiene el metodo iniciarSesionUsuario, este nos devolvera el credencial
     * la misma que es la key del map, esta esta formada del correo y contraseña.
     * Luego por el UsuarioDao comprobamos si existe y este nos va a retornar todo
     * el Usuario, si es null significa que el Usuario no existe o no estan correctas 
     * sus credenciales
     * 
     * @return usuario - objeto tipo Usuario
     * @see VistaUsuario
     * @see UsuarioDao
     */
    //llama al DAO para Iniciar sesion
    public Usuario inicioSesion() {
        String credenciales = vistaUsuario.iniciarSesionUsuario();
        usuario = UDao.read(credenciales);
        if(usuario!=null){
            vistaUsuario.imprimirUsuario(usuario);
        }
        return usuario;
    }
    
    /**
     * Metodo agregarTelefono.
     * 
     * Este metodo se encarga de asignar un telefono a un Usuario, para ello
     * recibe el codigo del telefono a ingresar, luego mediante TelefonoDao y su
     * metodo read, extraemos el telefono de la lista principal apra agregarlo a
     * Usuario con su metodo agregar usuario, posteriormente actualizamos el UsuarioDao
     * con el nuevo Usuario.
     * 
     * @param codigo - tipo int
     * @see TelefonoDao
     * @see Usuario
     * @see UsuarioDao
     */
    public void agregarTelefono(int codigo){
        telefono = TDao.read(codigo);
        usuario.agregarTelefono(telefono);
        UDao.update(usuario);        
    }
    /**
     * Metodo actualizarTelefono.
     * 
     * Recibe un dato tipo int que es el codigo del telfono, con este buscamos
     * dentro del TelefonoDao, luego actualizamos la lista del usuario con el
     * metodo actualizarTelefono
     * 
     * @param codigo 
     */
    public void actualizarTelefono(int codigo){
        telefono = TDao.read(codigo);
        usuario.actualizarTelefono(telefono);
        UDao.update(usuario);        
    }
    /**
     * Metodo eliminarTelefono.
     * 
     * Este metodo se encarga de eliminar el telefono de la lista del usuario que
     * inicio sesion.
     * 
     * @param codigo 
     */
    public void eliminarTelefono(int codigo){
        telefono = TDao.read(codigo);
        usuario.eliminarTelefono(telefono);
        UDao.update(usuario);        
    }
    /**
     * Metodo verTelefonoCodigo.
     * 
     * Este metodo nos imprime el telefono del usuario al cual le pasamos un 
     * codigo posteriormente.
     * 
     */
    public void verTelefonoCodigo(){
        vistaUsuario.imprimirTelefono(usuario);
    }
    /**
     * Metodo verTelefonos.
     * 
     * Este metodo se encarga de imprimir todos los telefnos que contine este 
     * Usuario.
     * 
     */
    public void verTelefonos(){
        vistaUsuario.imprimirUsuarioTelefonos(usuario);
    }
    /**
     * Metodo verTelefonoCorreo.
     * 
     * Este metodo imprime los contactos que pertenescan al usuario que 
     * validamos unicamente con el correo
     */
    public void verTelefonosCorreo(){
        String credencial = vistaUsuario.imprimirUsuarioTelefonos();
        usuario = UDao.telefonos(credencial);
        if(usuario!=null){
            verTelefonos();
        }        
    }
    /**
     * Metodo verUsuario.
     * 
     * Este metodo nos imprime los datos del Usuario
     */
    public void verUsuario(){
        vistaUsuario.imprimirUsuario(usuario);
    }

}
