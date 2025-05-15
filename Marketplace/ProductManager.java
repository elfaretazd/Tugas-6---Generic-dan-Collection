package Marketplace;

import java.util.*;

public class ProductManager {
    private List<Product<?>> products = new ArrayList<>();
    private Set<String> categories = new HashSet<>();
    private Queue<Product<?>> processedQueue = new LinkedList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
        categories.add(product.getCategory().toString());
    }

    public void removeProductById(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    public List<Product<?>> searchProduct(String name, String category) {
        List<Product<?>> result = new ArrayList<>();
        for (Product<?> p : products) {
            if (p.getName().equalsIgnoreCase(name) &&
                p.getCategory().toString().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    public void showAllProductsSorted() {
        List<Product<?>> sorted = new ArrayList<>(products);
        sorted.sort(Comparator.comparing(p -> p.getCategory().toString()));
        for (Product<?> p : sorted) {
            System.out.println(p);
        }
    }

    public void showAllCategories() {
        for (String category : categories) {
            System.out.println(category);
        }
    }

    public void processProduct(Product<?> product) {
        processedQueue.add(product);
    }

    public void showProcessedQueue() {
        for (Product<?> p : processedQueue) {
            System.out.println(p);
        }
    }

    // Bonus: Filter produk berdasarkan harga
    public List<Product<?>> filterByPrice(double min, double max) {
        List<Product<?>> result = new ArrayList<>();
        for (Product<?> p : products) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                result.add(p);
            }
        }
        return result;
    }
}
