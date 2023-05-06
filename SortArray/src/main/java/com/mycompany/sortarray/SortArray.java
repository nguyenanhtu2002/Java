/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sortarray;

import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class SortArray {

    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("nhap so phan tu mang: ");
        n = sc.nextInt();    
        }
        while(n<0);
        int arr[] = new int[n + 1];
        inputArray(n, arr);
        System.out.println("mang vua nhap:");
        outputArray(n, arr);
        sortUpAscending(n, arr);
        sortDescending(n,arr);
    }

    public static void inputArray(int n, int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d]= ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static void outputArray(int n, int arr[]) {
        for (int i = 0; i < n; i++) {
            System.out.printf(" arr[%d] = %d ", i, arr[i]);
        }
    }

    public static void sortUpAscending(int n, int arr[]) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("\n mang sau khi sap xep tang dan ");
        outputArray(n, arr);
    }
        public static void sortDescending(int n, int arr[]) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("\n mang sau khi sap xep giam dan");
        outputArray(n, arr);
    }
}
