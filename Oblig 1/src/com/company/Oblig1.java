package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static int maks(int[] a){        //Finner det største tallet i en tabell og flytter det til siste posisjon
        arrayCheck(a);
        for(int i = 0; i < a.length - 1; i++){  //for-loop som looper igjennom tabellen
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

    public static void bytt(char[] a, int i, int j) {    //Bytter om to tall i en tabell
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static int ombyttinger(int[] a){     //regner ut hvor mange bytter det skjer når maks algoritmen blir kjørt
        arrayCheck(a);
        int antallOmbyttinger = 0;
        for(int i = 0; i < a.length - 1; i++) {       //for-loop som looper igjennom tabellen
            if(a[i]>a[i+1]) {                   //If-statement som sjekker om verdien på index i er større enn den neste indexen
                bytt(a, i, i+1);             //Bytter plass på indeksene
                antallOmbyttinger++;            //Legger til 1 på antallOmbyttinger varibelen
            }
        }
        return antallOmbyttinger;
    }

    public static int antallUlikeSortert(int[] a){ //Gir deg et antall ulike siffere i et array som er sortert
        ikkeSortertExeption(a);
        int teller = 0;
        for(int i = 0; i < a.length - 1; i++){
            if(i > 0){
                if(a[i+1] != a[i]){             //Sjekker om det neste tallet i arrayet er likt det du er på
                    teller++;                   // hvis den ikke er det så legger den til på telleren
                }
            } else {
                teller++;                       //Hvis indeksen er null så legger den til en i counteren for å få med første tallet
            }
        }
        return teller;
    }

    /**
     * Sorterer først tabellen, så teller den antall
     * ulike siffere i tabellen med metoden {@link #antallUlikeUsortert(int[])}
     * @param a en vilkårlig usortert tabell som skal sjekkes
     * @return antall ulike siffere i et array som er usortert
     */
    public static int antallUlikeUsortert(int[] a){
        bubbleSort(a);                              //Sorterer arrayet
        return antallUlikeSortert(a);
    }

    /**
     * Sjekker om en tabell ikke er tom,
     * eller om den peker på {@code Null}
     * @param a tabellen som skal sjekkes
     */
    public static void arrayCheck(int[] a){
        if (a == null) {
            throw new NullPointerException("Arrayet er null!");   //Sjekker for et null array og kaster en NullPointerException
        }
        if (a.length == 0) {
            throw new NoSuchElementException("Tomt array!");     //Sjekker for tomt array og kaster en NoSuchElementException

        }
    }

    /**
     * Sjekker om en tabell er sortert i stigende rekkefølge
     * Thrower {@code IllegalStateException} hvis ikke.
     * @param a tabellen som skal sjekkes
     */
    public static void ikkeSortertExeption(int[] a){
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

    private static void bubbleSort(int[] a, int fra, int til) {
        if (til > (a.length)){
            throw new IllegalArgumentException("Til går utenfor tabellen");
        }

        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for (int i = fra; i < til-1; i++){
                if (a[i] > a[i+1]){
                    bytt(a, i, i+1);
                    sorted = false;
                }
            }
        }
    }

    //Oppgave 4
    /**
     * Sorterer en array slik at oddetallene
     * er sortert i stigene rekkefølge på venstre
     * side av tabellen, og partallene i stigende
     * rekkefølge på høyre siden av tabellen.
     * @param a tabellen som skal delsorteres
     */
    public static void delsortering(int[] a){
        int antallOddetall = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) {                //Sjekker om tallet i tabellen er et oddetall
                bytt(a, i, antallOddetall);     //Flytter oddetallet til venstre i tabellen
                ++antallOddetall;               //Telelr antall oddetall
            }
        }
        bubbleSort(a, 0, antallOddetall);        //Sorterer alle oddetallene i stigende rekkefølge
        bubbleSort(a, antallOddetall, a.length);    //Sorterer de resterende partallene i stigende rekkefølge
    }

    public static void rotasjon(char[] c){
        for (int i = 1; i < c.length; i++){
            bytt(c, 0, i);
        }
    }

    public static void rotasjon(int[] a){
        for (int i = 1; i < a.length; i++){
            bytt(a, 0, i);
        }
    }

    public static void rotasjon(char[] c, int k){
        if (k >= 0){
            for (int i = 0; i < k; i++) {
                rotasjon(c);
            }
        }else {
            for (int i = 0; i < Math.abs(k); i++){
                for (int j = c.length-2; j >= 0; j--){
                    bytt(c, c.length-1, j);
                }
            }
        }
    }

    public static int[]indekssortering(int[] a){
        int[] indeks = a.clone();
        System.out.println(Arrays.toString(a));

        bubbleSort(indeks);
        System.out.println(Arrays.toString(indeks));

        int like = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++){
                if (indeks[i] == a[j]){
                    indeks[i] = j;
                    break;

                }
            }
            System.out.println(Arrays.toString(indeks));
        }

        return indeks;
    }

    public static int[]tredjeMin(int[] a) {
        if (a.length < 3) {
            throw new NoSuchElementException("Tabellen må være lenger enn 3");
        }
        int n = a.length;     // tabellens lengde

        int m = 0;      // m er posisjonen til minste verdi
        int nm = 1;     // nm er posisjonen til nest minste verdi
        int nnm = 2;     // nnm er posisjonen til nest nest minste verdi

        if (a[2] < a[0]) {
            m = 2;
            nm = 0;
            nnm = 1;
        }
        if (a[1] < a[0]) {
            m = 1;
            nm = 0;
        }

        int minstVerdi = a[m];                // minste verdi
        int nestMinstVerdi = a[nm];           // nest minste verdi
        int nestNestMinstVerdi = a[nnm];       // nest nest minste verdi

        for (int i = 3; i < n; i++) {
            if (a[i] < nestNestMinstVerdi) {
                if (a[i] < nestMinstVerdi) {
                    if (a[i] < minstVerdi) {
                        nnm = nm;
                        nestNestMinstVerdi = nestMinstVerdi;

                        nm = m;
                        nestMinstVerdi = minstVerdi;

                        m = i;
                        minstVerdi = a[m];
                    }else {
                        nnm = nm;
                        nestNestMinstVerdi = a[nnm];

                        nm = i;
                        nestMinstVerdi = a[nm];

                    }
                }else {
                    nnm = i;
                    nestNestMinstVerdi = a[nnm];
                }

            }
        }
        return new int[] {m, nm, nnm};
    }
}
