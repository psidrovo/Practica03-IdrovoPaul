
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorUsuario {
    
    private VistaUsuario vistaUsuario;
    private VistaTelefono vistaTelefono;
    private UsuarioDao UDao;
    private TelefonoDao TDao;
    
    public ControladorUsuario() {
    }
    
    public ControladorUsuario(VistaUsuario vistaU, UsuarioDao usuarioDao, VistaTelefono vistaT, TelefonoDao telefonoDao) {
        this.vistaUsuario=vistaU;
        this.vistaTelefono=vistaT;
        this.UDao=usuarioDao;
        this.TDao=telefonoDao;
    }
    
}
