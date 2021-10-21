package com.ceep.videoclub.principal;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.negocio.CatalogoPeliculasImp;
import com.ceep.videoclub.negocio.ICatalogoPelicula;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        //Creamos puente de comuniucacion con Catalogo
        var nombreCatalogo = "Videoclub.txt";
        ICatalogoPelicula catalogo = new CatalogoPeliculasImp();
      
        while (true) {
            System.out.println("MENU");
            System.out.println(" 1.- Catalogo peliculas");
            System.out.println(" 2.- Agregar pelicula");
            System.out.println(" 3.- Listar peliculas");
            System.out.println(" 4.- Buscra pelicula");
            System.out.println(" 0.- Salir");
            System.out.print("Indica la opción deseada: ");
            Scanner sn = new Scanner(System.in);
            Scanner peli = new Scanner(System.in);
            Scanner busqueda = new Scanner(System.in);
            int opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Hola");
                    break;
                case 2:
                    System.out.print("Introduce la pelicula:\t");
                    String nombrePeli = peli.nextLine();
                    catalogo.agregarPelicula(nombrePeli, nombreCatalogo);
                    break;
                case 3:

                    break;
                case 4:
                    System.out.print("Introduce la pelicula a buscar:\t");
                    String buscar = busqueda.nextLine();
                    catalogo.buscarPelicula(nombreCatalogo, buscar);
                    break;
                case 0:
                    System.out.println("Gracias!, hasta la proxima");
                    break;

            }
        }

    }

}
