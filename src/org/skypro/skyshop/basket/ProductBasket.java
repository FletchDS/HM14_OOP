package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private int count = 0;
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), s -> new ArrayList<>()).add(product);

        count++;
    }

    public List<Product> removeProduct(String name) {
        List<Product> result = new ArrayList<>();

        if (products.containsKey(name)) {
            result = products.get(name);

            products.remove(name);
        }

        return result;
    }

    public int getTotalCost() {
        int result = 0;

        result = products.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();

        return result;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        products.values().stream().flatMap(Collection::stream)
                .forEach(i -> System.out.print(i.toString() + "\n"));

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров:  " + getNumberOfSpecialProducts());
    }

    public boolean findProduct(String productName) {
        if (products.containsKey(productName)) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumberOfSpecialProducts() {
        int number = 0;

        number = (int) products.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();

        return number;
    }

    public void clearBasket() {
        products.values().stream().flatMap(Collection::stream)
                .forEach(i -> i = null);

        products.entrySet()
                .forEach(i -> i = null);

        count = 0;
    }

}
