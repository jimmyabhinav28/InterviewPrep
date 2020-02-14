package dev.anksandabhi;

import dev.anksandabhi.arrays.BinarySearch;
import dev.anksandabhi.utils.SortOrder;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] elements={1,2,4,6,8,10,11};
        BinarySearch<Integer> integerBinarySearch=new BinarySearch<>();
        List<Integer> integerList=Arrays.asList(elements);
//        integerBinarySearch.search(integerList,2, SortOrder.ASCENDING);

        int x=integerBinarySearch.search(integerList,12, SortOrder.ASCENDING,0,integerList.size()-1);
        System.out.println(x);
	// write your code here
    }
}
