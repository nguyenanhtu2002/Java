
package com.mycompany.quadraticequationtwo;

import java.util.Scanner;


public class QuadraticEquationTwo {

    public static void main(String[] args) {
        float a, b, c;
        float x1, x2;
        Scanner sc = new Scanner(System.in);
        System.out.println("input a: ");
        a = sc.nextFloat();
        System.out.println("input b: ");
        b = sc.nextFloat();
        System.out.println("input c: ");
        c = sc.nextFloat();
        if (a == 0) {
            if (b == 0 && c == 0) {
                System.out.println("equation has infinitely many solution");
            } else if (c == 0) {
                System.out.println("x= 0");
            } else if (b == 0) {
                System.out.println("the equation has no solution");
            } else {
                System.out.printf("x =: %.2f", (float) -c / b);
            }
        } else {
            float delta = b * b - 4 * a * c;
            if (delta > 0) {
                x1 = (float) (-b + Math.sqrt(delta)) / (2 * a);
                x2 = (float) (-b - Math.sqrt(delta)) / (2 * a);
                System.out.printf("equation has two solution: \n x1 = %.2f, x2 = %.2f", x1, x2);
            }
            if (delta == 0) {
                x1 = x2 = (float) -b / (2 * a);
                System.out.printf("\n equation has one solution", x1);
            }
            if (delta < 0) {
                System.out.println("equation has no solution");
            }
        }
    }
}
