package org.skypro.skyshop.product.discount;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {

    private int price;
    private int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        this.price = price;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return (int)(price - price * ((double)discount / 100));
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %d (%d%%)",
                getName(),
                getPrice(),
                discount);
    }
}
