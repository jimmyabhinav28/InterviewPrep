package dev.anksandabhi.arrays;

import dev.anksandabhi.utils.SortOrder;
import dev.anksandabhi.utils.SortingUtils;

import java.util.List;

public class BinarySearch<T extends Comparable> {


    public int search(List<T> elements, T element, SortOrder sortOrder,int beginIndex,int endIndex) {
        if (elements == null)
            throw new RuntimeException("list cannot be null");
        if (element == null)
            throw new RuntimeException("element to be searched cannot be null");

        SortingUtils<T> sortingUtils = new SortingUtils<>();
        if (!sortingUtils.isCollectionSorted(elements, sortOrder))
            throw new RuntimeException("elements are not sorted");


        System.out.println("\n\n\nsearching for " + element + " in " + elements.sutoString());
        System.out.println("beginIndex is  " + beginIndex + " and endIndex is " + endIndex);


        if (beginIndex == endIndex) {
            if (elements.get(0).equals(element))
                return beginIndex;
            return -1;
        }

//        int mid = elements.size() / 2;
        int mid=(beginIndex+endIndex)/2;
    /*    List<T> firstHalfSublist = elements.subList(0, mid);
        List<T> secondHalfSublist = elements.subList(mid, elements.size());
*/
        T elementInMiddle = elements.get(mid);

        int compareDiff = elementInMiddle.compareTo(element);
        System.out.println("compared " + elementInMiddle + " with " + element + " .Result is " + compareDiff);

        if (compareDiff == 0)
            return mid;

        int searchResult = 0;
        if (compareDiff > 0) { //element in mid is greater
            if (sortOrder == SortOrder.ASCENDING) {
                searchResult = search(elements, element, sortOrder,0,mid);

            } else {
                searchResult = search(elements, element, sortOrder,mid,elements.size());
            }
        }

        if (compareDiff < 0) {
            if (sortOrder == SortOrder.ASCENDING)
                searchResult = search(elements, element, sortOrder,mid,elements.size());
            else
                searchResult = search(elements, element, sortOrder,0,mid);
        }

        if (searchResult != -1)
            return searchResult;
        else
            return -1;

    }
}
