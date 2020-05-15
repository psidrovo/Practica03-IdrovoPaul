/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Usuario;

/**
 *
 * @author Paul Idrovo
 */
public interface IUsuario {
    //Métodos CRUD
    public void create(Usuario usuario);
    public Usuario read(String credenciales);
    public void update(Usuario usuario);
    public Usuario telefonos(String correo);
}
