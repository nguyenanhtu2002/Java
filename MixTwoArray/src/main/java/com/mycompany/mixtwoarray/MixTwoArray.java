/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mixtwoarray;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class MixTwoArray {

    public static void main(String[] args) {
        int n, m = 0;
        int a, b;
        System.out.println("Nhap so phan tu mang 1: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr1[] = new int[n + 1];
        inputArray(n, arr1);
        
        System.out.println("Nhap so phan tu mang 2: ");
        m = sc.nextInt();   
        int arr2[] = new int[m + 1];      
        inputArray(m, arr2);
        
        int arr3[] = new int[n + m];
        mixTwoArray(n,m,arr1,arr2,arr3);
    }

    public static void inputArray(int n, int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf("\n arr[%d] = ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static void outputArray(int n, int arr[]) {
        for (int i = 0; i < n; i++) {
            System.out.printf(" arr[%d] = %d ", i, arr[i]);
        }
    }
    public static void mixTwoArray(int n, int m, int arr1[], int arr2[], int arr3[]){
        for(int i=0;i<n;i++){
            arr3[i]= arr1[i];      
        }
        for(int i=0;i<m;i++){
            arr3[n+i] = arr2[i];
        }
        Arrays.sort(arr3);
        System.out.println("sau khi tron 2 mang va sap xep \n");
        outputArray(n+m, arr3);
    }
   

}
