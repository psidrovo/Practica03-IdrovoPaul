/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuario;
import ec.edu.ups.modelo.Usuario;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Paul Idrovo
 */
public class UsuarioDao implements IUsuario{
    
    private Map<String,Usuario> mapaUsuario;

    public UsuarioDao() {
        mapaUsuario=new HashMap<String,Usuario>();
    }

    @Override
    public void create(Usuario usuario) {
        String key = usuario.getCorreo()+usuario.getContrasena();
        mapaUsuario.put(key, usuario);
    }

    @Override
    public Usuario read(String credenciales) {
        Usuario usLectura = mapaUsuario.get(credenciales);
        return usLectura;
    }

    @Override
    public void update(Usuario usuario) {
        String key = usuario.getCorreo()+usuario.getContrasena();
        mapaUsuario.put(key, usuario);
    }

    @Override
    public Usuario telefonos(String correo) {
        Iterator it = mapaUsuario.values().iterator();
        while(it.hasNext()){
            Usuario us = (Usuario) it.next();
            if(us.getCorreo()==correo){
                return us;
            }
        }
        return null;
    }
    
    
}
