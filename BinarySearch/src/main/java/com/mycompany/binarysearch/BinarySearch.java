package com.mycompany.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int key;
        System.out.println("enter the number to search");
        key = sc.nextInt();

        System.out.println("Enter the number of array elements:");
        n = sc.nextInt();

        int arr[] = new int[n];
        inputArray(n, arr);
        Arrays.sort(arr);
        if (searchKey(key, arr)) {
            System.out.println("had found");
        } else {
            System.out.println("can not find ");
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

