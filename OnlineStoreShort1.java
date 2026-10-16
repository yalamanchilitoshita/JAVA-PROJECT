import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.*;

public class OnlineStoreShort {
    static final Scanner sc = new Scanner(System.in);                 // M1: input
    static final Product[] products = {                              // M3: array
        new Product(1, "Laptop", 50000), new Product(2, "Phone", 25000),
        new Product(3, "Headphones", 2000), new Product(4, "Keyboard", 1500)
    };
    static final Map<Integer, Integer> cart = new HashMap<>();        // M6: Map

    public static void main(String[] args) {
        int choice;
        do {                                                          // M2: loop
            System.out.println("\nONLINE STORE\n1.Products  2.Add to cart  3.Cart  4.Search  5.Sort  6.Order  7.Exit");
            choice = readInt("Choice: ");
            switch (choice) {                                         // M2: switch
                case 1 -> showProducts();
                case 2 -> addToCart();
                case 3 -> showCart();
                case 4 -> search();
                case 5 -> sortProducts();
                case 6 -> placeOrder();
                case 7 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }

    static int readInt(String msg) {                                  // M1: method + exception
        while (true) try { System.out.print(msg); return Integer.parseInt(sc.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Enter a number."); }
    }

    static void showProducts() {
        for (Product p : products) System.out.println(p);             // M3: enhanced for
    }

    static void addToCart() {
        showProducts();
        int id = readInt("Product ID: "), qty = readInt("Quantity: ");
        if (find(id) == null || qty <= 0) System.out.println("Invalid product or quantity.");
        else { cart.put(id, cart.getOrDefault(id, 0) + qty); System.out.println("Added to cart."); }
    }

    static void showCart() {
        if (cart.isEmpty()) { System.out.println("Cart is empty."); return; }
        StringBuilder bill = new StringBuilder("YOUR CART\n");       // M5: StringBuilder
        cart.forEach((id, qty) -> bill.append(find(id).name).append(" x ").append(qty)
                .append(" = ₹").append(find(id).price * qty).append('\n'));
        System.out.print(bill);
        System.out.println("Total = ₹" + total());
    }

    static double total() {                                           // M6: stream + lambda
        return cart.entrySet().stream().mapToDouble(e -> find(e.getKey()).price * e.getValue()).sum();
    }

    static void search() {
        System.out.print("Search name: ");
        String q = sc.nextLine().trim().toLowerCase();                // M5: String operations
        List<Product> found = Arrays.stream(products)
                .filter(p -> p.name.toLowerCase().contains(q)).toList();
        if (found.isEmpty()) System.out.println("No product found.");
        else found.forEach(System.out::println);
    }

    static void sortProducts() {                                      // M5: sorting algorithm/library
        Arrays.sort(products, Comparator.comparingDouble(p -> p.price));
        showProducts();
    }

    static void placeOrder() {
        if (cart.isEmpty()) { System.out.println("Cart is empty."); return; }
        String order = "Order total: ₹" + total() + "\n";
        try { Files.writeString(Path.of("orders.txt"), order, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
              System.out.println("Order saved!\n" + order); cart.clear(); }
        catch (IOException e) { System.out.println("Could not save order."); }
    }

    static Product find(int id) {
        for (Product p : products) if (p.id == id) return p;
        return null;
    }

    static double discount(double price) { return discount(price, 10); } // M3: overloading
    static double discount(double price, double percent) { return price - price * percent / 100; }
    static int countProducts(Product[] items, int i) {                // M3: recursion
        return i == items.length ? 0 : 1 + countProducts(items, i + 1);
    }

    interface Identifiable { int getId(); }                           // M4: interface
    static class Product implements Identifiable, Comparable<Product> { // M4: class/object
        private final int id; private final String name; private final double price;
        Product(int id, String name, double price) { this.id = id; this.name = name; this.price = price; }
        public int getId() { return id; }
        public int compareTo(Product other) { return name.compareToIgnoreCase(other.name); }
        public String toString() { return id + ". " + name + " - ₹" + price; }
    }
}
