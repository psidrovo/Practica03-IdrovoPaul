
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.idao.ITelefono;
import ec.edu.ups.idao.IUsuario;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorUsuario {
    
    private VistaUsuario vistaUsuario;
    private VistaTelefono vistaTelefono;
    private IUsuario UDao;
    private ITelefono TDao;
    private Usuario usuario;
    private Telefono telefono;
    
    public ControladorUsuario() {
    }
    
    public ControladorUsuario(VistaUsuario vistaU, UsuarioDao usuarioDao, VistaTelefono vistaT, TelefonoDao telefonoDao) {
        this.vistaUsuario=vistaU;
        this.vistaTelefono=vistaT;
        this.UDao=usuarioDao;
        this.TDao=telefonoDao;
    }
    
    //llama al DAO para guardar un Usuario
    public void registrar() {
        usuario = vistaUsuario.registrarUsuario();
        UDao.create(usuario);
    }

    //llama al DAO para Iniciar sesion
    public Usuario inicioSesion() {
        String credenciales = vistaUsuario.iniciarSesionUsuario();
        usuario = UDao.read(credenciales);
        vistaUsuario.imprimirUsuario(usuario);
        return usuario;
    }
    
    //ejemplo de agregacion
    public void agregarTelefono(int codigo){
        //int codigo = vistaTelefono.buscarTelefono();
        telefono = TDao.read(codigo);
        usuario.agregarTelefono(telefono);
        UDao.update(usuario);        
    }
    
    public void verUsuario(){
        vistaUsuario.imprimirUsuario(usuario);
    }

}
