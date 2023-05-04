/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.phuongtrinhbac2;

import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class PhuongTrinhBac2 {

    public static void main(String[] args) {
        float a, b, c;
        float x1, x2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so a: ");
        a = sc.nextFloat();
        System.out.println("Nhap so b: ");
        b = sc.nextFloat();
        System.out.println("Nhap so c: ");
        c = sc.nextFloat();
        if (a == 0) {
            if (b == 0 && c == 0) {
                System.out.println("phuong trinh vo so nghiem");
            } else if (c == 0) {
                System.out.println("phuong trinh co nghiem = 0");
            } else if(b==0)
                System.out.println("phuong trinh vo nghiem");
             else {
                System.out.printf("x =: %.2f", (float) -c / b);
            }
        } else {
            float delta = b * b - 4 * a * c;
            if (delta > 0) {
                x1 = (float) (-b + Math.sqrt(delta)) / (2 * a);
                x2 = (float) (-b - Math.sqrt(delta)) / (2 * a);
                System.out.printf("phuong trinh co 2 nghiem phan biet: \n x1 = %.2f, x2 = %.2f", x1, x2);
            }
            if (delta == 0) {
                x1 = x2 = (float) -b / (2 * a);
                System.out.printf("\n phuong trinh co nghiem kep", x1);
            }
            if (delta < 0) {
                System.out.println("phuong trinh vo nghiem.");
            }
        }
    }

}
