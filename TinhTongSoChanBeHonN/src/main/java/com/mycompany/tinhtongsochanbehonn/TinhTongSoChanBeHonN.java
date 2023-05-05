/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tinhtongsochanbehonn;

import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class TinhTongSoChanBeHonN {

    public static void main(String[] args) {
        int n;
        int temp = 0;
        do {
            System.out.println("Nhap n: ");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0 && i < n) {
                    temp += i;
                }
            }
        } while (n < 0);
        System.out.printf("ket qua: %d", temp);
    }

}
