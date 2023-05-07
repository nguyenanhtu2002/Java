package com.mycompany.elementpositioninarray;

import java.util.Scanner;

public class ElementPositionInArray {

    public static void main(String[] args) {
        System.out.println("Enter the number of array elements");
        int sizeArray = 0;
        int a, b;
        Scanner sc = new Scanner(System.in);
        sizeArray = sc.nextInt();
        int arr[] = new int[sizeArray + 1];
        inputArray(sizeArray, arr);
        System.out.println("input number a");
        a = sc.nextInt();
        System.out.println("input number b");
        b = sc.nextInt();
        Position(sizeArray, arr, a - b);
    }

    public static void inputArray(int sizeArray, int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < sizeArray; i++) {
            System.out.printf("arr[%d] = ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static void Position(int n, int arr[], int key) {
        int check = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.printf("position at: arr[%d]", i);
                check += 1;
            }
        }
        if (check == 0) {
            System.out.println("can not find");
        }
    }
}
//nhập từ bàn phím 1 mảng, 2 số a và b in ra vị trí phần tử a-b có trong mảng
