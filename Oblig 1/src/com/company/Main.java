package com.company;

import java.util.Arrays;
import static com.company.Oblig1.*;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[] {6,2,3,4,5,1,7,8,9};
        int[] b = a.clone();
        int[] c = new int[] {3,3,4,5,5,6,7,7,7,8};
        int[] d = c.clone();
        System.out.println(Arrays.toString(a));
        delsortering(a);
        System.out.println(Arrays.toString(a));
        /*System.out.println(maks(a));
        System.out.println(ombyttinger(b));
        System.out.println(antallUlikeSortert(c));
        System.out.println(antallUlikeUsortert(d));*/
    }
}