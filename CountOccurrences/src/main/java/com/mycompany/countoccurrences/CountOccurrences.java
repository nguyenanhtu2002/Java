/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//cho một mảng, in ra số lần xuất hiện của các phần tử trong mảng
package com.mycompany.countoccurrences;

import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class CountOccurrences {

    public static void main(String[] args) {
        int n;
        System.out.println("nhap so phan tu mang: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n + 1];
        int countArray[] = new int[n];

        inputArray(n, arr);
        countOccurrencesOfArrays(n, arr, countArray);
    }

    public static void inputArray(int n, int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf("\n arr[%d] = ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static void countOccurrencesOfArrays(int n, int arr[], int countArray[]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i] == arr[j]) {
                    countArray[i] += 1;
                }
            }
        }

        int tmp = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("so lan xuat hien cua %d la %d \n", arr[i], countArray[i]);
        }
    }
}
