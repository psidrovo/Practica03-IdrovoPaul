/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.test;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;

/**
 *
 * @author Paul Idrovo
 */
public class Test {
    
        public static void main(String[] args) {
            // vista
            VistaUsuario vistaU = new VistaUsuario();
            VistaTelefono vistaT = new VistaTelefono();
            //DAOs
            UsuarioDao usuarioDao = new UsuarioDao();
            TelefonoDao telefonoDao = new TelefonoDao();
            // controlador
            ControladorUsuario controladorUsuario = new ControladorUsuario(vistaU, usuarioDao, vistaT, telefonoDao);
            ControladorTelefono controladorTelefono = new ControladorTelefono(vistaT, telefonoDao);
        
            controladorUsuario.registrar();
            controladorUsuario.registrar();
            controladorUsuario.inicioSesion();
            int codigo = controladorTelefono.crearNuevoTelefono();
            controladorUsuario.agregarTelefono(codigo);
            controladorUsuario.verUsuario();
            
    }
}
