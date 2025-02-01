package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {

    private List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public TreeMap<Searchable, List<Searchable>> search(String search) {
        TreeMap<Searchable, List<Searchable>> result = new TreeMap<>((s1, s2) -> s1.getName().compareTo(s2.getName()));

        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i).getSearchTerm().contains(search)) {
                result.computeIfAbsent(searchables.get(i), searchable -> new ArrayList<>()).add(searchables.get(i));
            }
        }

        return result;
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable result = null;
        int maxSubStringCount = 0;

        for (int i = 0, tempCount = 0, lastIndex = 0; i < searchables.size(); i++) {
            Searchable searchable = searchables.get(i);
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
                result = searchables.get(i);
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
}
