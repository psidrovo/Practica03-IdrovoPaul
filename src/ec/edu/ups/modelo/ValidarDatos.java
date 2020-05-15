
package ec.edu.ups.modelo;

import java.util.Scanner;

/**
 * Clase Validar Datos. 
 * 
 * Esta clase contiene metodos que nos ayudaran a validar los datos ingresados
 * por el Scanner, este valida tipo String, tipo Int, tipo Double.
 * 
 * @see Persona
 * 
 * @author Paul Idrovo
 */
public class ValidarDatos {
    /**
     * Metodo Validar String.
     * 
     * Este metodo nos ayuda a validar los datos al ser ingresados por un Scanner
     * comprueba si el dato ingresado es de tipo String y retorna ese String, caso
     * contrario volvera a pedir que se ingrese el valor hasta que sea el tipo String.
     * 
     * @return txt - Parametro tipo String
     */
    public static String validarString(){
        Scanner sc = new Scanner(System.in);
        boolean validar =false;
        String txt="";
        do{
            if(sc.hasNext()){
                txt=sc.next();
                validar = true;
            }else{
                sc.nextLine();
                System.out.println("Formato incorrecto\n Vuelva a ingresar");
            }
        }while(!validar);
        
        return txt;
    }    
    /**
     * Metodo Validar Int.
     * 
     * Este metodo nos ayuda a validar los datos al ser ingresados por un Scanner
     * comprueba si el dato ingresado es de tipo int y retorna ese int, caso
     * contrario volvera a pedir que se ingrese el valor hasta que sea el tipo int.
     * 
     * @return num - Parametro tipo int
     */
    public static int validarInt(){
        Scanner sc = new Scanner(System.in);
        boolean validar =false;
        int num=0;
        do{
            if(sc.hasNextInt()){
                num=sc.nextInt();
                validar = true;
            }else{
                sc.nextLine();
                System.out.println("Formato incorrecto\n Vuelva a ingresar");
            }
        }while(!validar);
        
        return num;
    }    
    /**
     * Metodo Validar Double.
     * 
     * Este metodo nos ayuda a validar los datos al ser ingresados por un Scanner
     * comprueba si el dato ingresado es de tipo double y retorna ese double, caso
     * contrario volvera a pedir que se ingrese el valor hasta que sea el tipo double.
     * 
     * @return num - Parametro tipo double
     */
    public static double validarDouble(){
        Scanner sc = new Scanner(System.in);
        boolean validar =false;
        double num=0;
        do{
            if(sc.hasNextDouble()){
                num=sc.nextDouble();
                validar = true;
            }else{
                sc.nextLine();
                System.out.println("Formato incorrecto\n Vuelva a ingresar");
            }
        }while(!validar);
        
        return num;
    }  
}
