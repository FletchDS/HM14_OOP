package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.simple.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class Main {

    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(5);

        Product product = new SimpleProduct("bread", 50);
        Article article1 = new Article("Some name", "Some description");
        Article article2 = new Article("Another name", "Another description");
        Article article3 = new Article("And another name", "And another description");

        searchEngine.add(product);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        Searchable[] searchables;

        System.out.println("-----------------------------------");
        searchables = searchEngine.search("bread");
        for (int i = 0; i < searchables.length; i++) {
            System.out.println((i + 1) + ") " + searchables[i]);
        }

        System.out.println("-----------------------------------");
        searchables = searchEngine.search("Another");
        for (int i = 0; i < searchables.length; i++) {
            System.out.println((i + 1) + ") " + searchables[i]);
        }

        System.out.println("-----------------------------------");
        searchables = searchEngine.search("name");
        for (int i = 0; i < searchables.length; i++) {
            System.out.println((i + 1) + ") " + searchables[i]);
        }

        System.out.println("-----------------------------------");
        searchables = searchEngine.search("a");
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null) {
                System.out.println((i + 1) + ") " + searchables[i].getStringRepresentation());
            } else {
                System.out.println((i + 1) + ") " + null);
            }
        }
    }
}