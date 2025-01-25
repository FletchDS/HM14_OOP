package org.skypro.skyshop.product.simple;

import org.skypro.skyshop.product.Product;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (!(price > 0)) {
            throw new IllegalArgumentException("Цена товара должна быть больше 0");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %d",
                getName(),
                getPrice());
    }
}
