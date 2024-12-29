package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class Main {

    public static final String textHighlightColor = "\n\u001B[32m";
    public static final String textResetHighlightColor = "\u001B[0m";

    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product product1 = new Product("Хлеб", 55);
        Product product2 = new Product("Сахар", 80);
        Product product3 = new Product("Гречка", 86);
        Product product4 = new Product("Кабачки", 85);
        Product product5 = new Product("Кетчуп", 68);
        Product product6 = new Product("Чеснок", 72);

        System.out.printf("%sДобавление продукта в корзину.%s", textHighlightColor, textResetHighlightColor);

        basket.addProduct(product1);

        System.out.println();

        basket.printBasket();

        System.out.printf("%sДобавление продукта в заполненную корзину, в которой нет свободного места.%s\n", textHighlightColor, textResetHighlightColor);

        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        System.out.printf("%sПечать содержимого корзины с несколькими товарами.%s\n", textHighlightColor, textResetHighlightColor);

        basket.printBasket();

        System.out.printf("%sПолучение стоимости корзины с несколькими товарами.%s\n", textHighlightColor, textResetHighlightColor);

        System.out.println("Стоимости корзины = " + basket.getTotalCost());

        System.out.printf("%sПоиск товара, который есть в корзине.%s\n", textHighlightColor, textResetHighlightColor);

        String tempString = product1.getName();
        boolean isProductInBasket = basket.findProduct(tempString);

        if (isProductInBasket){
            System.out.println("Продукт " + tempString + " в корзине есть");
        }
        else {
            System.out.println("Продукт " + tempString + " в корзине отсутствует");
        }

        System.out.printf("%sПоиск товара, которого нет в корзине.%s\n", textHighlightColor, textResetHighlightColor);

        tempString = "Стеклорез";
        isProductInBasket = basket.findProduct(tempString);

        if (isProductInBasket){
            System.out.println("Продукта " + tempString + " в корзине есть");
        }
        else {
            System.out.println("Продукт " + tempString + " в корзине отсутствует");
        }

        System.out.printf("%sОчистка корзины.%s\n", textHighlightColor, textResetHighlightColor);

        basket.clearBasket();

        System.out.printf("%sПечать содержимого пустой корзины.%s\n", textHighlightColor, textResetHighlightColor);

        basket.printBasket();

        System.out.printf("%sПолучение стоимости пустой корзины.%s\n", textHighlightColor, textResetHighlightColor);

        System.out.println("Стоимости корзины = " + basket.getTotalCost());

        System.out.printf("%sПоиск товара по имени в пустой корзине.%s\n", textHighlightColor, textResetHighlightColor);

        tempString = product2.getName();
        isProductInBasket = basket.findProduct(tempString);

        if (isProductInBasket){
            System.out.println("Продукт " + tempString + " в корзине есть");
        }
        else {
            System.out.println("Продукт " + tempString + " в корзине отсутствует");
        }
    }
}