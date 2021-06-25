package com.example.demo;

public class Hello {
    public static void main(String[] args){
        System.out.println("Hello this is my first Classload!!");
        int a = 1;
        long b = 2l;
        float c = 3.0f;
        double d = 4.0d;
        char e = 'a';
        byte f = 5;
        short g = 6;
        boolean h = true;
        int[] i = {1,2,3,4,5,6};

        int sum1 = (int) (a + b);
        int sum2 = e - a;
        int sum3 = (int) (c * d);
        int sum4 = a / f;

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);
        System.out.println("sum3 = " + sum3);
        System.out.println("sum4 = " + sum4);

        if (a == b){
            System.out.println("a = b");
        }

        for (int j = 0; j < i.length; j++){
            System.out.println("for" + j + " = " + i[j]);
        }

    }
}
