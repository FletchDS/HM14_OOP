package org.skypro.skyshop.search;

public interface Searchable {

    String searchTerm();

    String getType();

    String getName();

    default String getStringRepresentation(){
        return "имя " + getName() + " — " + getType();
    }
}