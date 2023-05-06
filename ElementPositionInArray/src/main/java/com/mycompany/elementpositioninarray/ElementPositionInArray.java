/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.elementpositioninarray;

import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class ElementPositionInArray {

    public static void main(String[] args) {
        System.out.println("Nhap so phan tu mang");
        int n = 0;
        int a, b;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n + 1];
        inputArray(n, arr);
        System.out.println("nhap a");
        a = sc.nextInt();
        System.out.println("nhap b");
        b = sc.nextInt();
        Position(n, arr, a - b);
    }

    public static void inputArray(int n, int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] = ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static void Position(int n, int arr[], int x) {
        int check = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                System.out.printf("vi tri la: %d", i);
                check += 1;
            }
        }
        if (check == 0) {
            System.out.println("khong tim thay");
        }
    }
}
