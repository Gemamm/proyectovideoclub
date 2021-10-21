package com.ceep.videoclub.datos;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.*;
/*import com.ceep.videoclub.excepciones.AccesoDatosEx;
import com.ceep.videoclub.excepciones.EscrituraDatosEx;
import com.ceep.videoclub.excepciones.LecturaDatosEx;*/
import java.util.*;
import java.io.*;

//se llama -IMPL de implementación :)
public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo)  {
        File archivo = new File(nombreArchivo);
        return true;
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        List<Pelicula> peliculasArrayList = new ArrayList<>();//para almacenr los obejtos
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null) { //hasta null
                //SI ENCUATRA UNA LÍNEA LO CONVIETE A OBJETO
                peliculasArrayList.add(new Pelicula(lectura));
                //avanzamos en la lectura
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las películas (FileNoFound)");

        } catch (IOException e) { //excepciones de E/S (lectura y escritura)
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las películas (IO)");
        }
        return peliculasArrayList;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        //PEGO EL CODIGO DE AGREGAR (escribir sobreescribe)
         //Declaramos obj tipo File
        File archivo = new File(nombreArchivo);
        try {
            //Invocamos al FileWriter para poder anexar la información y no spobreeescribir
            var salida = new PrintWriter(new FileWriter(nombreArchivo, true));//new File para que no sobreescriba
            //true xa que anexe info
            salida.println(pelicula.getNombre());
            salida.close();
        }  catch (IOException e) { //excepciones de E/S (lectura y escritura)
            e.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepción al escribir el archivo");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
         var archivo = new File(nombreArchivo);
        var resultado = "";
        try {
            //entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //nos devuelve una linea de nuestro archivo 
            var lectura = entrada.readLine();
            var i = 0;
            while(!lectura.equalsIgnoreCase(buscar)){
                i++;
                // Avanzamos en la lectura
                lectura = entrada.readLine();
            }
            resultado = "\nLa pelicula: " + buscar + ", está en la posición "+ i;
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
        return resultado;
    }

    @Override
    public String crear(String nombreArchivo) throws AccesoDatosEx {
        return "";
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {

    }

    
}
