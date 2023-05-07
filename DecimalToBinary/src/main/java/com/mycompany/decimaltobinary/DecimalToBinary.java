/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.decimaltobinary;

import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class DecimalToBinary {

    public static void main(String[] args) {
        int decimal;
        do {
            System.out.println("Nhap so can chuyen doi: ");
            Scanner sc = new Scanner(System.in);
            decimal = sc.nextInt();
        } while (decimal <= 0);

        System.out.printf("ket qua: %s", decimalToBinary(decimal));
    }

    public static String decimalToBinary(int decimal) {
        String binary = "";
        while (decimal != 0) {
            int b = decimal % 2;
            binary = b + binary;
            decimal = decimal / 2;
        }
        return binary;
    }
}
