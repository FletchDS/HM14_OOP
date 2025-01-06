package org.skypro.skyshop.product.fixprice;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {

    public final int PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: Фиксированная цена %d",
                getName(),
                getPrice());
    }
}
