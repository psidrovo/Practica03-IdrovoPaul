
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.VistaTelefono;
import java.util.List;

/**
 * Clase ControladorTelefono. 
 * 
 * Esta clase manejara toda la informacion de los telefonos y ademas tendra acceso
 * a la lista de Telefonos registrados que le pertenece a cada Usuario.
 * 
 * @author Paul Idrovo
 */
public class ControladorTelefono {

    private VistaTelefono vistaTelefono;
    private TelefonoDao TDao;
    private Telefono telefono;
    
    public ControladorTelefono() {
    }
    /**
     * Constructor.
     * 
     * Este constructor nos permite crear el controlador telefono y que disponga
     * de vistaTelefono y de TelefonoDao
     * 
     * @param vistaT
     * @param telefonoDao 
     */
    public ControladorTelefono(VistaTelefono vistaT, TelefonoDao telefonoDao) {
        this.vistaTelefono=vistaT;
        this.TDao=telefonoDao;
    }
    
    /**
     * Metodo crearNuevoTelefono.
     * 
     * Este metodo nos ayuda a crear un nuevo telefono y agregarlo
     * a la lista general
     * 
     * @return 
     */
    public int crearNuevoTelefono() {
        telefono = vistaTelefono.ingresarTelefono();
        TDao.create(telefono);
        return telefono.getCodigo();
    }

    /**
     * Metodo verTelefono.
     * 
     * Este metodo nos imprime el telefno con el codigo que le pasamos
     * 
     */
    public void verTelefono() {
        int codigo = vistaTelefono.buscarTelefono();
        telefono = TDao.read(codigo);
        vistaTelefono.visualizarTelefono(telefono);
    }

    /**
     * Metodo actualizar.
     * 
     * Este metodo lo que hace es actualizar nuestra lista de telefonos.
     * 
     * @return 
     */
    public int actualizar() {
        telefono = vistaTelefono.editarTelefono();
        TDao.update(telefono);
        return telefono.getCodigo();
    }

    /**
     * Metodo eliminar.
     * 
     * Este metodo es llamada para eliminar un telefono del directorio.
     * 
     * @return 
     */
    public int eliminar() {
        telefono = vistaTelefono.eliminarTelefono();
        TDao.delete(telefono.getCodigo());
        return telefono.getCodigo();
    }

    /**
     * Metodo verTelefonos.
     * 
     * Este metodo nos ayuda a imprimir la lista de telefonos.
     */
    public void verTelefonos() {
        List<Telefono> telefonos;
        telefonos = TDao.todosTelefonos();
        vistaTelefono.verTelefonos(telefonos);
    }
}
