/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tinhtongsochanbehonn;

import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class TinhTongSoChanBeHonN {

    public static void main(String[] args) {
        System.out.println("Nhap n");
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int temp=0;
        for(int i=0;i<n;i++){
            if(i % 2 ==0 && i<n)
                temp += i;
        }
        System.out.printf("ket qua: %d", temp);
    }
}
