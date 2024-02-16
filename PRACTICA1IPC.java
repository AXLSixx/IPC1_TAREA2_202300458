/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica1ipc;
import java.util.Scanner;

public class PRACTICA1IPC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int filas = 8;
        int columnas = 8;
        int posicionJugador = 0;
        int contador = filas * columnas;

        // Dibuja la cuadrícula con numeración de derecha a izquierda
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("+----");
            }
            System.out.println("+");
            for (int j = 0; j < columnas; j++) {
                if (contador == posicionJugador) {
                    System.out.print("| @ ");
                } else {
                    System.out.print("| \u001B[34m" + contador + "\u001B[0m "); // Nuevo color para la numeración
                }
                contador--;
            }
            System.out.println("|");
        }

        // Juego: Mueve al jugador según un número aleatorio
        System.out.println("\nBienvenido escaleras y serpientes!");
        System.out.println("Presiona Enter para lanzar los dados...");

        // Juego: Mueve al jugador según un número aleatorio
        while (true) {
            scanner.nextLine(); // Espera a que el usuario presione Enter
            int dado = lanzarDado();
            System.out.println("Has sacado un " + dado + ". Avanzas " + dado + " casillas.");
            posicionJugador += dado;

            if (posicionJugador >= filas * columnas) {
                System.out.println("Felicidades! Has llegado a la meta.");
                break;
            } else {
                System.out.println("Posición actual del jugador: " + posicionJugador);
            }

            contador = filas * columnas; // Reinicia el contador para el segundo tablero

            // Dibuja la cuadrícula con numeración de izquierda a derecha (segundo tablero)
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print("+----");
                }
                System.out.println("+");
                for (int j = 0; j < columnas; j++) {
                    if (contador == posicionJugador) {
                        System.out.print("| @ ");
                    } else {
                        System.out.print("| \u001B[34m" + contador + "\u001B[0m "); // Nuevo color para la numeración
                    }
                    contador--;
                }
                System.out.println("|");
            }
        }
    }

    public static int lanzarDado() {
        return (int) (Math.random() * 6) + 1;  
    }
}

