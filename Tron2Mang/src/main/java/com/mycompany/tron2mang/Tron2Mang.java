/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tron2mang;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class Tron2Mang {

    public static void main(String[] args) {
        int n, m = 0;
        int a, b;
        System.out.println("Nhap so phan tu mang 1: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr1[] = new int[n + 1];
        NhapMang(n, arr1);
        
        System.out.println("Nhap so phan tu mang 2: ");
        m = sc.nextInt();   
        int arr2[] = new int[m + 1];      
        NhapMang(m, arr2);
        
        int arr3[] = new int[n + m];
        Tron2Mang(n,m,arr1,arr2,arr3);
    }

    public static void NhapMang(int n, int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf("\n arr[%d] = ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static void XuatMang(int n, int arr[]) {
        for (int i = 0; i < n; i++) {
            System.out.printf(" arr[%d] = %d ", i, arr[i]);
        }
    }
    public static void Tron2Mang(int n, int m, int arr1[], int arr2[], int arr3[]){
        for(int i=0;i<n;i++){
            arr3[i]= arr1[i];      
        }
        for(int i=0;i<m;i++){
            arr3[n+i] = arr2[i];
        }
        Arrays.sort(arr3);
        System.out.println("sau khi tron 2 mang va sap xep \n");
        XuatMang(n+m, arr3);
    }
   

}
