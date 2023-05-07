/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.binary_search;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class Binary_Search {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int key;
        System.out.println("Nhap so can tim");
        key = sc.nextInt();

        System.out.println("nhap so phan tu trong mang:");
        n = sc.nextInt();

        int arr[] = new int[n];
        inputArray(n, arr);
        Arrays.sort(arr);
        if (searchKey(key, arr)) {
            System.out.println("tim thay");
        } else {
            System.out.println("ko tim thay ");
        }
    }

    public static void inputArray(int n, int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d]= ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static boolean searchKey(int key, int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
