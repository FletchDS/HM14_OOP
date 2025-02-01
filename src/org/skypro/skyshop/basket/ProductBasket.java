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

        if (products.containsKey(name)){
            result = products.get(name);

            products.remove(name);
        }

        return result;
    }

    public int getTotalCost() {
        int result = 0;

        for (Map.Entry<String, List<Product>> tempProducts : products.entrySet()) {
            for (Product product : tempProducts.getValue()) {
                result += product.getPrice();
            }
        }

        return result;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        String result = "";
        for (Map.Entry<String, List<Product>> tempProducts : products.entrySet()) {
            for (Product product : tempProducts.getValue()) {
                result += product.toString() + "\n";
            }
        }

        result += "Итого: " + getTotalCost() + "\n";
        result += "Специальных товаров:  " + getNumberOfSpecialProducts();

        System.out.println(result);
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

        for (Map.Entry<String, List<Product>> tempProducts : products.entrySet()) {
            for (Product product : tempProducts.getValue()) {
                if (product.isSpecial()) {
                    number++;
                }
            }
        }

        return number;
    }

    public void clearBasket() {
        for (Map.Entry<String, List<Product>> tempProducts : products.entrySet()) {
            for (Product product : tempProducts.getValue()) {
                product = null;
            }
            tempProducts = null;
        }

        count = 0;
    }

}
