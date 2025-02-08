package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public TreeSet<Searchable> search(String search) {
        TreeSet<Searchable> result = new TreeSet<>(new SearchableComparator());

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(search)) {
                result.add(searchable);
            }
        }

        return result;
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable result = null;
        int maxSubStringCount = 0, tempCount = 0, lastIndex = 0;

        for (Searchable searchable : searchables) {
            while (true) {
                lastIndex = searchable.getSearchTerm().indexOf(search, lastIndex);
                if (lastIndex != -1) {
                    tempCount++;
                    lastIndex += search.length();
                } else {
                    break;
                }
            }

            if (maxSubStringCount < tempCount) {
                result = searchable;
                maxSubStringCount = tempCount;
            }
            tempCount = 0;
        }

        if (result == null) {
            throw new BestResultNotFound(search);
        }
        return result;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    private static class SearchableComparator implements Comparator<Searchable> {

        @Override
        public int compare(Searchable o1, Searchable o2) {
            int i = Integer.compare(o2.getName().length(), o1.getName().length());

            if (i == 0) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return i;
            }

        }
    }
}
