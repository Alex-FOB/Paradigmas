package App;

import Models.gestor;
import java.util.Scanner;


public class App {
    public static void prueba(gestor manejador){
        manejador.cargarViajero(5, "42805869", "Alejandro", "Magno", 42);
        manejador.cargarViajero(36, "42159123", "Miles", "Morales", 40);
        manejador.cargarViajero(24, "42654879","Pepperoni", "Pizza", 10);
        manejador.cargarViajero(101, "42123684", "Miguel", "Ohana", 42);
        //manejador.mostrarViajero(0);
        //manejador.consultarMillas("42654879");
        //manejador.acumMillas("42654879", 9);
        //manejador.canjMillas("42159123", 10);
        //manejador.mejorViajero();
    }
    public static void opcionMenu(Integer op, gestor manejador){
        Scanner input = new Scanner(System.in);
        try{
            Integer nro;
            Integer millas;
            String dni;
            switch(op){
                case 1:
                    System.out.println("----CREACION DE USUARIO----\nIngresar:\n1.- Nro del viajero\n2.- DNI del viajero\n3.- Nombre del viajero\n4.- Apellido del viajero\n5.- Millas del viajero\n----------");
                    nro = input.nextInt();
                    dni = input.next();
                    String nom = input.next();
                    String ape = input.next();
                    millas = input.nextInt();
                    manejador.cargarViajero(nro, dni, nom, ape, millas);
                    input.next();
                    break;
                case 2:
                    System.out.println("----MOSTRAR VIAJERO----\n-> Ingrese el nro. del viajero: ");
                    nro = input.nextInt();
                    manejador.mostrarViajero(nro);
                    input.next();
                    break;
                case 3:
                    System.out.println("----CONSULTAR MILLAS----\n-> Ingrese el dni del viajero: ");
                    dni = input.next();
                    manejador.consultarMillas(dni);
                    input.next();
                    break;
                case 4:
                    System.out.println("----ACUMULAR MILLAS----\n1.- Ingrese dni del viajero\n2.- Cantidad de millas");
                    dni = input.next();
                    millas = input.nextInt();
                    manejador.acumMillas(dni, millas);
                    input.next();
                    break;
                case 5:
                    System.out.println("----CANJEAR MILLAS----\n1.- Ingrese dni del viajero\n2.- Cantidad de millas");
                    dni = input.next();
                    millas = input.nextInt();
                    manejador.canjMillas(dni, millas);
                    input.next();
                    break;
                case 6:
                    System.out.println("----MEJORES VIAJEROS----");
                    manejador.mejorViajero();
                    input.next();
                    break;
                case 7:
                    System.out.println("FINALIZANDO EJERCICIO ...");
                    input.next();
                    break;
            }
        } catch(Exception error){
            System.out.println("ERROR: datos de entrada invalidos");
            input.nextInt();
        }
    }
    public static void main(String[] args) throws Exception {
        Integer opcion = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese cantidad: ");
        Integer cant = input.nextInt();
        gestor manejador = new gestor(cant);
        prueba(manejador);
        while(opcion != 7){
            try{
                System.out.println("----MENU----\n1.- Cargar viajero\n2.- Mostrar viajero\n3.- Consultar cantidad de millas\n4.- Acumular millas\n5.- Canjear millas\n6.- Mejor viajero\n7.- Salir");
                opcion = input.nextInt();
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor(); //PARA LIMPIAR LA CONSOLA
                opcionMenu(opcion, manejador);
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor(); //PARA LIMPIAR LA CONSOLA
            } catch (Exception error){
                System.out.println("ERROR: opcion invalida");
                input.nextInt();
            }
        }
    }
}
