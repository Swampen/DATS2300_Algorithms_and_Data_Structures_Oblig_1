package com.company;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[] {6,2,3,4,5,1,7,8,9};
        int[] b = a.clone();
        int[] c = new int[] {3,3,4,5,5,6,7,7,7,8};
        int[] d = c.clone();
        System.out.println(maks(a));
        System.out.println(ombyttinger(b));
        System.out.println(antallUlikeSortert(c));
        System.out.println(antallUlikeUsortert(d));
    }

    public static int maks(int[] a){        //Finner det største tallet i en tabell og flytter det til siste posisjon
        arrayCheck(a);
        for(int i = 0; i<a.length-1; i++){  //for-loop som looper igjennom tabellen
            if(a[i]> a[i+1]){               //If-statement som sjekker om verdien på index i er større enn den neste indexen
                bytt(a, i, i+1);         //Bytter plass på indeksene
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
                bytt(a, i, i+1);             //Bytter plass på indeksene
                antallOmbyttinger++;            //Legger til 1 på antallOmbyttinger varibelen
            }
        }
        return antallOmbyttinger;
    }

    public static int antallUlikeSortert ( int[] a){ //Gir deg et antall ulike siffere i et array som er sortert
        ikkeSortertExeption(a);
        int teller = 0;
        for(int i = 0; i < a.length-1; i++){
            if(i>0){
                if(a[i+1] != a[i]){             //Sjekker om det neste tallet i arrayet er likt det du er på
                    teller++;                   // hvis den ikke er det så legger den til på telleren
                }
            } else {
                teller++;                       //Hvis indeksen er null så legger den til en i counteren for å få med første tallet
            }
        }
        return teller;
    }

    public static int antallUlikeUsortert(int[] a){ //Gir deg et antall ulike siffere i et array som er usortert
        bubbleSort(a);                              //Sorterer arrayet
        int teller = antallUlikeSortert(a);         //Kjører det sorterte arrayet gjennom algoritmen for sorterte array
        return teller;
    }
    
    public static void arrayCheck(int[] a) {    //sjekker at arrayet er lovlig
        if (a == null) {
            throw new NullPointerException("array er null!");   //Sjekker for et null array og kaster en NullPointerException
        }
        if (a.length == 0) {
            throw new NoSuchElementException("Tomt array!");     //Sjekker for tomt array og kaster en NoSuchElementException

        }
    }

    public static void ikkeSortertExeption ( int[] a){
        for (int i = 0; i < a.length - 1; i++) {            //Looper igjennom arrayet og sjekker om det er sortert
            if (!(a[i] <= a[i + 1])) {                      //Hvis det ikke er sortert så kastes en exception
                    throw new IllegalStateException("Tabellen er ikke sortert");
            }
        }
    }

    public static void bubbleSort(int[] a){ //Sorterer et array ved bruk av bubble metoden
        for (int i= 0; i < a.length; i++){  //Looper igjennom arrayen til den er sortert
            maks(a);                        //Sender det største tallet bakerst
        }
    }
}