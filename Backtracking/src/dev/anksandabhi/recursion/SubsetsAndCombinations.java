package dev.anksandabhi.recursion;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.ArrayList;
import java.util.List;

/*
Subsets and combinations are very different from permutations. While there is a straight forward recursive approach
for permutations, subset/combinations do not have a such a case. These are trickier
 */
public class SubsetsAndCombinations<T> {

    /**
     * how do you generate a power set recursively?
     * You may connect that the number of subsets of a set of length N is 2^N, empty set being one of the subsets
     * Also, if you generate all binary numbers of length N, the number of results will be 2^N
     * The logic goes, that if you have to generate the power set of a set of length N (say E arr[N]),
     * you generate all binary numbers of length N.
     * You pick each binary number once. Say N is 4, then one such binary number will be 0000, this corresponds
     * to not picking any of the numbers. 0001, means picking the arr[0], 0010 means picking arr[1],
     * 0110 means picking arr[2] and arr[1]...The logic should now be clear
     * @param elements
     * @return
     */
    public List<List<T>> getAllSubsets(List<T> elements)
    {
        List<List<T>> allSubsets=new ArrayList<>();
        List<List<Integer>> allBinariesOfLengthN=generateBinaryNumbersOfLengthN(elements.size());
        for(List<Integer> binary: allBinariesOfLengthN)
        {
            List<T>subset=new ArrayList<>();
            for(int i=0;i<binary.size();i++)
            {
                if(binary.get(i)==1)
                    subset.add(elements.get(binary.size()-i-1));
            }
            allSubsets.add(subset);
        }

        return allSubsets;
    }

    private List<List<Integer>> generateBinaryNumbersOfLengthN(int n)
    {
        List<List<Integer>> toreturn=null;
        if(n==1)
        {
            List<Integer> one=new ArrayList<>();
            one.add(1);
            List<Integer> zero=new ArrayList<>();
            zero.add(0);
            toreturn=new ArrayList<>();
            toreturn.add(zero);
            toreturn.add(one);
            return toreturn;
        }
        List<List<Integer>> smallerBinaries=generateBinaryNumbersOfLengthN(n-1);
        toreturn=new ArrayList<>();
        //prepend 0 at head
        for(List<Integer> smallerBinary: smallerBinaries)
        {
            List<Integer> zeroPrependedBinary=new ArrayList<>(smallerBinary);
            zeroPrependedBinary.add(0,0);
            toreturn.add(zeroPrependedBinary);
        }

        //prepend 1 at head
        for(List<Integer> smallerBinary: smallerBinaries)
        {
            List<Integer> onePrependedBinary=new ArrayList<>(smallerBinary);
            onePrependedBinary.add(0,1);
            toreturn.add(onePrependedBinary);
        }

        return toreturn;
    }
}
