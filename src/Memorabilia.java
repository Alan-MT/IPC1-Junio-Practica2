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
        Ejemplo();
        int opion = 0;
        do {
            System.out.println("MENU");
            System.out.println("1. Prestamos de peliculas");
            System.out.println("2. Devolucion de peliculas");
            System.out.println("3. Mostrar peliculas");
            System.out.println("4. Ingresar Peliculas");
            System.out.println("5. Ingresar Clientes Nuevos");
            System.out.println("6. Mostrar Clientes");
            System.out.println("7. Reportes");
            System.out.println("8. Salir");
            System.out.println("Escribe el numero de la opcion");
            opion = sca.nextInt();
            switch (opion) {
                case 1:
                    prestamoPeliculas();
                    break;
                case 2:
                    Devolucion();
                    break;
                case 3:
                    mostrarTodasPeliculas();
                    break;
                case 4:
                    ingresoPeliculas();
                    break;
                case 5:
                    RegistrarPersona();
                    break;
                case 6:
                    mostrarClientes();
                    break;
                case 7:
                    Reportes();
                    break;
                case 8:
                    System.out.println("hasta pronto");
                    break;
                default:
                    System.out.println("No existe esta opcion");
                    break;
            }
        } while (opion != 8);

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
        } else if (peliprestada[cliente - 1] == true) {
            System.out.println("El cliente no puede perdir otra pelicula");
        } else {
            System.out.println("Cliente no encontrado");

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
                break;
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
        for (int i = 0; i < prestamos.length; i++) {
            if (peli_clie[i][0] != null) {
                System.out.println("Numero de Prestamo: "+(i+1)+"   Pelicula: " + peli_clie[i][0] + "   Cliente: " + peli_clie[i][1] + "   ID CLIENTE: "
                        + prestamos[i][1]);
            }
        }

        System.out.print("\nIngrese el numero de prestamo: ");
        int numPrestamo = sca.nextInt();
        prestamos[numPrestamo-1][2] = 0;

        for (int i = 0; i < cantidadClientes; i++) {
            if (prestamos[numPrestamo-1][1] == id_telefono[i][0]) {
                peliprestada[i] = false;
                prestamos[numPrestamo-1][1] = 0;
                break;
            }
        }

        for (int i = 0; i < cantidadClientes; i++) {
            if (prestamos[numPrestamo-1][0] == id_anio_Prest[i][0]) {
                Disponible[i] = true;
                prestamos[numPrestamo-1][0] = 0;
                break;
            }
        }
    }

    public void RegistrarPersona() {
        System.out.println("Ingrese su nombre");
        String nombre = sca.next();
        for (int i = 0; i < cantidadClientes; i++) {
            if (nombreCliente[i] == null) {
                nombreCliente[i] = nombre;
                System.out.println("ingrese su telefono ");
                int telefono = sca.nextInt();
                id_telefono[i][1] = telefono;
                int id = generarID();
                id_telefono[i][0] = id;
                peliprestada[i] = false;
                break;

            }

        }

    }

    public int generarID() {
        int ID = 0;
        for (int i = 0; i < cantidadClientes; i++) {
            ID = (int) (Math.random() * (999 - 100) + 100);
            if (id_telefono[i][0] != ID && id_telefono[i][0] == 0) {
                break;
            }
        }
        return ID;
    }

    public void ingresoPeliculas() {
        System.out.print("\nIngrese el nombre de la pelicula: ");
        String nombrepeli = sca.nextLine();
        String categoria = asignarCategoria();
        System.out.print("\nIngrese el anio de la pelicula: ");
        int anio = sca.nextInt();
        int id = generarIdPeliculas();
        for (int i = 0; i < cantidadClientes; i++) {
            if (nombrePeli_Ca[i][0] == null) {
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

    public int generarIdPeliculas() {
        int ID = 0;
        for (int i = 0; i < cantidadClientes; i++) {
            ID = (int) (Math.random() * (100 - 1) + 1);
            if (id_anio_Prest[i][0] != ID && id_anio_Prest[i][0] == 0) {
                break;
            }
        }
        return ID;
    }

    public void ordenarString() {
        for (int i = 0; i < cantidadClientes; i++) {
            for (int j = 0; j < cantidadClientes - 1; j++) {
                if ((nombrePeli_Ca[j][0] != null) && (nombrePeli_Ca[j + 1][0] != null)
                        && (nombrePeli_Ca[j][0].compareToIgnoreCase(nombrePeli_Ca[j + 1][0]) > 0)) {
                    String auxiliar = nombrePeli_Ca[j][0];
                    nombrePeli_Ca[j][0] = nombrePeli_Ca[j + 1][0];
                    nombrePeli_Ca[j + 1][0] = auxiliar;

                    auxiliar = nombrePeli_Ca[j][1];
                    nombrePeli_Ca[j][1] = nombrePeli_Ca[j + 1][1];
                    nombrePeli_Ca[j + 1][1] = auxiliar;

                    int auxi = id_anio_Prest[j][0];
                    id_anio_Prest[j][0] = id_anio_Prest[j + 1][0];
                    id_anio_Prest[j + 1][0] = auxi;

                    auxi = id_anio_Prest[j][1];
                    id_anio_Prest[j][1] = id_anio_Prest[j + 1][1];
                    id_anio_Prest[j + 1][1] = auxi;

                    auxi = id_anio_Prest[j][2];
                    id_anio_Prest[j][2] = id_anio_Prest[j + 1][2];
                    id_anio_Prest[j + 1][2] = auxi;

                    boolean aux = Disponible[j];
                    Disponible[j] = Disponible[j + 1];
                    Disponible[j + 1] = aux;
                }
            }
        }
    }

    public void Reportes() {
        System.out.println("\n Reportes");
        System.out.println("1. Cantidad de peliculas por categoria: ");
        System.out.println("2. Peliculas por Categoria: ");
        System.out.println("3. Cantidad de prestamos por peliculas: ");
        System.out.println("4. Peliculas mas prestadas y menos prestada");
        System.out.print("Seleccione una opcion: ");
        int num = sca.nextInt();
        switch (num) {
            case 1:
                System.out.println("peliculas por categoria");
                int[] contadora = new int[5];
                contadoresCategoria(contadora);
                break;
            case 2:
                System.out.println("\nPeliculas por Categoria Especifica");
                buscarCategoriaEspecifica();
                break;
            case 3:
                imprimirPeliculasPrestadas();
                break;
            case 4:
                String masPrestadas = "", menosPrestads = "";
                manejarCategoria(masPrestadas, menosPrestads);
            default:
                System.out.println("numero incorrecto");
                break;
        }
    }

    public String asignarCategoria() {
        System.out.print("\nSeleccione la categoria de la pelicula: ");
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + "." + categorias[i]);
        }
        System.out.println("Escriba el numero de la categoria");
        int categoriaPelicua = sca.nextInt();
        return categorias[categoriaPelicua - 1];
    }

    public void manejarCategoria(String masPrestadas, String menosPrestda) {
        int mayor = 0, menor = 100;
        for (int i = 0; i < cantidadClientes; i++) {
            if (nombrePeli_Ca[i][0] != null) {
                if (id_anio_Prest[i][2] != 0 && id_anio_Prest[i][2] > mayor) {
                    mayor = id_anio_Prest[i][2];
                    masPrestadas = nombrePeli_Ca[i][0];
                }
                if (id_anio_Prest[i][2] < menor) {
                    menor = id_anio_Prest[i][2];
                    menosPrestda = nombrePeli_Ca[i][0];
                }
            }

        }
        System.out.println("\nPelicula Mas Prestada: " + masPrestadas);
    
        System.out.println("\nPelicula Menos Prestada: " + menosPrestda);
    }

    public void imprimirPeliculasPrestadas() {
        for (int i = 0; i < cantidadClientes; i++) {
            if (nombrePeli_Ca[i][0] != null) {
                System.out.println("Pelicula " + nombrePeli_Ca[i][0] + "  Prestamos  " + id_anio_Prest[i][2]);
            }

        }
    }

    public void contadoresCategoria(int[] contador) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (nombrePeli_Ca[i][0] != null && nombrePeli_Ca[i][1].equals(categorias[0])) {
                contador[0]++;
            } else if (nombrePeli_Ca[i][1] != null && nombrePeli_Ca[i][1].equals(categorias[1])) {
                contador[1]++;
            } else if (nombrePeli_Ca[i][2] != null && nombrePeli_Ca[i][1].equals(categorias[2])) {
                contador[2]++;
            } else if (nombrePeli_Ca[i][3] != null && nombrePeli_Ca[i][1].equals(categorias[3])) {
                contador[3]++;
            } else if (nombrePeli_Ca[i][4] != null && nombrePeli_Ca[i][1].equals(categorias[4])) {
                contador[4]++;
            }

        }
        for (int i = 0; i < contador.length; i++) {
            System.out.println(categorias[i] + ": " + contador[i]);
        }
    }

    public void buscarCategoriaEspecifica() {
        String categ = asignarCategoria();
        System.out.println("Categoria de pelicula " + categ);
        int contador = 0;

        for (int i = 0; i < cantidadClientes; i++) {
            if (nombrePeli_Ca[i][1] != null && nombrePeli_Ca[i][1].equals(categ)) {
                System.out.println(" -> " + nombrePeli_Ca[i][0]);
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("   Aun no hay peliculas de esta categoria.");
        }
    }

    public void Ejemplo() {
        categorias[0] = "Romanticas";
        categorias[1] = "Ciencias Ficcion";
        categorias[2] = "Comedia";
        categorias[3] = "Terror";
        categorias[4] = "Accion";

        nombreCliente[0] = "Juan";
        nombreCliente[1] = "Jose";
        nombreCliente[2] = "Alan";
        nombreCliente[3] = "Mich";
        nombreCliente[4] = "Otto";
        id_telefono[0][0] = 120;
        id_telefono[1][0] = 230;
        id_telefono[2][0] = 300;
        id_telefono[3][0] = 304;
        id_telefono[4][0] = 430;
        id_telefono[0][1] = 58493843;
        id_telefono[1][1] = 58493812;
        id_telefono[2][1] = 58493823;
        id_telefono[3][1] = 58493834;
        id_telefono[4][1] = 58493845;
        peliprestada[0] = true;
        peliprestada[1] = false;
        peliprestada[2] = true;
        peliprestada[3] = false;
        peliprestada[4] = true;
        nombrePeli_Ca[0][0] = "El señor de los anillos";
        nombrePeli_Ca[1][0] = "Star Wars episodio 9";
        nombrePeli_Ca[2][0] = "Spiderman";
        nombrePeli_Ca[3][0] = "El conjuro";
        nombrePeli_Ca[4][0] = "MIsion immposible";
        nombrePeli_Ca[0][1] = categorias[1];
        nombrePeli_Ca[1][1] = categorias[1];
        nombrePeli_Ca[2][1] = categorias[1];
        nombrePeli_Ca[3][1] = categorias[3];
        nombrePeli_Ca[4][1] = categorias[4];
        id_anio_Prest[0][0] = 45;
        id_anio_Prest[1][0] = 90;
        id_anio_Prest[2][0] = 43;
        id_anio_Prest[3][0] = 56;
        id_anio_Prest[4][0] = 67;
        id_anio_Prest[0][1] = 1998;
        id_anio_Prest[1][1] = 2018;
        id_anio_Prest[2][1] = 2000;
        id_anio_Prest[3][1] = 2010;
        id_anio_Prest[4][1] = 2008;
        id_anio_Prest[0][2] = 1;
        id_anio_Prest[1][2] = 1;
        id_anio_Prest[2][2] = 1;
        id_anio_Prest[3][2] = 1;
        id_anio_Prest[4][2] = 1;
        Disponible[0] = false;
        Disponible[1] = true;
        Disponible[2] = false;
        Disponible[3] = true;
        Disponible[4] = false;

    }
}
