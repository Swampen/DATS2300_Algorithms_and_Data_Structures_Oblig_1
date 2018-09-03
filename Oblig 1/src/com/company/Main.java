package com.company;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[] {8,7,4,3,2};
        System.out.println(maks(a));
        System.out.println(ombyttinger(a));
    }

    public static int maks(int[] a){
        for(int i = 0; i<a.length-1; i++){
            if(a[i]> a[i+1]){
                bytt(a, i, i+1);
            }
        }
        return a[a.length-1];
    }

    public static void bytt(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static int ombyttinger(int[] a){
        int antallOmbyttinger = 0;
        for(int i=0; i<a.length-1; i++) {
            if(a[i]>a[i+1]) {
                bytt(a, i, i+1);
                antallOmbyttinger++;
            }
        }
        return antallOmbyttinger;
    }
}
