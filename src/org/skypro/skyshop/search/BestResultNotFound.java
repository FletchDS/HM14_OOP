package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {

    private String name;

    public BestResultNotFound(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BestResultNotFound{" +
                "Не удалось найти объект по запросу '" + name + "' }";
    }
}
