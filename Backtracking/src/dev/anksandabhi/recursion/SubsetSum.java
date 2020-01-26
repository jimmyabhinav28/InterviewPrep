package dev.anksandabhi.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    /**
     * the method draws from the way you form all subsets of given length
     * in that problem the constraint was on the length of the subset.
     * Here the constraint is on the sum of the subset
     * <p>
     * <p>
     * All combinations of sum  S = all combinations of sum (S-e) taking this element(e) +
     * all combinations of sum S not taking this element(e)
     *
     * @param elements
     * @param sum
     * @return
     */
    public static List<List<Integer>> allSubsetsThatAddUpToGivenSum(List<Integer> elements, int sum) {
//        System.out.println("trying for sum " + sum + " with elements " + elements.toString());

        if (sum < 0 || elements == null || elements.isEmpty())
            return null;

        if (sum == 0)  //irrespective of whether there are elements or not, a sum of 0 is always feasible, by an empty set
        {
            List<Integer> emptyList = new ArrayList<>();
            List<List<Integer>> toreturn = new ArrayList<>();
            toreturn.add(emptyList);
            return toreturn;
        }

        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> listWithFirstElementRemoved = removeFirstElement(elements);

//        System.out.println("Taking "+elements.get(0));
        List<List<Integer>> allSubsetsAfterTakingThisElement = allSubsetsThatAddUpToGivenSum(listWithFirstElementRemoved, sum - elements.get(0));

//        System.out.println("Not taking "+elements.get(0));
        List<List<Integer>> allSubsetsNotTakingThisElement = allSubsetsThatAddUpToGivenSum(listWithFirstElementRemoved, sum);

        if (allSubsetsNotTakingThisElement == null && allSubsetsAfterTakingThisElement == null)
            return null;
        if (allSubsetsAfterTakingThisElement != null) {

            prependElementToAllLists(allSubsetsAfterTakingThisElement, elements.get(0));
            allSubsets.addAll(allSubsetsAfterTakingThisElement);
        }
        if (allSubsetsNotTakingThisElement != null)
            allSubsets.addAll(allSubsetsNotTakingThisElement);
        return allSubsets;
//
    }

    private static List<Integer> removeFirstElement(List<Integer> elements) {
        List<Integer> withHeadRemoved = new ArrayList<Integer>(elements);
        withHeadRemoved.remove(withHeadRemoved.get(0));
        return withHeadRemoved;
    }

    private static void prependElementToAllLists(List<List<Integer>> listOfLists, Integer element) {

        for (List<Integer> list : listOfLists) {
//            System.out.println("prepending " + element + " to " + list.toString());
            list.add(0, element);
        }
    }

}
