package dev.anksandabhi.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations<T> {

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


}
