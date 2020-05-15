/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Telefono;
import static ec.edu.ups.modelo.ValidarDatos.*;
import java.util.List;

/**
 *
 * @author Paul Idrovo
 */
public class VistaTelefono {
    
    public Telefono ingresarTelefono() {
        System.out.println("***INGRESE LOS DATOS DEL TELEFONO***");
        Telefono tfRegistro = new Telefono();
        System.out.println("Ingrese el codigo");        
        tfRegistro.setCodigo(validarInt());
        System.out.println("Ingrese el numero");  
        tfRegistro.setNumero(validarString());
        System.out.println("Ingrese el tipo");  
        tfRegistro.setTipo(validarString());
        System.out.println("Ingrese la operadora");  
        tfRegistro.setOperadora(validarString());
        
        return tfRegistro;
    }

    public Telefono editarTelefono() {
        System.out.println("***INGRESE LOS NUEVOS DATOS DEL TELEFONO***");
        Telefono tfRegistro = new Telefono();
        System.out.println("Ingresa codigo del telefono para editar");
        tfRegistro.setCodigo(validarInt());
        System.out.println("Ingrese el numero");  
        tfRegistro.setNumero(validarString());
        System.out.println("Ingrese el tipo");  
        tfRegistro.setTipo(validarString());
        System.out.println("Ingrese la operadora");  
        tfRegistro.setOperadora(validarString());
        return tfRegistro;
    }

    public Telefono eliminarTelefono() {
        System.out.println("***ELIMINAR TELEFONO***");
        System.out.println("Ingresa codigo del telefono a eliminar");
        int codigo = validarInt();
        return new Telefono(codigo, null, null, null);
    }

    public int buscarTelefono() {
        System.out.println("***BUSCAR TELEFONO***");
        System.out.println("Ingresa el codigo del telefono a buscar");
        int codigo = validarInt();
        return codigo;
    }

    public void visualizarTelefono(Telefono telefono) {
        System.out.println("Telefono: \n" + telefono);
    }

    public void verTelefonos(List<Telefono> Telefonos) {
        for (Telefono telefono : Telefonos) {
            System.out.println(telefono);
        }
    }
}
