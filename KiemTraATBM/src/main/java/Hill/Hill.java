package Hill;

import java.util.Scanner;

public class Hill {
    private static int[][] khoa;
    private static int[][] khoa1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String chuoi = scanner.nextLine();

        initKhoa(scanner);

        int luaChon;

        do {
            System.out.println("\n*** MENU ***");
            System.out.println("1. Mã hóa");
            System.out.println("2. Giải mã");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();

            switch(luaChon) {
                case 1:
                    String chuoiDaMaHoa = maHoa(chuoi);
                    System.out.println("Chuỗi đã mã hóa: " + chuoiDaMaHoa);
                    break;
                case 2:
                    String chuoiDaGiaiMa = giaiMa(chuoi);
                    System.out.println("Chuỗi đã giải mã: " + chuoiDaGiaiMa);
                    break;
                case 3:
                    System.out.println("Cảm ơn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while(luaChon != 3);

        scanner.close();
    }

    private static void initKhoa(Scanner scanner) {
        khoa = new int[2][2];
        khoa1 = new int[2][2];

        int d;

        do {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print("Nhập khóa[" + i + "][" + j + "]: ");
                    int tg = scanner.nextInt();
                    khoa[i][j] = tg % 26;
                }
            }

            d = khoa[0][0] * khoa[1][1] - khoa[0][1] * khoa[1][0];
            if ((d % 26) != 1) {
                System.out.println("\nKhóa không thỏa mãn.");
            }
        } while ((d % 26) != 1);

        khoa1[0][0] = khoa[1][1];
        khoa1[1][1] = khoa[0][0];
        khoa1[0][1] = (26 - khoa[0][1]) % 26;
        khoa1[1][0] = (26 - khoa[1][0]) % 26;
    }

    private static void nhanMaTran(int[] a, int[][] b, int[] c) {
        c[0] = (a[0] * b[0][0] + a[1] * b[1][0]) % 26;
        c[1] = (a[0] * b[0][1] + a[1] * b[1][1]) % 26;
    }

    private static String maHoa(String banRo) {
        String tmp = "";
        int l = banRo.length();
        int[] a = new int[2];
        int[] b = new int[2];

        for (int i= 0; i < l; i+=2) {
            banRo = banRo.toUpperCase();
            a[0] = (banRo.charAt(i) - 65) % 26;
            a[1] = (banRo.charAt(i + 1) - 65) % 26;
            nhanMaTran(a, khoa, b);
            tmp += (char) ((b[0] % 26) + 65);
            tmp += (char) ((b[1] % 26) + 65);
        }

        return tmp;
    }

    private static String giaiMa(String banMa) {
        String tmp = "";
        int l = banMa.length();
        int[] a = new int[2];
        int[] b = new int[2];

        for (int i = 0; i < l; i+=2) {
            banMa = banMa.toUpperCase();
            a[0] = (banMa.charAt(i) - 65) % 26;
            a[1] = (banMa.charAt(i + 1) - 65) % 26;
            nhanMaTran(a, khoa1, b);
            tmp += (char) ((b[0] % 26) + 65);
            tmp += (char) ((b[1] % 26) + 65);
        }

        return tmp;
    }
}