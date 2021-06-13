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
    String[] categorias = new String[10];
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
        prestamoPeliculas();
        Devolucion();
    }
    public static void main(String[] args) {
        Memorabilia peli = new Memorabilia();
    }
    public void prestamoPeliculas() {
        mostrarClientes();
        System.out.print("Escriba el numero de cliente: ");
        int cliente = sca.nextInt();
        if (peliprestada[cliente-1]==false) {
            imprimirPeliculasDisponibles();
            int numPel = sca.nextInt();
            System.out.println("Escriba el numero de dias a prestar");
            int dias = sca.nextInt();
            realizarPrestamo((cliente-1), (numPel-1), dias);
        }else{
            System.out.println("El cliente no puede perdir otra pelicula");
        }
        
    }
    public void realizarPrestamo(int indiceCliente, int indicePel, int numdias){
        peliprestada[indiceCliente] = true;
        Disponible[indicePel] = false;
        id_anio_Prest[indicePel][2]++;

        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i][0]==0) {
                prestamos[i][0] = id_anio_Prest[indicePel][0];
                prestamos[i][1] = id_telefono[indiceCliente][0];
                prestamos[i][2] = numdias;
                
                peli_clie[i][0] = nombrePeli_Ca[indicePel][0];
                peli_clie[i][1] = nombreCliente[indiceCliente];
            } 
        }
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

    public void mostrarClientes() {

        for (int i = 0; i < cantidadClientes; i++) {
            if (nombreCliente[i] != null) {
                System.out.println((i+1)+".  ID: "+id_telefono[i][0]+",   Nombre: "+nombreCliente[i]+",   Telefono: "+id_telefono[i][1]+",  Estado de Prestamo: "+estadoCliente(peliprestada[i]));
            }
        }
    }

    public String estadoCliente(boolean estado) {
        String estadoCliente;

        if (estado == true) {
            estadoCliente = "Activo";
        } else {
            estadoCliente = "No activo";
        }
        return estadoCliente;
    }

    public void imprimirPeliculasDisponibles(){

        System.out.println("Peliculas Disponibles");

        for (int i = 0; i < cantidadClientes; i++) {
            if (id_anio_Prest[i][0] != 0 && Disponible[i]==true) {            
                System.out.println((i+1)+".  ID: "+id_anio_Prest[i][0]+",   Nombre: "+nombrePeli_Ca[i][0]+",   Anio: "+id_anio_Prest[i][1]+",   Categoria: "+nombrePeli_Ca[i][1]);
            }
        }

    }
    public void mostrarTodasPeliculas(){

        System.out.println("Peliculas");

        for (int i = 0; i < cantidadClientes; i++) {
            if (id_anio_Prest[i][0] != 0) {
                System.out.println((i+1)+".  ID: "+id_anio_Prest[i][0]+",   Nombre: "+nombrePeli_Ca[i][0]+",   Anio: "+id_anio_Prest[i][1]+",   Categoria: "+nombrePeli_Ca[i][1]+",   Estado: "+estadoPelicula(Disponible[i]));
            }
        }

    }

    public void Devolucion(){

       // Devolución de películas: Para esto debe mostrar las películas prestadas incluyendo
//nombre de la película y el nombre del cliente. Seleccionar la película a devolver y
//modificar el estado del cliente y la película, dejando en disponibilidad.
        /*System.out.println("ID del cliente");
        int idcliente= sca.nextInt();
        System.out.println("ID de la pelicula");
        int idpelicula = sca.nextInt();
        for (int i = 0; i < cantidadClientes; i++) {
            //if (id_anio_prestamo[i][0] != 0 && disponible[i]==true) {
            if (id_telefono[i][0] == idcliente && idpelicula == id_anio_Prest[i][0]) {

                System.out.println((i+1)+".  ID: "+id_anio_Prest[i][0]+",   Nombre: "+nombrePeli_Ca[i][0]+",   Anio: "+id_anio_Prest[i][1]+",   Categoria: "+nombrePeli_Ca[i][1]+",   Estado: "+estadoPelicula(Disponible[i]));
                Disponible[idpelicula] = true;
            } 
        }*/
        for (int i = 0; i < cantidadClientes; i++) {
            if (Disponible[i] == true) {
                System.out.println("Nombre: "+nombrePeli_Ca[i][0]+" Cliente: "+nombreCliente[i]+" ID CLIENTE: "+id_telefono[i][0]);
            }
            
        }
        System.out.println("Ingrese el ID del cliente");
        int idcliente= sca.nextInt();
        for (int i = 0; i < Disponible.length; i++) {
            if (idcliente == id_telefono[i][0]) {
                Disponible[i] = true;
                peliprestada[i] = false;

            }
            
        }
        

        
    }
    public void RegistrarPersona(){
        System.out.println("Ingrse su nombre");
        String nombre = sca.nextLine();
        for(int i = 0; i<cantidadClientes;i++ ){
            if(nombre != nombreCliente[i] && nombreCliente[i] == ""){
                nombreCliente[i] = nombre;
                System.out.println("ingrese su telefono ");
                int telefono = sca.nextInt();
                id_telefono[i][1] = telefono;
                int ID = (int)(Math.random()*(999-100)+100);
                id_telefono[i][0] = ID;
                peliprestada[i] = false;
        }
        

        }

    }
    


}