/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.standardizationofletters;

import java.util.Scanner;

public class StandardizationOfLetters {

public static void main(String[] args) {
        String str;

        String result = "";
        System.out.println("Input string: ");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        str = str.replaceAll("\\s+", " ");
        str = str.trim();
        str = str.toLowerCase();
        String temp[] = str.split(" ");
        for (int i = 0; i < temp.length; i++) {
            result += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                result += " ";
            }
        }
        System.out.println(result);
    }
}
