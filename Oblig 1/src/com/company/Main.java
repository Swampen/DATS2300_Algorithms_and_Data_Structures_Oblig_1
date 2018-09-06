package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.company.Oblig1.*;

public class Main {

    public static void main(String[] args) {

        char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] d0 = {'G', 'H', 'I', 'J', 'A', 'B', 'C', 'D', 'E', 'F'};

        Oblig1.rotasjon(d, 4);
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(d0));
    }
}