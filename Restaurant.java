

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private String nama;
    private ArrayList<String> menus;
    private ArrayList<Double> harga;
    private static Scanner scanner = new Scanner(System.in);

    public Restaurant() {
        this.nama = nama;
        this.menus = menus;
        this.harga = harga;
    }

    public String getName() {
        return nama;
    }

    public void setName(String name) {
        this.nama = nama;
    }

    public ArrayList<String> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<String> menus) {
        this.menus = menus;
    }

    public ArrayList<Double> getPrice() {
        return harga;
    }

    public void setPrice(ArrayList<Double> price) {
        this.harga = price;
    }
    //fungsi dari admin
    public static void addRestaurant(ArrayList<Restaurant> restaurants) {
        System.out.print("Insert nama restaurant : ");
        String name = scanner.nextLine();

        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setName(name);

        ArrayList<String> menus = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        boolean continueAddingMenu = true;
        while (continueAddingMenu) {
            System.out.print("Masukkan menu : ");
            String menu = scanner.nextLine();
            menus.add(menu);

            System.out.print("Harga : ");
            Double price = scanner.nextDouble();
            prices.add(price);

            scanner.nextLine();

            System.out.print("Tambah menu baru? (y/n): ");
            String answer = scanner.nextLine();
            continueAddingMenu = answer.equalsIgnoreCase("y");
        }

        newRestaurant.setMenus(menus);
        newRestaurant.setPrice(prices);

        restaurants.add(newRestaurant);
        System.out.println("sukses menambah restaurant.");
    }

    public static void deleteRestaurant(ArrayList<Restaurant> restaurants) {
        System.out.print("nama restaurant yang ingin dihapus : ");
        String nameToDelete = scanner.nextLine();

        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            if (restaurant.getName().equalsIgnoreCase(nameToDelete)) {
                restaurants.remove(i);
                System.out.println("Restaurant telah dihapus.");
                return;
            }
        }

        System.out.println("Restaurant tidak ditemukan.");
    }

    public static void showRestaurants(ArrayList<Restaurant> restaurants) {
        System.out.println("List of restaurants:");

        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant.getName());
        }
    }
    //fungsi customer
    public void showMenu() {
        System.out.println("Daftar menu di " + this.getName() + ":");

        for (int i = 0; i < menus.size(); i++) {
            System.out.println("- " + menus.get(i) + " : Rp " + harga.get(i));
        }
    }
    public double calculateTotal(ArrayList<String> selectedMenus) {
        double total = 0;

        for (String selectedMenu : selectedMenus) {
            int index = menus.indexOf(selectedMenu);
            if (index != -1) {
                total += harga.get(index);
            }
        }

        return total;
    }
    public boolean hasMenu(String menuName) {
        return menus.contains(menuName);
    }

}

