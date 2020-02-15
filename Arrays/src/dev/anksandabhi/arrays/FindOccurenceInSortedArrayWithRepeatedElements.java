package dev.anksandabhi.arrays;

import java.util.List;

public class FindOccurenceInSortedArrayWithRepeatedElements {

    public static int findFirstOcurrenceOfAnElementInASortedArray(List<Integer> elements, Integer element) {
        return findFirstOcurrenceOfAnElementInASortedArray(elements, element, 0, elements.size() - 1);
    }

    public static int findLastOcurrenceOfAnElementInASortedArray(List<Integer> elements, Integer element) {
        return findLastOcurrenceOfAnElementInASortedArray(elements, element, 0, elements.size() - 1);
    }

    private static int findFirstOcurrenceOfAnElementInASortedArray(List<Integer> elements, Integer element, int beginIndex, int endIndex) {

        int midIndex = beginIndex + (endIndex - beginIndex) / 2; //this prevents integer overflow which the alternate expression (beginIndex+endIndex)/2 may cause

        System.out.println("BeginIndex is " + beginIndex + "   EndIndex is " + endIndex + "   midIndex is :" + midIndex);
        //boundary case return conditions
        if(endIndex-beginIndex==1)
        {
            if(elements.get(beginIndex)==element)
                return beginIndex;
        }
        int boundaryCaseResults = checkExistenceOnBoundaryConditions1(elements, element, beginIndex, endIndex, midIndex);
        if (boundaryCaseResults != -2)
            return boundaryCaseResults;

        if (elements.get(midIndex) == element && elements.get(midIndex - 1) < element)
            return midIndex;

        if (elements.get(midIndex) >= element)
            return findFirstOcurrenceOfAnElementInASortedArray(elements, element, beginIndex, midIndex - 1);

        if (elements.get(midIndex) <= element)
            return findFirstOcurrenceOfAnElementInASortedArray(elements, element, midIndex + 1, endIndex);

        return -1;
    }


    private static int findLastOcurrenceOfAnElementInASortedArray(List<Integer> elements, Integer element, int beginIndex, int endIndex) {

        int midIndex = beginIndex + (endIndex - beginIndex) / 2; //this prevents integer overflow which the alternate expression (beginIndex+endIndex)/2 may cause

        System.out.println("BeginIndex is " + beginIndex + "   EndIndex is " + endIndex + "   midIndex is :" + midIndex);
        //boundary case return conditions
        if(endIndex-beginIndex==1)
        {
            if(elements.get(endIndex)==element)
                return endIndex;
        }

        int boundaryCaseResults = checkExistenceOnBoundaryConditions2(elements, element, beginIndex, endIndex, midIndex);
        if (boundaryCaseResults != -2)
            return boundaryCaseResults;

        if (elements.get(midIndex) == element && elements.get(midIndex + 1) > element)
            return midIndex;

        if (elements.get(midIndex) >= element)
            return findLastOcurrenceOfAnElementInASortedArray(elements, element, beginIndex, midIndex - 1);

        if (elements.get(midIndex) <= element)
            return findLastOcurrenceOfAnElementInASortedArray(elements, element, midIndex + 1, endIndex);

        return -1;
    }


    private static int checkExistenceOnBoundaryConditions1(List<Integer> elements, Integer element, int beginIndex, int endIndex, int midIndex) {
        System.out.println("checking boundary conditions");

        int boundaryResult = -2;


        if (beginIndex == endIndex) {
            if (elements.get(beginIndex) == element)
                boundaryResult = beginIndex;
            else
                boundaryResult = -1;
            System.out.println("result of c1"+boundaryResult);
        }

        if (midIndex == elements.size() - 1) {
            if (elements.get(midIndex) == element)
                boundaryResult = midIndex;
            else
                boundaryResult = -1;
            System.out.println("result of c2"+boundaryResult);
        }

        if (midIndex == 0) {
            if (elements.get(midIndex) == element)
                boundaryResult= midIndex;
            else
                boundaryResult= -1;
            System.out.println("result of c3"+boundaryResult);
        }

        System.out.println("boundary result is "+boundaryResult);
        return boundaryResult;
    }


    private static int checkExistenceOnBoundaryConditions2(List<Integer> elements, Integer element, int beginIndex, int endIndex, int midIndex) {
        System.out.println("checking boundary conditions");

        int boundaryResult = -2;


        if (beginIndex == endIndex) {
            if (elements.get(beginIndex) == element)
                boundaryResult = beginIndex;
            else
                boundaryResult = -1;
            System.out.println("result of c1"+boundaryResult);
        }

        if (midIndex == elements.size() - 1) {
            if (elements.get(midIndex) == element)
                boundaryResult = midIndex;
            else
                boundaryResult = -1;
            System.out.println("result of c2"+boundaryResult);
        }

        if (midIndex == 0) {
            if (elements.get(midIndex) == element)
                boundaryResult= midIndex;
            else
                boundaryResult= -1;
            System.out.println("result of c3"+boundaryResult);
        }

        System.out.println("boundary result is "+boundaryResult);
        return boundaryResult;
    }

}
