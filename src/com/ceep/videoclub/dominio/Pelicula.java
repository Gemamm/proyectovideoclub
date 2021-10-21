/*
1º el paquete de excepciones
2º paquete dominio, ya podemos instanciar objetros de "Película"
3º capa de acceso a datos (Interface y clase)
    en la interface pongo Throws de los métodoa wue puede que me generen una excepcion
    a) la interface
    b) la clase con los métodos 
La capa de acceso a datos tiene las operaciones de acceso a datos,
Iré recorriendo el fichero Y cada línea será una película
La clase hará uso de la enidad película
La info del fichero la convertirá a objetos para pasarlos a la capa negocio,
donde está el catálogo películas. ListarPeliculas recorre un archivo, está por 
encima de la capa backend. La capa de catálogo no ve la capa de acceso a datos,
accede a los objetos
El catálogo accede a los objetos de la capa acceso a datos
Cada capa "tapa la anterior"
La capa Acceso a datos va accediendo a file y creando objetos (método listar) y devuelve un listado
listar lee info, pasa a objetos y devuelve el listado <list>
El catálogo muestra cada 9un ade lasa películas

La vista será la capa PRINCIPAL
    - accederá a la capa catálogo de películas (que es la siguiente capa)

Desde la capa vista:  -> listar de CATALOGO -> listrar de ACCESO A DATOS -> leer FILE (el archivo bbdd)
"BAJO ACOPLAMIENTO Y ALTA COHESIÓN"

4ª vamos a la capa de negocio
*/
package com.ceep.videoclub.dominio;

public class Pelicula {

    private String nombre;

    public Pelicula() {
    }

    public Pelicula(String nombre) {
        this();//llamanda al constructor vacío
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre;
    }

    //podemos incluir el equal y el hashcode
}
