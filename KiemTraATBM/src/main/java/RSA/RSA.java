package RSA;

import java.util.Random;
import java.util.Scanner;

public class RSA{
    private static long p, q;
    private static long n, phiN;
    private static long e, d, m, c;

    public static long tinhMod(long a, long k, long n) {
        long res = 1;
        for (long i = 0; i < k; i++) {
            res = (res * a) % n;
        }
        return res;
    }

    public static long gcd(long q, long r) {
        if (r == 0) return q;
        return gcd(r, q % r);
    }

    public static long invMod(long a, long m) {
        if (gcd(a, m) == 1) {
            a = a % m;
            for (long i = 1; i < m; i++) {
                if ((a * i) % m == 1) return i;
            }
        }
        return -1;
    }

    public static boolean isPrime(long a) {
        if (a < 2) return false;
        for (long i = 2; i <= Math.sqrt(a); i++)
            if (a % i == 0) return false;
        return true;
    }

    public static void input() {
        Random rand = new Random();
        do {
            q = rand.nextInt(100) + 1;
        } while (!isPrime(q));
        do {
            p = rand.nextInt(100) + 1;
        } while (!isPrime(p));
        n = p * q;
        phiN = (p - 1) * (q - 1);
        do {
            e = rand.nextInt((int) (phiN - 2)) + 2;
        } while (gcd(e, phiN) != 1);
        d = invMod(e, phiN);
        System.out.println("================Khoa da tao: " + p + " va " + q);
    }

    public static void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap thong diep: ");
        m = scanner.nextLong();
    }

    public static long cypher() {
        c = tinhMod(m, e, n);
        return c;
    }

    public static long plain() {
        m = tinhMod(c, d, n);
        return m;
    }

    public static void menu() {
        System.out.println("\n==============================================");
        System.out.println(" |   1. Sua thong tin can ma hoa               |");
        System.out.println(" |   2. Tao khoa                               |");
        System.out.println(" |   3. Ma hoa                                 |");
        System.out.println(" |   4. Giai ma                                |");
        System.out.println(" |   5. Ket thuc chuong trinh                  |");
        System.out.println("\n==============================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            menu();
            System.out.print("___Nhap lua chon: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    nhapThongTin();
                    break;
                case 2:
                    input();
                    break;
                case 3:
                    System.out.println("==========================Cypher: " + cypher());
                    break;
                case 4:
                    System.out.println("\n========================Plain: " + plain());
                    break;
                case 5:
                    System.out.println("Chuong trinh ket thuc.");
                    System.exit(0);
            }
        } while (choice != 5);
    }
}
