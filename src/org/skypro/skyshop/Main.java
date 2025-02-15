package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.discount.DiscountedProduct;
import org.skypro.skyshop.product.simple.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------------search----------------");

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
            SearchEngine searchEngine = new SearchEngine();

            SimpleProduct product3 = new SimpleProduct("Арбузные семена", 50);
            SimpleProduct product4 = new SimpleProduct("Арбузный сок 'Добрый Арбуз'", 50);
            Article article = new Article("Лучшие сорта арбузов", "Лучшие сорта арбузов");

            searchEngine.add(product3);
            searchEngine.add(product4);
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

        System.out.println("----------------basket----------------");

        ProductBasket productBasket = new ProductBasket();

        Product product1 = new DiscountedProduct("Арбуз", 100, 20);
        Product product2 = new SimpleProduct("Арбузный сок", 200);

        productBasket.addProduct(product1);
        productBasket.addProduct(product2);

        productBasket.printBasket();

        List<Product> removedProducts = productBasket.removeProduct("Арбуз");

        System.out.println("\nУдаленные продукты = " + removedProducts);

        removedProducts = productBasket.removeProduct("Ничего");

        if (removedProducts.isEmpty()) {
            System.out.println("\nСписок пуст");
        }

        System.out.println();

        productBasket.printBasket();

        System.out.println("----------------search----------------");

        SearchEngine searchEngine = new SearchEngine();

        Article article1 = new Article("Первый арбуз", "Будет 4");
        Article article2 = new Article("Второй арбуз", "Будет 3");
        SimpleProduct simpleProduct1 = new SimpleProduct("Малый арбузный сок", 50);
        SimpleProduct simpleProduct2 = new SimpleProduct("Большой арбузный сок", 50);

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(simpleProduct1);
        searchEngine.add(simpleProduct2);

        Set<Searchable> searchables = searchEngine.search("арбуз");
        System.out.println("Отсортированный Set = " + searchables);
    }
}