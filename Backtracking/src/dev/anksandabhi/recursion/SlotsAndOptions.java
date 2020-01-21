package dev.anksandabhi.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given M options of type T and N slots to fill with those options. You may use an option as many times
 * as you want. Find all possible fillings of the N slots
 */
public class SlotsAndOptions<T> {

    /**
     * @param numberOfSlots
     * @param options
     * @return
     */
    public List<List<T>> generateAllPossibleFillings(Integer numberOfSlots, List<T> options) {
        List<List<T>> allFillings = null;

        //base case
        if (numberOfSlots == 1) {
            allFillings = new ArrayList<>();
            for (T option : options) {
                List<T> x = new ArrayList<>();
                x.add(option);
                allFillings.add(x);

            }

            return allFillings;
        }

        //recursive call
        allFillings = new ArrayList<>();
        List<List<T>> allFillingsOfSmallerLength = generateAllPossibleFillings(numberOfSlots - 1, options);

        for (T option : options) {
            for (List<T> filling : allFillingsOfSmallerLength) {
                List<T> x = new ArrayList<>(filling);
                x.add(0, option);
                allFillings.add(x);
            }

        }


        return allFillings;
    }
}
