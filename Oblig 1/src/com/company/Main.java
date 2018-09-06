package com.company;

import java.util.Arrays;

import static com.company.Oblig1.*;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[] {-4, -1, 3, 0, 2, -3, -2, 4, 1};

        delsortering(a);
        System.out.println(-3%2);
        System.out.println(Arrays.toString(a));

        String s = flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU");
        System.out.println(s);

    }
}