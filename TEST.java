package com.mycompany.test;

import java.util.Scanner;
import java.util.Random;

public class TEST{
    
    // Tablero de juego
    static int opcion;
    static String[][] tablero = new String[8][8];
    static String[][] penalizaciones = new String[8][8];
    
    // Scanner global de numeros y letras
    static Scanner inputData = new Scanner(System.in);
    static Scanner inputString = new Scanner(System.in);
    
    //Posicion y jugador
    static String ficha = "@"; 
    public static int posicion = 1;
    
    //Penalizacion
    public static int penalizacionnivel = -99;

    public static void main(String[] args) {
           
        do{
            System.out.println("==============Menú Principal============");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Retomar Juego");
            System.out.println("3. Mostrar información del estudiante");
            System.out.println("4. Salir");
            System.out.println("=======================================");
            System.out.print("Elige una opción: ");
            opcion = inputData.nextInt();
            menu_opcion (opcion);
        }while (opcion!= 4);
    }
    
    public static void menu_opcion(int opcion_){
        
        switch(opcion){
            case 1:
                System.out.println("JUEGO INICIADO");
                Tablero();
                PenalizacionesDificultad(); 
                seleccionaropcion();
                break;
                
            case 2:
                System.out.println("JUEGO RETOMADO");
                break;
                
            case 3:
                System.out.println("Nombra: Angel David Marinez García");
                System.out.println("Carnet: 202300410");
                System.out.println("CUI: 3037960140110");
                break;
            
            case 4: 
                System.out.println("GRACIAS POR USAR EL JUEGO ");
                break;
                
            default:
                System.out.println("NUMERO NO VALIDO");
        }
    }
    
    public static void Tablero() {
        int contador = 1;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = String.valueOf(contador);
                contador++; //contador=contador+1
            }
        }

        for (int i = 0; i < penalizaciones.length; i++) {
            for (int j = 0; j < penalizaciones[i].length; j++) {
                penalizaciones[i][j] = "";
            }
        }
    }
    
    public static void Penalizaciones() {
        
        Random random = new Random();

        int cantpen;
        int posrandom;
        for (int i = 0; i < penalizaciones.length; i++) {

            cantpen = random.nextInt(3) + 2;

            while (cantpen != 0) {
                
                while (true) {
                    
                    posrandom = random.nextInt(penalizaciones[i].length);
                    
                    if (!penalizaciones[i][posrandom].contains("#")) {
                        break;
                    }
                }
                penalizaciones[i][posrandom] = "#" + penalizaciones[i][posrandom];
                cantpen--;
            }
        }    
    }
    
    public static void numeraciontab (){
        
        System.out.println("=========================");
        boolean tab = false;
        String casillas;
        
        for (int i = tablero.length -1; i >=0; i--) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("+-----");
            }
            System.out.println("+");
            
            
            for (int j = tablero.length-1; j >= 0; j--) {
               
                if (tab == true) {
                    
                    casillas = penalizaciones[i][j]+tablero[i][j];
                    System.out.printf("| %4s", casillas);
                } else{
                        casillas = penalizaciones[i][(tablero.length - 1) - j] + tablero[i][(tablero.length - 1) - j];
                        System.out.printf("| %4s", casillas);
                        }
            }
            System.out.println("|");
            
              for (int j = tablero.length - 1; j >= 0; j--) {
                if (tab == true) {
                    if (posicion == Integer.parseInt(tablero[i][j])) {
                        System.out.printf("| %4s ", ficha);

                        if (penalizaciones[i][j].contains("#")) {
                            penalizacionnivel = i + 1;
                        }
                    } else {
                        System.out.printf("| %4s ", " ");
                    }
                } else {

                    if (posicion == Integer.parseInt(tablero[i][(tablero.length - 1) - j])) {
                        System.out.printf("| %4s ", ficha);
                        if (penalizaciones[i][(tablero.length - 1) - j].contains("#")) {
                            penalizacionnivel = i + 1;
                        }
                    } else {
                        System.out.printf("| %4s ", " ");
                    }
                }
            }
              
              System.out.println("|");
              tab = !tab;
        }
        
        for (int j = 0; j < 8; j++) {

            System.out.print("+------");
        }
        System.out.println("+");
    }
    
    public static void seleccionaropcion(){
        
        String elegir;
        Random random = new Random();
        int dado;
        do {
            if (posicion > 64) {
                System.out.println(" Ganaste el juego");
                break;
            }
            numeraciontab();

            PenalizacionesDificultad();
            System.out.println(" Lanzar dado (d)");
            System.out.println(" Pausar Juego (p)");
            elegir = inputString.nextLine();

            if (elegir.equals("d")) {
                dado = random.nextInt(6) + 1;
                System.out.println("El dado indica que avanzaras " + dado+ " casillas");
                posicion += dado; 
            } else if (elegir.equals("p")) {
                System.out.println("Juego pausado");
            } else {
                System.out.println("Opcion no valida");
            }
        } while (!elegir.equals("p"));    
    }
    
    public static void PenalizacionesDificultad(){
        if (penalizacionnivel == 1 || penalizacionnivel == 2) { 
            System.out.println("Estoy en nivel facil de penalizacion");
        } else if (penalizacionnivel == 3 || penalizacionnivel == 4 || penalizacionnivel == 5) {
            System.out.println("Estoy en nivel intermedio de penalizacion");
        } else if (penalizacionnivel == 6 || penalizacionnivel == 7 || penalizacionnivel == 8) {
            System.out.println("Estoy en nivel dificil de penalizacion");
        }
        penalizacionnivel = -99;
    }
}

    

