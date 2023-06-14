package DiffieHellman;

import java.math.BigInteger;
import java.util.Scanner;

public class DiffieHellman{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Diffie-Hellman Key Exchange -----");
            System.out.println("1. Tính căn nguyên thủy của một số nguyên tố");
            System.out.println("2. Tính khóa công khai của bên gửi và bên nhận");
            System.out.println("3. Tính khóa bí mật của bên gửi và bên nhận");
            System.out.println("4. Hiển thị khóa bí mật K");
            System.out.println("0. Thoát");
            System.out.print("Vui lòng chọn chức năng (0-4): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    findPrimitiveRoot(scanner);
                    break;
                case 2:
                    calculatePublicKeys(scanner);
                    break;
                case 3:
                    calculatePrivateKeys(scanner);
                    break;
                case 4:
                    displaySharedSecretKey(scanner);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                    break;
            }

            System.out.println("\nNhấn phím bất kỳ để tiếp tục...");
            scanner.nextLine();
            System.out.println("---------------------------------------");
        }
    }

    // Tìm căn nguyên thủy của một số nguyên tố
    public static void findPrimitiveRoot(Scanner scanner) {
        System.out.print("Nhập số nguyên tố q: ");
        int q = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i < q; i++) {
            if (isPrimitiveRoot(i, q)) {
                System.out.println("Căn nguyên thủy của " + q + " là: " + i);
                return;
            }
        }

        System.out.println("Không tìm thấy căn nguyên thủy của " + q + ".");
    }

    // Kiểm tra xem một số có phải là căn nguyên thủy của một số nguyên tố hay không
    public static boolean isPrimitiveRoot(int a, int q) {
        if (gcd(a, q) != 1)
            return false;

        int totient = q - 1;
        int[] factors = primeFactorization(totient);

        for (int i = 0; i < factors.length; i++) {
            if (BigInteger.valueOf(a).modPow(BigInteger.valueOf(totient / factors[i]), BigInteger.valueOf(q)).equals(BigInteger.ONE))
                return false;
        }

        return true;
    }

    // Tính ước chung lớn nhất của hai số
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // Phân tích một số thành các thừa số nguyên tố
    public static int[] primeFactorization(int n) {
        int[] factors = new int[32];
        int count = 0;

        while (n % 2 == 0) {
            factors[count++] = 2;
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors[count++] = i;
                n /= i;
            }
        }

        if (n > 2)
            factors[count++] = n;

        int[] resizedFactors = new int[count];
        System.arraycopy(factors, 0, resizedFactors, 0, count);
        return resizedFactors;
    }

    // Tính khóa công khai của bên gửi và bên nhận
    public static void calculatePublicKeys(Scanner scanner) {
        System.out.print("Nhập số nguyên tố p: ");
        int p = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập căn nguyên thủy g: ");
        int g = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập khóa bí mật của bên gửi a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập khóa bí mật của bên nhận b: ");
        int b = Integer.parseInt(scanner.nextLine());

        int A = BigInteger.valueOf(g).modPow(BigInteger.valueOf(a), BigInteger.valueOf(p)).intValue();
        int B = BigInteger.valueOf(g).modPow(BigInteger.valueOf(b), BigInteger.valueOf(p)).intValue();

        System.out.println("Khóa công khai của bên gửi A: " + A);
        System.out.println("Khóa công khai của bên nhận B: " + B);
    }

    // Tính khóa bí mật của bên gửi và bên nhận
    public static void calculatePrivateKeys(Scanner scanner) {
        System.out.print("Nhập số nguyên tố p: ");
        int p = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập khóa bí mật của bên gửi a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập khóa công khai của bên nhận B: ");
        int B = Integer.parseInt(scanner.nextLine());

        int secretKeyA = BigInteger.valueOf(B).modPow(BigInteger.valueOf(a), BigInteger.valueOf(p)).intValue();

        System.out.print("Nhập khóa bí mật của bên nhận b: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập khóa công khai của bên gửi A: ");
        int A = Integer.parseInt(scanner.nextLine());

        int secretKeyB = BigInteger.valueOf(A).modPow(BigInteger.valueOf(b), BigInteger.valueOf(p)).intValue();

        if (secretKeyA == secretKeyB)
            System.out.println("Khóa bí mật K: " + secretKeyA);
        else
            System.out.println("Khóa bí mật không trùng khớp!");
    }

    // Hiển thị khóa bí mật K lên màn hình
    public static void displaySharedSecretKey(Scanner scanner) {
        System.out.print("Nhập khóa bí mật K: ");
        int secretKey = Integer.parseInt(scanner.nextLine());

        System.out.println("Khóa bí mật K: " + secretKey);
    }
}
