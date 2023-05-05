/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sapxepmang1chieu;

import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class SapXepMang1Chieu {

    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("nhap so phan tu mang: ");
        n = sc.nextInt();    
        }
        while(n<0);
        int arr[] = new int[n + 1];
        NhapMang(n, arr);
        System.out.println("mang vua nhap:");
        XuatMang(n, arr);
        SapXepTangDan(n, arr);
        SapXepGiamDan(n,arr);
    }

    public static void NhapMang(int n, int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d]= ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static void XuatMang(int n, int arr[]) {
        for (int i = 0; i < n; i++) {
            System.out.printf(" arr[%d] = %d ", i, arr[i]);
        }
    }

    public static void SapXepTangDan(int n, int arr[]) {
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
        XuatMang(n, arr);
    }
        public static void SapXepGiamDan(int n, int arr[]) {
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
        XuatMang(n, arr);
    }
}
