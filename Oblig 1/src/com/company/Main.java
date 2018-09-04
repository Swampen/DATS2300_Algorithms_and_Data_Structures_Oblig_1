package com.company;

import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[] {8,7,4,3,2};
        System.out.println(ombyttinger(a));
    }

    public static int maks(int[] a){        //Finner det største tallet i en tabell og flytter det til siste posisjon
        arrayCheck(a);
        for(int i = 0; i<a.length-1; i++){  //for-loop som looper igjennom tabellen
            if(a[i]> a[i+1]){               //If-statement som sjekker om verdien på index i er større enn den neste indexen
                bytt(a, i, i+1);
            }
        }
        return a[a.length-1];   //Returnerer den største verdien i tabellen
    }

    public static void bytt(int[] a, int i, int j) {    //Bytter om to tall i en tabell
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static int ombyttinger(int[] a){     //regner ut hvor mange bytter det skjer når maks algoritmen blir kjørt
        arrayCheck(a);
        int antallOmbyttinger = 0;
        for(int i=0; i<a.length-1; i++) {       //for-loop som looper igjennom tabellen
            if(a[i]>a[i+1]) {                   //If-statement som sjekker om verdien på index i er større enn den neste indexen
                bytt(a, i, i+1);
                antallOmbyttinger++;
            }
        }
        return antallOmbyttinger;
    }

    public static void arrayCheck(int[] a) {
        if(a == null) {
            throw new NullPointerException("array er null!");
        }
        if(a.length == 0){
            throw new NoSuchElementException("Tomt array!");     //Sjekker for tomt array og kaster en NoSuchElementException
        }
    }
}
