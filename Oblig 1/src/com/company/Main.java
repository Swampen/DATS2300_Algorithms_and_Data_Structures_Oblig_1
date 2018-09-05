package com.company;

import java.util.Arrays;
import static com.company.Oblig1.*;

public class Main {

    public static void main(String[] args) {

        String s = flett("ABC","DEFGH");
        String t = flett("IJKLMN", "OPQ");
        String g = flett("","AB");
        String a = flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU");
        int[] b = {6,10,16,11,7,12,3,9,8,5};
        int[] i = indekssortering(b);
        System.out.println(s);
        System.out.println(t);
        System.out.println(g);
        System.out.println(a);
        System.out.println(Arrays.toString(i));

    }
}