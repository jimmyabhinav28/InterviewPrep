package dev.anksandabhi.arrays;

public class FindPivotInSortedRotatedArray {

    /**
     * returns the index of the sorted pivoted array
     *
     * @param array
     * @return
     */
    public static int findPivotInSortedPivotedArray(Integer[] array) {
        int beginIndex = 0;
        int endIndex = array.length - 1;
        int n=array.length;

        while (beginIndex <= endIndex) {
            int mid = (beginIndex + endIndex) / 2;
            System.out.println("beginIndex :" + beginIndex + ", endIndex :" + endIndex + ", mid :" + mid);
            boolean elementsToLeftAreSorted = false;
            boolean elementsToRightAreSorted = false;


                elementsToLeftAreSorted = checkIfElementsAreSorted(array, beginIndex, mid-1);

                elementsToRightAreSorted = checkIfElementsAreSorted(array, mid+1, endIndex);

            if (elementsToLeftAreSorted && elementsToRightAreSorted) {
                if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1])
                    return mid;
            }
            if (elementsToLeftAreSorted) {

                beginIndex = mid+1;
                System.out.println("elements to left are sorted. Updating beginIndex to "+beginIndex);
                //endIndex unchanged
                continue;
            }

            if (elementsToRightAreSorted) {
                endIndex = mid - 1;
                System.out.println("elements to right are sorted. Updating endIndex to "+endIndex);
                continue;
            }

        }

        return -1;
    }

    private static boolean checkIfElementsAreSorted(Integer[] array, int beginIndex, int endIndex) {

        if(beginIndex==endIndex)
            return true;
        if (array[beginIndex] < array[endIndex])
            return true;
        return false;
    }
}
