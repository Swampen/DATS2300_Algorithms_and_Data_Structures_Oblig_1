package com.company;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[] {3,7,4,8,2};
        System.out.println(maks(a));
    }

    public static int maks(int[] a){
        for(int i = 0; i<a.length-1; i++) if(a[i]> a[i+1]){
            bytt(a, i);
        }
        return a[a.length-1];
    }

    public static void bytt(int[] a, int i) {
        int tmp = a[i];
        a[i] = a[i+1];
        a[i+1] = tmp;
    }
}
