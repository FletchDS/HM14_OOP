package org.skypro.skyshop.search;

public class SearchEngine {

    Searchable[] searchables;
    private static int index = 0;

    public SearchEngine(int searchablesSize) {
        this.searchables = new Searchable[searchablesSize];
    }

    public Searchable[] search(String search) {
        Searchable[] result = new Searchable[5];

        for (int i = 0, j = 0; i < searchables.length && i < index; i++) {
            if (j >=5){
                break;
            }

            if (searchables[i].searchTerm().contains(search)) {
                result[j] = searchables[i];
                j++;
            }
        }

        return result;
    }

    public void add(Searchable searchable) {
        searchables[index] = searchable;
        index++;
    }
}
