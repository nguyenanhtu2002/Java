
package com.mycompany.decimaltobinary;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        int decimal;
        System.out.println("enter decimal number: ");
        Scanner sc = new Scanner(System.in);
        decimal = sc.nextInt();
        if (decimal > 0) {
            System.out.printf("result: %s", convertPositiveDecimalToBinary(decimal));
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
