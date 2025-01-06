package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.discount.DiscountedProduct;
import org.skypro.skyshop.product.fixprice.FixPriceProduct;
import org.skypro.skyshop.product.simple.SimpleProduct;

public class Main {

    public static final String textHighlightColor = "\n\u001B[32m";
    public static final String textResetHighlightColor = "\u001B[0m";

    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        SimpleProduct product1 = new SimpleProduct("Хлеб", 50);
        SimpleProduct product2 = new SimpleProduct("Сахар", 80);
        FixPriceProduct product3 = new FixPriceProduct("Гречка");
        FixPriceProduct product4 = new FixPriceProduct("Кабачки");
        DiscountedProduct product5 = new DiscountedProduct("Кетчуп", 68, 10);
        DiscountedProduct product6 = new DiscountedProduct("Чеснок", 72, 20);

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