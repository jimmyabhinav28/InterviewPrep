package dev.anksandabhi;

import dev.anksandabhi.arrays.FindOccurenceInSortedArrayWithRepeatedElements;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       /* Integer[] elements={1,2,4,6,8,10,11};
        BinarySearch<Integer> integerBinarySearch=new BinarySearch<>();
        List<Integer> integerList=Arrays.asList(elements);
//        integerBinarySearch.search(integerList,2, SortOrder.ASCENDING);

        int x=integerBinarySearch.search(integerList,12, SortOrder.ASCENDING,0,integerList.size()-1);
        System.out.println(x);
	// write your code here*/

//        testGetFirstOccurenceInSortedArray();

        testGetLastOccurenceInSortedArray();
    }

    private static void testGetFirstOccurenceInSortedArray()
    {
        Integer[] elementsArray={0,0,1,1,1,2,4,6,8,10,11,12,12};
        List<Integer> elements=Arrays.asList(elementsArray);
        int firstOccurence= FindOccurenceInSortedArrayWithRepeatedElements.findFirstOcurrenceOfAnElementInASortedArray(elements,12);
        System.out.println("size of list is "+elementsArray.length);
        System.out.println(firstOccurence);

    }

    private static void testGetLastOccurenceInSortedArray()
    {
        Integer[] elementsArray={0,0,1,1,1,2,4,6,8,10,11,12};
        List<Integer> elements=Arrays.asList(elementsArray);
        int firstOccurence= FindOccurenceInSortedArrayWithRepeatedElements.findLastOcurrenceOfAnElementInASortedArray(elements,1);
        System.out.println(firstOccurence);

    }



}


