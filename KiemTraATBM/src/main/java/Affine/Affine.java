package Affine;

import java.util.Scanner;

import java.util.Scanner;

public class Affine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        int a = 0, b = 0;
        while (true) {
            System.out.println("1. Nhập thông điệp: ");
            System.out.println("2. Nhập khóa K");
            System.out.println("3. Mã hóa thông điệp sử dụng khóa K");
            System.out.println("4. Giải mã bản mã để thu được bản rõ ban đầu");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Nhập thông điệp cần mã hóa: ");
                    text = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Nhập giá trị a trong khóa K: ");
                    a = scanner.nextInt();
                    System.out.print("Nhập giá trị b trong khóa K: ");
                    b = scanner.nextInt();
                    if (gcd(a, 26) != 1) {
                        System.out.println("Lỗi: a và 26 không có ước chung lớn nhất");
                        continue;
                    }
                    break;
                case 3:
                    if (a == 0 || b == 0) {
                        System.out.println("Lỗi: cần nhập khóa K trước khi mã hóa");
                        continue;
                    }
                    String cipher = affineEncrypt(text, a, b);
                    System.out.println("Bản mã: " + cipher);
                    break;
                case 4:
                    if (a == 0 || b == 0) {
                        System.out.println("Lỗi: cần nhập khóa K trước khi giải mã");
                        continue;
                    }
                    String plaintext = affineDecrypt(text, a, b);
                    System.out.println("Bản rõ ban đầu: " + plaintext);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lỗi: chức năng không hợp lệ");
                    break;
            }
        }
    }

    public static String affineEncrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                result.append((char) (((a * (ch - 'A')) + b) % 26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) (((a * (ch - 'a')) + b) % 26 + 'a'));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String affineDecrypt(String cipher, int a, int b) {
        StringBuilder result = new StringBuilder();
        int a_inv = 0, flag = 0;
        for (int i = 0; i < 26; i++) {
            flag = (a * i) % 26;
            if (flag == 1) {
                a_inv = i;
                break;
            }
        }
        for (int i = 0; i < cipher.length(); i++) {
            char ch = cipher.charAt(i);
            if (Character.isUpperCase(ch)) {
                result.append((char) (((a_inv * ((ch - 'A' - b + 26)) % 26)) + 'A'));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) (((a_inv * ((ch - 'a' - b + 26)) % 26)) + 'a'));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}