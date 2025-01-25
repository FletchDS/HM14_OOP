package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private int count = 0;
    private final List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        products.add(product);

        count++;
    }

    public List<Product> removeProduct(String name){
        List<Product> result = new ArrayList<>();
        Iterator<Product> productIterator = products.iterator();

        while (productIterator.hasNext()){
            Product product = productIterator.next();

            if (Objects.equals(product.getName(), name)){
                result.add(product);
                products.remove(product);
                count--;
            }
        }

        return result;
    }

    public int getTotalCost() {
        int result = 0;

        for (int i = 0; i < count; i++) {
            result += products.get(i).getPrice();
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
            result += products.get(i).toString() + "\n";
        }

        result += "Итого: " + getTotalCost() + "\n";
        result += "Специальных товаров:  " + getNumberOfSpecialProducts();

        System.out.println(result);
    }

    public boolean findProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(products.get(i).getName(), productName)) {
                return true;
            }
        }

        return false;
    }

    public int getNumberOfSpecialProducts(){
        int number =0;

        for (int i = 0; i < count; i++) {
            if (products.get(i).isSpecial()) {
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
