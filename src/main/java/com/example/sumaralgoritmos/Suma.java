package com.example.sumaralgoritmos;

public class Suma {

    public static long sumaIterativo(int n){
        long sumatoria=0;
        for (int i=0;i<=n;i++){
            sumatoria+=i;
        }
        return sumatoria;
    }

    public static long sumaRecursivo(int n){
        return sumaRecursivo(n, 1);
    }

    public static long sumaRecursivo(int n,long sumatoria){
        if (0==n){
            return sumatoria-1;
        }
        return sumaRecursivo(n-1,sumatoria+n);
    }

    public static long sumaGauss(int n){
        return ((long) n *(n+1))/2;
    }
}
