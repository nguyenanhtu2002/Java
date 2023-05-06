package com.mycompany.reversestring;

import java.util.Scanner;

/**
 *
 * @author Nguyen Anh Tu
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println("Nhap chuoi");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        reverseStr(str);
    }

    public static void reverseStr(String str) {
        String ketqua = "";
        String arr[] = str.trim().split("\\s+");
        for (int i = arr.length - 1; i >= 0; i--) {
            ketqua += arr[i];
            if (i > 0) {
                ketqua += " ";
            }
        }
        System.out.printf("%s", ketqua);
    }

}
//nhập vào 1 chuỗi in ra chuỗi đảo ngược (xóa bỏ dấu cách thừa)
//ví dụ( “     hello     world   “) →(“world hello”)
