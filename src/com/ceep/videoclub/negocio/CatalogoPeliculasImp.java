package com.ceep.videoclub.negocio;

import com.ceep.videoclub.datos.*;
import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.AccesoDatosEx;
import com.ceep.videoclub.excepciones.EscrituraDatosEx;
import com.ceep.videoclub.excepciones.LecturaDatosEx;
import java.io.File;
import java.util.*;
/*import java.util.logging.Level;
import java.util.logging.Logger;*/

/*import java.util.logging.Level; NO LOS VAMOS A USAR
import java.util.logging.Logger;*/

public class CatalogoPeliculasImp implements ICatalogoPelicula {

    //creamos variable para recorrer el array list. OJO A LA INTERFACE
    private final IAccesoDatos DATOS;
    //esto crea un canal de comunicación para acceder a sus operaciones

    //creo el constructor para poder crear el objeto
    public CatalogoPeliculasImp() {
        this.DATOS = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreCatalogo) {
        //CREAR OBJ PELICULA, con el constructor con el parámetro
        //Pelicula nuevaPelicula = new Pelicula(nombrePelicula);
        //HAGO TRY CATCH X ESCRIBIR (que puede dar excepción)
        try {
            if (this.DATOS.existe(nombreCatalogo)){
                this.DATOS.escribir(new Pelicula(nombrePelicula), nombreCatalogo, true);
            }else{
                System.out.println("Catálogo no inicializado");
            }
            
        } catch (EscrituraDatosEx ex) {
             System.out.println("Error lectura desde Catálogo agreagarPelicula");
             ex.printStackTrace(System.out);
            /*Logger.getLogger(CatalogoPeliculasImp.class.getName()).log(Level.SEVERE, null, ex);*/
        }
    }

    @Override
    public void listarPeliculas(String nombreCatalogo) {
        //Accedo a través de los objetps crados en mi array list
        List<Pelicula> peliculasALCat = new ArrayList<>();
        try {
            peliculasALCat = this.DATOS.listar(nombreCatalogo);
            peliculasALCat.forEach(pelicula -> {
                System.out.println("pelicula: " + pelicula.getNombre());
            });
        } catch (LecturaDatosEx ex) {
            System.out.println("Error lectura desde Catálogo películasImp");
            ex.printStackTrace(System.out); //Devuelve los errorez
            /*Logger.getLogger(CatalogoPeliculasImp.class.getName()).log(Level.SEVERE, null, ex);*/
        }
    }

    @Override
    public void buscarPelicula(String nombreCatalogo, String buscar) {
       
         var archivo = new File(nombreCatalogo);
        try {
            System.out.println(this.DATOS.buscar(nombreCatalogo, buscar));
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace();
            System.out.println("Error al buscar el archivo");
        }
    }

    @Override
    public void iniciarCatalogo(String nombreCatalogo) {

    }

}
