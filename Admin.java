package TugasPBO;

import java.util.ArrayList;
import java.util.Scanner;
public class Admin {

    public class AdminRestoran {
        private static ArrayList<String> restoranList = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            boolean exit = false;
            while (!exit) {
                System.out.println("Silahkan pilih opsi:");
                System.out.println("1. Tambah Restoran");
                System.out.println("2. Hapus Restoran");
                System.out.println("3. Lihat Restoran");
                System.out.println("4. Keluar");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        tambahRestoran();
                        break;
                    case 2:
                        hapusRestoran();
                        break;
                    case 3:
                        lihatRestoran();
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Masukkan opsi yang benar.");
                }
            }
        }

        private static void tambahRestoran() {
            System.out.print("Masukkan nama restoran: ");
            String restoran = scanner.nextLine();
            restoranList.add(restoran);
            System.out.println("Restoran berhasil ditambahkan!");
        }

        private static void hapusRestoran() {
            System.out.print("Masukkan nama restoran yang ingin dihapus: ");
            String restoran = scanner.nextLine();
            boolean removed = restoranList.remove(restoran);
            if (removed) {
                System.out.println("Restoran berhasil dihapus!");
            } else {
                System.out.println("Restoran tidak ditemukan.");
            }
        }

        private static void lihatRestoran() {
            if (restoranList.isEmpty()) {
                System.out.println("Belum ada restoran yang ditambahkan.");
            } else {
                System.out.println("Daftar Restoran:");
                for (String restoran : restoranList) {
                    System.out.println(restoran);
                }
            }
        }
    }

}
