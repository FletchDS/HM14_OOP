package org.skypro.skyshop.search;

public class SearchEngine {

    private Searchable[] searchables;
    private static int index = 0;

    public SearchEngine(int searchablesSize) {
        this.searchables = new Searchable[searchablesSize];
    }

    public Searchable[] search(String search) {
        Searchable[] result = new Searchable[5];

        for (int i = 0, j = 0; i < searchables.length && i < index; i++) {
            if (j >= 5) {
                break;
            }

            if (searchables[i].getSearchTerm().contains(search)) {
                result[j] = searchables[i];
                j++;
            }
        }

        return result;
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable result = null;
        int maxSubStringCount = 0;

        for (int i = 0, tempCount = 0, lastIndex = 0; i < searchables.length && i < index; i++) {
            Searchable searchable = searchables[i];
            while (true)
            {
                lastIndex = searchable.getSearchTerm().indexOf(search, lastIndex);
                if (lastIndex !=-1){
                    tempCount++;
                    lastIndex += search.length();
                } else {
                    break;
                }
            }

            if(maxSubStringCount < tempCount){
                result = searchables[i];
                maxSubStringCount = tempCount;
            }
            tempCount = 0;
        }

        if (result == null){
            throw new BestResultNotFound(search);
        }
        return result;
    }

    public void add(Searchable searchable) {
        if (searchables.length == index) {
            return;
        }
        searchables[index] = searchable;
        index++;
    }
}
