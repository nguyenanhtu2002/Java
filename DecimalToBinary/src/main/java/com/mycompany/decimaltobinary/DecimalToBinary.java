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
        System.out.println("Nhap so can chuyen doi: ");
        Scanner sc = new Scanner(System.in);
        decimal = sc.nextInt();
        if (decimal > 0) {
            System.out.printf("ket qua: %s", convertPositiveDecimalToBinary(decimal));
        }

    }

    private static String convertPositiveDecimalToBinary(int decimal) {
        String binary = "";
        while (decimal != 0) {
            int bit = decimal % 2;
            binary = bit + binary;
            decimal /= 2;
        }
        return binary;
    }
}
