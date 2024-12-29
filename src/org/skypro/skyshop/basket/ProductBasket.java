package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class ProductBasket {
    private int count = 0;
    private final int maxCount = 5;
    private final Product[] products = new Product[maxCount];

    public void addProduct(Product product) {
        if (count == maxCount) {
            System.out.println("Невозможно добавить продукт");
            return;
        }

        products[count] = product;

        count++;
    }

    public int getTotalCost() {
        int result = 0;

        for (int i = 0; i < count; i++) {
            result += products[i].getPrice();
        }

        return result;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        String result = "";
        for (int i = 0; i < count; i++) {
            result += String.format(
                    "%s: %d\n",
                    products[i].getName(),
                    products[i].getPrice());
        }

        result += "Итого: " + getTotalCost();

        System.out.println(result);
    }

    public boolean findProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(products[i].getName(), productName)) {
                return true;
            }
        }

        return false;
    }

    public void clearBasket() {
        for (Product product : products) {
            product = null;
        }

        count = 0;
    }

}
