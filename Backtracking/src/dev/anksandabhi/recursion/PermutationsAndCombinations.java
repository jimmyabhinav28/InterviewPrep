package dev.anksandabhi.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsAndCombinations<T> {

    /**
     * permuatitions are relevant to arrangements.
     *
     * @param elements            all list of options/ elements to be arranged.. all elements must be unique
     * @param lengthOfPermutation
     * @return
     */
    public List<List<T>> getAllPermutations(List<T> elements, int lengthOfPermutation) {
        if (lengthOfPermutation == 1) {
            List<List<T>> permutations = new ArrayList<>();
            for (int i = 0; i < elements.size(); i++) {
                List<T> permutation = new ArrayList<>();
                permutation.add(elements.get(i));
                permutations.add(permutation);
            }
            return permutations;
        }

        List<List<T>> permutations = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            List<T> elemenstAfterThisElementIsRemoved = new ArrayList<>(elements);
            elemenstAfterThisElementIsRemoved.remove(elements.get(i));
            List<List<T>> smallerPermutations = getAllPermutations(elemenstAfterThisElementIsRemoved, lengthOfPermutation - 1);

            for (List<T> smallerPermutation : smallerPermutations) {
                List<T> permutation = new ArrayList<>(smallerPermutation);
                permutation.add(0, elements.get(i));
                permutations.add(permutation);
            }
        }

        return permutations;
    }


    /**
     * All combinations of length k = all combinations of length k-1 taking this element +
     * all combinations of length k not taking this element
     *
     * @param elements
     * @param length
     * @return
     */
    public List<List<T>> allCombinationsOfGivenLength(List<T> elements, int length) {
        if (elements.size() < length)
            return new ArrayList<>();

        if (length == 1) {
            //the various combinations of 1 letter possible are those combinations which have one of the elements only
            List<List<T>> combinations = new ArrayList<>();
            for (T element : elements) {
                List<T> combination = new ArrayList<>();
                combination.add(element);
                combinations.add(combination);
            }
            return combinations;
        }

        List<List<T>> combinations = new ArrayList<>();
        //remove first element
        List<List<T>> allCombinationsTakingThisElement = allCombinationsOfGivenLength(elements.subList(1, elements.size()), length - 1);
        prependElementToAllLists(allCombinationsTakingThisElement, elements.get(0));

        List<List<T>> allCombinationsNotTakingThisElement = allCombinationsOfGivenLength(elements.subList(1, elements.size()), length);

        combinations.addAll(allCombinationsNotTakingThisElement);
        combinations.addAll(allCombinationsTakingThisElement);
        return combinations;
    }

    private void prependElementToAllLists(List<List<T>> listOfLists, T element) {
        for (List<T> list : listOfLists) {
            list.add(0, element);
        }
    }
}
