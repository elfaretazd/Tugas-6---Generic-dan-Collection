package Marketplace;

public class Marketplace {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        Product<String> p1 = new Product<>(1, "Laptop", "Elektronik", 12000000);
        Product<String> p2 = new Product<>(2, "Kemeja", "Fashion", 150000);
        Product<String> p3 = new Product<>(3, "Smartphone", "Elektronik", 7000000);
        Product<String> p4 = new Product<>(4, "Sepatu", "Fashion", 300000);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);
        manager.addProduct(p4);

        System.out.println("=== Semua Produk (Diurutkan Berdasarkan Kategori) ===");
        manager.showAllProductsSorted();

        System.out.println("\n=== Semua Kategori Unik ===");
        manager.showAllCategories();

        System.out.println("\n=== Proses Produk ===");
        manager.processProduct(p1);
        manager.processProduct(p4);

        System.out.println("\n=== Antrian Produk yang Telah Diproses ===");
        manager.showProcessedQueue();

        System.out.println("\n=== Cari Produk (Nama: 'Laptop', Kategori: 'Elektronik') ===");
        for (Product<?> p : manager.searchProduct("Laptop", "Elektronik")) {
            System.out.println(p);
        }

        System.out.println("\n=== Hapus Produk dengan ID 2 ===");
        manager.removeProductById(2);
        manager.showAllProductsSorted();

        System.out.println("\n=== BONUS: Filter Produk dengan Harga 1jt - 8jt ===");
        for (Product<?> p : manager.filterByPrice(1_000_000, 8_000_000)) {
            System.out.println(p);
        }
    }
}
