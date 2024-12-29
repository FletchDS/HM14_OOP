package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class ProductBasket {
    private int count = 0;
    private final int MAX_COUNT = 5;
    private final Product[] products = new Product[MAX_COUNT];

    public void addProduct(Product product) {
        if (count == MAX_COUNT) {
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
            result += products[i].toString() + "\n";
        }

        result += "Итого: " + getTotalCost() + "\n";
        result += "Специальных товаров:  " + getNumberOfSpecialProducts();

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

    public int getNumberOfSpecialProducts(){
        int number =0;

        for (int i = 0; i < count; i++) {
            if (products[i].isSpecial()) {
                number++;
            }
        }

        return  number;
    }

    public void clearBasket() {
        for (Product product : products) {
            product = null;
        }

        count = 0;
    }

}
