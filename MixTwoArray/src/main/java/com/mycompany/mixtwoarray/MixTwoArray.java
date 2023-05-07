
package com.mycompany.mixtwoarray;

import java.util.Arrays;
import java.util.Scanner;

public class MixTwoArray {

    public static void main(String[] args) {
        int sizeArr1, sizeArr2 = 0;
        int a, b;
        System.out.println("Enter the number of array elements one: ");
        Scanner sc = new Scanner(System.in);
        sizeArr1 = sc.nextInt();
        int arr1[] = new int[sizeArr1 + 1];
        inputArray(sizeArr1, arr1);
        
        System.out.println("Enter the number of array elements two: ");
        sizeArr2 = sc.nextInt();   
        int arr2[] = new int[sizeArr2 + 1];      
        inputArray(sizeArr2, arr2);
        
        int arr3[] = new int[sizeArr1 + sizeArr2];
        mixTwoArray(sizeArr1,sizeArr2,arr1,arr2,arr3);
    }

    public static void inputArray(int sizeArr1, int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < sizeArr1; i++) {
            System.out.printf("\n arr[%d] = ", i);
            arr[i] = sc.nextInt();
        }
    }

    public static void outputArray(int sizeArr1, int arr[]) {
        for (int i = 0; i < sizeArr1; i++) {
            System.out.printf(" arr[%d] = %d ", i, arr[i]);
        }
    }
    public static void mixTwoArray(int sizeArr1, int sizeArr2, int arr1[], int arr2[], int arr3[]){
        for(int i=0;i<sizeArr1;i++){
            arr3[i]= arr1[i];      
        }
        for(int i=0;i<sizeArr2;i++){
            arr3[sizeArr1+i] = arr2[i];
        }
        Arrays.sort(arr3);
        System.out.println("result \n");
        outputArray(sizeArr1+sizeArr2, arr3);
    }
   

}
