package com.example.sumaralgoritmos;

import java.util.ArrayList;

public class Main {

    static int[] valoresN = {100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    static int[] valoresRecursiva = {100, 1000, 10000, 100000, 1000000, 10000000};

    public static void main(String[] args) {
        ArrayList<Dato> resultadosIterativa = correrIterativa();
        ArrayList<Dato> resultadosRecursiva = correrRecursiva();
        ArrayList<Dato> resultadosGauss = correrGauss();
    }

    public static ArrayList<Dato> correrIterativa(){
        ArrayList<Dato> resultados = new ArrayList<>();
        long startTime;
        long endTime;
        long time;
        long resultado;
        for (int i = 0; i < valoresN.length; i++) {
            int n = valoresN[i];
            System.out.println("Sumatoria iterativa n=" + n + ": ");
            startTime = System.nanoTime();
            resultado = Suma.sumaIterativo(n);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println("Resultado: " + resultado);
            System.out.println("Tiempo en ns: " + time);
            System.out.println("-------------------------------");
            resultados.add(new Dato(n, time, resultado));
        }
        return resultados;
    }

    public static ArrayList<Dato> correrRecursiva(){
        ArrayList<Dato> resultados = new ArrayList<>();
        long startTime;
        long endTime;
        long time;
        long resultado;
        for (int i = 0; i < valoresRecursiva.length; i++) {
            int n = valoresRecursiva[i];
            System.out.println("Sumatoria Recursiva n=" + n + ": ");
            startTime = System.nanoTime();
            resultado = Suma.sumaRecursivo(n);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println("Resultado: " + resultado);
            System.out.println("Tiempo en ns: " + time);
            System.out.println("-------------------------------");
            resultados.add(new Dato(n, time, resultado));
        }
        return resultados;
    }

    public static ArrayList<Dato> correrGauss(){
        ArrayList<Dato> resultados = new ArrayList<>();
        long startTime;
        long endTime;
        long time;
        long resultado;
        for (int i = 0; i < valoresN.length; i++) {
            int n = valoresN[i];
            System.out.println("Sumatoria Gauss n=" + n + ": ");
            startTime = System.nanoTime();
            resultado = Suma.sumaGauss(n);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println("Resultado: " + resultado);
            System.out.println("Tiempo en ns: " + time);
            System.out.println("-------------------------------");
            resultados.add(new Dato(n, time, resultado));
        }
        return resultados;
    }
}