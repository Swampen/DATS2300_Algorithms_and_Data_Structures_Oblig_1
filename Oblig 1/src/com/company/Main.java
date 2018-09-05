package com.company;

import static com.company.Oblig1.*;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,0};

        indekssortering(a);

        String s = flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU");
        System.out.println(s);

    }
}