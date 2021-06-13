package src;

public class Memorabilia{

    public Memorabilia(){
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
    }
    public static void main(String[] args) {
        Memorabilia peli = new Memorabilia();
    }



}