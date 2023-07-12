

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Restaurant> restaurants = new ArrayList<>();
    public Main() {
    }

    public static void main(String[] args) {
        int check = 2;
        Scanner scanner = new Scanner(System.in);
        Login user1 = new Login();

        do {
            System.out.println("Login");
            System.out.println("=======MASUK/LOGIN=======");
            System.out.print("insert username : ");
            String user = scanner.nextLine();
            System.out.print("insert password : ");
            String password = scanner.nextLine();
            if ((!user.equals(user1.getUsername_user()) || !password.equals(user1.getPassword_user())) && (!user.equals(user1.getUsername_admin()) || !password.equals(user1.getPassword_admin()))) {
                System.out.println("Username / Password anda salah");
            } else {
                check = 0;
                if (user.equals(user1.getUsername_user())) {
                    System.out.println(" Welcome " + user);
                    int customerChoice = 0;
                    do {
                        System.out.println("=======MENU CUSTOMER=======");
                        System.out.println("1. Melihat Restoran");
                        System.out.println("2. Memilih Restoran");
                        System.out.println("3. Logout");
                        System.out.println("==========================");
                        System.out.print("Pilihan : ");
                        customerChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (customerChoice) {
                            case 1:
                                Restaurant.showRestaurants(restaurants);
                                break;
                            case 2:
                                // Menampilkan daftar restoran yang sudah ada
                                Restaurant.showRestaurants(restaurants);

                                // Memilih restoran yang telah didaftar
                                System.out.print("Daftar restoran : ");
                                String selectedRestaurant = scanner.nextLine();

                                // Mencari restoran yang dipilih di dalam list restoran
                                Restaurant chosenRestaurant = null;
                                for (Restaurant restaurant : restaurants) {
                                    if (restaurant.getName().equalsIgnoreCase(selectedRestaurant)) {
                                        chosenRestaurant = restaurant;
                                        break;
                                    }
                                }


                                if (chosenRestaurant != null) {
                                    ArrayList<String> menus = chosenRestaurant.getMenus();
                                    ArrayList<Double> prices = chosenRestaurant.getPrice();

                                    System.out.println("Menu " + chosenRestaurant.getName() + ":");
                                    for (int i = 0; i < menus.size(); i++) {
                                        System.out.println((i+1) + ". " + menus.get(i) + " - Rp " + prices.get(i));
                                    }


                                    ArrayList<String> cartMenus = new ArrayList<>();
                                    ArrayList<Double> cartPrices = new ArrayList<>();
                                    boolean continueOrdering = true;
                                    while (continueOrdering) {
                                        System.out.print("Pilih nomor menu: ");
                                        int menuNumber = scanner.nextInt();
                                        scanner.nextLine();
                                        cartMenus.add(menus.get(menuNumber-1));
                                        cartPrices.add(prices.get(menuNumber-1));

                                        System.out.print("Tambah pesanan lagi? (y/n): ");
                                        String answer = scanner.nextLine();
                                        continueOrdering = answer.equalsIgnoreCase("y");
                                    }

                                    // Menampilkan daftar pesanan dan total dari harga
                                    System.out.println("Pesanan Anda:");
                                    double totalPrice = 0;
                                    for (int i = 0; i < cartMenus.size(); i++) {
                                        System.out.println("- " + cartMenus.get(i) + " - Rp " + cartPrices.get(i));
                                        totalPrice += cartPrices.get(i);
                                    }
                                    System.out.println("Total harga: Rp " + totalPrice);
                                } else {
                                    System.out.println("Restoran tidak ditemukan.");
                                }
                                break;
                            case 3:
                                System.out.println("Keluar dari customer.");
                                break;
                            default:
                                System.out.println("Insert tidak valid.");
                        }
                    } while (customerChoice != 3);
                } else if (user.equals(user1.getUsername_admin())) {
                    System.out.println("Selamat datang admin " + user);
                    int choice = 0;
                    do {
                        System.out.println("=======MENU=======");
                        System.out.println("1. Tambah Restoran");
                        System.out.println("2. Hapus Restoran");
                        System.out.println("3. Lihat Restoran");
                        System.out.println("4. Keluar");
                        System.out.println("===================");
                        System.out.print("Pilih opsi : ");
                        choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                Restaurant.addRestaurant(restaurants);
                                break;
                            case 2:
                                Restaurant.deleteRestaurant(restaurants);
                                break;
                            case 3:
                                Restaurant.showRestaurants(restaurants);
                                break;
                            case 4:
                                System.out.println("Keluar dari admin.");
                                check = 2;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    } while (choice != 4);
                }
            }
        } while(check > 1);

    }
}
