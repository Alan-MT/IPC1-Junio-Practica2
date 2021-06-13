package src;

import java.util.Scanner;

public class Memorabilia {

    final int cantidadClientes = 30;
    // Clientes
    String[] nombreCliente = new String[cantidadClientes];
    int[][] id_telefono = new int[cantidadClientes][2];
    boolean[] peliprestada = new boolean[cantidadClientes];
    // peliculasx
    String[][] nombrePeli_Ca = new String[cantidadClientes][2];
    int[][] id_anio_Prest = new int[cantidadClientes][3];
    boolean[] Disponible = new boolean[cantidadClientes];
    String[] categorias = new String[5];
    // prestamos
    // id peli, id cliente, dias prestados
    int[][] prestamos = new int[30][3];
    String[][] peli_clie = new String[30][2];
    Scanner sca = new Scanner(System.in);

    public Memorabilia() {
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

        categorias[0] = "Romanticas";
        categorias[1] = "Ciencias Ficcion";
        categorias[2] = "Comedia";
        categorias[3] = "Terror";
        categorias[4] = "Accion";
    }

    public static void main(String[] args) {
        Memorabilia peli = new Memorabilia();
    }

    public void prestamoPeliculas() {
        mostrarClientes();
        System.out.print("Escriba el numero de cliente: ");
        int cliente = sca.nextInt();
        if (peliprestada[cliente - 1] == false) {
            imprimirPeliculasDisponibles();
            int numPel = sca.nextInt();
            System.out.println("Escriba el numero de dias a prestar");
            int dias = sca.nextInt();
            realizarPrestamo((cliente - 1), (numPel - 1), dias);
        } else {
            System.out.println("El cliente no puede perdir otra pelicula");
        }

    }

