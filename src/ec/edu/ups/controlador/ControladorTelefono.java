
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.vista.VistaTelefono;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorTelefono {

    private VistaTelefono vistaTelefono;
    private TelefonoDao Tdao;
    
    public ControladorTelefono() {
    }
    
    public ControladorTelefono(VistaTelefono vistaT, TelefonoDao telefonoDao) {
        this.vistaTelefono=vistaT;
        this.Tdao=telefonoDao;
    }
    
}
