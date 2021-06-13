package src;

import java.util.Scanner;

public class Memorabilia{

    final int cantidadClientes=30;
    //Clientes
    String[] nombreCliente = new String[cantidadClientes];
    int [][] id_telefono = new int[cantidadClientes][2];
    boolean[] peliprestada = new boolean[cantidadClientes];
    //peliculasx
    String[][] nombrePeli_Ca = new String[cantidadClientes][2];
    int [][] id_anio_Prest = new int[cantidadClientes][3];
    boolean[] Disponible = new boolean[cantidadClientes];
    //prestamos
    //id peli, id cliente, dias prestados
    int[][] prestamos = new int[30][3];
    String[][] peli_clie = new String[30][2];
    Scanner sca = new Scanner(System.in);

    public Memorabilia(){
        System.out.println("MENU");
        System.out.println("1.");
        System.out.println("2.");
        System.out.println("3.");
        System.out.println("4.");
        System.out.println("5.");
        System.out.println("6.");
        System.out.println("7.");
        System.out.println("8.");
        System.out.println("9.");
        System.out.println("Escribe el numero de la opcion");
    }
    public static void main(String[] args) {
        Memorabilia peli = new Memorabilia();
    }
    public void prestamoPeliculas() {

        imprimirPeliculas();
    }

    public void imprimirPeliculas(){

        System.out.println("Peliculas");

        for (int i = 0; i < cantidadClientes; i++) {
            //if (id_anio_prestamo[i][0] != 0 && disponible[i]==true) {
            if (id_anio_Prest[i][0] != 0) {
                System.out.println((i+1)+".  ID: "+id_anio_Prest[i][0]+",   Nombre: "+nombrePeli_Ca[i][0]+",   Anio: "+id_anio_Prest[i][1]+",   Categoria: "+nombrePeli_Ca[i][1]+",   Estado: "+estadoPelicula(Disponible[i]));
            }
        }

    }

    public String estadoPelicula(boolean estado) {
        String estadoPelicula;

        if (estado == true) {
            estadoPelicula = "Disponible";
        } else {
            estadoPelicula = "Prestada";
        }
        return estadoPelicula;
    }
    


}