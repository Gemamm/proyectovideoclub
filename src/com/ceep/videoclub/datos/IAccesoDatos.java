/*Este es el tercer paso, primero las excepciones y luego la clase 
de la que crearé los objetos

la interfaz x defecto tiene métodos PUBLICOS y ABSTRACTOS
    la lógica la definimos en la clase
 */
package com.ceep.videoclub.datos;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.*;
import java.util.*;
/*
En la INTERFACE
podemos omitur la palabra "public" y static, ya que lo es por defecto
2º Valoramos si de estos métodos alguno me puede generar una excepción
    - existe puede generar una excep`ción de acceso a datos: añado throws AccesoDatosEx
    - listar puede generar de lectura
    - buscar de lectura
    - crae de acceso a datos
    - borra de acceso
*/
public interface IAccesoDatos {
    
    //Existe: comprueba si el fichero existe
    boolean existe(String nombreArchivo);//NO NECESITA EXCEPCION

    //OJO! devuelve lista! listar: devuelve un listado de películas, contenido en el archivo nombreArchivo
    List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;

    /*Escribe una nueva pelicula en el archivo nombreArchrivo
    /con el parámetro anexar podemos indicar si queremos agregar 
    la pelicula o sobreescribir*/
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    /*Busca la expresion de buscar en el archivo y 
    nos muestra un mensajer en caso de encontrar o no*/
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    //Crea el archoivo
    void crear(String nombreArchivo) throws AccesoDatosEx;

    //Borra el archivo
    void borrar(String nombreArchivo);
}
