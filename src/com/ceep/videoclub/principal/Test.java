package com.ceep.videoclub.principal;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.negocio.CatalogoPeliculasImp;
import com.ceep.videoclub.negocio.ICatalogoPelicula;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        //Creamos puente de comuniucacion con Catalogo
       var option = -1;
       var nombrePeli = "";
       var lectura = new Scanner(System.in);
        var nombreCatalogo = "Videoclub.txt";
        ICatalogoPelicula catalogo = new CatalogoPeliculasImp();
      
        catalogo.agregarPelicula("Matrix", nombreCatalogo);
        while (option != 0){
            System.out.println("Elige una de las opciones: \n"
                    + "1.- Catalogo peliculas. \n"
                    + "2.- Agregar pelicula. \n"
                    + "3.- Listar peliculas. \n"
                    + "4.- Buscar pelicula. \n"
                    + "0.- Salir\n");
           option = Integer.parseInt(lectura.nextLine());
           
           switch (option){
               case 1:
                    catalogo.iniciarCatalogo(nombreCatalogo);
                    System.out.println("Catalogo inicado...");
                    break;
                case 2:
                    System.out.print("Introduce la pelicula:\t");
                    nombrePeli = lectura.nextLine();
                    catalogo.agregarPelicula(nombrePeli, nombreCatalogo);
                    System.out.println("Se ha agrgado la " + nombrePeli + "al catalogo"
                    +nombreCatalogo);
                    break;
                case 3:
                    catalogo.listarPeliculas(nombreCatalogo);
                    

                    break;
                case 4:
                    System.out.print("Introduce la pelicula a buscar:\t");
                    nombrePeli = lectura.nextLine();
                    catalogo.buscarPelicula(nombreCatalogo, nombrePeli);
                    break;
                case 0:
                    System.out.println("Gracias!, hasta la proxima");
                    break;
                default:
                    System.out.println("Opción desconocida");
           }
        }
       /* while (true) {
            System.out.println("MENU");
            System.out.println(" 1.- Catalogo peliculas");
            System.out.println(" 2.- Agregar pelicula");
            System.out.println(" 3.- Listar peliculas");
            System.out.println(" 4.- Buscar pelicula");
            System.out.println(" 0.- Salir");
            System.out.print("Indica la opción deseada: ");
            Scanner sn = new Scanner(System.in);
            Scanner peli = new Scanner(System.in);
            Scanner busqueda = new Scanner(System.in);
            int opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogo(nombreCatalogo);
                    break;
                case 2:
                    System.out.print("Introduce la pelicula:\t");
                    String nombrePeli = peli.nextLine();
                    catalogo.agregarPelicula(nombrePeli, nombreCatalogo);
                    break;
                case 3:
                    catalogo.listarPeliculas(nombreCatalogo);

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
        }*/

    }

}
