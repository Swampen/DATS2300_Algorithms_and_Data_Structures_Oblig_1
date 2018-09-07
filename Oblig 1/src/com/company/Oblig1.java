package com.company;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    //Oppgave 1
    /**
     * Finner maks verdi i et array ved å sammeligne hver indeks i arrayet med den neste, hvis den første er større enn
     * den neste bytter de plass helt til det største tallet blir sist i arrayet
     * @param a Arrayet du skal finne maks verdi i (int array)
     * @return Maks verdien
     */
    public static int maks(int[] a){
        arrayCheck(a);
        for(int i = 0; i < a.length - 1; i++){
            if(a[i]> a[i+1]){
                bytt(a, i, i+1);
            }
        }
        return a[a.length-1];
    }
    
    /**
     * Metode for å bytte plass på verdien av to indekser
     * @param a Hvilket array som skal behandles (int array)
     * @param i Første indeksen
     * @param j andre indeksen
     */
    public static void bytt(int[] a, int i, int j) {    //Bytter om to tall i en tabell
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * Metode for å bytte plass på verdien av to indekser
     * @param a Hvilket array som skal behandles (char array)
     * @param i Første indeksen
     * @param j andre indeksen
     */
    public static void bytt(char[] a, int i, int j) {    //Bytter om to tall i en tabell
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * Metode som teller hvor mange bytter som skjer under maks metoden
     * @param a Arrayet du skal finne maks verdi i og hvor mange bytter (int array)
     * @return antallet bytter som skjer i løpet av metoden
     */
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

    //Oppgave 2
    /**
     * Metode som teller antall ulike siffer i en tabell ved å sammenligne en indeks med den neste, om de er forskjellige
     * så inkrementerer den teller variablen
     * @param a Arrayet som du skal finne hvor mange ulike siffer det er i
     * @return Antallet ulike siffer
     */
    public static int antallUlikeSortert(int[] a){ //Gir deg et antall ulike siffere i et array som er sortert
        ikkeSortertExeption(a);
        if (a.length == 0){
            return 0;
        }
        int teller = 1;
        for(int i = 0; i < a.length - 1; i++){
            if(a[i+1] != a[i]){             //Sjekker om det neste tallet i arrayet er likt det du er på
                teller++;                   // hvis den ikke er det så legger den til på telleren
            }

        }
        return teller;
    }

    //Oppgave 3
    /**
     * Sorterer først tabellen, så teller den antall
     * ulike siffere i tabellen med metoden {@link #antallUlikeSortert(int[])}
     * @param a en vilkårlig usortert tabell som skal sjekkes
     * @return antall ulike siffere i et array som er usortert
     */
    public static int antallUlikeUsortert(int[] a){
        if(a.length == 0){
            return 0;
        }
        int antall = 0;
        int min = Integer.MAX_VALUE;
        int sistemin=Integer.MIN_VALUE;
        boolean nyFunnet = true;
        boolean first = true;

        while(nyFunnet){
            if(first){
                first = false;
            } else {
                nyFunnet=false;
            }
            for(int i = 0; i < a.length; i++){
                if((a[i] < min) && (a[i] > sistemin)){
                    min=a[i];
                    nyFunnet=true;
                }
            }
            if(nyFunnet){
                antall++;
            }
            sistemin=min;
            min = Integer.MAX_VALUE;
        }
        return antall;
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

    /**
     * Sorterer en tabell i stigende rekkefølge
     * @param a tabellen som skal sorteres
     */
    public static void bubbleSort(int[] a){ //Sorterer et array ved bruk av bubble metoden
        for (int i= 0; i < a.length; i++){  //Looper igjennom arrayen til den er sortert
            maks(a);                        //Sender det største tallet bakerst
        }
    }

    /**
     * Sorterer en tabell i stigende rekkefølge innenfor et gitt intervall
     * @param a tabellen som skal sorteres
     * @param fra starten på intervallet
     * @param til slutten på intervallet
     */
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
            if (Math.abs(a[i] % 2) == 1) {                //Sjekker om tallet i tabellen er et oddetall
                bytt(a, i, antallOddetall);     //Flytter oddetallet til venstre i tabellen
                ++antallOddetall;               //Telelr antall oddetall
            }
        }
        Arrays.sort(a, 0, antallOddetall);
        Arrays.sort(a, antallOddetall, a.length);
        //bubbleSort(a, 0, antallOddetall);        //Sorterer alle oddetallene i stigende rekkefølge
        //bubbleSort(a, antallOddetall, a.length);    //Sorterer de resterende partallene i stigende rekkefølge
    }

    /**
     * Reverserer en tabell innenfor gitt intervall
     * @param c tabellen som skal reverseres
     * @param v venstre grense
     * @param h høyre grense
     */
    public static void reverser(char[] c, int v, int h){
        char[] temp = c.clone();
        for (int i = v; i <= h; i++){
            c[i] = temp[h - i + v];
        }
    }

    //Oppgave 5
    /**
     * Roterer en tabell med en mot høyre
     * @param c tabellen som skal roteres
     */
    public static void rotasjon(char[] c){
        for (int i = 1; i < c.length; i++){
            bytt(c, 0, i);
        }
    }

    //Oppgave 6
    /**
     * Roterer en tabell et gitt antall ganger.
     * Roterer mot høyre hvis k er positiv og
     * mot venstre hvis k er negativ
     * @param c tabellen som skal roteres
     * @param k antall rotasjoner som skal gjennomføres
     */
    public static void rotasjon(char[] c, int k){
        if (k > 0 && c.length !=0){
            int n = c.length;
            int steg = k % n;
            reverser(c, 0, n-1);
            reverser(c, 0, steg-1);
            reverser(c, steg, n-1);
        }else if (k < 0 && c.length !=0){
            int n = c.length;
            int steg = Math.abs(k % n);
            reverser(c, 0, steg-1);
            reverser(c, steg, n-1);
            reverser(c, 0, n-1);
        }
    }

    //Oppgave 7a
    /**
     * Metode som fletter sammen to tekststrenger ved bruk av substring-metoden og rekursjon
     * @param s tekststreng nr. 1
     * @param t tekststreng nr. 2
     * @return Det flettede resultatet
     */
    public static String flett(String s, String t){
        checkString(s);
        checkString(t);
        if(s.isEmpty() || t.isEmpty()){
            return s+t;
        }

        return s.substring(0, 1) + t.substring(0, 1) + flett(s.substring(1), t.substring(1));
    }

    //Oppgave 7b
    public static String flett(String... s){
        int longest = 0;
        StringBuilder returnString = new StringBuilder();
        for (String c: s) {
            if(c.length()>longest){
                longest = c.length();
            }
        }
        for (int i = 0; i < longest; i++){
            for (String t: s ) {
                if(t.length()>i){
                    returnString.append(t.substring(i, i + 1));
                }
            }
        }
        return returnString.toString();
    }
    /**
     * Metode for å sjekke om en String  er null
     * @param s Stringen som skal sjekkes
     */
    public static void checkString(String s){
        if(s == null){
            throw new NullPointerException("Strengen kan ikke være null");
        }
    }

    //Oppgave 8
    /**
     * Metoden vil lage oppgi indeksene til en tabell
     * sortert i stigende rekkefølge
     * @param a tabellen som skal indeks sortert
     * @return en tabell med indekser til {@code int[] a}
     * i stigende rekkefølge
     */
    public static int[]indekssortering(int[] a){
        int[] indeks = a.clone();
        Arrays.sort(indeks);

        int gammelTeller = 0;

        for (int i = 0; i < indeks.length; i++) {
            int indeksElement = indeks[i];
            int teller = 0;

            if (i > 0) {
                if (indeksElement == a[indeks[i - 1]]) {
                    teller = gammelTeller + 1;
                    gammelTeller = teller;
                } else {
                    gammelTeller = 0;
                }
            }
            for (int j = 0; j < a.length; j++){

                if (teller > 0 && indeksElement == a[j]){
                    j+=teller-1;
                    teller = 0;
                }else if (indeksElement == a[j]){
                    indeks[i] = j;
                    break;
                }
            }
        }
        return indeks;
    }

    //Oppgave 9

    /**
     * Finner de tre minste verdiene i en tabell
     * @param a tabellen som skal søkes i
     * @return returnerer indeksene til de tre minste verdiene
     */
    public static int[]tredjeMin(int[] a) {
        if (a.length < 3) {
            throw new NoSuchElementException("Tabellen må ha en lengde på 3 eller mer");
        }
        int n = a.length;     // tabellens lengde

        int m = 0;
        int nm = 0;
        int nnm = 0;

        int minstVerdi = Integer.MAX_VALUE;                // minste verdi
        int nestMinstVerdi = Integer.MAX_VALUE;           // nest minste verdi
        int nestNestMinstVerdi = Integer.MAX_VALUE;       // nest nest minste verdi

        for (int i = 0; i < n; i++) {

            if (a[i] < minstVerdi) {
                nnm = nm;
                nestNestMinstVerdi = nestMinstVerdi;

                nm = m;
                nestMinstVerdi = minstVerdi;

                m = i;
                minstVerdi = a[i];
            } else if (a[i] < nestMinstVerdi) {
                nnm = nm;
                nestNestMinstVerdi = nestMinstVerdi;

                nm = i;
                nestMinstVerdi = a[i];

            } else if (a[i] < nestNestMinstVerdi) {
                nnm = i;
                nestNestMinstVerdi = a[i];
            }
        }
        int[] treMinste = {minstVerdi, nestMinstVerdi, nestNestMinstVerdi};
        return new int[] {m, nm, nnm};
    }

    //Oppgave 10

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean inneholdt(String a, String b){
        if (a.length() > b.length()){
            return false;
        }
        char [] aChar = a.toCharArray();
        char [] bChar = b.toCharArray();
        Arrays.sort(aChar);
        boolean inneholder = true;
        int gammelTeller = 0;

        for (int i = 0; i < aChar.length; i++){
            char undersøkElement = aChar[i];
            int teller = 0;
            inneholder = false;

            if (i > 0) {
                if (undersøkElement == aChar[i - 1]) {
                    teller = gammelTeller + 1;
                    gammelTeller = teller;
                }else {
                    gammelTeller = 0;
                }
            }
            for (int j = 0; j < bChar.length; j++){

                if (teller > 0 && undersøkElement == bChar[j]){
                    j+=teller-1;
                    teller = 0;
                }else if (undersøkElement == bChar[j]){
                    inneholder = true;
                    break;
                }
            }
            if (!inneholder){
                break;
            }
        }

        return inneholder;
    }
}
