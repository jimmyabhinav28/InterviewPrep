package dev.anksandabhi.utils;

import java.util.Collection;
import java.util.Iterator;

public class SortingUtils<T extends Comparable> {

    public boolean isCollectionSorted(Collection<T> elements, SortOrder sortOrder) {
        int differenceForTheSortOrder = 0;


        if (sortOrder == SortOrder.ASCENDING)
            differenceForTheSortOrder = -1;
        else
            differenceForTheSortOrder = 1;

        if (elements == null)
            throw new RuntimeException("empty collection");
        if (elements.size() <= 1)
            return true;
        Iterator<T> iterator = elements.iterator();

        T current = iterator.next();
        T next = null;
        while (iterator.hasNext()) {
            next=iterator.next();
            int diff = current.compareTo(next);
            if (diff == 0 || diff == differenceForTheSortOrder)
                continue;
            else
                return false;
        }

        return true;
    }

}
