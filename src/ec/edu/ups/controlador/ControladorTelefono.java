
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.VistaTelefono;
import java.util.List;

/**
 *
 * @author Paul Idrovo
 */
public class ControladorTelefono {

    private VistaTelefono vistaTelefono;
    private TelefonoDao TDao;
    private Telefono telefono;
    
    public ControladorTelefono() {
    }
    
    public ControladorTelefono(VistaTelefono vistaT, TelefonoDao telefonoDao) {
        this.vistaTelefono=vistaT;
        this.TDao=telefonoDao;
    }
    
     //llama al DAO para guardar un Telefono
    public int crearNuevoTelefono() {
        telefono = vistaTelefono.ingresarTelefono();
        TDao.create(telefono);
        return telefono.getCodigo();
    }

    //llama al DAO para obtener un telefono por el codigo y luego los muestra en la vista
    public void verTelefono() {
        int codigo = vistaTelefono.buscarTelefono();
        telefono = TDao.read(codigo);
        vistaTelefono.visualizarTelefono(telefono);
    }

    //llama al DAO para actualizar telefono
    public int actualizar() {
        telefono = vistaTelefono.editarTelefono();
        TDao.update(telefono);
        return telefono.getCodigo();
    }

    //llama al DAO para eliminar un cliente
    public int eliminar() {
        telefono = vistaTelefono.eliminarTelefono();
        TDao.delete(telefono.getCodigo());
        return telefono.getCodigo();
    }

    //llama al DAO para obtener todos telefonos
    public void verTelefonos() {
        List<Telefono> telefonos;
        telefonos = TDao.todosTelefonos();
        vistaTelefono.verTelefonos(telefonos);
    }
}
