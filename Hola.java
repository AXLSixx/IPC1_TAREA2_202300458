/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hola;

/**
 *
 * @author Axel
 */
import java.util.Scanner;
import java.util.Random;
public class Hola {
    // Tablero de juego
    public static String [][] tablero = new String[8][8];
    public static String [][] penalizaciones = new String[8][8];
    
    // Scanner global de numeros y letras
    public static Scanner inputData = new Scanner(System.in);
    public static Scanner inputString = new Scanner(System.in);
    
    //Posicion y jugador
    public static String ficha = "@"; 
    public static int posicion = 1;
    
    //Penalizacion
    public static int penalizacionnivel = -99;

    public static void main(String[] args) {
        int opcion;
        
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
        
        switch(opcion_){
            case 1 -> {
                System.out.println("JUEGO INICIADO");
                Tablero();
                PenalizacionesDificultad(); 
                seleccionaropcion();
            }
                
            case 2 -> System.out.println("JUEGO RETOMADO");
                
            case 3 -> {
                System.out.println("Nombra: Angel David Marinez García");
                System.out.println("Carnet: 202300410");
                System.out.println("CUI: 3037960140110");
            }
            
            case 4 -> System.out.println("GRACIAS POR USAR EL JUEGO ");
                
            default -> System.out.println("NUMERO NO VALIDO");
        }
    }
    
    public static void Tablero() {
        int contador = 1;
        for (String[] tablero1 : tablero) {
            for (int j = 0; j < tablero1.length; j++) {
                tablero1[j] = String.valueOf(contador);
                contador++; //contador=contador+1
            }
        }

        for (String[] penalizacione : penalizaciones) {
            for (int j = 0; j < penalizacione.length; j++) {
                penalizacione[j] = "";
            }
        }
    }
    
    public static void Penalizaciones() {
        
        Random random = new Random();

        int cantpen;
        int posrandom;
        for (String[] penalizacione : penalizaciones) {
            cantpen = random.nextInt(3) + 2;
            while (cantpen != 0) {
                while (true) {
                    posrandom = random.nextInt(penalizacione.length);
                    if (!penalizacione[posrandom].contains("#")) {
                        break;
                    }
                }
                penalizacione[posrandom] = "#" + penalizacione[posrandom];
                cantpen--;
            }
        }    
    }
    
    public static void numeraciontab (){
        
        System.out.println("=========================");
        boolean tab = true;
        String casillas;
        
        for (int i = tablero.length -1; i >= 0; i--) {
            for (String[] tablero1 : tablero) {
                System.out.print("+-----");
            }
            System.out.println("+");
            
            
            for (int j = tablero.length; j >= 0; j--) {
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
    
    public static void PenalizacionesDificultad(int penalizacionnivel){
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
