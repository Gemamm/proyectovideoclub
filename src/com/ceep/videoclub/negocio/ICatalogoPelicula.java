package com.ceep.videoclub.negocio;

//CAPA LOGICA
//ME DEVUELVE LOS OBJETOS DE LAS PELICIULAS
public interface ICatalogoPelicula {

    //Agregar una película al catálogo
    void agregarPelicula(String nombrePelicula, String nombreCatalogo);

    //Mostrar todad las películas del catálogo
    void listarPeliculas(String nombreCatalogo);

    //Busca película en nuetro catálogo. Recibe el nombre y el criterio de búsqueda
    void buscarPelicula(String nombreCatalogo, String buscar);

    //inicia nuestro catálogo
    void iniciarCatalogo(String nombreCatalogo);

}