    public void realizarPrestamo(int indiceCliente, int indicePel, int numdias) {
        peliprestada[indiceCliente] = true;
        Disponible[indicePel] = false;
        id_anio_Prest[indicePel][2]++;

        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i][0] == 0) {
                prestamos[i][0] = id_anio_Prest[indicePel][0];
                prestamos[i][1] = id_telefono[indiceCliente][0];
                prestamos[i][2] = numdias;

                peli_clie[i][0] = nombrePeli_Ca[indicePel][0];
                peli_clie[i][1] = nombreCliente[indiceCliente];
            }
        }
    }

    public void imprimirPeliculas() {
        System.out.println("Peliculas");
        for (int i = 0; i < cantidadClientes; i++) {
            // if (id_anio_prestamo[i][0] != 0 && disponible[i]==true) {
            if (id_anio_Prest[i][0] != 0) {
                System.out.println((i + 1) + ".  ID: " + id_anio_Prest[i][0] + ",   Nombre: " + nombrePeli_Ca[i][0]
                        + ",   Anio: " + id_anio_Prest[i][1] + ",   Categoria: " + nombrePeli_Ca[i][1] + ",   Estado: "
                        + estadoPelicula(Disponible[i]));
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
                System.out.println(
                        (i + 1) + ".  ID: " + id_telefono[i][0] + ",   Nombre: " + nombreCliente[i] + ",   Telefono: "
                                + id_telefono[i][1] + ",  Estado de Prestamo: " + estadoCliente(peliprestada[i]));
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

    public void imprimirPeliculasDisponibles() {

        System.out.println("Peliculas Disponibles");

        for (int i = 0; i < cantidadClientes; i++) {
            if (id_anio_Prest[i][0] != 0 && Disponible[i] == true) {
                System.out.println((i + 1) + ".  ID: " + id_anio_Prest[i][0] + ",   Nombre: " + nombrePeli_Ca[i][0]
                        + ",   Anio: " + id_anio_Prest[i][1] + ",   Categoria: " + nombrePeli_Ca[i][1]);
            }
        }

    }

    public void mostrarTodasPeliculas() {

        System.out.println("Peliculas");

        for (int i = 0; i < cantidadClientes; i++) {
            if (id_anio_Prest[i][0] != 0) {
                System.out.println((i + 1) + ".  ID: " + id_anio_Prest[i][0] + ",   Nombre: " + nombrePeli_Ca[i][0]
                        + ",   Anio: " + id_anio_Prest[i][1] + ",   Categoria: " + nombrePeli_Ca[i][1] + ",   Estado: "
                        + estadoPelicula(Disponible[i]));
            }
        }

    }

    public void Devolucion() {

        // Devolución de películas: Para esto debe mostrar las películas prestadas
        // incluyendo
        // nombre de la película y el nombre del cliente. Seleccionar la película a
        // devolver y
        // modificar el estado del cliente y la película, dejando en disponibilidad.
        /*
         * System.out.println("ID del cliente"); int idcliente= sca.nextInt();
         * System.out.println("ID de la pelicula"); int idpelicula = sca.nextInt(); for
         * (int i = 0; i < cantidadClientes; i++) { //if (id_anio_prestamo[i][0] != 0 &&
         * disponible[i]==true) { if (id_telefono[i][0] == idcliente && idpelicula ==
         * id_anio_Prest[i][0]) {
         * 
         * System.out.println((i+1)+".  ID: "+id_anio_Prest[i][0]+",   Nombre: "
         * +nombrePeli_Ca[i][0]+",   Anio: "+id_anio_Prest[i][1]+",   Categoria: "
         * +nombrePeli_Ca[i][1]+",   Estado: "+estadoPelicula(Disponible[i]));
         * Disponible[idpelicula] = true; } }
         */
        for (int i = 0; i < cantidadClientes; i++) {
            if (Disponible[i] == true) {
                System.out.println("Nombre: " + nombrePeli_Ca[i][0] + " Cliente: " + nombreCliente[i] + " ID CLIENTE: "
                        + id_telefono[i][0]);
            }

        }
        System.out.println("Ingrese el ID del cliente");
        int idcliente = sca.nextInt();
        for (int i = 0; i < Disponible.length; i++) {
            if (idcliente == id_telefono[i][0]) {
                Disponible[i] = true;
                peliprestada[i] = false;

            }

        }
    }

    public void RegistrarPersona(){
        System.out.println("Ingrese su nombre");
        String nombre = sca.nextLine();
        for(int i = 0; i<cantidadClientes;i++ ){
            if(nombre != nombreCliente[i] && nombreCliente[i] == null){
                nombreCliente[i] = nombre;
                System.out.println("ingrese su telefono ");
                int telefono = sca.nextInt();
                id_telefono[i][1] = telefono;
                int id = generarID();
                id_telefono[i][0] = id;  
                peliprestada[i] = false; 
                

        }
        

        }

    }
    
    public int generarID(){
        int ID = 0;
       for (int i = 0; i < cantidadClientes; i++) {
        ID = (int)(Math.random()*(999-100)+100);
           if (id_telefono[i][0]!=ID &&  id_telefono[i][0] == 0) {   
               break;
           }
       }  
        return ID;
    }

    public void ingresoPeliculas(){
        System.out.print("\nIngrese el nombre de la pelicula: ");
        String nombrepeli = sca.nextLine();
        String categoria = asignarCategoria();
        System.out.print("\nIngrese el anio de la pelicula: ");
        int anio = sca.nextInt();
        int id = generarIdPeliculas();
        for (int i = 0; i < cantidadClientes; i++) {
            if (nombrePeli_Ca[i][0]==null) {
                nombrePeli_Ca[i][0] = nombrepeli;
                nombrePeli_Ca[i][1] = categoria;
                id_anio_Prest[i][0] = id;
                id_anio_Prest[i][1] = anio;
                id_anio_Prest[i][2] = 0;
                Disponible[0] = true;
                break;
            }
           
        }
        
        
    }

    public int generarIdPeliculas(){
        int ID = 0;
       for (int i = 0; i < cantidadClientes; i++) {
        ID = (int)(Math.random()*(100-1)+1);
           if (id_anio_Prest[i][0]!=ID &&  id_anio_Prest[i][0] == 0) {   
               break;
           }
       }  
        return ID;
    }

    public void ordenarString() {
        for (int i = 0; i < cantidadClientes; i++) {
            for (int j = 0; j < cantidadClientes-1; j++) {
                if ((nombrePeli_Ca[j][0]!=null)&&(nombrePeli_Ca[j+1][0]!=null)&&(nombrePeli_Ca[j][0].compareToIgnoreCase(nombrePeli_Ca[j+1][0])>0)) {
                    String auxiliar = nombrePeli_Ca[j][0];
                    nombrePeli_Ca[j][0]=nombrePeli_Ca[j+1][0];
                    nombrePeli_Ca[j+1][0]=auxiliar;
                }
            }
        }
    }

    public void Reportes(){
        System.out.println("\n Reportes");
        System.out.println("Cantidad de peliculas por categoria: ");
        int[] contadora = new int[5];
        System.out.println("Peliculas por Categoria: ");

 
        System.out.println("Cantidad de prestamos por peliculas: ");
        imprimirPeliculasPrestadas();
        String masPrestadas = "", menosPrestads = "";
        manejarCategoria(masPrestadas, menosPrestads);
        System.out.println("Peliculas mas prestadas: "+masPrestadas);

        System.out.println("peliculas Menos prestadas: "+menosPrestads);


    }

    public String asignarCategoria(){
        System.out.print("\nSeleccione la categoria de la pelicula: ");
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i+1)+"."+categorias[i]);
        }
        System.out.println("Escriba el numero de la categoria");
        int categoriaPelicua = sca.nextInt();
        return categorias[categoriaPelicua-1];
    }

    public void manejarCategoria(String masPrestadas,String menosPrestda){
        int mayor =0,menor = 100;
        for (int i = 0; i < cantidadClientes; i++) {
            if (id_anio_Prest[i][2]>mayor) {
                mayor = id_anio_Prest[i][2];
                masPrestadas = nombrePeli_Ca[i][0];
            }if (id_anio_Prest[i][2]<menor) {
                menor = id_anio_Prest[i][2];
                menosPrestda = nombrePeli_Ca[i][0];
            }
        }
    }

    public void imprimirPeliculasPrestadas(){
        for (int i = 0; i < cantidadClientes; i++) {
            if (nombrePeli_Ca[i][0]!= null) {
                System.out.println("Pelicula "+nombrePeli_Ca[i][0]+"  Prestamos  "+id_anio_Prest[i][2];  
            }
            
            
        }
    }
}
