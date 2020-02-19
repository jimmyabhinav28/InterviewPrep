package dev.anksandabhi;

import dev.anksandabhi.arrays.FindOccurenceInSortedArrayWithRepeatedElements;
import dev.anksandabhi.arrays.FindPivotInSortedRotatedArray;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        testGetFirstOccurenceInSortedArray();
//        testGetLastOccurenceInSortedArray();
        testFindPivotInSortedRotatedArray();
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


    private static void testFindPivotInSortedRotatedArray()
    {
        Integer[] elementsArray={1,2,3,4,5,6};
        Integer[] elementRotated={3,4,5,6,7,1,2};
        int pivotIndex= FindPivotInSortedRotatedArray.findPivotInSortedPivotedArray(elementRotated);
        System.out.println(pivotIndex);
    }



}


