
package com.ceep.videoclub.excepciones;

//extiende de exception y lleva constructor con mensaje
public class AccesoDatosEx extends Exception{

    public AccesoDatosEx(String mensaje) {
        super(mensaje); //llamamos al constructor del padre con ese mensaje
    }
    
}
