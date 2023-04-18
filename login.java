package TugasPBO;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("LOGIN");
        System.out.println("1.Admin");
        System.out.println("2.Customer");
        System.out.println("Silakan pilih jenis pengguna:");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Anda masuk sebagai Admin.");
        } else if (choice == 2) {
            System.out.println("Anda masuk sebagai Customer.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }


}
