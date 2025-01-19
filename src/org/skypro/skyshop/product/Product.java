package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    private String name;

    public Product(String name) {
        if (name == null) {
            throw new NullPointerException("Попытка обращения к переменной со значением null");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Строка была пустой или состояла исключительно из пробелов");
        }
        this.name = name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public abstract String toString();
}
