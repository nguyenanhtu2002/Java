package View;

//Ceasar
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khai báo mảng ký tự P để lưu các ký tự trong bảng chữ cái
        char[] P = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        while (true) {
            // In menu chức năng
            System.out.println("1. Ma hoa xau ky tu");
            System.out.println("2. Giai ma xau ky tu");
            System.out.println("3. Thoat");

            // Nhập lựa chọn từ bàn phím
            System.out.print("Nhap lua chon cua ban: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Nhập xâu ký tự và khoá từ bàn phím
                System.out.print("Nhap xau ky tu: ");
                String s = scanner.next();
                System.out.print("Nhap khoa k: ");
                int k = scanner.nextInt();

                // Mã hóa xâu ký tự
                String result = "";
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    int index = -1;

                    // Tìm vị trí của ký tự c trong mảng P
                    for (int j = 0; j < P.length; j++) {
                        if (P[j] == c) {
                            index = j;
                            break;
                        }
                    }

                    // Mã hóa ký tự c nếu nó có trong mảng P
                    if (index != -1) {
                        index = (index + k) % P.length;
                        result += P[index];
                    } else {
                        result += c;
                    }
                }

                // In kết quả mã hóa ra màn hình
                System.out.println("Xau da duoc ma hoa: " + result);
            } else if (choice == 2) {
                // Nhập xâu ký tự và khoá từ bàn phím
                System.out.print("Nhap xau ky tu: ");
                String s = scanner.next();
                System.out.print("Nhap khoa k: ");
                int k = scanner.nextInt();

                // Giải mã xâu ký tự
                String original = "";
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    int index = -1;

                    // Tìm vị trí của ký tự c trong mảng P
                    for (int j = 0; j < P.length; j++) {
                        if (P[j] == c) {
                            index = j;
                            break;
                        }
                    }

                    // Giải mã ký tự c nếu nó có trong mảng P
                    if (index != -1) {
                        index = (index - k + P.length) % P.length;
                        original += P[index];
                    } else {
                        original += c;
                    }
                }

                // In kết quả giải mã ra màn hình
                System.out.println("Xau ban dau: " + original);
            } else if (choice == 3) {
                // Thoát khỏi chương trình
                System.out.println("Cam on da su dung chuong trinh!");
                break;
            } else {
                // Lựa chọn không hợp lệ
                System.out.println("Lua chon khong hop le!");
            }
        }
    }
}