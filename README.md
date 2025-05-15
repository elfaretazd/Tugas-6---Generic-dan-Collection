# Tugas-6---Generic-dan-Collection

Fitur Tambahan: Produk Termahal per Kategori

🎯 Tujuan Fitur:
Menampilkan produk paling mahal (dengan harga tertinggi) dari setiap kategori produk yang tersedia di marketplace.

💡 Alasan dan Manfaat:
Berguna untuk menyoroti produk unggulan atau premium dalam setiap kategori.

Bermanfaat bagi pengguna yang ingin melihat produk dengan nilai paling tinggi per kategori.

Memanfaatkan struktur data HashMap dan Generic class Product<T> agar fleksibel terhadap tipe kategori.

🧠 Konsep Dasar:
Menggunakan:

Map<String, Product<?>>:

Key: kategori (sebagai String)

Value: objek Product<?> dengan harga tertinggi di kategori tersebut

Iterasi semua produk, lalu bandingkan dan simpan produk dengan harga tertinggi untuk masing-masing kategori.

🧪 Contoh Kasus:
Misal terdapat 4 produk:

java
Salin kode
Product<String> p1 = new Product<>(1, "Laptop", "Elektronik", 12000000);

Product<String> p2 = new Product<>(2, "Kemeja", "Fashion", 150000);

Product<String> p3 = new Product<>(3, "Smartphone", "Elektronik", 7000000);

Product<String> p4 = new Product<>(4, "Sepatu", "Fashion", 300000);

Maka output dari fitur ini:

=== Produk Termahal per Kategori ===

Kategori: Elektronik → ID: 1, Name: Laptop, Category: Elektronik, Price: 12000000.0

Kategori: Fashion → ID: 4, Name: Sepatu, Category: Fashion, Price: 300000.0

🧑‍💻 Implementasi Kode:

📄 Di ProductManager.java:

Tambahkan method berikut:

public void showMostExpensivePerCategory() {

    Map<String, Product<?>> expensiveMap = new HashMap<>();

    for (Product<?> p : products) {

        String category = p.getCategory().toString();

        if (!expensiveMap.containsKey(category) || p.getPrice() > 

expensiveMap.get(category).getPrice()) {

            expensiveMap.put(category, p);
        }
    }

    System.out.println("=== Produk Termahal per Kategori ===");

    for (Map.Entry<String, Product<?>> entry : expensiveMap.entrySet()) {

        System.out.println("Kategori: " + entry.getKey() + " → " + entry.getValue());
    }
}

📄 Di Marketplace.java:

Panggil method di main():

System.out.println("\n=== FITUR TAMBAHAN: Produk Termahal per Kategori ===");
manager.showMostExpensivePerCategory();

📦 Struktur Data yang Digunakan:
Struktur	Fungsi
HashMap<String, Product<?>>	Menyimpan produk termahal berdasarkan nama kategori
Generic Product<T>	Mendukung fleksibilitas tipe kategori
ArrayList<Product<?>>	Sumber data produk untuk iterasi

