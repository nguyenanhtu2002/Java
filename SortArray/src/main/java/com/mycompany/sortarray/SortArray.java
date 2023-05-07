/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sortarray;

import java.util.Scanner;

public class SortArray {

    public static void main(String[] args) {
        int sizeArr = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter the number of array elements: ");
            sizeArr = sc.nextInt();
        } while (sizeArr < 0);
        int arr[] = new int[sizeArr + 1];
        inputArray(sizeArr, arr);
        System.out.println("Array:");
        outputArray(sizeArr, arr);
        sortUpAscending(sizeArr, arr);
        sortDescending(sizeArr, arr);
    }

    public static void inputArray(int sizeArr, int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < sizeArr; i++) {
            System.out.printf("arr[%d]= ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static void outputArray(int sizeArr, int arr[]) {
        for (int i = 0; i < sizeArr; i++) {
            System.out.printf(" arr[%d] = %d ", i, arr[i]);
        }
    }

    public static void sortUpAscending(int sizeArr, int arr[]) {
        int temp;
        for (int i = 0; i < sizeArr; i++) {
            for (int j = i + 1; j < sizeArr; j++) {
                if (arr[j] < arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("\n Sort Up Ascending  ");
        outputArray(sizeArr, arr);
    }

    public static void sortDescending(int sizeArr, int arr[]) {
        int temp;
        for (int i = 0; i < sizeArr; i++) {
            for (int j = i + 1; j < sizeArr; j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("\n sort descending");
        outputArray(sizeArr, arr);
    }
}
