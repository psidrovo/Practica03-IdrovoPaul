package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Paul Idrovo
 */
public class Usuario {
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private List<Telefono> directorio;
    
    public Usuario() {
        directorio=new ArrayList<Telefono>();
    }

    public Usuario(String cedula, String nombre, String apellido, String correo, String contrasena, List<Telefono> directorio) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.directorio = directorio;
        this.directorio=new ArrayList<Telefono>();
    }

    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Telefono> getDirectorio() {
        return directorio;
    }
    
    //métodos de la agregación
    public void agregarTelefono(Telefono telefono) {
        directorio.add(telefono);
    }

    public void actualizarTelefono(Telefono telefono) {
        //El contains busca un telefono por su codigo mediante el equals
        if (directorio.contains(telefono)) {
            //El indexof busca la pocicion de un telefono por su codigo mediante el equals
            int index = directorio.indexOf(telefono);
            directorio.set(index, telefono);
        }
    }

    public void eliminarTelefono(Telefono telefono) {
        if (directorio.contains(telefono)) {
            int index = directorio.indexOf(telefono);
            directorio.remove(index);
        }
    }

    public List<Telefono> listar() {
        return directorio;
    }

    public Telefono buscar(int codigo) {
        Iterator it = directorio.iterator();
        while(it.hasNext()){
            Telefono tf = (Telefono)it.next();
            if(tf.getCodigo()==codigo){
                return tf;
            }
        }
        return null;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.correo);
        hash = 37 * hash + Objects.hashCode(this.contrasena);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrasena=" + contrasena + ", directorio=" + directorio + '}';
    }
    
}
