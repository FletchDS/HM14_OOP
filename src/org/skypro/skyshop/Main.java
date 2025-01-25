package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.discount.DiscountedProduct;
import org.skypro.skyshop.product.simple.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ошибка 1");
        try {
            SimpleProduct product = new SimpleProduct("", 50);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException);
        }

        System.out.println("\nОшибка 2");
        try {
            SimpleProduct product = new SimpleProduct(null, 50);
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException);
        }

        System.out.println("\nОшибка 3");
        try {
            SimpleProduct product = new SimpleProduct("Арбуз", -50);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException);
        }

        System.out.println("\nОшибка 4");
        try {
            DiscountedProduct product = new DiscountedProduct("Арбуз", 50, 110);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException);
        }

        System.out.println("\nПоиск самого подходящего элемента");
        try {
            SearchEngine searchEngine = new SearchEngine(5);

            SimpleProduct product1 = new SimpleProduct("Арбузные семена", 50);
            SimpleProduct product2 = new SimpleProduct("Арбузный сок 'Добрый Арбуз'", 50);
            Article article = new Article("Лучшие сорта арбузов", "Лучшие сорта арбузов");

            searchEngine.add(product1);
            searchEngine.add(product2);
            searchEngine.add(article);

            Searchable searchable = searchEngine.getSearchTerm("Арбуз");
            System.out.println("Самый подходящий элемент по запросу 'Арбуз' = " + searchable);

            searchable = searchEngine.getSearchTerm("Лук");
            System.out.println("Самый подходящий элемент по запросу 'Лук' = " + searchable);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException);
        } catch (BestResultNotFound bestResultNotFound) {
            System.out.println(bestResultNotFound);
        }
    }
}