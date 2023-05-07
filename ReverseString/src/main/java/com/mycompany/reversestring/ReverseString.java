package com.mycompany.reversestring;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println("input string");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        reverseStr(str);
    }

    public static void reverseStr(String str) {
        String result = "";
        String arr[] = str.trim().split("\\s+");
        for (int i = arr.length - 1; i >= 0; i--) {
            result += arr[i];
            if (i > 0) {
                result += " ";
            }
        }
        System.out.printf("%s", result);
    }

}
