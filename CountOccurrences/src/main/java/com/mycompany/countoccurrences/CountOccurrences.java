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
        int arr[] = new int[n];
        int countArray[] = new int[n];

        inputArray(n, arr, countArray);
        countOccurrencesOfArrays(n, arr, countArray);
    }

    public static void inputArray(int n, int arr[], int countArray[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf("\n arr[%d] = ", i);
            arr[i] = sc.nextInt();
            countArray[i] = -1;
        }
    }
    // a {1, 2, 3, 2, 4, 2, 5, 3};
    //b   {-1, 0, -1, -1, -1, -1, -1, -1};
    //count =1

    public static void countOccurrencesOfArrays(int n, int arr[], int countArray[]) {
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < countArray.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    countArray[j] = 0;
                }
            }
            if (countArray[i] != 0) {
                countArray[i] = count;
            }
        }
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] != 0) {
                System.out.printf("%d xuat hien %d lan \n",arr[i],countArray[i]);
            }
        }
    }
}
