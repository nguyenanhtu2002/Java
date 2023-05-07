/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sumnumber;

/**
 *
 * @author Nguyen Anh Tu
 */
public class SumNumber {

    public static void main(String[] args) {
        int n;
        int temp = 0;
        do {
            System.out.println("input n: ");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0 && i < n) {
                    temp += i;
                }
            }
        } while (n < 0);
        System.out.printf("result: %d", temp);
    }
}
