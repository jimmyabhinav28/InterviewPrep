package dev.anksandabhi.arrays;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
This class is to demonstrate the usage of the Collections API
 */
public class CollectionsPrep {

    public static<T extends Comparable> void sort(List<T> elements)
    {
         Collections.sort(elements);
    }

    //if a type T extends(in the generics sense it is equivalent to extends or implements) the Comparable Inteface, return the
    //max of the type
    public static <T extends Comparable<T>> T findMaximum(List<T> elements)
    {
        return Collections.max(elements);
    }

    //find maximum using a comparator
    public static <T> T findMaximum(List<T> elements, Comparator<T> comparator)
    {
        return Collections.max(elements,comparator);
    }

    //find minimum
    public static <T extends Comparable<T>> T findMinimum(List<T> elements)
    {
        return Collections.min(elements);
    }

    //find minimum using a comparator
    public static <T> T findMinimum(List<T> elements, Comparator<T> comparator)
    {
        return Collections.min(elements,comparator);
    }



    //reverse a list
    public static void reverse(List<?> list)
    {
        Collections.reverse(list);
    }



    public static int testBinarySearch(List<Integer> integerList,Integer element)
    {
        return Collections.binarySearch(integerList,element);
    }


}
