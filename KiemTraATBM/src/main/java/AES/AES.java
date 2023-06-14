package AES;

import java.util.Scanner;

public class AES {

    private static final String base64Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static String toBase64(String data) {
        int counter = 0;
        int bitStream = 0;
        StringBuilder encoded = new StringBuilder();
        int offset = 0;
        for (char c : data.toCharArray()) {
            int numVal = (int) c;
            offset = 16 - counter % 3 * 8;
            bitStream += numVal << offset;
            if (offset == 16) {
                encoded.append(base64Chars.charAt(bitStream >> 18 & 0x3f));
            }
            if (offset == 8) {
                encoded.append(base64Chars.charAt(bitStream >> 12 & 0x3f));
            }
            if (offset == 0 && counter != 3) {
                encoded.append(base64Chars.charAt(bitStream >> 6 & 0x3f));
                encoded.append(base64Chars.charAt(bitStream & 0x3f));
                bitStream = 0;
            }
            counter++;
        }
        if (offset == 16) {
            encoded.append(base64Chars.charAt(bitStream >> 12 & 0x3f));
            encoded.append("==");
        }
        if (offset == 8) {
            encoded.append(base64Chars.charAt(bitStream >> 6 & 0x3f));
            encoded.append('=');
        }
        return encoded.toString();
    }

    public static String fromBase64(String data) {
        int counter = 0;
        int bitStream = 0;
        StringBuilder decoded = new StringBuilder();
        int offset = 0;
        for (char c : data.toCharArray()) {
            int numVal = base64Chars.indexOf(c);
            if (numVal != -1) {
                offset = 18 - counter % 4 * 6;
                bitStream += numVal << offset;
                if (offset == 12) {
                    decoded.append((char) (bitStream >> 16 & 0xff));
                }
                if (offset == 6) {
                    decoded.append((char) (bitStream >> 8 & 0xff));
                }
                if (offset == 0 && counter != 4) {
                    decoded.append((char) (bitStream & 0xff));
                    bitStream = 0;
                }
            } else if (c != '=') {
                return "";
            }
            counter++;
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("-------- Mã hóa/Giải mã bằng AES --------");
            System.out.println("1. Nhập thông điệp cần mã hóa");
            System.out.println("2. Mã hóa");
            System.out.println("3. Giải mã");
            System.out.println("4. Thoát");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Đọc dòng trống sau lệnh nextInt()
                    System.out.print("Nhập thông điệp cần mã hóa: ");
                    input = scanner.nextLine();
                    break;
                case 2:
                    if (!input.isEmpty()) {
                        String encoded = toBase64(input);
                        System.out.println("Thông điệp đã được mã hóa: " + encoded);
                    } else {
                        System.out.println("Vui lòng nhập thông điệp trước khi mã hóa.");
                    }
                    break;
                case 3:
                    if (!input.isEmpty()) {
                        String decoded = fromBase64(input);
                        System.out.println("Thông điệp đã được giải mã: " + decoded);
                    } else {
                        System.out.println("Vui lòng nhập thông điệp trước khi giải mã.");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
            System.out.println();
        }
    }
}
